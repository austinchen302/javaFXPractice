package austin.javafx.beginners;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<Integer, Map<String, String>> database = new HashMap<>();
    private int id = 0;

    public int saveCow(Map<String, String> cowRecord) {
        database.put(id, cowRecord);
        return id++;
    }

    public Map<String, String> getCow(String name) {
        for (Map<String, String> cow : database.values()) {
            if (cow.containsKey(name)) {
                return cow;
            }
        }
        return null;
    }

    public Map<Integer, Map<String, String>> getData() {
        return database;
    }
}
