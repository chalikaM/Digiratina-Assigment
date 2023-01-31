package com.example.company.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {

    public static Long getTimeTaken(Long startTime) {
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static String convertToString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return "Cannot convert the object to a string";
        }
    }
}
