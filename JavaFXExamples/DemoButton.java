package uabc.curlango.demojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DemoButton extends Application {
    private boolean isSpanish = false;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        Label label = new Label("Hello World!");
        label.setVisible(false);
        label.setText("Hola Mundo!");

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                label.setVisible(true);
                if (isSpanish) {
                    isSpanish = false;
                    btn.setText("En inglés!");
                    label.setText("Hola guapa!");
                    System.out.println("Hola mundo!");
                }else {
                    isSpanish = true;
                    btn.setText("In Spanish!!");
                    label.setText("Hello beautiful!");
                    System.out.println("Hello World!");
                }

            }
        });


        Scene scene = new Scene(grid, 300, 275);
        grid.add(label, 1, 0);
        grid.add(btn, 1, 1);

        //grid.setGridLinesVisible(true);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
