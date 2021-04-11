package cat.itb.servlettest.utilities;

import java.util.Random;

public class Utilities
{
    public static String generateCode(int length)
    {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) code.append(random.nextInt(10));
        return code.toString();
    }
}