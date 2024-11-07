package austin.javafx.beginners;

import java.util.HashMap;
import java.util.Map;

public class DAO {

    static Database db = new Database();

    public void saveCow(Map<Integer, Map<String, String>> cowRecord) {
        db.saveCow(cowRecord);
    }


}
