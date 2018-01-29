package hospital.parse.petient;

import hospital.entity.Patients.Gender;
import hospital.entity.Patients.Patient;
import hospital.entity.Patients.PatientList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Для сериализации созданных обьектов в xml и их десериализации.
 * C помощью библиотеки DOM
 */
public class DOM {
    private String fileName = "patient.xml";



    public void convertToXml() {
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        PatientList patientList = PatientList.getInstance();


        Element patients = document.createElement("Patients");
        document.appendChild(patients);


        for (int i = 0; i < patientList.getPatients().size(); i++) {
            Element patient = document.createElement("Patient");
            patient.setAttribute("ID", String.valueOf(patientList.getPatients().get(i).getId()));
            patients.appendChild(patient);

            Element fullName = document.createElement("name");
            fullName.setTextContent(patientList.getPatients().get(i).getFullName().get("Имя") + " "
                    + patientList.getPatients().get(i).getFullName().get("Отчество") + " "
                    + patientList.getPatients().get(i).getFullName().get("Фамилия"));
            patient.appendChild(fullName);



            Element complaints = document.createElement("complaints");
            complaints.setTextContent(patientList.getPatients().get(i).getComplaints());
            patient.appendChild(complaints);

            Element gender = document.createElement("gender");
            gender.setTextContent(String.valueOf(patientList.getPatients().get(i).getGender()));
            patient.appendChild(gender);

            Element dateOfbirthday = document.createElement("dateOfBirth");
            SimpleDateFormat spd = new SimpleDateFormat("dd-MM-yyyy");
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            spd.setTimeZone(timeZone);
            dateOfbirthday.setTextContent(spd.format(patientList.getPatients().get(i).getDateOfBirth()));
            patient.appendChild(dateOfbirthday);

            Element diseases = document.createElement("diseases");//Врачебное заключение(или диагноз)
            diseases.setTextContent(patientList.getPatients().get(i).getDiseases());
            patient.appendChild(diseases);

            Element isAlive = document.createElement("isAlive");
            isAlive.setTextContent(String.valueOf(patientList.getPatients().get(i).isAlive()));
            patient.appendChild(isAlive);


            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            }
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + File.separator + fileName));
            try {
                transformer.transform(source, result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }

        }

    }


    public void convertFromXml() {
        Document docomunt = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            docomunt = builder.parse(fileName);
        } catch (Exception ex) {
            System.out.println("fail");
        }


        PatientList patientList = PatientList.getInstance();
        Element listElement = docomunt.getDocumentElement();
        NodeList peopleList = listElement.getElementsByTagName("Patient");
        List<Patient> patients = new ArrayList<>();
        for (int i = 0; i < peopleList.getLength(); i++) {
            Node node = peopleList.item(i);
            Element element = (Element) node;
            int id = Integer.parseInt(peopleList.item(i).getAttributes().item(0).getNodeValue());
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            String complaints = element.getElementsByTagName("complaints").item(0).getTextContent();
            String gender = element.getElementsByTagName("gender").item(0).getTextContent();


            SimpleDateFormat spd = new SimpleDateFormat("dd-MM-yyyy");
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            spd.setTimeZone(timeZone);
            Date date = null;
            try {
                date = spd.parse(element.getElementsByTagName("dateOfBirth").item(0).getTextContent());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String diseases = element.getElementsByTagName("diseases").item(0).getTextContent();
            Boolean isAlive = Boolean.valueOf(element.getElementsByTagName("isAlive").item(0).getTextContent());
            String[] fullName = name.split(" ");
            if (gender.equals("F")) {
                patients.add(new Patient(id, fullName[0], fullName[1], fullName[2], complaints, Gender.F, date, diseases, isAlive));
            } else if (gender.equals("M")) {
                patients.add(new Patient(id, fullName[0], fullName[1], fullName[2], complaints, Gender.M, date, diseases, isAlive));
            }


        }
        patientList.setPatients(patients);
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
