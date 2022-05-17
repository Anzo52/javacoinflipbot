// A Java bot that guesses its own coin flip and keeps track of the number of times it guesses correctly.
// Score is initalized to 0, +1 for each correct guess, -1 for each incorrect guess.
// Every 60 seconds the bot will flip a coin, represented as int 0 or 1, and will guess if it is heads or tails using 0 or 1.
// The bot will then print the date and time (YYYYMMDDHHMMSS), the coin flip (0 or 1), the guess (0 or 1), and the score.
// The bot will then sleep for 60 seconds.
// The bot will then repeat.


import java.util.Calendar;
import java.util.Random;


public class CoinFlipBot {

    public static int score = 0;
    public static int coinFlip;
    public static int guess;
    public static int year;
    public static int month;
    public static int day;
    public static int hour;
    public static int minute;
    public static int second;


    public static int coinFlip() {
        Random rand = new Random();
        coinFlip = rand.nextInt(2);
        return coinFlip;
    }

    public static int guess() {
        Random rand = new Random();
        guess = rand.nextInt(2);
        return guess;
    }

    public static int score() {
        if (coinFlip == guess) {
            score++;
        } else {
            score--;
        }
        return score;
    }

    public static void main(String[] args) {

        while(true){
            Calendar cal = Calendar.getInstance();
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH) + 1;
            day = cal.get(Calendar.DAY_OF_MONTH);
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);

            coinFlip();
            guess();
            score();

            System.out.println(year + "" + month + "" + day + "" + hour + "" + minute + "" + second + " " + coinFlip + " " + guess + " " + score);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}