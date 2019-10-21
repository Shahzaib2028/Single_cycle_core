package riscv

import chisel3._

class Main extends Module{
	val io = IO(new Bundle {
		//val instruction = Input(UInt(32.W))
		//val pc = Input(UInt(32.W))
		//val branch_check = Output(UInt(1.W))
		val reg_output = Output(SInt(32.W))




})

		val control = Module(new Control())
		val immediate = Module(new Immediate())
		val alu = Module(new ALU())
		val alu_control = Module(new ALUcontrol())
		val register32 = Module(new Register32())
		val ins = Module(new InsMem())
		val Pc = Module(new PC())
		val jalr = Module(new JALR())
		val datamem = Module(new DataMem())

		//Data memory connections
		datamem.io.store :=  control.io.MemWrite
		datamem.io.load :=  control.io.MemRead
		datamem.io.addr := (alu.io.out(9,2)).asUInt
		datamem.io.store_data :=  register32.io.rs2


		when(control.io.MemtoReg === 0.U){
			register32.io.DataWrite := alu.io.out
		}.elsewhen(control.io.MemtoReg === 1.U){
			register32.io.DataWrite := datamem.io.Data_Out	
		}.otherwise{
			register32.io.DataWrite := datamem.io.Data_Out
		}
		//io.reg_output := register32.io.DataWrite

		//JALR connections
		when(control.io.extend_sel === "b0".U){
			jalr.io.typ := immediate.io.I_Type
		}.elsewhen(control.io.extend_sel === "b10".U){
			jalr.io.typ := immediate.io.S_Type
		}.elsewhen(control.io.extend_sel === "b01".U){
			jalr.io.typ := immediate.io.U_Type
		}.otherwise{
			jalr.io.typ := DontCare
		}
		
		jalr.io.rs1 := register32.io.rs1

		//PC and Instruction connection
		ins.io.wrAddr := Pc.io.pc(11,2)
		Pc.io.input := Pc.io.pc4

		//CONTROL
		control.io.opcode := ins.io.rdData(6,0)
		//IMMEDIATE GENERATION
		immediate.io.instruction := ins.io.rdData
		immediate.io.pc := Pc.io.pc

		when((alu.io.branch.asUInt & control.io.branch) === 1.U && control.io.Next_pc_sel === 1.U){
			Pc.io.input  := immediate.io.Sb_Type.asUInt
		}.elsewhen((alu.io.branch.asUInt & control.io.branch) === 0.U && control.io.Next_pc_sel === 1.U){
			Pc.io.input  := Pc.io.pc + 4.U
		}.elsewhen(control.io.Next_pc_sel === 0.U){
			Pc.io.input  := Pc.io.pc + 4.U
		}.elsewhen(control.io.Next_pc_sel === "b10".U){
			Pc.io.input := immediate.io.Uj_Type.asUInt
		}.elsewhen(control.io.Next_pc_sel === "b11".U){
			Pc.io.input := jalr.io.out.asUInt
		}.otherwise{
			Pc.io.input := DontCare
		}
				


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
		when(control.io.operand_A_sel === "b10".U){
			alu.io.a := Pc.io.pc4.asSInt
		}.otherwise{
			alu.io.a := register32.io.rs1
		}
		when(control.io.extend_sel === "b00".U && control.io.operand_B_sel === "b1".U){
			alu.io.b := immediate.io.I_Type
		}.elsewhen(control.io.extend_sel === "b10".U && control.io.operand_B_sel === "b1".U){
			alu.io.b := immediate.io.S_Type
		}.elsewhen(control.io.extend_sel === "b01".U && control.io.operand_B_sel === "b1".U){
			alu.io.b := immediate.io.U_Type
		}.otherwise{
			alu.io.b := register32.io.rs2

		}		
		
		alu.io.ALUcont := alu_control.io.ALUcont
		//register32.io.DataWrite := alu.io.out
		//io.reg_output := register32.io.rs1
		io.reg_output := alu.io.out

}
