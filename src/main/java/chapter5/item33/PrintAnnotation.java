package chapter5.item33;
import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:20
 * @Description Use of asSubclass to safely cast to a bounded type token (Page 155)
 * @Version 0.0.1
 */
public class PrintAnnotation {
    static Annotation getAnnotation(AnnotatedElement element,
                                    String annotationTypeName) {
        // Unbounded type token
        Class<?> annotationType;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(
                annotationType.asSubclass(Annotation.class));
    }

    // Test program to print named annotation of named class
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println(
                "Usage: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        String className = args[0];
        String annotationTypeName = args[1]; 
        Class<?> klass = Class.forName(className);
        System.out.println(getAnnotation(klass, annotationTypeName));
    }
}
