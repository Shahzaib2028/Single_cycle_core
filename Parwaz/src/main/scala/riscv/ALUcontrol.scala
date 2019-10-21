package riscv

import chisel3._
import chisel3.util.Cat

class ALUcontrol extends Module{
	val io = IO(new Bundle{
		val ALUop = Input(UInt(3.W))
		val func7 = Input(UInt(1.W))
		val func3 = Input(UInt(3.W))
		val ALUcont = Output(UInt(5.W))

})
		when(io.ALUop === "b000".U){		
			io.ALUcont := Cat(0.U , io.func7 , io.func3) 		//R-TYPE
		}.elsewhen(io.ALUop === "b001".U){
			when(io.func3 === "b101".U){
				io.ALUcont := Cat(0.U , io.func7 , io.func3)
			}.otherwise{
				io.ALUcont := Cat("b00".U , io.func3)
			}
			//io.ALUcont := Cat(0.U , io.func7 , io.func3)  	// I-TYPE
		}.elsewhen(io.ALUop === "b100".U){
			io.ALUcont := "b00000".U	 	//Load
		}.elsewhen(io.ALUop === "b101".U){
			io.ALUcont := "b00000".U 		//Store
		}.elsewhen(io.ALUop === "b110".U){
			io.ALUcont := "b00000".U		//LUI
		}.elsewhen(io.ALUop === "b010".U){
			io.ALUcont := Cat("b10".U , io.func3) 		        //SB-TYPE
		}.elsewhen(io.ALUop === "b011".U){
			io.ALUcont := "b11111".U 				//JALR
		}.otherwise{
			io.ALUcont := DontCare		
		}






}
