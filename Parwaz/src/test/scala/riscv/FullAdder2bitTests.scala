package riscv

import chisel3.iotesters.PeekPokeTester

class FullAdder2bitTests(c: FullAdder2bit) extends PeekPokeTester(c){
	poke(c.io.a1, 1)
	poke(c.io.b1, 1)
	poke(c.io.a2, 1)
	poke(c.io.b2, 0)
	poke(c.io.cin, 0)

	
	step(1)
	expect(c.io.count, 1)
	expect(c.io.sum0, 0)
	expect(c.io.sum1, 0)
	//expect(adder.c.io.sum, 1)
}
