package austin.javafx.beginners;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.util.Map;

public class Controller {
    private Builder<Region> viewBuilder;
    private Interactor interactor;

    public Controller() {
        Model model = new Model();
        interactor = new Interactor(model);
        viewBuilder = new View(model, this::saveCow, this::getCow);
    }

    public void saveCow() {
        interactor.saveCow();
    }

    public void getCow() {
        Map<String, String> cowRecord = interactor.getCow();
        try {
            for (String name : cowRecord.keySet()) {
                System.out.println("Name: " + name + " Description: " + cowRecord.get(name));
            }
        } catch (NullPointerException e) {
            System.out.println("No cow found");
        }

    }

    public Region getView() {
        return viewBuilder.build();
    }
}
