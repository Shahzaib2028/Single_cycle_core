package riscv

import chisel3.iotesters.PeekPokeTester

class MainTests(c: Main) extends PeekPokeTester(c){
	//poke(c.io.instruction, 156307)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	step(1)
	//expect(c.io.reg_output, 1)



}
