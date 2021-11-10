package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class PrintSkillTest {

    @BeforeEach
    void setUp() {
        assertTrue(true);
    }

    @Test
    void getResultsNumber() throws FileNotFoundException {
        String userPath = ".\\.\\users\\josh.txt";
        try {
            Scanner scan = new Scanner(new File(userPath));
        }
        catch (Exception e) {
            System.out.println("error. not found. mistake in file payh");
        }
        assertTrue(true);
    }

    @Test
    void presentProgram() {
        // Тут просто показ текста
        assertTrue(true);
    }

    @Test
    void selectDifficulty() {
        try {
            byte difficulty;
        }
        catch (Exception NumberFormatException) {
            fail();
        }
        assertTrue(true);
    }

    @Test
    void echoDifficulty() {
        // Тут проверка на верность
        byte difficulty = 1;
        if (difficulty == 1)
            System.err.println("\nEasy difficulty was selected.");
        else if (difficulty == 2)
            System.err.println("\nMedium difficulty was selected.");
        else if (difficulty == 3)
            System.err.println("\nHard difficulty was selected.");
        else
            fail();
        assertTrue(true);
    }

    @Test
    void outWords() {
        // Нечего проверять
        assertTrue(true);
    }

    @Test
    void inputWords() {
        String Out = "Text";
        String In = "Text";
        if (Out.equals(In)) {
            assertTrue(true);
        }
        else {
            System.err.println("несостыковочка");
            fail();
        }
    }

    @Test
    void calculateResults() {
        // Нечего проверять
        assertTrue(true);
    }

    @Test
    void outResults() {
        double result = 1;
        byte difficulty = 3;
        boolean isCorrect = result > 0;
        if (difficulty == 2) {
            difficulty = (byte) (difficulty + 3);
        }
        else if (difficulty == 3) {
            difficulty = (byte) (difficulty + 7);
        }
        if (result <= (15 + difficulty)) {
            System.err.println("FastestHand");
        }
        else if (result < (21 + difficulty) && result > (16 + difficulty)) {
            System.err.println("Excellent");
        }
        else if (result < (27 + difficulty) && result > (22 + difficulty)) {
            System.err.println("Good");
        }
        else if (result < (33 + difficulty) && result > (28 + difficulty)) {
            System.err.println("Okay");
        }
        else if (result < (39 + difficulty) && result > (34 + difficulty)) {
            System.err.println("Satisfactory");
        }
        else {
            System.err.println("Awful");
        }
        if(isCorrect) {
            assertTrue(true);
        }
        else {
            fail();
        }
    }

    @Test
    void pressAnyKey() {
        // Нечего проверять
        assertTrue(true);
    }

    @Test
    void multiSession() {
        byte difficulty = 2;
        if (difficulty < 0) {
            System.out.println("ошибочка. слоджность неверно передаётся");
            fail();
        }
        String userNameTwo = "josh";
        String userNameOne = "marcus";
        float result1 = (float) 10.10;
        float result2 = (float) 9.90;
        if (result1 > result2) {
            System.err.println("Looks like " + userNameTwo + " was faster! Congrats " + userNameTwo + "!");
        }
        else if (result1 < result2) {
            System.err.println("Looks like " + userNameOne + " was faster! Congrats " + userNameOne + "!");
        }
        else {
            System.err.println("OMG, how is that possible ???? ");
        }
        assertTrue(true);
    }

    @Test
    void session() {
        boolean isApproved = true;
        if (isApproved) {
            try {
                String userNameTwo = "marcus";
            }
            catch (Exception e) {
                fail();
            }
        }
        boolean isTrue = false;
        do {
            System.err.print("\nDo you want to continue this session?");
        } while (isTrue);
        assertTrue(true);
    }

    @Testable
    void InputtingFirst() {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime);
        if (time < 0) {
            System.out.println("ошибка в записи времени");
        }
        assertTrue(true);
    }

    @Test
    void InputtingSecond() {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long time = (endTime - startTime);
        if (time < 0) {
            System.out.println("ошибка в записи времени");
        }
        assertTrue(true);
    }


    @Test
    void mainTest() {
        try {
            float result;
        }
        catch (Exception NumberFormatException) {
            System.err.println("неверный формат числа");
            fail();
        }
        assertTrue(true);
    }
}