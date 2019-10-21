package riscv

import chisel3.iotesters.PeekPokeTester

class TypeDecodeTests(c: TypeDecode) extends PeekPokeTester(c){
	poke(c.io.opcode, 55)
	step(1)
	expect(c.io.R_Type, 0)
	expect(c.io.Load, 0)
	expect(c.io.Store, 0)
	expect(c.io.Branch, 0)
	expect(c.io.I_Type, 0)
	expect(c.io.JALR, 0)
	expect(c.io.JAL, 0)
	expect(c.io.LUI, 1)

}
