package com.app.magicsquarejava;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardController {
    public AnchorPane   boardPane, logoPane;

    public Button       a1, a2, a3,
                        b1, b2, b3,
                        c1, c2, c3;
    public Button       peg1, peg2, peg3, peg4, peg5, peg6, peg7, peg8, peg9;
    public Button       backButton;
    public Text         turnText;
    private Button      selectedPos = null;
    private String      playerA, playerB;


    @FXML
    public void onPosClick(MouseEvent mouseEvent) {
        Button clickedPos = (Button) mouseEvent.getSource();

        if (selectedPos != null) {
            selectedPos.setStyle("-fx-background-color: #FFC2D1; -fx-background-radius: 25;");
        }

        selectedPos = clickedPos;
        clickedPos.setStyle("-fx-background-color: #E69AA9; -fx-background-radius: 25;");
    }

    @FXML
    public void onPegClick(MouseEvent mouseEvent) throws IOException {
        Button clickedPeg = (Button) mouseEvent.getSource();

        if (selectedPos != null) {
            String pegText = clickedPeg.getText();
            selectedPos.setText(pegText);
            selectedPos.setStyle("-fx-background-color: #FFC2D1; -fx-background-radius: 25;");
            selectedPos.setDisable(true);

            clickedPeg.setStyle("-fx-background-color: #FFD7E1; -fx-background-radius: 50;");
            clickedPeg.setTextFill(Color.WHITE);
            clickedPeg.setDisable(true);

            BoardModel.input(selectedPos, clickedPeg);

            if (BoardModel.over == 1){
                FXMLLoader loader = new FXMLLoader(BoardModel.class.getResource("over-view.fxml"));
                Pane popupPane = loader.load();

                OverController overController = loader.getController();

                if (BoardModel.turncount == 10)
                    overController.setWinner(playerA);

                if (BoardModel.turncount % 2 == 0)
                    overController.setWinner(playerA);
                else
                    overController.setWinner(playerB);

                Stage popupStage = new Stage();
                popupStage.setTitle("Game Over");
                popupStage.setScene(new Scene(popupPane));

                popupStage.showAndWait();
            }

            if (BoardModel.turncount % 2 == 0)
                turnText.setText(playerB + "'s turn !");
            else
                turnText.setText(playerA + "'s turn !");
        }
    }

    //****************************************************************************************************************8

    public void onBackButtonClick(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
            Parent menuPane = loader.load();

            MenuController menuController = loader.getController();

            Scene scene = new Scene(menuPane);
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPlayerA(String playerA) {
        this.playerA = playerA;
        turnText.setText(this.playerA + "'s turn !");
    }

    public void setPlayerB(String playerB) {
        this.playerB = playerB;
    }

    public void closeBoardView() {
        Stage boardStage = (Stage) boardPane.getScene().getWindow();
        boardStage.close();
    }

}
