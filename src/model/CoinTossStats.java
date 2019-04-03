package model;

import java.util.Scanner;

public class CoinTossStats {
    private final int NUMBER_OF_COIN_TOSSES = 8;

    private int numberOfCoinTossesRemaining;
    private String result;
    private int numberOfHeads;
    private int numberOfTails;

    private Scanner scanner = new Scanner(System.in);

    public CoinTossStats() {
        this.numberOfCoinTossesRemaining = 8;
    }

    public void playGame() {
        System.out.print("\nWelcome to the coin toss stats recorder\n"
                + "Please record the your results of 8 coin tosses. \n"
                + "Enter 'h' for heads and 't' for tails.\n\n");
        recordResults();
        printResults();
    }

    private void recordResults() {
        while (numberOfCoinTossesRemaining > 0) {
            do {
                System.out.print(generatePromptString());
                result = scanner.nextLine();
            } while (!isValidResult());
        }
    }

    private String generatePromptString() {
        String tossNumber = "";
        switch (numberOfCoinTossesRemaining) {
            case 8:
                tossNumber = "First ";
                break;
            case 7:
                tossNumber = "Second ";
                break;
            case 6:
                tossNumber = "Third ";
                break;
            case 5:
                tossNumber = "Fourth ";
                break;
            case 4:
                tossNumber = "Fifth ";
                break;
            case 3:
                tossNumber = "Sixth ";
                break;
            case 2:
                tossNumber = "Seventh ";
                break;
            case 1:
                tossNumber = "Eight ";
                break;
        }
        return tossNumber + "toss: ";
    }

    private boolean isValidResult() {
        boolean isValid = false;
        switch (result.toLowerCase()) {
            case "h":
                isValid = true;
                numberOfHeads++;
                numberOfCoinTossesRemaining--;
                break;
            case "t":
                isValid = true;
                numberOfTails++;
                numberOfCoinTossesRemaining--;
                break;
        }
        return isValid;
    }

    private void printResults() {
        System.out.printf("\n%s %d\n", "Number of heads:", numberOfHeads);
        System.out.printf("%s %d\n", "Number of tails:", numberOfTails);
        System.out.printf("\n%s %.2f%s\n", "Percent heads:", numberOfHeads*100.0 / NUMBER_OF_COIN_TOSSES,
                "%");
        System.out.printf("%s %.2f%s\n", "Percent tails:", numberOfTails*100.0 / NUMBER_OF_COIN_TOSSES,
                "%");
    }
}
