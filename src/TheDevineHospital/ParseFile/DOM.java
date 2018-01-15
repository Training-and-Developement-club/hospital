package TheDevineHospital.ParseFile;

import TheDevineHospital.EntityClasses.Doctors;
import TheDevineHospital.EntityClasses.Hospital;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DOM extends Parse {
    /*
     *  STAX и SAX не стал использовать потому что XML - документ маленький,
     * да и само приложение не выполняет обработок гигантского кол-ва информации.
     */


    @Override
    public Hospital parse(String filaName) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        FileInputStream fileInputStream = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();
            fileInputStream = new FileInputStream(filaName);
            document = documentBuilder.parse(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Hospital hospital = new Hospital();
        Element root = document.getDocumentElement();


        NodeList nodeList = root.getElementsByTagName("name");
        Node node = nodeList.item(0);
        hospital.setName(node.getTextContent());



        nodeList = root.getElementsByTagName("location");
        Node node1 = nodeList.item(0);
        hospital.setLocation(node1.getTextContent());


        NodeList doctorsList = root.getElementsByTagName("doctors");
        List<Doctors>doctors = new ArrayList<>();
        for(int i = 0;i<doctorsList.getLength();i++){
            Node node2 = doctorsList.item(i);
            Element element = (Element)node2;
            doctors.add(new Doctors());
            doctors.get(i).setId(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
            doctors.get(i).setName(element.getElementsByTagName("name").item(0).getTextContent());
            doctors.get(i).setDegree(element.getElementsByTagName("degree").item(0).getTextContent());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            try {
                date = sdf.parse(element.getElementsByTagName("dateOfBirth").item(0).getTextContent());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            doctors.get(i).setDateOfBirth(date);
            doctors.get(i).setYearEperience(Integer.parseInt(element.getElementsByTagName("yearEperience").item(0).getTextContent()));
            List<String>type = new ArrayList<>();
            for(int j = 0;j<element.getElementsByTagName("type").getLength();j++){
               type.add(element.getElementsByTagName("type").item(j).getTextContent());

            }
            doctors.get(i).setType(type);
            doctors.get(i).setVisible(Boolean.valueOf(element.getElementsByTagName("visible").item(0).getTextContent()));

            }


        hospital.setDoctors(doctors);
        System.out.println(hospital.toString());

        return hospital;


    }
}
