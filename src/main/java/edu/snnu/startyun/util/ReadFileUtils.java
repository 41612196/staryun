package edu.snnu.startyun.util;

import java.io.*;

public class ReadFileUtils {

    /**
     * @param filePath 读取本地文件的输入流
     * @return byte[]
     */
    public static byte[] getIns(String filePath){
        try {
            InputStream in = new FileInputStream(new File(filePath));
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            return swapStream.toByteArray();
        } catch (FileNotFoundException e) {
            System.out.println("请检查文件路径是否正确");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream bytesToInputStream(byte[] bytes) {

        return new ByteArrayInputStream(bytes);
    }

    /**
     * 读取数据库表中文件的输出流
     * @param targetPath 文件存储到本地的路径
     * @return FileOutputStream
     */
    public static FileOutputStream getOuts(String targetPath){
        File file = new File(targetPath);
        String path = targetPath.substring(0,targetPath.lastIndexOf("\\"));
        //如果文件不存在则创建目录
        if (!file.exists()){
            new File(path).mkdir();
        }

        FileOutputStream fos ;
        try {
            fos = new FileOutputStream(file);
            return fos;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取数据库中的文件二进制数据写出目标地址
     * @param in 输入流
     * @param out 输出流
     * @return boolean
     */
    public static boolean readBinaryFile(InputStream in, OutputStream out){
        try {
            int len;
            byte[] b = new byte[1000];
            while ((len=in.read(b)) != -1){
                out.write(b,0,len);
            }
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
