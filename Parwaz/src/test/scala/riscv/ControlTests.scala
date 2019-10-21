package riscv

import chisel3.iotesters.PeekPokeTester

class ControlTests(c: Control) extends PeekPokeTester(c){
	poke(c.io.opcode, 55)
	step(1)
	expect(c.io.MemWrite, 0)
	expect(c.io.branch, 0)
	expect(c.io.MemRead, 0)
	expect(c.io.RegWrite, 1)
	expect(c.io.MemtoReg, 0)
	expect(c.io.ALUoperation, 6)
	expect(c.io.operand_A_sel, 3)
	expect(c.io.operand_B_sel, 1)
	expect(c.io.extend_sel, 1)
	expect(c.io.Next_pc_sel, 0)


}
