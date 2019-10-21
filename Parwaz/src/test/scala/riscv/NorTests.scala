package riscv
import chisel3.iotesters.PeekPokeTester

class NorTests(c: Nor) extends PeekPokeTester(c){
	poke(c.io.a, 0)
	poke(c.io.b, 1)
	step(1)
	expect(c.io.o, 0)
}
