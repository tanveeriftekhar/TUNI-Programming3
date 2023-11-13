import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class median {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers:");
        String inputLine = scanner.nextLine();
        String[] numberStrings = inputLine.split(" ");

        List<Double> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            try {
                double number = Double.parseDouble(numberString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + numberString);
            }
        }

        Collections.sort(numbers);

        double median;
        int count = numbers.size();

        if (count % 2 == 0) {
            int middleIndex1 = count / 2 - 1;
            int middleIndex2 = count / 2;
            median = (numbers.get(middleIndex1) + numbers.get(middleIndex2)) / 2.0;
        } else {
            int middleIndex = count / 2;
            median = numbers.get(middleIndex);
        }

        System.out.println("Median: " + median);
    }
}
