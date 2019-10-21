package riscv

import chisel3._

class Control extends Module{
	val io = IO(new Bundle{
		val opcode = Input(UInt(7.W))
		
		val MemWrite = Output(UInt(1.W))
		val branch = Output(UInt(1.W))
		val MemRead = Output(UInt(1.W))
		val RegWrite = Output(UInt(1.W))
		val MemtoReg = Output(UInt(1.W))
		val ALUoperation = Output(UInt(3.W))
		val operand_A_sel = Output(UInt(2.W))
		val operand_B_sel = Output(UInt(1.W))
		val extend_sel = Output(UInt(2.W))
		val Next_pc_sel = Output(UInt(2.W))

})
		val type_decode = Module(new TypeDecode())
		val control_decode = Module(new ControlDecode())

		type_decode.io.opcode := io.opcode
		control_decode.io.R_Type := type_decode.io.R_Type
		control_decode.io.Load := type_decode.io.Load
		control_decode.io.Store := type_decode.io.Store
		control_decode.io.Branch := type_decode.io.Branch
		control_decode.io.I_Type := type_decode.io.I_Type
		control_decode.io.JALR := type_decode.io.JALR
		control_decode.io.JAL := type_decode.io.JAL
		control_decode.io.LUI := type_decode.io.LUI

		io.MemWrite := control_decode.io.MemWrite
		io.branch := control_decode.io.branch
		io.MemRead := control_decode.io.MemRead
		io.RegWrite := control_decode.io.RegWrite
		io.MemtoReg := control_decode.io.MemtoReg
		io.ALUoperation := control_decode.io.ALUoperation
		io.operand_A_sel := control_decode.io.operand_A_sel
		io.operand_B_sel := control_decode.io.operand_B_sel
		io.extend_sel := control_decode.io.extend_sel
		io.Next_pc_sel := control_decode.io.Next_pc_sel        


}
