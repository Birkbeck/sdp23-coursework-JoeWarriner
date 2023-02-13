package sml.instruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static sml.Registers.Register.*;

public class OutInstructionTest extends InstructionTest {

    @Test
    void executeValid(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        registers.set(EAX, 5);
        Instruction instruction = new OutInstruction(null, EAX);
        System.setOut(new PrintStream(outContent));
        instruction.execute(machine);
        Assertions.assertEquals("5\r\n", outContent.toString());
    }




}
