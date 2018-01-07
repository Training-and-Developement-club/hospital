package TheDevineHospital.ParseFile.DateConverter_НеПомнюЗачемСоздал;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateConvert extends JsonDeserializer<Date> {
    private final String[] format = new String[]{"yyyy-MM-dd HH:mm", "yyyy-MM-dd"};


    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        for (String format : this.format) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                return sdf.parse(jsonParser.getValueAsString());

            } catch (Exception ex) {
            }
        }


        return null;
    }
}
