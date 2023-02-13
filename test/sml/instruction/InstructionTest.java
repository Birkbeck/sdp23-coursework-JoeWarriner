package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import sml.Machine;
import sml.Registers;

import sml.Instruction;
import sml.Machine;
import sml.Registers;


abstract class InstructionTest {

    protected Machine machine;
    protected Registers registers;

    @BeforeEach
    void setUp() {
        machine = new Machine(new Registers());
        registers = machine.getRegisters();
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
        registers = null;
    }
}
