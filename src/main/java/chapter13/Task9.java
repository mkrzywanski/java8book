package chapter13;

import java.util.Locale;
import java.util.ResourceBundle;

public class Task9 {

    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag("pl_PL"));
        System.out.println(resourceBundle.getString("hello"));
    }

}
