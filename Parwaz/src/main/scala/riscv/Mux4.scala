package riscv

import chisel3._

class Mux4 extends Module{
	val io = IO(new Bundle{
		val i0 = Input(UInt(1.W))
		val i1 = Input(UInt(1.W))
		val i2 = Input(UInt(1.W))
		val i3 = Input(UInt(1.W))
		val s0 = Input(UInt(1.W))
		val s1 = Input(UInt(1.W))
		val out = Output(UInt(1.W))
		

})

		val muxA = Module(new Mux())
		val muxB = Module(new Mux())
		val muxC = Module(new Mux())

		muxA.io.a := io.i0
		muxA.io.b := io.i1
		muxA.io.sel := io.s0

		muxB.io.a := io.i2
		muxB.io.b := io.i3
		muxB.io.sel := io.s0

		muxC.io.a := muxA.io.o1
		muxC.io.b := muxB.io.o1
		muxC.io.sel := io.s1

		io.out := muxC.io.o1
}
