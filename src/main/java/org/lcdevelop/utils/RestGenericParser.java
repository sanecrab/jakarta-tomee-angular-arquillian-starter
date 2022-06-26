package org.lcdevelop.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LuisCarlosGonzalez
 */
public class RestGenericParser {

    public static String objectToJSON(Object object, Boolean indentOutput) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (Boolean.TRUE.equals(indentOutput)) {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
        }
        StringWriter result = new StringWriter();
        try {
            objectMapper.writeValue(result, object);
        } catch (Exception e) {
            System.out.println("ERROR objectToJSON(): " + e.getMessage());
        }
        return result.toString();
    }

    public static <T> List<T> JSONToEntityList(String jsonData, Class<T> objectType) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<T> result = null;
        try {
            result = objectMapper.readValue(jsonData, objectMapper.getTypeFactory().constructCollectionType(List.class, objectType));
        } catch (Exception e) {
            System.out.println("ERROR objectToJSON(): " + e.getMessage());
        }
        return result;
    }

    public static <T> T JSONToEntity(String jsonData, Class<T> objectType) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
        T result = null;
        try {
            result = objectMapper.readValue(jsonData, objectType);
        } catch (Exception e) {
        }
        return result;
    }

    public static String dateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        if (date != null) {
            try {
                return dateFormat.format(date);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Date stringToDate(String dateString, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        if (dateString != null) {
            try {
                return dateFormat.parse(dateString);
            } catch (Exception e) {
            }
        }
        return null;
    }
}
