package riscv

import chisel3._

class FullAdder2bit extends Module{
	val io = IO(new Bundle{
		val a1 = Input(UInt(1.W))
		val b1 = Input(UInt(1.W))
		val a2 = Input(UInt(1.W))
		val b2 = Input(UInt(1.W))
		val cin = Input(UInt(1.W))
		val sum0 = Output(UInt(1.W))
		val sum1 = Output(UInt(1.W))
		val count = Output(UInt(1.W))



})

		val adder1 = Module(new FullAdder())
		val adder2 = Module(new FullAdder())

		adder1.io.cin := io.cin
		adder1.io.a := io.a1
		adder1.io.b := io.b1
		adder2.io.cin := adder1.io.count
		adder2.io.a := io.a2
		adder2.io.b := io.b2
		io.sum0 := adder1.io.sum
		io.sum1 := adder2.io.sum
		io.count := adder2.io.count
		
		
		

}
