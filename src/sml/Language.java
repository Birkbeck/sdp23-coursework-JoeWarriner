package sml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class Language {


    private static final HashMap<String, Class<?>> lookup = new HashMap<>();
    private static final Language instance = new Language();

    private Language() {

    }

    public static Class<?> get(String opcode){
        return lookup.get(opcode);
    }

    public static void importLanguage(String filepath) throws IOException {
        try {
            DocumentBuilder xmlBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document langDefinition = xmlBuilder.parse(new File(filepath));
            langDefinition.getDocumentElement().normalize();
            NodeList kvPairs = langDefinition.getElementsByTagName("instruction");
            int numPairs = kvPairs.getLength();
            // Don't seem to be able to stream from Nodelist object, so using for loop. Naughty naughty.
            for (int i = 0; i < numPairs; i++){
                NamedNodeMap elements = kvPairs.item(i).getAttributes();
                lookup.put(elements.item(1).getNodeValue(), Class.forName(elements.item(0).getNodeValue()));
            }
        } catch (Exception e) {
            throw new IOException("XML import didn't work");
        }
}
    }



