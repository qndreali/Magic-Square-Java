package com.app.magicsquarejava;

import javafx.scene.control.Button;

import java.io.IOException;

public class BoardModel {
    private static int[] One = new int[3];
    private static int[] Two = new int[3];
    private static int[] Three = new int[3];
    private static int[] Four = new int[3];
    private static int[] Five = new int[3];
    private static int[] Six = new int[3];

    public static int turncount = 1;
    public static int over = 0;

    public static void input(Button clickedPosButton, Button clickedPegButton) throws IOException {
        String buttonText = clickedPosButton.getId();
        char rowChar = buttonText.charAt(0);
        int colNumber = Integer.parseInt(buttonText.substring(1));

        int row = 0, col, peg;

        switch (rowChar) {
            case 'a' -> row = 1;
            case 'b' -> row = 2;
            case 'c' -> row = 3;
        }

        col = colNumber;

        peg = Integer.parseInt(clickedPegButton.getText());

        if (row == 1)
            One[col - 1] = peg;
        if (row == 2)
            Two[col - 1] = peg;
        if (row == 3)
            Three[col - 1] = peg;

        if (col == 1)
            Four[row - 1] = peg;
        if (col == 2)
            Five[row - 1] = peg;
        if (col == 3)
            Six[row - 1] = peg;

        if ((lineSum(One) < 15 && lineSum(One) != 0) ||
                (lineSum(Two) < 15 && lineSum(Two) != 0) ||
                (lineSum(Three) < 15 && lineSum(Three) != 0) ||
                (lineSum(Four) < 15 && lineSum(Four) != 0) ||
                (lineSum(Five) < 15 && lineSum(Five) != 0) ||
                (lineSum(Six) < 15 && lineSum(Six) != 0)) {
           over = 1;
        } else {
            turncount++;
            if (turncount == 10)
                over = 1;
        }
    }

    public static int lineSum(int[] line) {
        int lineSum = 0;

        if (line[0] != 0 && line[1] != 0 && line[2] != 0) {
            lineSum = line[0] + line[1] + line[2];
        }

        return lineSum;
    }


}
