package TheDevineHospital.TestByJUnit;

import TheDevineHospital.DownloadFiles.URLDownload;
import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.ParseFile.HospitalParser.DOM;
import TheDevineHospital.ParseFile.HospitalParser.Jackson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestParsing extends Assert {
    private Jackson jackson;
    private DOM dom;

    @Before
    public void initialization(){
        jackson = new Jackson();
        dom = new DOM();
    }
/*
* Надо бы придумать что-то другое
* */
    @Test
    public void parse(){
        assertTrue(jackson.parse("hospital.json") != new Hospital());
        assertEquals(new Hospital(),dom.parse(URLDownload.getHospitalJSON()));
    }
}
