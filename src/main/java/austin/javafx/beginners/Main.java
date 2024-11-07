package austin.javafx.beginners;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Controller().getView()));
        stage.show();
    }
/*
    private Region createContent() {
        HBox nameEntry = new HBox(new Label("Name: "), new TextField(""));
        nameEntry.setSpacing(6);
        nameEntry.setPadding(new Insets(0,0,0,50));
        nameEntry.setAlignment(Pos.CENTER_LEFT);
        return nameEntry;
    }*/

    private Region createWelcomeLabel() {
        HBox nameEntry = createTextField("Username: ", 6, new int[]{0,0,0,0});
        HBox passwordEntry = createTextField("Password: ", 6, new int[]{0,0,0,0});
        nameEntry.setAlignment(Pos.CENTER);
        passwordEntry.setAlignment(Pos.CENTER);
        Label result = new Label();
        Button submit = new Button("Submit");
        submit.setOnAction(event -> result.setText("Success!"));
        VBox field = new VBox(nameEntry, passwordEntry, result, submit);
        field.setSpacing(6);
        field.setAlignment(Pos.CENTER);
        return field;
    }

    private HBox createTextField(String label, int spacing, int[] insets) {
        HBox ret = new HBox(new Label(label), new TextField(""));
        ret.setSpacing(spacing);
        ret.setPadding(new Insets(insets[0], insets[1], insets[2], insets[3]));
        return ret;
    }

}
