package uabc.curlango.lcrgui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class LCRGameGUI extends Application {
    LCRGame lcrGame;
    Label fichasCenter;
    Label jugador1;
    Label jugador2;
    Label jugador3;
    Label jugadorActual;

    @Override
    public void start(Stage stage) throws IOException {
        lcrGame = new LCRGame();
        lcrGame.encontrarPrimerJugador();
        lcrGame.crearJugadores();

        BorderPane fondo = new BorderPane();

        fondo.setCenter(crearCentro());
        fondo.setTop(crearPanel("Jugador 1:", 1));
        fondo.setLeft(crearPanel("Jugador 2:", 2));
        fondo.setRight(crearPanel("Jugador 3:", 3));
        fondo.setBottom(crearPanelParaCenter());

        Scene scene = new Scene(fondo, 320, 240);
        stage.setTitle("Left-Center-Right");
        stage.setScene(scene);
        stage.show();
    }

    private VBox crearPanelParaCenter() {
        VBox panel = new VBox();
        Label titulo = new Label("Center");
        fichasCenter = new Label("0");
        panel.getChildren().addAll(titulo, fichasCenter);
        panel.setAlignment(Pos.CENTER);
        return panel;
    }

    private VBox crearPanel(String nombre, int numeroDeJugador) {
        VBox panel = new VBox();
        Label titulo = new Label(nombre);
        panel.getChildren().add(titulo);
        switch (numeroDeJugador) {
            case 1:
                jugador1 = new Label("0");
                panel.getChildren().add(jugador1);
                break;
            case 2:
                jugador2 = new Label("0");
                panel.getChildren().add(jugador2);
                break;
            case 3:
                jugador3 = new Label("0");
                panel.getChildren().add(jugador3);
                break;
        }

        panel.setAlignment(Pos.CENTER);
        return panel;
    }

    private HBox crearCentro() {
        HBox centro = new HBox();

        Font font = new Font("Arial", 20);
        Label dado1 = new Label("L");
        dado1.setFont(font);
        dado1.setStyle("-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 5;");
        Label dado2 = new Label("C");
        dado2.setFont(font);
        dado2.setStyle("-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 5;");
        Label dado3 = new Label("R");
        dado3.setFont(font);
        dado3.setStyle("-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 5;");

        jugadorActual = new Label("0");
        jugadorActual.setFont(font);
        jugadorActual.setStyle("-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 5;");
        Button lanzar = new Button("Lanzar");
        lanzar.setOnAction(e -> {
            lcrGame.lanzarDados();
            lcrGame.procesarResultados();
            lcrGame.cambiarTurno();
            lcrGame.establecerJugadores();

            dado1.setText("" + lcrGame.getDado1().getValor());
            dado2.setText("" + lcrGame.getDado2().getValor());
            dado3.setText("" + lcrGame.getDado3().getValor());

            jugador1.setText("" + lcrGame.getJugador1().getFichas());
            jugador2.setText("" + lcrGame.getJugador2().getFichas());
            jugador3.setText("" + lcrGame.getJugador3().getFichas());

            jugadorActual.setText("" + lcrGame.getJugadorActual().getNombre());

            fichasCenter.setText("" + lcrGame.getCentro().getFichas());
        });
        centro.setAlignment(Pos.CENTER);
        centro.getChildren().addAll(lanzar, dado1, dado2, dado3, jugadorActual);
        return centro;
    }

    public static void main(String[] args) {
        launch();
    }
}