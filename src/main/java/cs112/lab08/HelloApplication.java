package cs112.lab08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    //CONSTANTS

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnologia", "8.png", 8),
            new LoteriaCard("La ingenieria", "9.png", 9),
    };

    private final Random random = new Random();

    @Override
    public void start(Stage stage) throws IOException {
        Label titleLabel = new Label("EChALE STEM Loteria");
        titleLabel.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #7b1fa2;");

        ImageView cardImageView = new ImageView(new LoteriaCard().getImage());
        cardImageView.setFitWidth(230);
        cardImageView.setFitHeight(300);
        cardImageView.setPreserveRatio(true);

        Label messageLabel = new Label("Draw a random card!");
        messageLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #333333;");

        Button drawCardButton = new Button("Draw Random Card");
        drawCardButton.setStyle("-fx-font-size: 14px; -fx-background-color: #7b1fa2; -fx-text-fill: white;");

        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int randomIndex = random.nextInt(LOTERIA_CARDS.length);
                LoteriaCard card = LOTERIA_CARDS[randomIndex];

                cardImageView.setImage(card.getImage());
                messageLabel.setText("You drew " + card.getCardName() + "!");
            }
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #fff8e1;");
        layout.getChildren().add(titleLabel);
        layout.getChildren().add(cardImageView);
        layout.getChildren().add(messageLabel);
        layout.getChildren().add(drawCardButton);

        Scene scene = new Scene(layout, 350, 500);
        stage.setTitle("Loteria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
