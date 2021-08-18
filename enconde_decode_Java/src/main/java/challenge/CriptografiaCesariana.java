package challenge;

import java.util.ArrayList;
import java.util.Locale;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        int key = 3;
        char[] chars = texto.toCharArray();

        for (int i = 0; i < texto.length(); i++ ) {
            if (chars[i] >= 97 && chars[i] <= 122) {
                chars[i] += key;
            } else if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += key + 32;
            }
        }
        String message = new String(chars);
        System.out.println(message);
        return message;
    }

    @Override
    public String descriptografar(String texto) {
        int key = 3;
        char[] chars = texto.toCharArray();

        for (int i = 0; i < texto.length(); i++ ) {
            if (chars[i] >= 97 && chars[i] <= 122) {
                chars[i] -= key;
            } else if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] -= key - 32;
            }
        }

        String message = new String(chars);
        System.out.println(message);
        return message;
    }
}
