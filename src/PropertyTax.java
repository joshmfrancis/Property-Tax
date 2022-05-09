// Names: Joshua Francis, Jordan Golliday
// Course: CSC 135
// File Name: PropertyTax.java

// Imports I used
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class PropertyTax extends Application {
    
    // Variables and Objects used
    
    // Button to presss when calculating information for the user to read
    Button calc = new Button("Calculate");
        
    // Text Fields for the user to input information in
    TextField propertyValue = new TextField();
    TextField propertyTax = new TextField();
        
    // "Titles" for the TextFields for the user to read and decide what to input
    Text textPropertyValue = new Text("Enter Property Value");
    Text textPropertyTax = new Text("Enter Property Tax (Ex: $0.64 on every "
            + "$100 of assessment value is entered in as 0.0064)");
    
    // Output used for the button Claculations to change
    Text output = new Text("");
    
    // Strings that are for use of the Action Event and the output format
    String s1, s2;
    
    @Override
    public void start(Stage primaryStage) {

        
        // GridPane that handles all of the information displaying, 
        // button, and output for the reader to see.
        GridPane inputGrid = new GridPane();
        inputGrid.setVgap(5);
        inputGrid.setHgap(40);
        inputGrid.add(textPropertyValue, 0, 0);
        inputGrid.add(textPropertyTax, 1, 0);
        inputGrid.add(propertyValue, 0, 1);
        inputGrid.add(propertyTax, 1, 1);
        inputGrid.add(calc, 0, 3);
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setStyle("-fx-background-color: white");
        inputGrid.add(output, 0, 4);
        
        calc.setOnAction(this::processButtonPress);

        // Creates the scene with the GridPane and sets size
        Scene scene = new Scene(inputGrid, 800, 320);

        // Titles the stage and sets other needed start properties
        primaryStage.setTitle("GUI Property Tax");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void processButtonPress(ActionEvent event) {

        // Grabs the input from the user 
        // and converts them to doubles for the program to compute
        double value = (Double.parseDouble(propertyValue.getText())*.60);
        double tax = Double.parseDouble(propertyTax.getText());
        
        // Strings to add to the output for 
        // the user to read in the output text object
        s1 = ("The Property's Value is: $" + value);
        s2 = ("\nThe Tax on the Property is: $" +  (value * tax));
        output.setText(s1 + s2);
        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
