package sml;
import org.junit.jupiter.api.Assertions;
import sml.Registers;

import org.junit.jupiter.api.Test;

import static sml.Registers.Register.*;

public class RegistersTest {

    @Test
    void equalsTest(){
        Registers reg1 = new Registers();
        Registers reg2 = new Registers();
        reg1.set(EAX, 1);
        reg2.set(EAX, 1);
        Assertions.assertEquals(true, reg1.equals(reg2));
    }
}
