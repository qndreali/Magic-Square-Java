package com.app.magicsquarejava;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

    public AnchorPane   menuPane, logoPane, buttonPane, mechPane, playerPane;
    public Button       playButton, mechButton, exitButton, backButton, startButton;
    @FXML
    private TextField   aTextField, bTextField;

    private String      playerA, playerB;



    @FXML
    public void onPlayButtonClick(MouseEvent mouseEvent) {
        buttonPane.setVisible(false);
        backButton.setVisible(true);
        playerPane.setVisible(true);
    }

    @FXML
    public void onMechButtonClick(MouseEvent mouseEvent) {
        buttonPane.setVisible(false);
        mechPane.setVisible(true);
        backButton.setVisible(true);
    }

    @FXML
    public void onExitButtonClick(MouseEvent mouseEvent) {
        System.exit(0);
    }

    @FXML
    public void onBackButtonClick(MouseEvent mouseEvent) {
        buttonPane.setVisible(true);
        mechPane.setVisible(false);
        playerPane.setVisible(false);
        backButton.setVisible(false);
    }

    @FXML
    public void onStartButtonClick(MouseEvent mouseEvent) {
        playerA = aTextField.getText();
        playerB = bTextField.getText();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("board-view.fxml"));
            Parent boardPane = loader.load();

            BoardController boardController = loader.getController();

            boardController.setPlayerA(playerA);
            boardController.setPlayerB(playerB);

            Scene scene = new Scene(boardPane);
            Stage stage = (Stage) playButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}