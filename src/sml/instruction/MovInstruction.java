package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

public class MovInstruction extends Instruction {
    private final RegisterName target;
    private final int input;

    public static final String OP_CODE = "mov";

    public MovInstruction(String label, RegisterName target, String input) {
        super(label, OP_CODE);
        this.target = target;
        this.input = Integer.parseInt(input);
    }

    @Override
    public int execute(Machine m) {
        m.getRegisters().set(target, input);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + target + " " + input;
    }
}
