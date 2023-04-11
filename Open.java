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

public class Open extends Application {

	public static void main(String[] args) {
launch(args);
}

public void start(Stage primaryStage) throws Exception {
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setMinSize(300, 300);
	grid.setVgap(5);
	grid.setHgap(5);
	
	Label Email = new Label("Email:");
	grid.add(Email, 1, 0);
	 
	TextField op1 = new TextField();
	op1.setPrefColumnCount(15);
	grid.add(op1, 2, 0);
	 
	Label SecondOperand = new Label("Password:");
	grid.add(SecondOperand, 1, 1);
	 
	TextField op2 = new TextField();
	op2.setPrefColumnCount(5);
	grid.add(op2, 2, 1);
	
	Button bttn = new Button("Sign In");
	grid.add(bttn, 2, 10);
	
	

	bttn.setOnAction(new EventHandler<ActionEvent>() {
		 
        public void handle(ActionEvent event) {
        	String no1 = op1.getText();
        	
           int numb1 = Integer.parseInt(no1);
          
           String no2 = op2.getText();
           int numb2 = Integer.parseInt(no2);
          int val = numb1 - numb2;
          
         
     
        }
    });
	
	
	

Scene scene = new Scene(grid, 500, 500);

primaryStage.setTitle("COSC GUI group");
primaryStage.setScene(scene);
primaryStage.show();

}
}