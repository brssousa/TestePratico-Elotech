package br.com.bruno.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Este font foi extraido de um site. Feito algumas alterações para atender a demando do sistema.
 *
 * Fonte: https://receitasdecodigo.com.br/java/validar-email-em-java
 */

public class ValidaEmail {

    public static boolean isEmail(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
