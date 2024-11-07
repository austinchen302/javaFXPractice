package austin.javafx.beginners;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Builder;
import javafx.util.converter.NumberStringConverter;
import org.w3c.dom.Text;

import java.util.Objects;

public class View implements Builder<Region> {
    private final Model model;
    private final Runnable saveHandler;
    private final Runnable retrieveHandler;

    public View(Model model, Runnable saveHandler, Runnable retrieveHandler) {
        this.model = model;
        this.saveHandler = saveHandler;
        this.retrieveHandler = retrieveHandler;
    }

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        results.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/style.css")).toExternalForm());
        results.setTop(headingLabel("Cow Information"));
        results.setCenter(createSaveField());
        results.setBottom(createRetriveField());
        return results;
    }

    private Node createSaveField() {
        VBox results = new VBox(6, idBox(), nameBox(), descriptorBox(), saveButton());
        results.setPadding(new Insets(20));
        return results;
    }

    private Node idBox() {
        VBox ret = new VBox(6,promptLabel("ID:"), boundIntegerField(model.getIDProperty()));
        ret.setAlignment(Pos.CENTER_LEFT);
        return ret;
    }

    private Node nameBox() {
        VBox ret = new VBox(6,promptLabel("Name:"), boundTextField(model.getNameProperty()));
        ret.setAlignment(Pos.CENTER_LEFT);
        return ret;
    }

    private Node descriptorBox() {
        VBox ret = new VBox(6, promptLabel("Description:"), boundTextField(model.getDescriptorProperty()));
        ret.setAlignment(Pos.CENTER_LEFT);
        return ret;
    }

    private Node saveButton() {
        Button saveButton = new Button("Save");
        saveButton.setOnAction(evt -> saveHandler.run());
        HBox results = new HBox(10, saveButton);
        results.setAlignment(Pos.CENTER_RIGHT);
        return results;
    }

    private Node createRetriveField() {
        VBox ret = new VBox(6, searchBox(), searchButton());
        ret.setPadding(new Insets(20));
        return ret;
    }

    private Node searchBox() {
        VBox ret = new VBox(6, promptLabel("Search"), boundTextField(model.getNameSearchProperty()));
        ret.setAlignment(Pos.CENTER_LEFT);
        return ret;
    }

    private Node searchButton() {
        Button searchButton = new Button("Search");
        searchButton.setOnAction(evt -> retrieveHandler.run());
        HBox ret = new HBox(10, searchButton);
        ret.setAlignment(Pos.CENTER_RIGHT);
        return ret;
    }

    private Node boundIntegerField(IntegerProperty property) {
        TextField field = new TextField();
        field.textProperty().bindBidirectional(property, new NumberStringConverter());
        return field;
    }

    private Node boundTextField(StringProperty boundProperty) {
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(boundProperty);
        return textField;
    }

    private Node promptLabel(String contents) {
        return styledLabel(contents, "prompt-label");
    }

    private Node headingLabel(String contents) {
        return styledLabel(contents, "heading-label");
    }

    private Node styledLabel(String contents, String styleClass) {
        Label label = new Label(contents);
        label.getStyleClass().add(styleClass);
        return label;
    }
}
