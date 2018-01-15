package TheDevineHospital.ParseFile.ConvertToXmlFromXml;

import TheDevineHospital.EntityClasses.Patients.Patient;
import TheDevineHospital.EntityClasses.Patients.PatientList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/*
 * Для конвертации созданных обьектов в текстовый файл с расширением xml.
 * @param fileName в нём хранится имя файла со списком пациентов.
 */
public class XmlConverter {
    private static String fileName = "patient.xml";



    /*
     *  Конвертация(или по java-вски сериализация) java-обьектов в файл с расширением xml,
     * C помощью библиотеки DOM.
     * */
    public static PatientList convertToXml(){
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        PatientList patientList = PatientList.newInstance();

        Element patients = document.createElement("Patients");
        document.appendChild(patients);

        for(int i = 0;i<patientList.getPatients().size();i++){
            Element patient = document.createElement("Patient");
            patient.setAttribute("ID",String.valueOf(patientList.getPatients().get(i).getId()));
            patients.appendChild(patient);

            Element fullName = document.createElement("name");
            fullName.setTextContent(patientList.getPatients().get(i).getFullName().get("Имя") + " "
                    + patientList.getPatients().get(i).getFullName().get("Фамилия") + " "
                    + patientList.getPatients().get(i).getFullName().get("Отчество"));
            patient.appendChild(fullName);

            Element age = document.createElement("age");
            //***Сделать метод, который из даты рождения будет выводить возраст челика********************************************
            patient.appendChild(age);

            Element complaints = document.createElement("complaints");//Симптомы (или жалобы человека)
            complaints.setTextContent(patientList.getPatients().get(i).getComplaints());
            patient.appendChild(complaints);

            Element gender = document.createElement("gender");
            gender.setTextContent(String.valueOf(patientList.getPatients().get(i).getGender()));
            patient.appendChild(gender);

            Element dateOfbirthday = document.createElement("dateOfbirthday");
            dateOfbirthday.setTextContent(patientList.getPatients().get(i).getDateOfbirthday().toString());
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
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");//команда для сохранения глаз смотрящего в XML(форматирование короче)
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            }
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + File.separator + fileName ));
            try {
                transformer.transform(source,result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }

        }














        return patientList;
    }
    public static void convertFromXml(){

    }


    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        XmlConverter.fileName = fileName;
    }
}
