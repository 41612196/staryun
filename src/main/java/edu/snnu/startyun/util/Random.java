package edu.snnu.startyun.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Random {

    public static Integer getRandomInteger(int length){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Matcher m = p.matcher(uuid);
        return Integer.valueOf(m.replaceAll("").trim().substring(0,length));
    }
}
