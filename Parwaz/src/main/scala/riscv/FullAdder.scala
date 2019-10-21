package riscv

import chisel3._

class FullAdder extends Module{
	val io = IO(new Bundle{
		val a = Input(UInt(1.W))
		val b = Input(UInt(1.W))
		val cin = Input(UInt(1.W))
		val sum = Output(UInt(1.W))
		val count = Output(UInt(1.W))




})

		io.sum := (~io.a & ~io.b & ~io.cin) | (~io.a & io.b & ~io.cin) | (io.a & ~io.b & ~io.cin) | (io.a & io.b & io.cin)
		io.count := (io.b & io.cin) | (io.a & io.cin) | (io.a & io.b)








}
