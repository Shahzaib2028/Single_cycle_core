package riscv

import chisel3._

class JALR  extends Module{
	val io = IO(new Bundle{
		val rs1 = Input(SInt(32.W))
		val typ = Input(SInt(32.W))
		val out = Output(SInt(32.W))


})
		io.out := (io.rs1 + io.typ) & 4294967294L.S



}
