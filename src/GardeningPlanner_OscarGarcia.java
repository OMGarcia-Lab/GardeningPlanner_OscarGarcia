import java.util.Scanner;

public class GardeningPlanner_OscarGarcia {

    // Average Arrays Provided //
    static int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
    static int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Welcome Message //
        System.out.println("-".repeat(100));
        System.out.println("Welcome to the CSC 215 Gardening Planner!");
        System.out.println("-".repeat(100));

        // User Inputs //
        System.out.print("- Enter minimum temperature for plant: ");
        int minTemp = input.nextInt();
        System.out.print("- Enter maximum temperature for plant: ");
        int maxTemp = input.nextInt();
        System.out.print("- Enter minimum rainfall for plant: ");
        int minRain = input.nextInt();

        System.out.println("-".repeat(100));

        // Space //
        System.out.println();

        // Arrays to Store Growth and Height for Each Month //
        int[] plantGrowth = new int[12];
        int[] plantHeight = new int[12];

        // Calculate and Print Results of growth and height for each month //
        calculated(minTemp, maxTemp, minRain, plantGrowth, plantHeight);
        printResults(plantGrowth, plantHeight);
    }

    // Calculating Process //
    // I could NOT figure out how to add a + sign th the growth numbers and I can't find any help in videos or forums //
    public static void calculated(int minTemp, int maxTemp, int minRain, int[] plantGrowth, int[] plantHeight) {
        // Plant Start Height //
        int height = 0;

        for (int i = 0; i < 12; i++) {
            if (avgTemp[i] < minTemp || avgTemp[i] > maxTemp) {
                plantGrowth[i] = -1;
            } else {
                plantGrowth[i] = avgRain[i] - minRain;
            }

            // Plant Height //
            height += plantGrowth[i];
            if (height < 0) {
                height = 0;
            }
            plantHeight[i] = height;
        }
    }

    // Chart Section //
    public static void printResults(int[] plantGrowth, int[] plantHeight) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int maxHeight = getMaxHeight(plantHeight);


        System.out.println("-".repeat(100));
        System.out.printf("%-14s%-14s%-14s%-14s%-14s%s", "INDEX", "MONTH", "TEMPERATURE", "RAINFALL", "PLANT GROWTH", "HEIGHT");

        // Not sure why but the chart won't print out properly unless I add an extra blank Print Statement //
        System.out.println();

        for (int i = 0; i < 12; i++) {
            System.out.printf("%-14s%-14s%-14s%-14s%-14s%s", i, months[i], avgTemp[i], avgRain[i], plantGrowth[i], plantHeight[i]);

            if (plantHeight[i] == maxHeight) {
                System.out.print("   \u001B[30;43mMAX\033[0m");
            }
            System.out.println();
        }
        System.out.println("-".repeat(100));
    }

    // Max Height Calculations //
    public static int getMaxHeight(int[] plantHeight) {
        int max = 0;
        for (int height : plantHeight) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }
}
