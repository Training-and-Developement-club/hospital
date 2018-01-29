package hospital.controller.verification;

import hospital.parse.petient.DOM;

/**
 * Сохраняет изменённую/созданную инфу о пациентах
 */
public class SaveInfo {
    public static void saveAll() {
        DOM DOM = new DOM();//сохраняем пациентов в xml
        DOM.convertToXml();
        DOM = null;
    }
}
