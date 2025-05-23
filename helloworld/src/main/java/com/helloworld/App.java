package com.helloworld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        // Sructure
        Label label1 = new Label("Bonjour");
        Label label2 = new Label("le");
        Label label3 = new Label("monde !");
        Button closeButton = new Button("Close");
        VBox vbox = new VBox(label1, label2, label3, closeButton);
        Scene scene = new Scene(vbox, 280, 280);

        // Styling
        Font font = Font.font("Arial", 24);
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        closeButton.setMinWidth(100);
        closeButton.setMinHeight(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        // Behavior
        closeButton.setOnAction(value -> {
            stage.close();
        });

        stage.setTitle("first JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}