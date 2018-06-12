package com.bolad.popularblogs.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");

    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
        throws IOException, JsonProcessingException {

        String formattedDate = dateFormat.format(date);
        generator.writeString(formattedDate);
    }
}
