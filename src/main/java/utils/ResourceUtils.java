package utils;

import java.io.InputStream;

public class ResourceUtils {
    public static InputStream getResourceAsStream(String path) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }
        return is;
    }
}
