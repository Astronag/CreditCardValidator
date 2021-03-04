import java.util.Arrays;
import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Credit card number");
        String cardNumber = input.next();

        CreditCardOperations creditCardOperations = new CreditCardOperations();

        String result = creditCardOperations.validateCreditCard(cardNumber);

        System.out.println("The Credit card number " + cardNumber + " is " + result);
    }

    public static class CreditCardOperations {

        public String validateCreditCard(String cardNumber) {
            if(cardNumber.length() < 12)
                return "invalid";

            int[] digits = new int[cardNumber.length()];

            for(int i = 0; i < cardNumber.length(); ++i) {
                if(!Character.isDigit(cardNumber.charAt(i)))
                    return "invalid";
                digits[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
            }

            for(int i = digits.length - 2; i >= 0; i -= 2) {
                int doubledDigit = digits[i] * 2;
                if(doubledDigit > 9)
                    doubledDigit = doubledDigit % 10 + 1;
                digits[i] = doubledDigit;
            }

            int sum = Arrays.stream(digits).sum();

            if(sum == 0 || sum % 10 != 0)
                return "invalid";
            return "valid";
        }

    }
}
