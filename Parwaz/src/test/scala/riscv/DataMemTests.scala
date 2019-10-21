package riscv
import chisel3.iotesters.PeekPokeTester

class DataMemTests(c: DataMem) extends PeekPokeTester(c){
	poke(c.io.load, 1)
	poke(c.io.store, 1)
	poke(c.io.addr, 0)
	poke(c.io.store_data, -2)
	step(1)
	//expect(c.io.Data_Out, -2)


}
