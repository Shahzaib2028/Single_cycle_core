package riscv

import chisel3._

class Nor extends Module{
	val io = IO(new Bundle{
		val a = Input(UInt(1.W))
		val b = Input(UInt(1.W))
		val o = Output(UInt(1.W))
})
		io.o := ~(io.a | io.b)
}
