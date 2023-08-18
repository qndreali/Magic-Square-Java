package com.app.magicsquarejava;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class OverController {
    public AnchorPane overPane, logoPane;
    public Text winnerText;
    public Button exitButton;

    public void onExitButtonClick(MouseEvent mouseEvent){
        System.exit(0);
    }

    public void setWinner(String winner) {
        winnerText.setText(winner + " wins!");
    }
}
