package austin.javafx.beginners;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Interactor {
    private Model model;
    private final Broker broker = new Broker();

    public Interactor(Model model) {
        this.model = model;
    }

    public void saveCow() {
        broker.saveCow(createCowFromModel());
        System.out.println("Cow Name: " + model.getName() + " Description: " + model.getDescriptor());
    }

    public Map<String, String> getCow() {
        return broker.getCow(getSearchFromModel());
    }

    private Cow createCowFromModel() {
        Cow cow = new Cow();
        cow.setName(model.getName());
        cow.setDescriptor(model.getDescriptor());
        return cow;
    }

    private String getSearchFromModel() {
        return model.getNameSearch();
    }

}

