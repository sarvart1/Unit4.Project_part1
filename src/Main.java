import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int fiveKind = 0;
        int fourKind = 0;
        int fullHouse = 0;
        int threeKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        try {
            Scanner input = new Scanner(new File("data"));

            while (input.hasNextLine()) {
                String[] cards = input.nextLine().split("\\|")[0].split(",");

                int[] count = new int[5];

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (cards[i].equals(cards[j])) {
                            count[i]++;
                        }
                    }
                }

                int max = 0;
                int pairs = 0;

                for (int i = 0; i < 5; i++) {
                    if (count[i] > max) {
                        max = count[i];
                    }
                    if (count[i] == 2) {
                        pairs++;
                    }
                }

                pairs = pairs / 2;

                if (max == 5) {
                    fiveKind++;
                } else if (max == 4) {
                    fourKind++;
                } else if (max == 3 && pairs == 1) {
                    fullHouse++;
                } else if (max == 3) {
                    threeKind++;
                } else if (pairs == 2) {
                    twoPair++;
                } else if (pairs == 1) {
                    onePair++;
                } else {
                    highCard++;
                }
            }

            input.close();

            System.out.println("Number of five of a kind hands: " + fiveKind);
            System.out.println("Number of full house hands: " + fullHouse);
            System.out.println("Number of four of a kind hands: " + fourKind);
            System.out.println("Number of three of a kind hands: " + threeKind);
            System.out.println("Number of two pair hands: " + twoPair);
            System.out.println("Number of one pair hands: " + onePair);
            System.out.println("Number of high card hands: " + highCard);

        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }
}