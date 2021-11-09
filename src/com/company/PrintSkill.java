package com.company;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class PrintSkill {

    protected static final String[] WordsEasy = {"Tomato", "Friend", "Excide", "Fabric", "Denote", "Naught", "Burman", "Potent", "Malaga", "Hacker", "Custom", "Hamper", "Civism", "Odible", "Rocket", "Guitar", "Swatch", "Burned", "Protect"};
    protected static final String[] WordsMedium = {"Etymology", "Subvention", "Leucopathy", "Undergroan", "Haematosis", "Interpoint", "Distringas", "Reexchange", "Volitional", "Serjeantcy", "Unpitousty", "Torpidness", "Culvertail", "Sapiential", "Funambulus", "Eliquation", "Ruffianous", "Eikosylene", "Adjectived", "Inbreaking"};
    protected static final String[] WordsHard = {"Galactometries", "Factionalising", "Eccentricities", "Dactylographer", "Cabinetworkers", "Abominableness", "Labiogressions", "Macroaggregate", "Nanotechnology", "Paddleboatings", "Quadriennially", "Easterlinesses", "Backwardations", "Xanthosiderite", "Zombifications", "Yieldabilities", "Wafflestompers", "Valedictorians", "Tachygraphical", "Karyoplasmatic"};

    public static String userPath;
    public static String userNameOne;
    public static String userNameTwo;

    public static void presentProgram() {
        System.err.println("Welcome to PrintSkill! This program will help you improve your typing skills!");
    }

    public static int getResultsNumber() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(userPath));
        int i = 0;
        boolean isCorrect;
        do {
            isCorrect = true;
            try {
                scan.nextLine();
                i = i + 1;
            } catch (NoSuchElementException e) {
                isCorrect = false;
            }
        } while (isCorrect);
        return i;
    }

    public static void updateUserInfo() {
        System.err.print("Enter username: ");
        Scanner in = new Scanner(System.in);
        userNameOne = in.nextLine();
        userPath = ".\\.\\users\\" + userNameOne + ".txt";
        try {
            Scanner scan = new Scanner(new File(userPath));
            int size = getResultsNumber();
            String [] results = new String[size];
            int i, n;
            for(n = 0; n < size; n++) {
                results[n] = scan.nextLine();
            }
            System.err.println("\nHello, " + userNameOne + ", here are your previous result(s): \n");
            System.err.println("===========================================================");
            byte f;
            for (i = 0; i < 5; i++) {
                f = (byte) (i + 1);
                size = size - 1;
                if(size > -1)
                    System.err.println("[" + f + "] " + results[size] + "\n===========================================================");
            }
        } catch (FileNotFoundException e){
            System.err.println("Welcome to the club, " + userNameOne + "!");
            System.err.println("TIP: Use this username next time to upload the results.");
        }
    }

    public static byte selectDifficulty() {
        boolean isCorrect;
        byte difficulty = 0;
        System.err.print("Select difficulty (1 - Easy / 2 - Medium / 3 - Hard): ");
        do {
            Scanner sc_diff = new Scanner(System.in);
            isCorrect = true;
            try {
                difficulty = (byte) Integer.parseInt(sc_diff.nextLine());
            } catch (NumberFormatException e) {
                System.err.print("Enter the difficulty correctly: ");
                isCorrect = false;
            }
            if ((difficulty < 1 || difficulty > 3) && isCorrect) {
                System.err.print("Enter the difficulty correctly: ");
                isCorrect = false;
            }
        } while (!isCorrect);
        return difficulty;
    }

    public static void echoDifficulty(byte difficulty) {
        if (difficulty == 1)
            System.err.println("\nEasy difficulty was selected.");
        else if (difficulty == 2)
            System.err.println("\nMedium difficulty was selected.");
        else
            System.err.println("\nHard difficulty was selected.");
    }

    public static void outWords() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.err.println("\nYour words are ready. They will be withdrawn now.");
        TimeUnit.SECONDS.sleep(2);
        System.err.println("\nGet ready! You have 5 seconds!");
        TimeUnit.SECONDS.sleep(5);
    }

    public static void inputWords(byte difficulty) throws InterruptedException {
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
                System.err.print("\n===");
                for(int i = 0; i < length; i++) {
                    System.err.print("=");
                }
                System.err.println("===");
                System.err.println("   " + Array[n]);
                System.err.print("===");
                for(int i = 0; i < length; i++) {
                    System.err.print("=");
                }
                System.err.println("===");
                System.err.print("\nEnter the word that appeared on your screen: ");
                Scanner sc_text = new Scanner(System.in);
                TextIn = sc_text.nextLine();
                if (TextIn.equalsIgnoreCase(Array[n])) {
                    System.err.println("\nFine! You entered word correctly!");
                    isPrecise = true;
                } else {
                    System.err.println("\nEnter the word correctly, without errors and extra spaces. Penalty 3 seconds!");
                    TimeUnit.SECONDS.sleep(3);
                    isPrecise = false;
                }
            } while (!isPrecise);
        }
    }

    public static void calculateResults() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.err.print("Calculating results");
        TimeUnit.SECONDS.sleep(1);
        System.err.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.err.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.err.println(".");
    }

    public static void outResults(float result, byte difficulty) {
        String FastestHand = "Your rating: " + (char)34 + "The fastest hand in the Wild West" + (char)34 + ".";
        String Good = "Your rating: Good, but it could be better!";
        String Excellent = "Your rating: Excellent! Keep it up!";
        String Okay = "Your rating: Okay, but try your best next time!";
        String Satisfactory = "Your rating: Satisfactory. Practice more.";
        String Awful = "Your rating: Awful. You may have forgotten the location of the buttons on the keyboard.";
        if (difficulty == 2) {
            difficulty = (byte) (difficulty + 3);
        }
        else if (difficulty == 3) {
            difficulty = (byte) (difficulty + 7);
        }
        if (result <= (15 + difficulty)) {
            System.err.println(FastestHand);
        }
        else if (result < (21 + difficulty) && result > (16 + difficulty)) {
            System.err.println(Excellent);
        }
        else if (result < (27 + difficulty) && result > (22 + difficulty)) {
            System.err.println(Good);
        }
        else if (result < (33 + difficulty) && result > (28 + difficulty)) {
            System.err.println(Okay);
        }
        else if (result < (39 + difficulty) && result > (34 + difficulty)) {
            System.err.println(Satisfactory);
        }
        else {
            System.err.println(Awful);
        }
    }

    public static void pressAnyKey() {
        System.err.println("\nSee you again, cowboy.");
        Scanner scan = new Scanner(System.in);
        System.err.print("Press any key to close...");
        scan.nextLine();
    }

    public static boolean isTrue;
    public static boolean isApproved() {
        boolean isCorrect;
        String yn;
        System.err.print("(Y - Yes / N - No): ");
        do {
            isCorrect = true;
            Scanner in = new Scanner (System.in);
            yn = in.nextLine();
            if (yn.equalsIgnoreCase("Y"))
                isTrue = true;
            else if (yn.equalsIgnoreCase("N"))
                isTrue = false;
            else{
                isCorrect = false;
                System.err.print("Choose correctly (Y / N): ");
            }
        }while(!isCorrect);
        return isTrue;

    }

    public static String wordDifficulty(byte difficulty) {
        if (difficulty == 1)
            return "Easy";
        else if (difficulty == 2)
            return "Medium";
        else
            return "Hard";
    }

    public static void singleSession() throws InterruptedException, IOException {
        byte difficulty;
        difficulty = selectDifficulty();
        echoDifficulty(difficulty);
        outWords();
        long startTime = System.currentTimeMillis();
        inputWords(difficulty);
        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime);
        float result = (float)time/1000;
        System.err.println("\nTime spent: " + result + " seconds.");
        FileWriter writer = new FileWriter(userPath, true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        writer.write(dtf.format(now) + " || Difficulty (" + wordDifficulty(difficulty) + "): " + result + " seconds.\n");
        writer.close();
        calculateResults();
        outResults(result, difficulty);
    }

    public static void multiSession() throws InterruptedException {
        byte difficulty;
        difficulty = selectDifficulty();
        echoDifficulty(difficulty);
        System.err.print("Now you rock, " + userNameOne + ".");
        outWords();
        long startTime = System.currentTimeMillis();
        inputWords(difficulty);
        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime);
        float result1 = (float)time/1000;
        System.err.println("\nIt's time to swap, players!");
        TimeUnit.SECONDS.sleep(10);
        System.err.print(userNameTwo + ", make it burn.");
        outWords();
        startTime = System.currentTimeMillis();
        inputWords(difficulty);
        endTime = System.currentTimeMillis();
        time = (endTime - startTime);
        float result2 = (float)time/1000;
        System.err.println("Results [" + userNameOne +"]: " + result1 + ".");
        System.err.println("Results [" + userNameTwo + "]: " + result2 + ".");
        calculateResults();
        if (result1 > result2)
            System.err.println("Looks like " + userNameTwo + " was faster! Congrats " + userNameTwo + "!");
        else if (result1 < result2)
            System.err.println("Looks like " + userNameOne + " was faster! Congrats " + userNameOne + "!");
        else
            System.err.println("OMG, how is that possible ???? ");

    }

    public static void session() throws IOException, InterruptedException {
        System.err.print("\nDo you want to initiate multiplayer mode? ");
        if (isApproved()){
            System.err.print("Enter second player's username: ");
            Scanner in = new Scanner(System.in);
            userNameTwo = in.nextLine();

            System.err.println("\nMultiplayer mode is active now. (Saves disabled)\n");
            do {
                multiSession();
                System.err.print("\nDo you want to continue this session?");
                isApproved();
            } while (isTrue);
        } else {
            System.err.println("Single session is active now.\n");
            do {
                singleSession();
                System.err.print("\nDo you want to continue this session? ");
                isApproved();
            } while (isTrue);
        }
    }

    public static void main (String[] args) throws InterruptedException, IOException {
        presentProgram();
        updateUserInfo();
        session();
        pressAnyKey();
    }
}
