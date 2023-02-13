package sml.instruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

public class MulInstructionTest extends InstructionTest{

    @Test
    void executeValid() {
        registers.set(EAX, 5 );
        registers.set(EBX, 6 );
        Instruction instruction = new MulInstruction(null, EAX, EBX);
        instruction.execute(machine);
        Assertions.assertEquals(30, machine.getRegisters().get(EAX));
    }
}
