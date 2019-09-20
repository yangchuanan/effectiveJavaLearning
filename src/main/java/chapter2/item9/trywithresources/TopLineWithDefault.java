package chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLineWithDefault {
    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 15:21
     * @Description try-with-resources with a catch clause  (Page 36)
     */
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    public static void main(String[] args) {
        String path = args[0];
        System.out.println(firstLineOfFile(path, "Toppy McTopFace"));
    }
}
