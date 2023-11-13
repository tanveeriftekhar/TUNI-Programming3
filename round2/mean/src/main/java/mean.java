import java.util.Scanner;

public class mean 
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter numbers:");

        String l = s.nextLine();
        String[] nums = l.split(" ");

        double result = 0.0, count = 0;
        
        for(String n : nums){
            result += Double.parseDouble(n);
            count++;
        }
        double mean = result / count;
        System.out.println("Mean: "+mean);
    }
}
