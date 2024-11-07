package austin.javafx.beginners;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private HashMap<Integer, Map<String, String>> database;

    public void saveCow(Map<Integer, Map<String, String>> cowRecord) {
        for (Integer id : cowRecord.keySet()) {
            database.put(id, cowRecord.get(id));
        }
    }

    public Map<Integer, Map<String, String>> getData() {
        return database;
    }
}
