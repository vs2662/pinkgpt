package CHAT;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UI extends Application {
    private void openHelpWindow() {
        Stage helpStage = new Stage();
        helpStage.setTitle("Help");

        VBox helpLayout = new VBox(10);
        helpLayout.setPadding(new Insets(20));
        helpLayout.setStyle("-fx-background-color: #ffffff;");

        Label helpText = new Label("Welcome to the help section!\n\nHere you can add FAQs, contact info, or tips.");
        helpText.setStyle("-fx-font-size: 16px;");

        helpLayout.getChildren().add(helpText);

        Scene helpScene = new Scene(helpLayout, 400, 200);
        helpStage.setScene(helpScene);
        helpStage.show();
    }

    @Override
    public void start(Stage stage) {
        // === Sidebar ===
        Image profileImage = new Image("https://cdn-icons-png.flaticon.com/512/3135/3135715.png");
        ImageView profileView = new ImageView(profileImage);
        profileView.setFitWidth(80);
        profileView.setPreserveRatio(true);

        Button newChatButton = createSidebarButton("New Chat");
        Button helpButton = createSidebarButton("Help");
        helpButton.setOnAction(e -> openHelpWindow());
        Button settingsButton = createSidebarButton("Settings");

        VBox sidebar = new VBox(20, profileView, newChatButton, helpButton, settingsButton);
        sidebar.setPadding(new Insets(30));
        sidebar.setStyle("-fx-background-color: #87CEEB;"); // sky blue
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.setPrefWidth(200);

        // === Main Area ===
        TextField searchField = new TextField();
        searchField.setPromptText("Ask something...");
        searchField.setFont(Font.font("Arial", 18));
        searchField.setPrefWidth(400);
        searchField.setStyle("-fx-background-radius: 20; -fx-padding: 10px; -fx-background-color: white;");

        Button searchButton = new Button("🔍");
        searchButton.setStyle("""
            -fx-background-color: #ff69b4;
            -fx-text-fill: white;
            -fx-font-size: 18px;
            -fx-background-radius: 20;
            -fx-padding: 8 16;
        """);

        HBox searchBox = new HBox(10, searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER);
        searchBox.setPadding(new Insets(50));

        VBox mainContent = new VBox(searchBox);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setStyle("-fx-background-color: #E0F7FA;"); // light sky blue

        // === Full Layout ===
        BorderPane root = new BorderPane();
        root.setLeft(sidebar);
        root.setCenter(mainContent);

        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("Sky Blue Chat UI");
        stage.setScene(scene);
        stage.show();
    }

    private Button createSidebarButton(String text) {
        Button button = new Button(text);
        button.setStyle("""
            -fx-background-color: #ff69b4;
            -fx-text-fill: white;
            -fx-font-size: 14px;
            -fx-font-weight: bold;
            -fx-background-radius: 12px;
            -fx-padding: 10 20;
        """);
        button.setMaxWidth(Double.MAX_VALUE);
        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}
