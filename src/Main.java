import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        nameOfBanks();

        System.out.println(Colors.ANSI_PURPLE + "Welcome" + Colors.ANSI_RESET);

        Card card = new Card();
        card.name();
        card.getPin();
        card.getRandomCashOnCard();
        card.getTheRestOfMoney();
        card.getUserCard();
    }

    private static void nameOfBanks() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("name of banks.txt");
        zapis.println("PKO_BP, Santander, Millenium, Alior_Bank, BZ_WBK");
        zapis.close();
    }
}
