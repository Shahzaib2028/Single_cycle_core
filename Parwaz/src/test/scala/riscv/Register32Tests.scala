package riscv

import chisel3.iotesters.PeekPokeTester

class Register32Tests(c: Register32) extends PeekPokeTester(c){
	poke(c.io.rs1_sel, 1)
	poke(c.io.rs2_sel, 3)
	poke(c.io.RegWrite, 1)
	poke(c.io.DataWrite, 10)
	poke(c.io.rd_sel, 3)
	step(1)
	expect(c.io.rs2, 10)
}
