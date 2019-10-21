package riscv

import chisel3.iotesters.PeekPokeTester

class FullAdder32Tests(c: FullAdder32) extends PeekPokeTester(c){
	poke(c.io.a, 25)
	poke(c.io.b, 35)
	step(1)
	expect(c.io.out, 60)

}
