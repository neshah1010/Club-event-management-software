import java.awt.ScrollPane;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalendarApp extends Application {

    private YearMonth currentYearMonth;
    private VBox faqContainer;
    @Override
    public void start(Stage primaryStage) throws IOException {
        currentYearMonth = YearMonth.now();
        
        Label label = new Label("COSC GUI INTERFACE"); // create a label with the desired text
        VBox parent = new VBox(label); // create a VBox container and add the label to it
        parent.setAlignment(Pos.CENTER);

        // Create a grid pane to hold the calendar
        GridPane calendarGrid = new GridPane();
        calendarGrid.setAlignment(Pos.CENTER);
        calendarGrid.setHgap(10);
        calendarGrid.setVgap(10);
        calendarGrid.setStyle("-fx-background-color: lightblue;");
        // Create labels for the days of the week
        Label sundayLabel = new Label("Sun");
        Label mondayLabel = new Label("Mon");
        Label tuesdayLabel = new Label("Tues");
        Label wednesdayLabel = new Label("Wed");
        Label thursdayLabel = new Label("Thurs");
        Label fridayLabel = new Label("Fri");
        Label saturdayLabel = new Label("Sat");

        // Add the day of the week labels to the calendar
        calendarGrid.add(sundayLabel, 0, 0);
        calendarGrid.add(mondayLabel, 1, 0);
        calendarGrid.add(tuesdayLabel, 2, 0);
        calendarGrid.add(wednesdayLabel, 3, 0);
        calendarGrid.add(thursdayLabel, 4, 0);
        calendarGrid.add(fridayLabel, 5, 0);
        calendarGrid.add(saturdayLabel, 6, 0);

        // Determine the first day of the month
        LocalDate firstOfMonth = currentYearMonth.atDay(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        int daysInMonth = currentYearMonth.lengthOfMonth();

        // Create labels for each day of the month
        int dayOfMonth = 1;
        for (int row = 1; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 1 && col < dayOfWeek) {
                    continue;
                }
                if (dayOfMonth > daysInMonth) {
                    break;
                }
                Label dayLabel = new Label(Integer.toString(dayOfMonth));
                calendarGrid.add(dayLabel, col, row);
                dayOfMonth++;
            }
        }

        // Create a border pane to hold the calendar and center it
        BorderPane root = new BorderPane();
        root.setCenter(calendarGrid);
        root.setTop(parent);
        BorderPane.setAlignment(calendarGrid, Pos.CENTER);       
        RadioButton rred = new RadioButton("Calendar"); 
    	RadioButton ryellow = new RadioButton("Suggestion"); 
    	RadioButton rgreen = new RadioButton("FAQs");
    	HBox paneforradiobuttons = new HBox(5); //creating HBox for RadioButtons
		paneforradiobuttons.setAlignment(Pos.CENTER); //keeping RadioButtons in the center
    	ToggleGroup group = new ToggleGroup(); 
		rred.setToggleGroup(group);
		ryellow.setToggleGroup(group);
		rgreen.setToggleGroup(group);
		paneforradiobuttons.getChildren().addAll(rred, ryellow, rgreen); //adding all RadioButtons to HBox
		 //Creating border pane
		root.setBottom(paneforradiobuttons); //keeping RadioButtons in bottom
        // Create the scene and show the stage
		rred.setOnAction(e -> {
			try {
				start(primaryStage);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		ryellow.setOnAction(e -> second(primaryStage));
		rgreen.setOnAction(e -> third(primaryStage));
        Scene scene = new Scene(root,300,420);   
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    

	public void second(Stage p) {
		Label label = new Label("Suggestions"); // create a label with the desired text
        VBox parent = new VBox(label); // create a VBox container and add the label to it
        parent.setAlignment(Pos.CENTER);
    	GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setStyle("-fx-background-color: lightblue;");
        // Create TextFields to get the user's name and email address
        Label nameLabel = new Label("First Name:");
        TextField nameTextField = new TextField();
        Label lastLabel = new Label("Last Name");
        TextField lastTextField = new TextField();
        Label studentLabel = new Label(" Student ID");
        TextField studentTextField = new TextField();
        studentTextField.setPromptText("Enter an integer");
        Label emailLabel = new Label("Email:");
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("username@algomau.ca");
        
        // Create a TextArea to get the user's suggestion
        Label suggestionLabel = new Label("Suggestion:");
        TextArea suggestionTextArea = new TextArea();
        suggestionTextArea.setWrapText(true);

        // Create a Button to submit the suggestion
        Button submitButton = new Button("Submit");
        submitButton.setAlignment(Pos.CENTER); 
        submitButton.setOnAction(e -> {
            // Get the user's inputs and process the suggestion
            String name = nameTextField.getText();
            String last = lastTextField.getText();
           String id = studentTextField.getText();
            String email = emailTextField.getText();
            String suggestion = suggestionTextArea.getText();
            // Process the suggestion here...
            // ...
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thank You");
            alert.setHeaderText(null);
            alert.setContentText("Thank you for your suggestion!");
            alert.showAndWait();
            // Clear the form
            nameTextField.clear();
            lastTextField.clear();
            studentTextField.clear();
            emailTextField.clear();
            suggestionTextArea.clear();
        });
        RadioButton rred = new RadioButton("Calendar"); 
    	RadioButton ryellow = new RadioButton("Suggestion"); 
    	RadioButton rgreen = new RadioButton("FAQs");
    	HBox paneforradiobuttons = new HBox(5); //creating HBox for RadioButtons
		paneforradiobuttons.setAlignment(Pos.CENTER); //keeping RadioButtons in the center
    	ToggleGroup group = new ToggleGroup(); 
		rred.setToggleGroup(group);
		ryellow.setToggleGroup(group);
		rgreen.setToggleGroup(group);
		paneforradiobuttons.getChildren().addAll(rred, ryellow, rgreen); //adding all RadioButtons to HBox
		rred.setOnAction(e -> {
			try {
				start(p);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		ryellow.setOnAction(e -> second(p));
		rgreen.setOnAction(e -> third(p)); 
		//Creating border pane
		BorderPane root = new BorderPane();
		root.setBottom(paneforradiobuttons);
        // Add the form elements to the GridPane
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTextField, 1, 0);
        gridPane.add(lastLabel, 0, 1);
        gridPane.add(lastTextField, 1, 1);
        gridPane.add(studentLabel, 0, 2);
        gridPane.add(studentTextField, 1, 2);
        gridPane.add(emailLabel, 0, 3);
        gridPane.add(emailTextField, 1, 3);
        gridPane.add(suggestionLabel, 0, 4);
        gridPane.add(suggestionTextArea, 1, 4);
        gridPane.add(submitButton, 0, 5);
        gridPane.add(root,0,20);
        Scene scene = new Scene(gridPane, 300, 420);

        // Set the Scene on the primary Stage and show it
        p.setTitle("Event");
        p.setScene(scene);
        p.show();
    }
	public void third(Stage p1) {
		p1.setTitle("Frequently Asked Questions");

        VBox vbox = new VBox();

        // Create each question and answer
        HBox question1 = new HBox(new Label("What are some benefits of using an event managing app?"));
        TextArea answer1 = new TextArea("You can be notified for any upcoming events");
        answer1.setEditable(false);
        vbox.getChildren().addAll(question1, answer1);

        HBox question2 = new HBox(new Label("How to add time for a particular date in events? "));
        TextArea answer2 = new TextArea("Yes you can by clicking on the date");
        answer2.setEditable(false);
        vbox.getChildren().addAll(question2, answer2);
        RadioButton rred = new RadioButton("Calendar"); 
    	RadioButton ryellow = new RadioButton("Suggestion"); 
    	RadioButton rgreen = new RadioButton("FAQs");
    	HBox paneforradiobuttons = new HBox(5); //creating HBox for RadioButtons
		paneforradiobuttons.setAlignment(Pos.CENTER); //keeping RadioButtons in the center
    	ToggleGroup group = new ToggleGroup(); 
		rred.setToggleGroup(group);
		ryellow.setToggleGroup(group);
		rgreen.setToggleGroup(group);
		paneforradiobuttons.getChildren().addAll(rred, ryellow, rgreen);
		vbox.getChildren().addAll(paneforradiobuttons);
        rred.setOnAction(e -> {
			try {
				start(p1);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		ryellow.setOnAction(e -> second(p1));
		rgreen.setOnAction(e -> third(p1)); 
        Scene scene = new Scene(vbox, 300, 420);
        p1.setScene(scene);
        p1.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
