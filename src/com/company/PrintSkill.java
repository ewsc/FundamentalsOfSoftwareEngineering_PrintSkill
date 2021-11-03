package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PrintSkill {

    public static final String[] WordsEasy = {"Tomato", "Friendship", "Intelligent", "Communist", "Nasty", "Ready", "Culmination", "Potent", "Anthology", "Hack", "Narcology", "Ignorance", "Sour", "Confused", "Rocket-carrying", "Electric guitar", "Conform", "Get burned"};
    public static final String[] WordsMedium = {"Etymology", "Subvention", "Leucopathy", "Undergroan", "Haematosis", "Interpoint", "Distringas", "Reexchange", "Volitional", "Serjeantcy", "Unpitousty", "Torpidness", "Culvertail", "Sapiential", "Funambulus", "Eliquation", "Ruffianous", "Eikosylene", "Adjectived", "Inbreaking"};
    public static final String[] WordsHard = {"Galactometries", "Factionalising", "Eccentricities", "Dactylographer", "Cabinetworkers", "Abominableness", "Labiogressions", "Macroaggregate", "Nanotechnology", "Paddleboatings", "Quadriennially", "Easterlinesses", "Backwardations", "Xanthosiderite", "Zombifications", "Yieldabilities", "Wafflestompers", "Valedictorians", "Tachygraphical", "Karyoplasmatic"};

    public static void PresentProgram() {
        System.out.println("\nWelcome to PrintSkill! This program will help you improve your typing skills!");
        System.out.println("First, choose the difficulty.");
    }

    public static byte SelectDifficulty() {
        boolean isCorrect;
        byte difficulty = 0;
        do {
            System.out.print("Select difficulty (1 - Easy / 2 - Medium / 3 - Hard): ");
            Scanner sc_diff = new Scanner(System.in);
            isCorrect = true;
            try {
                difficulty = (byte) Integer.parseInt(sc_diff.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter the difficulty correctly!");
                isCorrect = false;
            }
            if ((difficulty < 1 || difficulty > 3) && isCorrect) {
                System.out.println("Enter the difficulty correctly!");
                isCorrect = false;
            }
        } while (!isCorrect);
        return difficulty;
    }

    public static void EchoDifficulty(byte difficulty) {
        if (difficulty == 1)
            System.out.println("\nEasy difficulty was selected.");
        else if (difficulty == 2)
            System.out.println("\nMedium difficulty was selected.");
        else
            System.out.println("\nHard difficulty was selected.");
    }

    public static void OutWords() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\nYour words are ready. They will be withdrawn now.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\nGet ready! You have 5 seconds!");
        TimeUnit.SECONDS.sleep(5);
    }

    public static void InputWords(byte difficulty) throws InterruptedException {
        boolean isPrecise;
        String TextIn;
        String[] Array = WordsEasy;
        if (difficulty == 2) {
            Array = WordsMedium;
        }
        else if (difficulty == 3) {
            Array = WordsHard;
        }
        Collections.shuffle(Arrays.asList(Array));
        for (int n = 0; n < 5; n++) {
            do {
                byte length = (byte)Array[n].length();
                System.out.print("\n===");
                for(int i = 0; i < length; i++) {
                    System.out.print("=");
                }
                System.out.println("===");
                System.out.println("   " + Array[n]);
                System.out.print("===");
                for(int i = 0; i < length; i++) {
                    System.out.print("=");
                }
                System.out.println("===");
                System.out.print("\nEnter the word that appeared on your screen: ");
                Scanner sc_text = new Scanner(System.in);
                TextIn = sc_text.nextLine();
                if (TextIn.equalsIgnoreCase(Array[n])) {
                    System.out.println("Fine! You entered word correctly!\n");
                    isPrecise = true;
                } else {
                    System.out.println("Enter the word correctly, without errors and extra spaces. Penalty 3 seconds!\n");
                    TimeUnit.SECONDS.sleep(2);
                    isPrecise = false;
                }
            } while (!isPrecise);
        }
    }

    public static void CalculateResults() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.print("Calculating results");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(".");
    }

    public static void OutResults(float result, byte difficulty) {
        String FastestHand = "Your rating: 'The fastest hand in the Wild West.'";
        String Good = "Your rating: Good, but it could be better!";
        String Excellent = "Your rating: Excellent! Keep it up!";
        String Okay = "Your rating: Okay, but try your best next time!";
        String Satisfactory = "Your rating: Satisfactory. Practice more.";
        if (difficulty == 1) {
            if (result <= 15) {
                System.out.println(FastestHand);
            }
            else if (result < 21 && result > 16) {
                System.out.println(Excellent);
            }
            else if (result < 27 && result > 22) {
                System.out.println(Good);
            }
            else if (result < 33 && result > 28) {
                System.out.println(Okay);
            }
            else {
                System.out.println(Satisfactory);
            }
        } else if (difficulty == 2) {
            if (result <= 22) {
                System.out.println(FastestHand);
            }
            else if (result < 28 && result > 23) {
                System.out.println(Excellent);
            }
            else if (result < 34 && result > 29) {
                System.out.println(Good);
            }
            else if (result < 40 && result > 35) {
                System.out.println(Okay);
            }
            else {
                System.out.println(Satisfactory);
            }
        } else {
            if (result <= 26) {
                System.out.println(FastestHand);
            }
            else if (result < 34 && result > 27) {
                System.out.println(Excellent);
            }
            else if (result < 42 && result > 35) {
                System.out.println(Good);
            }
            else if (result < 50 && result > 43) {
                System.out.println(Okay);
            }
            else {
                System.out.println(Satisfactory);
            }
        }
    }

    public static void PressAnyKey() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Press any key to close...");
        scan.nextLine();
    }

    public static void main (String[] args) throws InterruptedException {
        byte difficulty;
        PresentProgram();
        difficulty = SelectDifficulty();
        EchoDifficulty(difficulty);
        OutWords();
        long startTime = System.currentTimeMillis();
        InputWords(difficulty);
        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime);
        float result = (float)time/1000;
        System.out.println("\nSeconds spent: " + result);
        CalculateResults();
        OutResults(result, difficulty);
        PressAnyKey();
    }
}