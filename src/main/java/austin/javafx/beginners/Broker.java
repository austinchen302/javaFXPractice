package austin.javafx.beginners;

import java.util.HashMap;
import java.util.Map;

public class Broker {
    private final DAO dao = new DAO();

    public void saveCow(Cow cow) {
        dao.saveCow(createCowRecord(cow));
    }

    private Map<String, String> createCowRecord(Cow cow) {
        HashMap<String, String> ret = new HashMap<>();
        ret.put(cow.getName(), cow.getDescriptor());
        return ret;
    }

    public Map<String, String> getCow(int id) {
        return dao.getCow(id);
    }
}
