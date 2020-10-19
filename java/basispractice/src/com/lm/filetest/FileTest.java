package com.lm.filetest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author luoming
 * @date 2020/05/18
 */
public class FileTest {

    public static void main(String[] args) throws Exception {

        String path = "C:/Users/luoming/Desktop/采集5.18错误数据/T_JCXX_JCJBXXerrorinfo.txt";
        // win系统
        // String path = "c:\\hello.txt";
        FileInputStream fileInputStream = new FileInputStream(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        fileInputStream.close();

    }
}
