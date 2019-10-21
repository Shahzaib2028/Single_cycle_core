package riscv

import chisel3._

class ALU extends Module{
	val io = IO(new Bundle{
		val a = Input(SInt(32.W))
		val b = Input(SInt(32.W))
		val ALUcont = Input(UInt(5.W))
		val out = Output(SInt(32.W))
		val branch = Output(SInt(1.W))

})
		when(io.ALUcont === "b00000".U){                //ADD ADDI
			io.out := io.a + io.b
		}.elsewhen(io.ALUcont === "b00001".U){          //SLL SLLI
			val shift_left = io.b(4,0)
			io.out := io.a << shift_left
		}.elsewhen(io.ALUcont === "b00010".U){          //SLT SLTI
			when(io.a < io.b){
				io.out := 1.S			
			}.otherwise{
				io.out := 0.S
			}
		}.elsewhen(io.ALUcont === "b00011".U){         //SLTU SLTUI BLTU
			when(io.a.asUInt < io.b.asUInt){
				io.out := 1.S
			}.otherwise{
				io.out := 0.S	
			}
		}.elsewhen(io.ALUcont === "b00100".U){           //XOR XORI
			io.out := io.a  ^ io.b
		}.elsewhen(io.ALUcont === "b00101".U){           //SLR SLRI
			val shift_right = io.b(4,0)
			io.out := io.a >> shift_right	
		}.elsewhen(io.ALUcont === "b00110".U){         //OR ORI
			io.out := io.a  | io.b
		}.elsewhen(io.ALUcont === "b00111".U){         //AND ANDI
			io.out := io.a & io.b
		}.elsewhen(io.ALUcont === "b01000".U){         //SUB
			io.out := io.a - io.b
		}.elsewhen(io.ALUcont === "b01101".U){         //SRA SRAI
			val shift_right_a = io.b(4,0)
			io.out := io.a >> shift_right_a
		}.elsewhen(io.ALUcont === "b10000".U){        //BEQ
			when(io.a === io.b){
				io.out := 1.S
			}.otherwise{
				io.out := 0.S
			}
		}.elsewhen(io.ALUcont === "b10001".U){       //BNE
			when(io.a =/= io.b){
				io.out := 1.S
			}.otherwise{
				io.out := 0.S
			}
		}.elsewhen(io.ALUcont === "b10100".U){       //BLT
			when(io.a < io.b ){
				io.out := 1.S
			}.otherwise{
				io.out := 0.S
			}
		}.elsewhen(io.ALUcont === "b10101".U){       //BGE
			when(io.a >= io.b){
				io.out := 1.S
			}.otherwise{
				io.out := 0.S
			}
		}.elsewhen(io.ALUcont === "b10110".U){       //BLTU
			when(io.a.asUInt < io.b.asUInt){
				io.out := 1.S
			}.otherwise{
				io.out := 0.S
			}
		}.elsewhen(io.ALUcont === "b10111".U){      //BGEU
			when(io.a.asUInt >= io.b.asUInt){
				io.out := 1.S
			}.otherwise{
				io.out := 0.S
			}
		}.elsewhen(io.ALUcont === "b11111".U){      //JAL JALR
			io.out := io.a
		}.otherwise{
			io.out := DontCare
		}

		val code = io.ALUcont(4,3)
		when (code === "b10".U && io.out === 1.S){
			io.branch := 1.S

		}.otherwise{
			io.branch := 0.S
		}

}
