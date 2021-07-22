package by.training.task05.bean;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<Long, Parameters> map;

    public static Warehouse getInstance() {
        return instance;
    }

    public Warehouse() {
        this.map = new HashMap<>();
    }

    public Parameters get(Long id) throws BallException {
        if (!map.containsKey(id)) {
            throw new BallException("Warehouse does not contains cone with id " + id);
        }
        return map.get(id);
    }

    public Parameters put(Long id, Parameters value) {
        return map.put(id, value);
    }

    public Parameters remove(Long id) {
        return map.remove(id);
    }
}
