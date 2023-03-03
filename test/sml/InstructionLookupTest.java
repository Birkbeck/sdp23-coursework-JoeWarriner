package sml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.instruction.AddInstruction;

import java.io.IOException;

public class InstructionLookupTest {

    @Test
    void testLookupBuilder() throws IOException {
        Language.importLanguage("src/sml/example.xml");
        Assertions.assertEquals(AddInstruction.class, Language.get("add"));

    }
}
