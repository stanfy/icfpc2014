package com.stanfy.icfp2014.lambdaprocessor;

import com.stanfy.icfp2014.lambdaprocessor.instructions.*;

import java.util.ArrayList;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class LambdaManProcessor {

  public ArrayList<LambdaManProcessorInstruction> loadedProgram;

  /*
   control register (program counter / instruction pointer)
   */
  public int c;

  // Data stack
  public ArrayList<Object> s = new ArrayList<>();

  // Control stack
  public ArrayList<Object> d;

  // environment stack
  public EnvironmentFrame e = new EnvironmentFrame();

  /*
  Returns top stack value
   */
  public Object topControlValue() {
    return d.get(d.size() - 1);
  }

  /*
 Returns top stack value  from controlStack
 */
  public Object popControlValue() {
    Object value = d.remove(d.size() - 1);
    return value;
  }

  /*
  Push specified stack value to Control Stack
   */
  public void pushControlValue(Object o) {
    d.add(o);
  }

  /*
Returns top stack value
 */
  public Object topStackValue() {
    return s.get(s.size() - 1);
  }

  /*
Returns top stack value
*/
  public Object popStackValue() {
    Object value = s.get(s.size() - 1);
    s.remove(s.size() - 1);
    return value;
  }

  /*
  Push specified stack value
   */
  public void pushStackValue(Object o) {
    s.add(o);
  }

  public LambdaManProcessor(ArrayList<LambdaManProcessorInstruction> instructions) {
    // Address is just an index of instruction
    loadedProgram = instructions;
  }

  static ArrayList<LambdaManProcessorInstruction> parseAsmProgram(String program) {
    ArrayList<LambdaManProcessorInstruction> instructions = new ArrayList<>();
    String[] lines = program.split("\n");

    for (String s : lines) {
      String v = s.trim();
      String[] command = v.split("\\s+");
      if (command.length > 0) {

        LambdaManProcessorInstruction instruction = null;

        String commandName = command.length > 0 ? command[0] : null;
        String op1 = command.length > 1 ? command[1] : null;
        String op2 = command.length > 2 ? command[2] : null;
        String op3 = command.length > 3 ? command[3] : null;

        Integer op1Int = op1 == null ? null : Integer.valueOf(op1);
        Integer op2Int = op2 == null ? null : Integer.valueOf(op2);

        // Ignore
        if (commandName.equals(";")) {
          // Ignore
          continue;
        } else {
          if (commandName.equals("LDC")) {
            instruction = new LoadConstantInstruction(op1Int);
          } else {
            if (commandName.equals("LD")) {
              instruction = new LoadFromEnvironmentInstruction(op1Int, op2Int);
            } else if (commandName.equals("ADD")) {
              instruction = new AddInstruction();

            } else if (commandName.equals("SUB")) {
              instruction = new SubInstruction();
            } else if (commandName.equals("MUL")) {
              instruction = new MulInstruction();
            } else if (commandName.equals("DIV")) {
              instruction = new DivInstruction();
            } else if (commandName.equals("CEQ")) {
              instruction = new CompareEqualInstruction();
            } else if (commandName.equals("CGT")) {
              instruction = new CompareGreaterThanInstruction();
            } else if (commandName.equals("CGTE")) {
              instruction = new CompareGreaterThanOrEqualInstruction();
            } else if (commandName.equals("ATOM")) {
              instruction = new CheckAtomInstruction();

            } else if (commandName.equals("CONS")) {
              instruction = new ConsInstruction();
            } else if (commandName.equals("CAR")) {
              instruction = new CARInstruction();
            } else if (commandName.equals("CDR")) {
              instruction = new CDRInstruction();
            } else if (commandName.equals("SEL")) {
              instruction = new SELInstruction(op1Int, op2Int);
            } else if (commandName.equals("JOIN")) {
              instruction = new JoinInstruction();
            } else if (commandName.equals("LDF")) {
              instruction = new LoadFunctionInstruction(op1Int);
            } else if (commandName.equals("AP")) {
              instruction = new APInstruction(op1Int);
            } else if (commandName.equals("RTN")) {
              instruction = new ReturnFunctionInstruction();
            } else if (commandName.equals("DUM")) {
              instruction = new DUMInstruction(op1Int);
            } else if (commandName.equals("RAP")) {
              instruction = new RAPInstruction(op1Int);
            } else if (commandName.equals("TSEL")) {
              instruction = new TSELInstruction(op1Int, op2Int);
            } else if (commandName.equals("TAP")) {
              instruction = new TAPInstruction(op1Int);
            } else if (commandName.equals("TRAP")) {
              instruction = new TRAPInstruction(op1Int);
            } else if (commandName.equals("ST")) {
              instruction = new STInstruction(op1Int, op2Int);
            } else if (commandName.equals("DBUG")) {
              instruction = new DBUGInstruction();
            } else if (commandName.equals("BRK")) {
              instruction = new BRKInstruction();
            }
          }
        }


        if (instruction != null) {
          instructions.add(instruction);
        }
      }
    }
    return instructions;
  }

  public InstructionResult step() {
    // Get current instruction
    if (c >= loadedProgram.size()) {
      return InstructionResult.MACHINE_STOP;
    }
    LambdaManProcessorInstruction instruction = loadedProgram.get(c);
    return instruction.processOn(this);
  }

  public void run() {
    while (step() == InstructionResult.SUCCESS) {
      System.out.println("Next step");
    }
  }
}
