package riscv

import chisel3.iotesters.PeekPokeTester

class PCTests(c: PC) extends PeekPokeTester(c){
	poke(c.io.input, 4)
	poke(c.io.pc4, 1)
	poke(c.io.pc, 1)
	step(1)

}
