package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DebugTool {
    public static void main(String[] args) 
                               throws NoSuchMethodException {
        Class<SomeObject> c = SomeObject.class;

        Method method = c.getMethod("doSomething");
        if(method.isAnnotationPresent(Debug.class)) {
            System.out.println("@Debug is found.");

            Debug debug = method.getAnnotation(Debug.class);
            System.out.println("\tvalue = " + debug.value());
            System.out.println("\tname = " + debug.name());
        }
        else {
            System.out.println("@Debug is not found.");
        }

        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations) {
            System.out.println(
                    annotation.annotationType().getName());
        }
    }
} 