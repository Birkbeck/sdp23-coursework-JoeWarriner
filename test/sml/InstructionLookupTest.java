package sml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.instruction.AddInstruction;

import java.io.IOException;

public class InstructionLookupTest {

    @Test
    void testLookupBuilder() throws IOException {
        InstructionLookup testLookup = new InstructionLookup("src/sml/example.xml");
        Assertions.assertEquals(AddInstruction.class, testLookup.get("add"));

    }
}
