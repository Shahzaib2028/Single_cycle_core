package riscv

import chisel3._
import chisel3.util.Cat
import chisel3.util.Fill

class Immediate extends Module{
	val io = IO(new Bundle{
		val instruction = Input(UInt(32.W))
		val pc = Input(UInt(32.W))
		val I_Type = Output(SInt(32.W))
		val S_Type = Output(SInt(32.W))
		val Sb_Type = Output(SInt(32.W))
		val Uj_Type = Output(SInt(32.W))
		val U_Type = Output(SInt(32.W))

  })

		val imm31 = io.instruction(31)
		val imm30 = io.instruction(30,25)
		val imm24 = io.instruction(24,21)
		val imm20 = io.instruction(20)
		val imm19 = io.instruction(19,12)
		val imm11 = io.instruction(11,8)
		val imm7 = io.instruction(7)

		io.I_Type := Cat(Fill(20,imm31),imm31,imm30,imm24,imm20).asSInt
		io.S_Type := Cat(Fill(20,imm31),imm31,imm30,imm11,imm7).asSInt
		io.Sb_Type := Cat(Fill(19,imm31),imm31,imm7,imm30,imm11, 0.U).asSInt +io.pc.asSInt
		io.Uj_Type := Cat(Fill(11,imm31),imm31,imm19,imm20,imm30,imm24, 0.U).asSInt +io.pc.asSInt
		io.U_Type := (Cat(imm31,imm30,imm24,imm20,imm19) << 12.U).asSInt
		

		


}
