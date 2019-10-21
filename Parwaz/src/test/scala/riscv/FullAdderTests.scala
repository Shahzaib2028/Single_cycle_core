package riscv

import chisel3.iotesters.PeekPokeTester

class FullAdderTests(c: FullAdder) extends PeekPokeTester(c){

	poke(c.io.a, 0)
	poke(c.io.b, 1)
	poke(c.io.cin, 0)
	
	step(1)
	expect(c.io.sum, 1)
	expect(c.io.count, 0)
}
