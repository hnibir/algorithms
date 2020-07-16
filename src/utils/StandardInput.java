package utils;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StandardInput {
    // assume Unicode UTF-8 encoding
    private static final String CHARSET_NAME = "UTF-8";
    // assume language = English, country = US for consistency with System.out.
    private static final Locale LOCALE = Locale.US;

    private static Scanner scanner;

    static {
        initializeScanner();
    }

    public StandardInput() {

    }

    private static void initializeScanner() {
        scanner = new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }

    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

    public static int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read 'int' value, but found \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read 'int' value, but no values are available");
        }
    }
}
