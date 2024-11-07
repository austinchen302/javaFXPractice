package austin.javafx.beginners;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    private final StringProperty name = new SimpleStringProperty("");
    private final IntegerProperty birthday = new SimpleIntegerProperty(0);
    private final IntegerProperty id = new SimpleIntegerProperty(0);
    private final StringProperty descriptor = new SimpleStringProperty("");

    public String getName() {
        return name.get();
    }

    public void setName(String newName) {
        name.set(newName);
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public int getBirthday() {
        return birthday.get();
    }

    public void setBirthday(int newBirthday) {
        birthday.set(newBirthday);
    }

    public IntegerProperty getBirthdayProperty() {
        return birthday;
    }

    public int getID() {
        return id.get();
    }

    public void setID(int newID) {
        id.set(newID);
    }

    public IntegerProperty getIDProperty() {
        return id;
    }

    public String getDescriptor() {
        return descriptor.get();
    }

    public void setDescriptor(String newDescriptor) {
        descriptor.set(newDescriptor);
    }

    public StringProperty getDescriptorProperty() {
        return descriptor;
    }

}
