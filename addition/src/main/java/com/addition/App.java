package com.addition;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        TextArea additionField = new TextArea();
        additionField.setEditable(false);
        additionField.setWrapText(true);

        // GridPane containing 10 buttons each numbered from 0 to 9.
        GridPane numberPad = new GridPane();
        int buttonValue = 0;
        // result is in an array since Java doesn't allow primitive types to be
        // transmitted to lambdas
        int[] result = { 0 };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                Button button = new Button(Integer.toString(buttonValue));

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Button button = (Button) event.getTarget();
                        additionField.setText(additionField.getText() + button.getText() + " + ");
                        result[0] += Integer.parseInt(button.getText());
                    }
                });

                numberPad.add(button, j, i, 1, 1);
                buttonValue++;
            }
        }

        Button clear = new Button("Vider");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                additionField.setText("");
                result[0] = 0;
            }
        });

        Button calculate = new Button("Calculer");
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                additionField.setText(additionField.getText() + "= " + result[0] + " + ");
            }
        });

        HBox buttonsBox = new HBox(clear, calculate);

        // Embedding all of the above
        VBox controlsBox = new VBox(additionField, numberPad, buttonsBox);
        StackPane root = new StackPane();
        root.getChildren().add(controlsBox);
        Scene scene = new Scene(root, 500, 400);

        // Styling
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(0, 0, 0, 0));
        controlsBox.setAlignment(Pos.TOP_CENTER);
        controlsBox.maxWidthProperty().bind(scene.widthProperty().multiply(0.8));
        additionField.setMaxHeight(400);
        numberPad.setAlignment(Pos.CENTER);
        buttonsBox.setAlignment(Pos.CENTER);

        // Output
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}