package TheDevineHospital.TheCommandCenterOfThisProgramm;

import TheDevineHospital.ParseFile.ConvertToXmlFromXml.XmlConverter;

/**
 * Сохраняет изменённую/созданную инфу о пациентах
 */
public class SaveInfo {
    public static void saveAll() {
        XmlConverter xmlConverter = new XmlConverter();//сохраняем пациентов в xml
        xmlConverter.convertToXml();
        xmlConverter = null;
    }
}
