package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.ArrayList;
import java.util.List;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

public class JnzInstruction extends Instruction {
    private final RegisterName target;
    private final String targetLabel;

    public static final String OP_CODE = "jnz";

    public JnzInstruction(String label, RegisterName target, String targetLabel) {
        super(label, OP_CODE);
        this.target = target;
        this.targetLabel = targetLabel;
    }

    @Override
    public int execute(Machine m) {
        // TODO: Use Stream API instead of for loop.
        int reg = m.getRegisters().get(target);
        if (reg != 0) {
            List<Instruction> prog = m.getProgram();
            for (int i = 0; i < prog.size(); i++) {
                if (prog.get(i).getLabel() == this.targetLabel){
                    return i;
                }
            }
        }
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + target + " " + targetLabel;
    }
}
