package sml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sml.instruction.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class InstructionLookup {

    private final HashMap<String, Class<?>> lookup = new HashMap<>();

    public InstructionLookup(String filepath) throws IOException {
        try {
            buildLookupTable(filepath);
        } catch (Exception e) {
            throw new IOException("XML import didn't work");
        }
    }
    public Class<?> get(String opcode){
        return lookup.get(opcode);
    }


    public void buildLookupTable(String filepath) throws ClassNotFoundException, ParserConfigurationException, IOException, SAXException {

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
    }


}
