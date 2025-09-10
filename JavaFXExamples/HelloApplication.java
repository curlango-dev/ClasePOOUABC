package uabc.curlango.demodeclasexxx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 1. Set title for stage
        stage.setTitle("Demo Lanzar Dados");

        // 2. ****** Create UI - Scene Graph ******
        HBox pane = createSceneGraph();
//        Pane pane = new Pane();
//        Button button = new Button("Click Me");
//        pane.getChildren().add(button);


        // 3. ********* Add UI - Scene Graph to scene ******
        Scene scene = new Scene(pane, 400, 400);

        // 4. ********* Set scene to stage *******
        stage.setScene(scene);
        // 5. ****** Show stage
        stage.show();

    }

    private HBox createSceneGraph() {
        HBox hBox = new HBox();
        hBox.setPrefSize(600, 600);

        // Add stuff to UI
        Font font = new Font("Arial", 150);
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


    public static void main(String[] args) {
        launch();
    }
}