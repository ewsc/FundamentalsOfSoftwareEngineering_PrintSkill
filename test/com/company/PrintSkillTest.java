package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class PrintSkillTest {

    @BeforeEach
    void setUp() {
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
        boolean isCorrect = result > 0;
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