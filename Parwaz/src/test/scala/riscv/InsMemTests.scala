package riscv

import chisel3.iotesters.PeekPokeTester

class InsMemTests(c: InsMem) extends PeekPokeTester(c){
	poke(c.io.wrAddr, 0)
	step(1)


}
