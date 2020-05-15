package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface ApiKeyGetter {
    static String getApiKey() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("ors.key"));
        return reader.readLine();
    }
}
