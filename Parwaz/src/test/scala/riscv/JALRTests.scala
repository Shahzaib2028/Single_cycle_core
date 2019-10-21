package riscv 

import chisel3.iotesters.PeekPokeTester

class JALRTests(c: JALR) extends PeekPokeTester(c){
	poke(c.io.rs1, 2)
	poke(c.io.typ, 2)
	step(1)
	expect(c.io.out, 4)

}
