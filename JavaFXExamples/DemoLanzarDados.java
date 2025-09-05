package uabc.curlango.demojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class DemoLanzarDados extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Set title for stage
        primaryStage.setTitle("Demo Lanzar Dados");

        // ****** Create UI - Scene Graph ******
        HBox pane = createSceneGraph();

        // ********* Add UI - Scene Graph to scene ******
        Scene scene = new Scene(pane,200,400);

        // ********* Set scene to stage *******
        primaryStage.setScene(scene);

        // Show stage
        primaryStage.show();
    }

    private HBox createSceneGraph() {
        HBox hBox = new HBox();
        hBox.setPrefSize(600, 600);

        // Add stuff to UI
        Font font = new Font("Arial", 50);
        Dado dado = new Dado();
        Label label = new Label();
        int EMOJI_DADO = 9855;
        String emoji = new String(Character.toChars(EMOJI_DADO + dado.getValor()));
        label.setText(emoji);
        label.setFont(font);

        Button lanzar = new Button("Lanzar");
        lanzar.setOnMouseClicked(event -> {
            dado.lanzar();
            label.setText(new String(Character.toChars(EMOJI_DADO + dado.getValor())));
        });

        // Add elements to UI
        hBox.getChildren().addAll(label, lanzar);
        return hBox;
    }
}
