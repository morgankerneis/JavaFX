package com.firstform;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Structure
        Label userInput = new Label("Entrée utilisateur : ");
        Label inputCopy = new Label("Copie de l'entrée");
        TextField userInpuTextField = new TextField("Saisissez un texte");
        TextField textFieldCopy = new TextField("Saisissez un texte");
        Button copy = new Button("Recopier");
        Button erase = new Button("Effacer");
        Button closeWindow = new Button("Quitter");
        VBox buttonList = new VBox(10, copy, erase, closeWindow);

        GridPane grid = new GridPane();

        grid.setGridLinesVisible(true);

        grid.add(userInput, 0, 0);
        grid.add(userInpuTextField, 1, 0);
        grid.add(inputCopy, 0, 1);
        grid.add(textFieldCopy, 1, 1);
        grid.add(buttonList, 2, 0, 1, 2);

        // Styling
        buttonList.setFillWidth(true);
        copy.setMaxWidth(Double.MAX_VALUE);
        erase.setMaxWidth(Double.MAX_VALUE);
        closeWindow.setMaxWidth(Double.MAX_VALUE);

        grid.setHgap(15);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        // Behaviour
        textFieldCopy.setDisable(true);

        copy.setOnAction(e -> {
            textFieldCopy.setText(userInpuTextField.getText());
        });

        erase.setOnAction(e -> {
            userInpuTextField.setText("");
            textFieldCopy.setText("");
        });

        closeWindow.setOnAction(e -> {
            Platform.exit();
            // stage.close();
        });

        // Code output
        Scene scene = new Scene(grid, 500, 250);
        stage.setScene(scene);
        stage.setTitle("Centrer verticalement et horizontalement");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}