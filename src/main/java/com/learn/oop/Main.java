package com.learn.oop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private List<Animal> zoo = new ArrayList<>();
    private ListView<Animal> animalListView = new ListView<>();
    private TextArea infoArea = new TextArea();
    private Label statusLabel = new Label("Welcome to the OOP Zoo!");
    private ProgressBar hungerBar = new ProgressBar(0);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java OOP Learning Zoo");

        // Populate Zoo
        zoo.add(new Lion("Simba"));
        zoo.add(new Elephant("Dumbo"));
        zoo.add(new Bird("Zazu"));
        zoo.add(new Lion("Nala"));
        zoo.add(new Elephant("Babar"));

        animalListView.getItems().addAll(zoo);
        animalListView.setPrefWidth(200);
        animalListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                updateHungerBar(newVal);
            }
        });

        // Header
        Label headerLabel = new Label("Zoo Management System");
        headerLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        headerLabel.setTextFill(Color.DARKSLATEBLUE);
        HBox header = new HBox(headerLabel);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 0 0 1 0;");

        // UI Components - Buttons
        Button soundButton = createStyledButton("Make Sound", "Polymorphism");
        Button feedButton = createStyledButton("Feed Animal", "Inheritance");
        Button feedSpecialButton = createStyledButton("Feed Special", "Overloading");
        Button flyButton = createStyledButton("Fly Action", "Interface");
        Button detailsButton = createStyledButton("Show Details", "Encapsulation");

        soundButton.setOnAction(e -> handleSound());
        feedButton.setOnAction(e -> handleFeed());
        feedSpecialButton.setOnAction(e -> handleFeedSpecial());
        flyButton.setOnAction(e -> handleFly());
        detailsButton.setOnAction(e -> handleDetails());

        VBox buttonBox = new VBox(12, soundButton, feedButton, feedSpecialButton, flyButton, detailsButton);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setMinWidth(220);

        // Info Area Styling
        infoArea.setEditable(false);
        infoArea.setWrapText(true);
        infoArea.setPrefHeight(180);
        infoArea.setStyle("-fx-font-family: 'Monospaced'; -fx-font-size: 13px; -fx-control-inner-background: #fafafa;");

        // Status and Progress
        hungerBar.setPrefWidth(200);
        Label hungerLabel = new Label("Hunger Level:");
        VBox statusBox = new VBox(5, hungerLabel, hungerBar, statusLabel);
        statusBox.setPadding(new Insets(10));
        statusBox.setStyle("-fx-background-color: #e8e8e8; -fx-border-color: #cccccc; -fx-border-width: 1 0 0 0;");
        statusLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

        // Layout
        BorderPane root = new BorderPane();
        root.setTop(header);
        
        VBox leftPane = new VBox(10, new Label("Animals:"), animalListView);
        leftPane.setPadding(new Insets(10));
        root.setLeft(leftPane);

        VBox centerPane = new VBox(10, new Label("Actions:"), buttonBox);
        centerPane.setPadding(new Insets(10));
        root.setCenter(centerPane);

        VBox bottomPane = new VBox(5, new Label("Information & Concepts:"), infoArea, statusBox);
        bottomPane.setPadding(new Insets(10));
        root.setBottom(bottomPane);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledButton(String text, String subtitle) {
        Button btn = new Button();
        VBox content = new VBox(2);
        content.setAlignment(Pos.CENTER);
        Label mainText = new Label(text);
        mainText.setFont(Font.font("System", FontWeight.BOLD, 12));
        Label subText = new Label(subtitle);
        subText.setFont(Font.font("System", 10));
        subText.setTextFill(Color.GRAY);
        content.getChildren().addAll(mainText, subText);
        btn.setGraphic(content);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setPadding(new Insets(8));
        return btn;
    }

    private void updateHungerBar(Animal animal) {
        // Hunger level 0 is full, 100 is starving. Progress bar 1.0 is full (so we invert it conceptually or just show it)
        // Let's say 100% hunger means the bar is full (starving).
        hungerBar.setProgress(animal.getHungerLevel() / 100.0);
        if (animal.getHungerLevel() > 80) {
            hungerBar.setStyle("-fx-accent: red;");
        } else if (animal.getHungerLevel() > 40) {
            hungerBar.setStyle("-fx-accent: orange;");
        } else {
            hungerBar.setStyle("-fx-accent: green;");
        }
    }

    private void handleSound() {
        Animal selected = animalListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String sound = selected.makeSound();
            statusLabel.setText(selected.getName() + " says: " + sound);
            infoArea.setText("CONCEPT: Polymorphism\n" +
                    "=======================\n" +
                    "Even though we treat the object as a generic 'Animal', " +
                    "it calls the specific 'makeSound()' method of its actual type (" + 
                    selected.getClass().getSimpleName() + ").\n\n" +
                    "Code: animal.makeSound(); // Results in \"" + sound + "\"");
        } else {
            statusLabel.setText("Please select an animal first!");
        }
    }

    private void handleFeed() {
        Animal selected = animalListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.eat();
            updateHungerBar(selected);
            statusLabel.setText("You fed " + selected.getName());
            infoArea.setText("CONCEPT: Inheritance\n" +
                    "====================\n" +
                    "The 'eat()' method is defined in the base class 'Animal'. " +
                    "Every subclass like '" + selected.getClass().getSimpleName() + "' inherits this behavior " +
                    "without having to redefine it.\n\n" +
                    "Hunger Level is now: " + selected.getHungerLevel());
        } else {
            statusLabel.setText("Please select an animal first!");
        }
    }

    private void handleFeedSpecial() {
        Animal selected = animalListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.eat("Premium Treats");
            updateHungerBar(selected);
            statusLabel.setText("You gave " + selected.getName() + " Premium Treats!");
            infoArea.setText("CONCEPT: Method Overloading\n" +
                    "===========================\n" +
                    "We called 'eat(String food)' instead of 'eat()'. " +
                    "Both methods have the same name but different parameters. " +
                    "This is a form of Compile-time Polymorphism.\n\n" +
                    "Hunger Level is now: " + selected.getHungerLevel());
        } else {
            statusLabel.setText("Please select an animal first!");
        }
    }

    private void handleFly() {
        Animal selected = animalListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (selected instanceof Flyable) {
                String action = ((Flyable) selected).fly();
                statusLabel.setText(action);
                infoArea.setText("CONCEPT: Interface\n" +
                        "==================\n" +
                        "The '" + selected.getClass().getSimpleName() + "' implements the 'Flyable' interface.\n" +
                        "Interfaces define what a class CAN DO (a contract).\n\n" +
                        "Code: ((Flyable) animal).fly();");
            } else {
                statusLabel.setText(selected.getName() + " cannot fly!");
                infoArea.setText("CONCEPT: Interface Check\n" +
                        "========================\n" +
                        "This animal does NOT implement the 'Flyable' interface. " +
                        "We use 'instanceof Flyable' to check this at runtime.");
            }
        } else {
            statusLabel.setText("Please select an animal first!");
        }
    }

    private void handleDetails() {
        Animal selected = animalListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            infoArea.setText("CONCEPT: Encapsulation & Abstraction\n" +
                    "====================================\n" +
                    "1. Encapsulation: The fields 'name' and 'hungerLevel' are PRIVATE. " +
                    "We access them via public getters.\n\n" +
                    "2. Abstraction: You interact with an 'Animal' object without needing " +
                    "to know internal implementation details.\n\n" +
                    "--- DETAILS ---\n" +
                    "Name: " + selected.getName() + "\n" +
                    "Type: " + selected.getClass().getSimpleName() + "\n" +
                    "Hunger Level: " + selected.getHungerLevel());
        } else {
            statusLabel.setText("Please select an animal first!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
