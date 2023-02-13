package sml.instruction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sml.Instruction;

import static sml.Registers.Register.*;

class MovInstructionTest extends  InstructionTest {

    @Test
    void executeValid() {
        registers.set(EAX, 5);
        Instruction instruction = new MovInstruction(null, EAX, "5");
        instruction.execute(machine);
        Assertions.assertEquals(5, machine.getRegisters().get(EAX));
    }

}