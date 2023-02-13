package sml.instruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

public class DivInstructionTest extends InstructionTest{

    @Test
    void executeValid() {
        registers.set(EAX, 10 );
        registers.set(EBX, 6 );
        Instruction instruction = new DivInstruction(null, EAX, EBX);
        instruction.execute(machine);
        Assertions.assertEquals(1, machine.getRegisters().get(EAX));
    }
}
