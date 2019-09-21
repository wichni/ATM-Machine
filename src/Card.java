import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Card {


    private int pin;
    private String name;
    private double randomCashOnCard;
    private int userCard;
    private int theRestOfMoney;
    private static int RANDOM_BOUND = 9999;

    public void name() throws FileNotFoundException {
        System.out.println(Colors.ANSI_BLUE + "Select the name of your bank" + Colors.ANSI_RESET);
        Scanner scanner = fileNameOfBanks();
        this.name = scanner.next();
        System.out.println(Colors.ANSI_GREEN + "Your bank is " + name.toUpperCase() + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_CYAN + "Inserd the card" + Colors.ANSI_RESET);
    }

    public void getPin() {
        System.out.println(Colors.ANSI_YELLOW + "Enter the PIN code: " + Colors.ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        try {
            this.pin = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(Colors.ANSI_RED + " Wrong PIN code ");
            System.out.println(" Try again " + Colors.ANSI_RESET);
            getPin();
        }
    }

    public void getRandomCashOnCard() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        this.randomCashOnCard = random.nextInt(RANDOM_BOUND);
        System.out.println(Colors.ANSI_GREEN + "Money on your account: " + randomCashOnCard);
        System.out.println("Pay: " + Colors.ANSI_RESET);
        this.userCard = scanner.nextInt();
    }

    public int getTheRestOfMoney() {
        theRestOfMoney = (int) randomCashOnCard - userCard;
        return theRestOfMoney;
    }

    public void getUserCard() {
        if (userCard % 10 != 0) {
            System.out.println(Colors.ANSI_RED + "Unable to perform operation" + "\nTry again" + Colors.ANSI_RESET);
        } else if (userCard < randomCashOnCard) {
            System.out.println(Colors.ANSI_GREEN + "Wait for money ");
            System.out.println("The rest of money on you account: " + (double) theRestOfMoney + "\nThank you " + Colors.ANSI_RESET);
        } else if (userCard > randomCashOnCard) {
            System.out.println(Colors.ANSI_RED + "You can not pay more: " + randomCashOnCard + "\nTry again" + Colors.ANSI_RESET);
        } else
            System.out.println(Colors.ANSI_BLUE + "You paid all the money" + "\nThank you" + Colors.ANSI_RESET);
    }

    private Scanner fileNameOfBanks() throws FileNotFoundException {
        File plik = new File("name of banks.txt");
        Scanner in = new Scanner(plik);
        String tekst = in.nextLine();
        System.out.println(tekst);
        return new Scanner(System.in);
    }
}

