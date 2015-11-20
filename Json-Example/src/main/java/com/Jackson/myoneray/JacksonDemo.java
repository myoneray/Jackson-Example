package com.Jackson.myoneray;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {
    public static void main(String[] args) throws ParseException, IOException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        User userA = new User();
        userA.setName("小民");
        userA.setEmail("xiaomin@sina.com");
        userA.setAge(20);
        userA.setBirthday(dateformat.parse("1996-10-01"));

        User userB = new User();
        userB.setName("小兵");
        userB.setEmail("xiaobing@sina.com");
        userB.setAge(20);
        userB.setBirthday(dateformat.parse("1999-10-01"));

        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        // User类转JSON
        // 输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
        String jsonA = mapper.writeValueAsString(userA);
        String jsonB = mapper.writeValueAsString(userB);
        System.out.println(jsonA);
        System.out.println(jsonB);

        // Java集合转JSON
        // 输出结果：[{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}]
        List<User> users = new ArrayList<User>();
        users.add(userA);
        users.add(userB);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);
    }
}