package TheDevineHospital.TestByJUnit;

import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.ParseFile.Jackson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestJackson extends Assert {
    private Jackson jackson;

    @Before
    public void initialization(){
        jackson = new Jackson();
    }
/*
* @return Надо бы придумать что-то другое
* */
    @Test
    public void parse(){
        assertFalse(jackson.parse("hospital.json") == new Hospital());
    }
}
