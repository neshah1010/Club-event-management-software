package LAB6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpenSignUp extends Application {

	public static void main(String[] args) {
launch(args);
}

public void start(Stage primaryStage) throws Exception {
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setMinSize(300, 300);
	grid.setVgap(5);
	grid.setHgap(5);
	
	Label name = new Label("Name:");
	grid.add(name, 1, 0);
	 
	TextField op1 = new TextField();
	op1.setPrefColumnCount(15);
	grid.add(op1, 2, 0);
	 
	Label lastN = new Label("Last Name:");
	grid.add(lastN, 1, 1);
	 
	TextField op2 = new TextField();
	op2.setPrefColumnCount(5);
	grid.add(op2, 2, 1);
	
	Label pass = new Label("password:");
	grid.add(pass, 1, 2);
	 
	TextField op3 = new TextField();
	op3.setPrefColumnCount(5);
	grid.add(op3, 2, 2);
	
	Label cpass = new Label("Confirm Password:");
	grid.add(cpass, 1, 3);
	 
	TextField op4 = new TextField();
	op4.setPrefColumnCount(5);
	grid.add(op4, 2, 3);
	
	
	Button bttn = new Button("Sign In");
	grid.add(bttn, 3, 10);
	
	
	

Scene scene = new Scene(grid, 500, 500);

primaryStage.setTitle("COSC GUI group");
primaryStage.setScene(scene);
primaryStage.show();

}
}