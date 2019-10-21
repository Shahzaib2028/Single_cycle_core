// See LICENSE.txt for license details.
package riscv
import chisel3.iotesters.{Driver, TesterOptionsManager}
import utils.TutorialRunner

object Launcher {
  val examples = Map(
      "Nand" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Nand(), manager) {
          (c) => new NandTests(c)
        }
      },
      "Xor" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Xor(), manager) {
          (c) => new XorTests(c)
        }
      },
      "Nor" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Nor(), manager) {
          (c) => new NorTests(c)
        }
      },
      "Xnor" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Xnor(), manager) {
          (c) => new XnorTests(c)
        }
      },
      "Mux" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Mux(), manager) {
          (c) => new MuxTests(c)
        }
      },
      "Mux4" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Mux4(), manager) {
          (c) => new Mux4Tests(c)
        }
      },
      "FullAdder" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new FullAdder(), manager) {
          (c) => new FullAdderTests(c)
        }
      },
      "FullAdder2bit" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new FullAdder2bit(), manager) {
          (c) => new FullAdder2bitTests(c)
        }
      },
      "FullAdder32" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new FullAdder32(), manager) {
          (c) => new FullAdder32Tests(c)
        }
      },
      "ALUcontrol" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new ALUcontrol(), manager) {
          (c) => new ALUcontrolTests(c)
        }
      },
      "TypeDecode" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new TypeDecode(), manager) {
          (c) => new TypeDecodeTests(c)
        }
      },
      "ControlDecode" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new ControlDecode(), manager) {
          (c) => new ControlDecodeTests(c)
        }
      },
      "Immediate" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Immediate(), manager) {
          (c) => new ImmediateTests(c)
        }
      },
      "ALU" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new ALU(), manager) {
          (c) => new ALUTests(c)
        }
      },
      "Register32" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Register32(), manager) {
          (c) => new Register32Tests(c)
        }
      },
      "Control" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Control(), manager) {
          (c) => new ControlTests(c)
        }
      },
      "Main" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Main(), manager) {
          (c) => new MainTests(c)
        }
      },
      "JALR" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new JALR(), manager) {
          (c) => new JALRTests(c)
        }
      },
      "PC" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new PC(), manager) {
          (c) => new PCTests(c)
        }
      },
      "InsMem" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new InsMem(), manager) {
          (c) => new InsMemTests(c)
        }
      },
      "DataMem" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new DataMem(), manager) {
          (c) => new DataMemTests(c)
        }
      }
 
      
      
      
  )
  def main(args: Array[String]): Unit = {
    TutorialRunner("examples", examples, args)
  }
}

