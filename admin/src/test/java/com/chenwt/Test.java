package com.chenwt;


import java.io.IOException;
import java.util.Map;

/**
 * @class：Test
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-07 18:05
 * @description:
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String appClientInfo =  "{\n" +
                "\t\t\"type\": 1,\n" +
                "\t\"clientInfo\": {\n" +
                "\t\t\"phone\": \"138001380000\",\n" +
                "\t\t\"name1\": \"1\",\n" +
                "\t\t\"name2\": \"2\",\n" +
                "\t\t\"name3\": \"3\",\n" +
                "\t\t\"name4\": \"4\"\n" +
                "\t}\n" +
                "}";
//        Map jsonObjectMap = JacksonUtils.jsonToBean(appClientInfo,Map.class);
//
//        Integer type = (Integer) jsonObjectMap.get("type");

        System.out.println(1111);
    }
}
