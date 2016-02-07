import java.util.Scanner;
/**
 * Step 5
 */
public class Longhand {

    private static String answer = "";
    private static String[] ones = {"zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};
    private static String[] teens = {"ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
    private static String[] mulTens = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};

    public static void triplet(int n) {
        if (n / 100 > 0) {
            answer += ones[n / 100] + "hundred ";
        }
        if (n % 100 / 10 == 1) {
            answer += teens[n % 10];
            return;
        }
        if (n % 100 / 10 >= 2) {
            answer += mulTens[n % 100 / 10];
        }
        if (n % 10 > 0) {
            answer += ones[n % 10];
        }
    }
    public static String toLonghand(double input) {
        int num = (int)(input / 1.0);    // Just starting with digits left of decimal
        if (num / 1000000 > 0) {
            triplet(num / 1000000);
            answer += "million ";
        }
        if (num % 1000000 / 1000 > 0) {
            triplet(num % 1000000 / 1000);
            answer += "thousand ";
        }
        if (num % 1000 > 0) {
            triplet(num % 1000);
        }
        if (num == 0) {
            answer += "zero ";
        }
        if (input - num > 0) {
            answer += "and " + (int)((input - num) * 100 + .5) + "/100 ";
        }
        answer += "dollars.";
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Double input = Double.parseDouble(scan.nextLine().substring(1));
        answer = toLonghand(input);

        System.out.println(answer);
    }
}
