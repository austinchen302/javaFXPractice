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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        broker.saveCow(createCowFromModel());
        System.out.println("Cow Name: " + model.getName() + " Description: " + model.getDescriptor());
    }

    private Cow createCowFromModel() {
        Cow cow = new Cow();
        cow.setName(model.getName());
        cow.setID(model.getID());
        cow.setDescriptor(model.getDescriptor());
        return cow;
    }

}

