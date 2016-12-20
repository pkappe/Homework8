
package homework8;

/**
 * Some (all?) people feel differently when the seasons change. Suppose we
 * decide to log our “mood” for every day in December so we can analyze our
 * overall feeling. Each mood value is an integer either -3, -2, -1, 0, 1, 2, or
 * 3. If our mood is zero, we feel fine. If our mood is 3, we feel terrific. If
 * our mood is -3, we feel terrible.
 * <P>
 *
 * Write a Java Mood class that has an ArrayList (not a primitive array)
 * instance variable of 31 integers and the following methods:
 * <p>
 *
 * • ▬ Your default constructor should initialize the ArrayList with random
 * (valid mood) integers. <br>
 * • ▬ Your parameterized constructor should initialize the ArrayList with
 * values read from a file. <br>
 * • ▬ Write a predicate that returns true if the ArrayList has only valid mood
 * values. <br>
 * • ▬ Calculate the number of good mood days, the days with mood values at
 * least zero. <br>
 * • ▬ Calculate the number of bad mood days, the days with mood values less
 * than zero. <br>
 * • ▬ Calculate the number of okay mood days, the days with mood values between
 * -1 and 1, inclusive. <br>
 * • ▬ Count the longest run of increasing mood days. For example, is 5. <br>
 * • ▬ Looking only at non-overlapping pairs of values, count the number of
 * times the mood days decreased. For example, (-0, 1, 2, -3, 1, 2, 3, -3, -2)
 * is 2.
 * <br>
 * • ▬ A sort method. <br>
 * • ▬ A toString() method.
 * <p>
 * Of course, your driver should test ALL your methods.
 *
 * @author Phil Kappe
 */
public class Homework8
{

    public static void main(String[] args)
    {
        Mood mood = new Mood();
        System.out.println("The random moods are: " + mood.getMoods());
        System.out.println();

        System.out.println("Moods are valid: " + mood.moodsAreValid());
        System.out.println();

        System.out.println("There are " + mood.goodMoodDays()
                + " good mood days.");
        System.out.println();

        System.out.println("There are " + mood.badMoodDays()
                + " bad mood days.");
        System.out.println();

        System.out.println("There are " + mood.okMoodDays()
                + " okay mood days.");
        System.out.println();

        System.out.println("The longest run of increasing mood days: "
                + mood.increasingMoodDays());
        System.out.println();

        System.out.println("The longest run of decreasing mood days: "
                + mood.decreasingMoodDays());
        System.out.println();
        
        System.out.println("String version of Array: " + mood.toString());
        System.out.println();
        
        System.out.println("Sorted Array: " + mood.sortedMood());
        System.out.println();
    }

}
