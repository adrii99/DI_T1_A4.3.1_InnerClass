package es.ieslosmontecillos.es;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ControlCircle extends Application {

    Circle circle = new Circle();

    @Override
    public void start(Stage stage) throws IOException {

        BorderPane borderpane = new BorderPane();
        stage.setTitle("Control Circle");

        //Circulo
        circle.setRadius(50.0f);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        borderpane.setCenter(circle);

        //Boton
        HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));
        Button btnEnlarge = new Button("Enlarge");
        Button btnShrink = new Button("Shrink");

        hbox.getChildren().addAll(btnEnlarge,btnShrink);

        borderpane.setBottom(hbox);

        //Inner Class
        class EnlargeHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                circle.setRadius(circle.getRadius() + 5);
            }
        }

        btnEnlarge.setOnAction(new EnlargeHandler());

        class ShrinkHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent actionEvent) {
                circle.setRadius(circle.getRadius() - 5);
            }
        }

        btnShrink.setOnAction(new ShrinkHandler());

        Scene scene = new Scene(borderpane,300,300);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}