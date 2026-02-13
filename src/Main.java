import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int five = 0;
        int four = 0;
        int full = 0;
        int three = 0;
        int twoPair = 0;
        int onePair = 0;
        int high = 0;

        try {
            Scanner input = new Scanner(new File("data"));

            while (input.hasNextLine()) {

                String line = input.nextLine();
                String cardsOnly = line.split("\\|")[0];
                String[] cards = cardsOnly.split(",");

                boolean[] counted = new boolean[5];

                int pairCount = 0;
                int threeCount = 0;
                int fourCount = 0;
                int fiveCount = 0;

                
                for (int i = 0; i < 5; i++) {

                    if (counted[i] == false) {

                        int matches = 1;

                        for (int j = i + 1; j < 5; j++) {
                            if (cards[i].equals(cards[j])) {
                                matches++;
                                counted[j] = true; 
                            }
                        }

                        if (matches == 2) {
                            pairCount++;
                        } else if (matches == 3) {
                            threeCount++;
                        } else if (matches == 4) {
                            fourCount++;
                        } else if (matches == 5) {
                            fiveCount++;
                        }
                    }
                }

                
                if (fiveCount == 1) {
                    five++;
                } else if (fourCount == 1) {
                    four++;
                } else if (threeCount == 1 && pairCount == 1) {
                    full++;
                } else if (threeCount == 1) {
                    three++;
                } else if (pairCount == 2) {
                    twoPair++;
                } else if (pairCount == 1) {
                    onePair++;
                } else {
                    high++;
                }
            }

            input.close();

            System.out.println("Number of five of a kind hands: " + five);
            System.out.println("Number of full house hands: " + full);
            System.out.println("Number of four of a kind hands: " + four);
            System.out.println("Number of three of a kind hands: " + three);
            System.out.println("Number of two pair hands: " + twoPair);
            System.out.println("Number of one pair hands: " + onePair);
            System.out.println("Number of high card hands: " + high);

        } catch (Exception e) {
            System.out.println("File error");
        }
    }
}
