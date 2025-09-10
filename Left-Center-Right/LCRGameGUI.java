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
    private LCRGame lcrGame;
    private Label fichasCenter;
    private Label fichasJugador1;
    private Label fichasJugador2;
    private Label fichasJugador3;
    private Label jugadorActual;
    private Label dado1;
    private Label dado2;
    private Label dado3;

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
                fichasJugador1 = new Label("3");
                panel.getChildren().add(fichasJugador1);
                break;
            case 2:
                fichasJugador2 = new Label("3");
                panel.getChildren().add(fichasJugador2);
                break;
            case 3:
                fichasJugador3 = new Label("3");
                panel.getChildren().add(fichasJugador3);
                break;
        }

        panel.setAlignment(Pos.CENTER);
        return panel;
    }

    private HBox crearCentro() {
        HBox centro = new HBox();

        Font font = new Font("Arial", 20);
        dado1 = new Label("L");
        dado1.setFont(font);
        dado1.setStyle("-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 5;");
        dado2 = new Label("C");
        dado2.setFont(font);
        dado2.setStyle("-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 5;");
        dado3 = new Label("R");
        dado3.setFont(font);
        dado3.setStyle("-fx-border-color: blue; " +
                "-fx-border-width: 2; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 5;");

        jugadorActual = new Label("0");
        jugadorActual.setFont(font);
//        jugadorActual.setStyle("-fx-border-color: blue; " +
//                "-fx-border-width: 2; " +
//                "-fx-border-style: solid; " +
//                "-fx-padding: 5;");
        jugadorActual.setVisible(false);
        Button lanzar = new Button("Lanzar");
        lanzar.setOnAction(e -> {
            atenderLanzamiento();
            if (lcrGame.esFinDeJuego()) {
                // cuando se termina el juego
                lanzar.setDisable(true); // deshabilita el botón
            }
        });
        centro.setAlignment(Pos.CENTER);
        centro.getChildren().addAll(lanzar, dado1, dado2, dado3, jugadorActual);
        return centro;
    }

    private void atenderLanzamiento() {
        lcrGame.lanzarDados();
        lcrGame.procesarResultados();
        lcrGame.cambiarTurno();
        lcrGame.establecerJugadores();

        actualizarDados();
        actualizarFichasDeJugadores();

        jugadorActual.setVisible(true);
        jugadorActual.setText("" + lcrGame.getJugadorActual().getNombre());

        fichasCenter.setText("" + lcrGame.getCentro().getFichas());
    }

    private void actualizarFichasDeJugadores() {
        fichasJugador1.setText("" + lcrGame.getJugador1().getFichas());
        fichasJugador2.setText("" + lcrGame.getJugador2().getFichas());
        fichasJugador3.setText("" + lcrGame.getJugador3().getFichas());
    }

    private void actualizarDados() {
        dado1.setText("" + lcrGame.getDado1().getValor());
        dado2.setText("" + lcrGame.getDado2().getValor());
        dado3.setText("" + lcrGame.getDado3().getValor());

        // mostrar solo la cantidad de dados que va a lanzar
        //  el jugador actual
        switch (lcrGame.getJugadorActual().getFichas()) {
            case 0: // si no tiene fichas, muestra 0 dados
                dado1.setVisible(false);
                dado2.setVisible(false);
                dado3.setVisible(false);
                break;
            case 1: // si tiene una ficha, muestra 1 dado
                dado1.setVisible(true);
                dado2.setVisible(false);
                dado3.setVisible(false);
                break;
            case 2: // si tiene 2 fichas, muestra 2 dados
                dado1.setVisible(true);
                dado2.setVisible(true);
                dado3.setVisible(false);
                break;
            default: // si tiene 3 o mas fichas, muestra 3 dados
                dado1.setVisible(true);
                dado2.setVisible(true);
                dado3.setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}