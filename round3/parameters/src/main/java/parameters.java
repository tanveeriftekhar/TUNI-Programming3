import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class parameters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parameters = new ArrayList<>();

        // Read parameters from the user
        System.out.println("Parameters:");
        String input;
        while (!(input = scanner.nextLine()).isEmpty()) {
            parameters.add(input);
        }

        // Sort the parameters alphabetically
        Collections.sort(parameters);

        // Find the maximum width for each column
        long maxCol1Width = Integer.toString(parameters.size()).length();
        long maxCol2Width = 0;
        for (String param : parameters) {
            maxCol2Width = Math.max(maxCol2Width, param.length());
        }

        // Calculate the total width of the table
        long totalWidth = maxCol1Width + 4 + maxCol2Width + 2;

        // Print the table
        System.out.println("#"+repeatCharacter('#', totalWidth));
        for (int i = 0; i < parameters.size(); i++) {
            String param = parameters.get(i);
            if (parameters.size() > 99) {
                System.out.printf("# %3d | %-"+(maxCol2Width)+"s #\n", i + 1, param);
            }else{
                System.out.printf("#%3d | %-"+(maxCol2Width)+"s #\n", i + 1, param);
            }
            if (i < parameters.size() - 1) {
                if (parameters.size() > 99) {
                System.out.println("#-----+-" + repeatCharacter('-', maxCol2Width) + "-#");
                }else{
                System.out.println("#----+-" + repeatCharacter('-', maxCol2Width) + "-#");
                }
            }
        }
        System.out.println("#"+repeatCharacter('#', totalWidth));
    }

    // Helper function to repeat a character n times
    private static String repeatCharacter(char ch, long n) {
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < n; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
