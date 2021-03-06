package riscv

import chisel3._

class Register32 extends Module{
	val io = IO(new Bundle{
		val rs1_sel = Input(UInt(5.W))
		val rs2_sel = Input(UInt(5.W))
		val rd_sel = Input(UInt(5.W))
		val RegWrite = Input(UInt(1.W))
		val DataWrite = Input(SInt(32.W))
		val rs1 = Output(SInt(32.W))
		val rs2 = Output(SInt(32.W))

})
		val registers = Reg( Vec (32, SInt(32.W)))
		registers(0) := 0.S
		//registers(4) := 1.S
		io.rs1 := registers(io.rs1_sel)
		io.rs2 := registers(io.rs2_sel)
		when(io.RegWrite === 1.U){
			when(io.rd_sel === "b00000".U){
				registers(io.rd_sel) := 0.S
			}.otherwise {
				registers(io.rd_sel) := io.DataWrite
			}
		}
		


}
