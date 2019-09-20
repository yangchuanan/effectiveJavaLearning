package chapter2.item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 15:18
 * @Description try-finally 释放资源并不是最好的方式
 * try-finally - No longer the best way to close resources! (page 34)
 */
public class TopLine {
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
