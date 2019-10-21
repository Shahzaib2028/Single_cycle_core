package riscv

import chisel3._

class TypeDecode extends Module{
	val io = IO(new Bundle{
		val opcode = Input(UInt(7.W))
		val R_Type = Output(UInt(1.W))
		val Load = Output(UInt(1.W))
		val Store= Output(UInt(1.W))
		val Branch = Output(UInt(1.W))
		val I_Type = Output(UInt(1.W))
		val JALR = Output(UInt(1.W))
		val JAL = Output(UInt(1.W))
		val LUI = Output(UInt(1.W))
		


})

		when(io.opcode === "b0110011".U){     //R-TYPE (51)
			io.R_Type := 1.U
			io.Load := 0.U
			io.Store := 0.U
			io.Branch := 0.U
			io.I_Type := 0.U
			io.JALR := 0.U
			io.JAL := 0.U
			io.LUI := 0.U
		}.elsewhen(io.opcode === "b0000011".U){   //Load(3)
			io.R_Type := 0.U
			io.Load := 1.U
			io.Store := 0.U
			io.Branch := 0.U
			io.I_Type := 0.U
			io.JALR := 0.U
			io.JAL := 0.U
			io.LUI := 0.U
		}.elsewhen(io.opcode === "b0100011".U){    //Store(35)
			io.R_Type := 0.U
			io.Load := 0.U
			io.Store := 1.U
			io.Branch := 0.U
			io.I_Type := 0.U
			io.JALR := 0.U
			io.JAL := 0.U
			io.LUI := 0.U
		}.elsewhen(io.opcode === "b1100011".U){    //Branch(99)
			io.R_Type := 0.U
			io.Load := 0.U
			io.Store := 0.U
			io.Branch := 1.U
			io.I_Type := 0.U
			io.JALR := 0.U
			io.JAL := 0.U
			io.LUI := 0.U
		}.elsewhen(io.opcode === "b0010011".U){    //I-TYPE(19)
			io.R_Type := 0.U
			io.Load := 0.U
			io.Store := 0.U
			io.Branch := 0.U
			io.I_Type := 1.U
			io.JALR := 0.U
			io.JAL := 0.U
			io.LUI := 0.U
		}.elsewhen(io.opcode === "b1100111".U){    //JALR(103)
			io.R_Type := 0.U
			io.Load := 0.U
			io.Store := 0.U
			io.Branch := 0.U
			io.I_Type := 0.U
			io.JALR := 1.U
			io.JAL := 0.U
			io.LUI := 0.U
		}.elsewhen(io.opcode === "b1101111".U){     //JAL(111)
			io.R_Type := 0.U
			io.Load := 0.U
			io.Store := 0.U
			io.Branch := 0.U
			io.I_Type := 0.U
			io.JALR := 0.U
			io.JAL := 1.U
			io.LUI := 0.U
		}.elsewhen(io.opcode === "b0110111".U){     //LUI(55)
			io.R_Type := 0.U
			io.Load := 0.U
			io.Store := 0.U
			io.Branch := 0.U
			io.I_Type := 0.U
			io.JALR := 0.U
			io.JAL := 0.U
			io.LUI := 1.U
		}.otherwise{
			io.R_Type := DontCare
			io.Load := DontCare
			io.Store := DontCare
			io.Branch := DontCare
			io.I_Type := DontCare
			io.JALR := DontCare
			io.JAL := DontCare
			io.LUI := DontCare
		}

}
