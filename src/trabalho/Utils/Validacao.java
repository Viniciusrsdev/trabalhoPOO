package trabalho.Utils;

import java.util.Date;
import java.util.Scanner;
import java.util.function.Function;

public class Validacao {

    public static String validarStringScan(Function<String, Boolean> validador, String titulo, String erro) {
        Scanner scan = new Scanner(System.in);
        boolean validado;
        String s;
        do {
            System.out.println(titulo);
            s = scan.nextLine();
            validado = validador.apply(s);
            if (!validado) {
                System.out.println(erro);
            }
        } while (!validado);
        return s;
    }

    public static Boolean validarBooleanScan(Function<String, Boolean> validador, String titulo, String erro) {
        Scanner scan = new Scanner(System.in);
        boolean validado;
        String s;
        do {
            System.out.println(titulo);
            s = scan.nextLine();
            validado = validador.apply(s);
            if (!validado) {
                System.out.println(erro);
            }
        } while (!validado);
        return true;
    }

    public static Object validarObjectScan(Function<String, Object> validador, String titulo, String erro) {
        Scanner scan = new Scanner(System.in);
        Object object;
        do {
            System.out.println(titulo);
            String s = scan.nextLine();
            object = validador.apply(s);
            if (object == null) {
                System.out.println(erro);
            }
        } while (object == null);
        return object;
    }

    public static Date validarDateScan(Function<String, Object> validador, String titulo, String erro) {
        Scanner scan = new Scanner(System.in);
        Date date;
        do {
            System.out.println(titulo);
            String s = scan.nextLine();
            date = (Date) validador.apply(s);
            if (date == null) {
                System.out.println(erro);
            }
        } while (date == null);
        return date;
    }
}
