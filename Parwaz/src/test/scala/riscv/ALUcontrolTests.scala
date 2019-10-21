package riscv

import chisel3.iotesters.PeekPokeTester

class ALUcontrolTests(c: ALUcontrol) extends PeekPokeTester(c){
	poke(c.io.ALUop, 3)
	poke(c.io.func3, 0)
	poke(c.io.func7, 0)
	step(1)
	expect(c.io.ALUcont, 31)

}
