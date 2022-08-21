package niewidzialny84.github.headless.utils;

import java.util.Random;

public final class RandomGenerator
{
    private static final Random randomGenerator = new Random();

    public static int randomInt(int min,int max) {
        return randomGenerator.nextInt(max+1-min) + min;
    }

    public static double randomDouble()
    {
        return randomGenerator.nextDouble();
    }
}
