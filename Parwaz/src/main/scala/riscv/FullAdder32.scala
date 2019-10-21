package riscv

import chisel3._

class FullAdder32 extends Module{
	val io = IO(new Bundle{
		val a = Input(UInt(32.W))
		val b = Input(UInt(32.W))
		val out = Output(UInt(32.W))



})

		io.out := io.a +io.b
}
