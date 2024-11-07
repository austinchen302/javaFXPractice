package austin.javafx.beginners;

import java.util.HashMap;
import java.util.Map;

public class DAO {

    static Database db = new Database();

    public void saveCow(Map<String, String> cowRecord) {
        db.saveCow(cowRecord);
    }

    public Map<String, String> getCow(String name) {
        return db.getCow(name);
    }


}
