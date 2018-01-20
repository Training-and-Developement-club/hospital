package TheDevineHospital.TheCommandCenterOfThisProgramm;

import TheDevineHospital.ParseFile.ConvertToXmlFromXml.XmlConverter;

public class SaveInfo {
    public static void saveAll(){
        XmlConverter.convertToXml();//сохраняем пациентов в xml
    }
}
