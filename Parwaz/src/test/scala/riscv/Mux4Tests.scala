package riscv

import chisel3.iotesters.PeekPokeTester

class Mux4Tests(c: Mux4) extends PeekPokeTester(c){

	poke(c.io.i0, 0)
	poke(c.io.i1, 0)
	poke(c.io.i2, 1)
	poke(c.io.i3, 0)
	poke(c.io.s0, 0)
	poke(c.io.s1, 1)
	step(1)
	expect(c.io.out, 1)
}
