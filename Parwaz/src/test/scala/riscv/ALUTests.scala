package riscv

import chisel3.iotesters.PeekPokeTester

class ALUTests(c: ALU) extends PeekPokeTester(c){
	poke(c.io.a, -3)
	poke(c.io.b, -2)
	poke(c.io.ALUcont, 20)
	step(1)
	expect(c.io.out, 1)
}
