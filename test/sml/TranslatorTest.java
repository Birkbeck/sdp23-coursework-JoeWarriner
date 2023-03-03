package sml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.instruction.AddInstruction;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TranslatorTest {

    @Test
    void getInstructionTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {
        Class<Translator> translatorClass = Translator.class;
        Method getInstruction = translatorClass.getDeclaredMethod("getInstruction", String.class);
        getInstruction.setAccessible(true);
        Field lineField = translatorClass.getDeclaredField("line");
        lineField.setAccessible(true);
        Language.importLanguage("src/sml/example.xml");
        Translator testTranslator = translatorClass.getDeclaredConstructor(String.class).newInstance("filename");
        lineField.set(testTranslator, "add EAX EBX");
        Object outputInstruction = getInstruction.invoke(testTranslator, "");
        Assertions.assertTrue(outputInstruction instanceof AddInstruction);
    }
}
