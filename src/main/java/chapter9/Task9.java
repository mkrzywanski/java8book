package chapter9;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class Task9 {
    public static void main(String[] args) throws IOException {
        String dff = "user" + ":" + "password";
        String b64 = Base64.getEncoder().encodeToString(dff.getBytes());


        URL url = new URL("https://test");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.addRequestProperty("Authorization", "Basic " + b64);

        urlConnection.connect();

    }
}
