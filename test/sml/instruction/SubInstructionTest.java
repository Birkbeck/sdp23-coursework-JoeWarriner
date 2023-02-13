package sml.instruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;

import static sml.Registers.Register.*;


public class  SubInstructionTest extends InstructionTest {

    @Test
    void executeValid() {
        registers.set(EAX, 5 );
        registers.set(EBX, 6 );
        Instruction instruction = new SubInstruction(null, EAX, EBX);
        instruction.execute(machine);
        Assertions.assertEquals(-1, machine.getRegisters().get(EAX));
    }
}
