import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static int findMax(Integer[] input)
    {
        int currentHighest = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] > currentHighest)
            {
                currentHighest = input[i];
            }
        }
        return currentHighest;
    }

    public static Integer[] findDuplicates(Integer[] input)
    {
        Integer[] duplicates = new Integer[input.length];
        boolean hasDupe;
        int dupCounter = 0;

        for (int i = 0; i < input.length; i++)
        {
            boolean seenBefore = false;
            for (int j = 0; j < i; j++)
            {
                if (input[i].equals(input[j])) seenBefore = true;
            }
            if (seenBefore) continue;

            hasDupe = false;
            for (int j = i + 1; j < input.length; j++)
            {
                if (input[i].equals(input[j])) hasDupe = true;
            }
            if (hasDupe)
            {
                duplicates[dupCounter] = input[i];
                dupCounter++;
            }
        }

        return Arrays.copyOf(duplicates, dupCounter);
        
    }

    public static Integer[] findUnique(Integer[] input)
    {
        Integer[] uniqueNums = new Integer[input.length];
        boolean hasDupe;
        int uniqueCount = 0;

        for (int i = 0; i < input.length; i++)
        {
            hasDupe = false;
            for (int j = 0; j < input.length; j++)
            {
                if (i == j) continue; // same index - doesn't count
                if (input[i].equals(input[j])) hasDupe = true;
            }
            if (!hasDupe)
            {
                uniqueNums[uniqueCount] = input[i];
                uniqueCount++;
            }
        }

        return Arrays.copyOf(uniqueNums, uniqueCount);
    }
}
