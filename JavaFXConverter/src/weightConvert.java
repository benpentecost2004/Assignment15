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

public class weightConvert extends Application {

    private static final double KG_TO_LBS = 2.20462;
    private static final double LBS_TO_KG = 0.453592;

    private TextField kgTextField;
    private TextField lbsTextField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("KG to LBS Conversion System");

        Label kgLabel = new Label("KG:");
        kgTextField = new TextField();
        kgTextField.setOnAction(e -> convertKgToLbs());

        Label lbsLabel = new Label("LBS:");
        lbsTextField = new TextField();
        lbsTextField.setOnAction(e -> convertLbsToKg());

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            convertKgToLbs();
            convertLbsToKg();
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(kgLabel, 0, 0);
        grid.add(kgTextField, 1, 0);

        grid.add(lbsLabel, 0, 1);
        grid.add(lbsTextField, 1, 1);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(convertButton);
        grid.add(buttonBox, 1, 2);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convertKgToLbs() {
        try {
            double kg = Double.parseDouble(kgTextField.getText());
            double lbs = kg * KG_TO_LBS;
            lbsTextField.setText(String.format("%.2f", lbs));
        } catch (NumberFormatException e) {
            kgTextField.setText("");
            lbsTextField.setText("");
        }
    }

    private void convertLbsToKg() {
        try {
            double lbs = Double.parseDouble(lbsTextField.getText());
            double kg = lbs * LBS_TO_KG;
            kgTextField.setText(String.format("%.2f", kg));
        } catch (NumberFormatException e) {
            kgTextField.setText("");
            lbsTextField.setText("");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}

