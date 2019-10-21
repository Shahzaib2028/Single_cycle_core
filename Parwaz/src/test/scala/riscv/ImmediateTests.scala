package riscv

import chisel3.iotesters.PeekPokeTester

class ImmediateTests(c: Immediate) extends PeekPokeTester(c){
	poke(c.io.instruction, 512)
	poke(c.io.pc, 25)
	step(1)
	expect(c.io.I_Type, 0)
	expect(c.io.S_Type, 4)
	expect(c.io.Sb_Type, 29)
	expect(c.io.Uj_Type, 25)
	expect(c.io.U_Type, 0)

}
