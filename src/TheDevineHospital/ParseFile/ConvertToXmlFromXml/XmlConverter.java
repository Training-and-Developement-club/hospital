package TheDevineHospital.ParseFile.ConvertToXmlFromXml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/*
 * Для конвертации созданных обьектов в текстовый файл с расширением xml.
 */
public class XmlConverter {
    private static String fileName = "patient.xml";
    /*
     *  Конвертация(или по java-вски сериализация) java-обьектов в файл с расширением xml,
     * C помощью библиотеки Jackson.
     * */
    public static void convertToXml(){
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }



    }
    public static void convertFromXml(){

    }
}
