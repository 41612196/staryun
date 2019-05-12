package edu.snnu.startyun.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtil {
    public static String getStreamString(InputStream tInputStream){
        if (tInputStream != null){
            try{
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(tInputStream));
                StringBuilder tStringBuffer = new StringBuilder();
                String sTempOneLine = "";
                while ((sTempOneLine = tBufferedReader.readLine()) != null){
                    tStringBuffer.append(sTempOneLine);
                }
                return tStringBuffer.toString();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
}
