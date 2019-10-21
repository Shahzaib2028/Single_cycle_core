package riscv

import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class DataMem extends Module{
	val io = IO(new Bundle{
		val store_data = Input(SInt(32.W))   //rs2
		val addr = Input(UInt(8.W))         //adderess
		val store = Input(UInt(1.W))
		val load = Input(UInt(1.W))
		val Data_Out = Output(SInt(32.W))




})
		val memory = Mem(1024,SInt(32.W))
		when(io.store === 1.U){
			memory(io.addr) := io.store_data
		}.otherwise{
			io.Data_Out := DontCare
		}
		when(io.load === 1.U){
			io.Data_Out := memory(io.addr)
		}.otherwise{
			io.Data_Out := DontCare
		}
		
		
		



}
