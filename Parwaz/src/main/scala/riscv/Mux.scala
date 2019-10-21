package riscv

import chisel3._

class Mux extends Module{
	val io = IO(new Bundle{
		val a = Input(UInt(1.W))
		val b = Input(UInt(1.W))
		val sel = Input(UInt(1.W))
		val o1 = Output(UInt(1.W))
//		val and1 = Output(UInt(1.W))
//		val and2 = Output(UInt(1.W))


})

		
		io.o1 :=  (io.b & io.sel) | (io.a & ~io.sel)

}


///io.and1 := io.b & io.sel
//io.and2 := io.a & ~io.sel
//io.o1 := io.and1 |io.and2
