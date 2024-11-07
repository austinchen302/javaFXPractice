package austin.javafx.beginners;

import java.util.HashMap;
import java.util.Map;

public class Broker {
    private final DAO dao = new DAO();

    public void saveCow(Cow cow) {
        dao.saveCow(createCowRecord(cow));
    }

    private Map<Integer, Map<String, String>> createCowRecord(Cow cow) {
        HashMap<Integer, Map<String, String>> ret = new HashMap<>();
        HashMap<String, String> record = new HashMap<>();
        record.put(cow.getName(), cow.getDescriptor());
        ret.put(cow.getID(), record);
        return ret;
    }
}
