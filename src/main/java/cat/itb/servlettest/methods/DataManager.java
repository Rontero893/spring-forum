package cat.itb.servlettest.methods;

import java.util.Arrays;

public class DataManager
{
    private static final char[] DNI_LETTERS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    public static final int ISBN_DIGIT_SIZE = 12;
    public static final int DNI_DIGIT_SIZE = 9;

    public static char getDNILetter(int dni) { return DNI_LETTERS[dni % 23]; }

    public static long getISBNControlNumber(long isbn)
    {
        long[] values = Arrays.stream(String.valueOf(isbn).split("")).mapToLong(Long::parseLong).toArray();
        long evens = 0, odds = 0;
        for (long digit : values) { if(digit % 2 == 0) evens += digit; else odds += digit; }
        return getDividendOf10For(evens + 3 * odds);
    }

    private static long getDividendOf10For(long number) { long i = 1; while ((number + i) % 10 != 0) i++; return i; }
}
