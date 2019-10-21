# RISC-V Single Cycle Core Parwaz
### Designed by Muhammad Shahzaib
Hello , I am a student of software engineering in Usman Institute of Technology. I totally understood the dtatpath of RISC-V and also implemented it on logisim.
I have developed a single cycle RISC-V core and now looking forward for Pipeline process . 

First of all get started by cloning this repository on your machine.  
```ruby
git clone https://github.com/merledu/Parwaz-Core.git
```
Create a .txt file and place the ***hexadecimal*** code of your instructions simulated on ***Venus*** (RISC-V Simulator)\
Each instruction's hexadecimal code must be on seperate line as following. This program consists of 9 instructions.
```
00500113
00500193
014000EF
00120293
00502023
00002303
00628663
00310233
00008067
```
Then perform the following step
```ruby
cd tornadic/Parwaz/src/main/scala/risccv
```
Open **InsMem.scala** with this command. You can also manually go into the above path and open the file in your favorite text editor.
```ruby
open InsMem.scala
```
Find the following line
``` python
loadMemoryFromFile(mem,"/home/shahzaib/chotu.txt")
```
Change the .txt file path to match your file that you created above storing your own program instructions.\
After setting up the InsMem.scala file, go inside the Parwaz folder.
```ruby
cd tornadic/Parwaz
```
And enter
```ruby
sbt
```
When the terminal changes to this type
```ruby
sbt:Parwaz>
```
Enter this command
```ruby
sbt:Parwaz> test:runMain riscv.Launcher Main
```
After you get success
```ruby
sbt:Parwaz> test:runMain riscv.Launcher Main --backend-name verilator
```
After success you will get a folder ***test_run_dir*** on root of your folder. Go into the examples folder inside.\
There you will find the folder named Main. Enter in it and you can find the Main.vcd file which you visualise on **gtkwave** to\
see your program running.

