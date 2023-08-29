package io;

import java.io.*;

/**
 * @Auther: ys
 * @Date: 2023/2/24 - 02 - 24 - 21:05
 */
public class StreamTest {
    public static void main(String[] args) {
        // 测试FileOutputStream
        //try {
        //    FileOutputStream fos = new FileOutputStream("output.txt");
        //    byte[] array = "java".getBytes();
        //    fos.write(array);
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}

        //try {
        //    FileInputStream fis = new FileInputStream("output.txt");
        //    int content = 0;
        //    while ((content = fis.read()) != -1){
        //        System.out.print((char)content);
        //    }
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}

        try {
            FileReader fr = new FileReader("output.txt");
            int content;
            while ((content = fr.read()) != -1){
                System.out.print((char)content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
