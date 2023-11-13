package fi.tuni.prog3.json;

import java.util.*;

public class ObjectNode extends Node implements Iterable<String> {

    private Map<String, Node> values;

    public ObjectNode() {
        this.values = new TreeMap<>();
    }

    public Node get(String key) {
        return values.get(key);
    }

    public void set(String key, Node node) {
        values.put(key, node);
    }

    public int size(){
        return values.size();
    }

    @Override
    public Iterator<String> iterator(){
        return values.keySet().iterator();
    }


    
}
