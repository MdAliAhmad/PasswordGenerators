import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLowercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUppercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecial = scanner.nextLine().equalsIgnoreCase("y");

        String password = generatePassword(length, useNumbers, useLowercase, useUppercase, useSpecial);

        System.out.println("Generated password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean useNumbers, boolean useLowercase,
                                           boolean useUppercase, boolean useSpecial) {
        StringBuilder characters = new StringBuilder();
        if (useNumbers) characters.append("0123456789");
        if (useLowercase) characters.append("abcdefghijklmnopqrstuvwxyz");
        if (useUppercase) characters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (useSpecial) characters.append("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");

        if (characters.length() == 0) {
            System.out.println("Please select at least one character type.");
            return null;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
}
