import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class distanceConvert extends Application {

    private static final double METERS_TO_FEET = 3.28084;
    private static final double FEET_TO_METERS = 0.3048;

    private TextField metersTextField;
    private TextField feetTextField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Conversion System");

        Label metersLabel = new Label("Meters:");
        metersTextField = new TextField();
        metersTextField.setOnAction(e -> convertMetersToFeet());

        Label feetLabel = new Label("Feet:");
        feetTextField = new TextField();
        feetTextField.setOnAction(e -> convertFeetToMeters());

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            convertMetersToFeet();
            convertFeetToMeters();
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(metersLabel, 0, 0);
        grid.add(metersTextField, 1, 0);

        grid.add(feetLabel, 0, 1);
        grid.add(feetTextField, 1, 1);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(convertButton);
        grid.add(buttonBox, 1, 2);
        
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convertMetersToFeet() {
        try {
            double meters = Double.parseDouble(metersTextField.getText());
            double feet = meters * METERS_TO_FEET;
            feetTextField.setText(String.format("%.2f", feet));
        } catch (NumberFormatException e) {
            metersTextField.setText("");
            feetTextField.setText("");
        }
    }

    private void convertFeetToMeters() {
        try {
            double feet = Double.parseDouble(feetTextField.getText());
            double meters = feet * FEET_TO_METERS;
            metersTextField.setText(String.format("%.2f", meters));
        } catch (NumberFormatException e) {
            metersTextField.setText("");
            feetTextField.setText("");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
