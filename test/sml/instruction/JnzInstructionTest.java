package sml.instruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

public class JnzInstructionTest  extends  InstructionTest{

    // TODO: Refactor this test class, we are probably unecessarily duplicating code here.

    @Test
    void executeValid() throws NoSuchFieldException, IllegalAccessException{
        Class<Machine> machineClass = Machine.class;
        Field programField =  machineClass.getDeclaredField("program");
        ArrayList<Instruction> mockProgram = new ArrayList<>();
        registers.set(EAX, 5 );
        registers.set(EBX, 6 );
        mockProgram.add(new AddInstruction(null, EAX, EBX ));
        mockProgram.add(new AddInstruction("1", EAX, EBX ));
        programField.setAccessible(true);
        programField.set(machine, mockProgram);
        Instruction instruction = new JnzInstruction(null, EAX, "1");
        int programCounterUpdate = instruction.execute(machine);
        Assertions.assertEquals(1, programCounterUpdate);
    }

    @Test
    void executeValid2() throws NoSuchFieldException, IllegalAccessException{
        Class<Machine> machineClass = Machine.class;
        Field programField =  machineClass.getDeclaredField("program");
        ArrayList<Instruction> mockProgram = new ArrayList<>();
        registers.set(EAX, 5 );
        registers.set(EBX, 6 );
        Instruction instruction = new JnzInstruction(null, EAX, "1");
        mockProgram.add(new AddInstruction(null, EAX, EBX ));
        mockProgram.add(instruction);
        mockProgram.add(new AddInstruction("1", EAX, EBX ));
        programField.setAccessible(true);
        programField.set(machine, mockProgram);
        int programCounterUpdate = instruction.execute(machine);
        Assertions.assertEquals(2, programCounterUpdate);
    }
}