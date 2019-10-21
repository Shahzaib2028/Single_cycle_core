package riscv

import chisel3._

class Top extends Module{
	val io = IO(new Bundle {
		//val instruction = Input(UInt(32.W))
		//val pc = Input(UInt(32.W))
		val reg_output = Output(SInt(32.W))




})

		val control = Module(new Control())
		val immediate = Module(new Immediate())
		val alu = Module(new ALU())
		val alu_control = Module(new ALUcontrol())
		val register32 = Module(new Register32())
		val ins = Module(new InsMem())
		val Pc = Module(new PC())
		

		//PC and Instruction connection
		ins.io.wrAddr := Pc.io.pc
		Pc.io.input := Pc.io.pc4

		//CONTROL
		control.io.opcode := ins.io.rdData(6,0)
		//IMMEDIATE GENERATION
		immediate.io.instruction := ins.io.rdData
		immediate.io.pc := Pc.io.pc
		//Register32
		register32.io.rs1_sel := ins.io.rdData(19,15)
		register32.io.rs2_sel := ins.io.rdData(24,20)
		register32.io.rd_sel := ins.io.rdData(11,7)
		register32.io.RegWrite := control.io.RegWrite
		//ALU CONTROL
		alu_control.io.ALUop := control.io.ALUoperation
		alu_control.io.func3 := ins.io.rdData(14,12)
		alu_control.io.func7 := ins.io.rdData(30)
		//ALU
		alu.io.a := register32.io.rs1
		when(control.io.extend_sel === "b00".U && control.io.operand_B_sel === "b1".U){
			alu.io.b := immediate.io.I_Type
		}.otherwise{
			alu.io.b := register32.io.rs2

		}		
		
		alu.io.ALUcont := alu_control.io.ALUcont
		register32.io.DataWrite := alu.io.out
		//io.reg_output := register32.io.rs1
		io.reg_output := alu.io.out

}
