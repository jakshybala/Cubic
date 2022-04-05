package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        game();
    }

    public static void newGames() {
        int newGame = scanner.nextInt();
        switch (newGame) {
            case 1 -> game();
            case 2 -> System.out.println("Game over");
        }
    }

    public static void game() {
        List<Integer> numberGuessedByUsers = new ArrayList<>();
        List<Integer> numberGuessedByTheComputer = new ArrayList<>();
        List<Integer> randomDieComputerNumber = new ArrayList<>();
        List<Integer> randomDieUserNumber = new ArrayList<>();
        List<Integer> scoreOfUser = new ArrayList<>();
        List<Integer> scoreOfComputer = new ArrayList<>();


        CubeService cubeService = new User();
        CubeService cubeService1 = new Computer();
        int counter1 = 2;
        int round = 0;
        System.out.println("---       Strat game       ---");
        do {
            System.out.println();
            System.out.print("Predict amount of points (2..12) : ");
            int guessNumberUser = scanner.nextInt(); //7
            System.out.println("""
                    
                    Cheating - 1
                    Not to cheating - 2""");
            int toCheatOrNotToCheat = scanner.nextInt(); //1
            int randomUserDie = cubeService.randomCube();
            boolean guessedOrNotGuessed = true;
            if (toCheatOrNotToCheat == 1) {
               int chance = random.nextInt(1,  counter1 + 1);
               int chance1 = random.nextInt(1, counter1 + 1);
                guessedOrNotGuessed = false;
                //First 1 chance out of 2 (50% to 50%) Round 2 1 chance out of 4 (one to 4) Round 3 1 chance out of 6 (one out of six)
                System.out.println("Two random numbers matched or not? " + chance + " = " + chance1);
                if (chance == chance1) {
                    randomUserDie = guessNumberUser;
                    guessedOrNotGuessed = true;
                }
            }
            numberGuessedByUsers.add(guessNumberUser);
            System.out.println("\nUser rolls the dices...");
            randomDieUserNumber.add(randomUserDie);
            int scoreUser = randomUserDie - (Math.abs(randomUserDie - guessNumberUser) * 2);
            int overwriteUserScore;
            if (!guessedOrNotGuessed) {
                System.out.println("NotToCheat - 10 points ");
                overwriteUserScore = scoreUser - 10;
            } else {
                overwriteUserScore = scoreUser;
            }
            scoreOfUser.add(overwriteUserScore);
            int guessNumberComputer = random.nextInt(2, 13);
            numberGuessedByTheComputer.add(guessNumberComputer);
            System.out.printf("""
                    On the dice fell %d points
                    Result is %d - abs(%d - %d) * 2: %d
                                
                    Sopernik predicted %d points
                    Sopernik rolls the dices
                    """, randomUserDie, randomUserDie, randomUserDie, guessNumberUser, overwriteUserScore, guessNumberComputer);
            int randomComputerDie = cubeService1.randomCube();
            if (!guessedOrNotGuessed) {
                int chance = random.nextInt(1,  counter1 + 1);
                int chance1 = random.nextInt(1, counter1 + 1);
                System.out.println("Two random numbers matched or not? " + chance + " - " + chance1);
                if (chance == chance1) {
                    randomComputerDie = guessNumberComputer;
                }
            }
            randomDieComputerNumber.add(randomComputerDie);
            int scoreComputer = randomComputerDie - (Math.abs(randomComputerDie - guessNumberComputer) * 2);
            scoreOfComputer.add(scoreComputer);
            System.out.printf("""
                    On the dice fell %d points
                    Result is %d - abs(%d - %d) * 2: %d""", randomComputerDie, randomComputerDie, randomComputerDie, guessNumberComputer, scoreComputer);
            if (scoreUser > scoreComputer) {
                int score = scoreUser - scoreComputer;
                System.out.printf("""
                                                
                        Users win %d points more
                        Congratulations!
                        """, score);
            } else {
                int score = scoreComputer - scoreUser;
                System.out.printf("""
                                                
                        Sopernik win %d points more
                        Congratulations!
                                                
                        """, score);
            }
            int currentScore = Math.abs(scoreComputer - scoreUser);
            System.out.printf("""
                    ---------- Current score ----------
                    User       %d points
                    Sopernik   %d points
                    """, scoreUser, scoreComputer);
            if (scoreUser > scoreComputer) {
                System.out.printf("""
                                                
                        Users is ahead by %d points!
                        -----------------------------------""", currentScore);
            }
            round++;
            counter1 += 2;
        } while (round < 3);
        System.out.println("""
                                
                -------------- Finish game --------------
                                
                 Round |         User   |    Sopernik
                -------+----------------+----------------""");
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            counter++;
            System.out.printf("""
                                   | Predicted   %d  | Predicted  %d
                            - %d -  | Dice        %d  | Dice       %d
                                   | Result      %d  | Result     %d
                            -------+-----------------+----------------
                            """, numberGuessedByUsers.get(i), numberGuessedByTheComputer.get(i),
                    counter, randomDieUserNumber.get(i), randomDieComputerNumber.get(i), scoreOfUser.get(i), scoreOfComputer.get(i));
        }
        int corzinaUser = 0;
        int corzinaSopernik = 0;
        for (int i = 0; i < 3; i++) {
            corzinaUser += scoreOfUser.get(i);
            corzinaSopernik += scoreOfComputer.get(i);
        }
        System.out.printf("""
                Total  | Points      %d | Points      %d
                """, corzinaUser, corzinaSopernik);
        int totalPoints = Math.abs(corzinaSopernik - corzinaUser);
        if (corzinaUser > corzinaSopernik) {
            System.out.printf("""
                    Users win %d points more. Congratulations!""", totalPoints);
        } else {
            System.out.printf("""
                    Sopernik win %d points more. Congratulations!""", totalPoints);
        }
        System.out.println("""
                                
                Continue game?
                yes - 1
                not - 2""");
        newGames();
    }
}
