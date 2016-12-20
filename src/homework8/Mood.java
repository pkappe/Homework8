
package homework8;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Phil Kappe
 */
class Mood
{

    private ArrayList<Integer> theMood = new ArrayList<>();

    /**
     * Constructor to generate 31 moods.
     */
    Mood()
    {
        Random rand = new Random();
        int count = 0;
        while (count < 31)
        {
            int randomNum = rand.nextInt(8);
            int toNegative = randomNum - 4;
            if (toNegative >= -3)
            {
                theMood.add(toNegative);
                count++;
            }
        }
    }

    /**
     * Populate the moods from a file.
     *
     * @param file The file in which the moods are contained.
     */
    Mood(String file)
    {
        try (Scanner scan = new Scanner(new File(file)))
        {
            while (scan.hasNext())
            {
                theMood.add(scan.nextInt());
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * Get the moods.
     *
     * @return An ArrayList of the moods.
     */
    ArrayList<Integer> getMoods()
    {
        return theMood;
    }

    /**
     * Sort the moods in the ArrayList.
     *
     * @return The ArrayList of moods.
     */
    ArrayList<Integer> sortedMood()
    {
        Collections.sort(theMood);
        return theMood;
    }

    /**
     * Generate a file of the moods from a random array list.
     */
    void generateMoodFile()
    {
        try (PrintWriter print = new PrintWriter("Moods.txt"))
        {
            for (Integer nums : theMood)
            {
                print.println(nums);
            }
            print.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * Check the array of moods for the values between -3 and 3.
     *
     * @return true if values fall in range, otherwise false.
     */
    boolean moodsAreValid()
    {
        boolean tempBool = true;
        for (Integer nums : theMood)
        {
            if (nums < -3 && nums > 3)
            {
                tempBool = false;
            }
        }
        return tempBool;
    }

    /**
     * Checks all the days in the month to find how many are good mood days.
     *
     * @return The value of good mood days.
     */
    int goodMoodDays()
    {
        int goodCount = 0;
        for (Integer nums : theMood)
        {
            if (nums >= 0)
            {
                goodCount++;
            }
        }
        return goodCount;
    }

    /**
     * Checks all the days in the month to find how many are bad mood days.
     *
     * @return The value of bad mood days.
     */
    int badMoodDays()
    {
        int badCount = 0;
        for (Integer nums : theMood)
        {
            if (nums < 0)
            {
                badCount++;
            }
        }
        return badCount;
    }

    /**
     * Calculates the okay mood days: Days that fall between -1 and 1.
     *
     * @return A number of the total number of okay mood days.
     */
    int okMoodDays()
    {
        int okCount = 0;
        for (Integer nums : theMood)
        {
            if (nums >= -1 && nums <= 1)
            {
                okCount++;
            }
        }
        return okCount;
    }

    /**
     * Counts the longest run of increasing mood days.
     *
     * @return Returns a value for the total number of increasing moods.
     */
    int increasingMoodDays()
    {
        int tempNum = -3;
        int tempLongestRunCount = 0;
        int finalLongestRunCount = 0;
        for (Integer nums : theMood)
        {
            if (nums >= tempNum)
            {
                tempNum = nums;
                tempLongestRunCount++;
                if (tempLongestRunCount > finalLongestRunCount)
                {
                    finalLongestRunCount = tempLongestRunCount;
                }
            }
            else
            {
                tempNum = -3;
                tempLongestRunCount = 0;
            }
        }
        return finalLongestRunCount;
    }

    /**
     * Calculates the number of decreasing mood days.
     *
     * @return A number with the longest run of decreasing mood days.
     */
    int decreasingMoodDays()
    {
        int tempNum = 3;
        int tempLongestRunCount = 0;
        int finalLongestRunCount = 0;
        for (Integer nums : theMood)
        {
            if (nums < tempNum)
            {
                tempNum = nums;
                tempLongestRunCount++;
                if (tempLongestRunCount > finalLongestRunCount)
                {
                    finalLongestRunCount = tempLongestRunCount;
                }
            }
            else
            {
                tempNum = -3;
                tempLongestRunCount = 0;
            }
        }
        return finalLongestRunCount;
    }

    /**
     * Get a String value of the moods.
     *
     * @return A String of the moods.
     */
    @Override
    public String toString()
    {
        String tempString = "";
        for (Integer nums : theMood)
        {
            tempString += nums.toString() + ", ";
        }
        int tempLength = tempString.length() - 2;

        return tempString.substring(0, tempLength);
    }

}
