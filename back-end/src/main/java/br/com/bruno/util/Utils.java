package br.com.bruno.util;

import java.util.Calendar;
import java.util.Date;

public class Utils {

    /**
     * Retorna apenas numeros. Removendo caracteres especiais da string.
     *
     * @param s
     * @return
     */
    public static String somenteNumero(String s){
        return s.replaceAll("[^0-9]", "");
    }


    /**
     * Verifica se a data é maior que a data atual
     *
     * @param data
     * @return
     */
    public static boolean isDataFutura(Date data){
        return data.after(new Date());
    }
}
