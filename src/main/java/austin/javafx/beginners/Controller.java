package austin.javafx.beginners;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class Controller {
    private Builder<Region> viewBuilder;
    private Interactor interactor;

    public Controller() {
        Model model = new Model();
        interactor = new Interactor(model);
        viewBuilder = new View(model, this::saveCow);
    }

    public void saveCow() {
        Task<Void> saveTask = new Task<>() {
            protected Void call() throws Exception {
                if (isCancelled()) {
                    return null;
                }
                interactor.saveCow();
                return null;
            }
        };
        Thread saveThread = new Thread(saveTask);
        saveThread.start();
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
