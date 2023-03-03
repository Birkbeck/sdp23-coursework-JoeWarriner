package sml;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Labels;
import sml.instruction.MovInstruction;

import static sml.Registers.Register.EAX;

public class LabelsTest {

    @Test
    void nullHandling() {
        Labels testLabels = new Labels();
        testLabels.getAddress("some label");
    }
}
