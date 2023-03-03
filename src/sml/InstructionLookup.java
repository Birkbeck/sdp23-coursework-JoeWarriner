package sml;

import sml.instruction.*;

import java.util.HashMap;
import java.util.Map;

public class InstructionLookup {
    private final HashMap<String, Class<?>> lookup = new HashMap<>(Map.of(
            "add", AddInstruction.class,
            "sub", SubInstruction.class,
            "div", DivInstruction.class,
            "jnz", JnzInstruction.class,
            "mov", MovInstruction.class,
            "mul", MulInstruction.class,
            "out", OutInstruction.class
    ));

    public Class<?> get(String opcode){
        return lookup.get(opcode);
    }
}
