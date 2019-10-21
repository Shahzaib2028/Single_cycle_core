package riscv

import chisel3.iotesters.PeekPokeTester

class MuxTests(c: Mux) extends PeekPokeTester(c){

	poke(c.io.a, 1)
	poke(c.io.b, 0)
	poke(c.io.sel, 0)
	step(1)
	expect(c.io.o1, 1)
}
