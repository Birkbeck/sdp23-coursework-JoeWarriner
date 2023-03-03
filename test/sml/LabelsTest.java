package sml;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Labels;
import sml.instruction.MovInstruction;

import static sml.Registers.Register.EAX;

public class LabelsTest {

    @Test
    void toStringTest() {
        Labels testLabels = new Labels();
        testLabels.addLabel("Foo", 1);
        testLabels.addLabel("Bar", 2);
        testLabels.addLabel("Baz", 3);
        Assertions.assertEquals("[Foo -> 1, Bar -> 2, Baz -> 3]", testLabels.toString());
    }
}
