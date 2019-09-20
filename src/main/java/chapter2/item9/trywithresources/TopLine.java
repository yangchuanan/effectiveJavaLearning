package chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 15:20
     * @Description try-with-resources - the the best way to close resources!  (Page 35)
     */
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
