package rrr;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties properties;
    private Set set;
    private List list;

    public void displayInfo() {
        System.out.println("Map contents:\n");
        for (Map.Entry<String, Object> m : map.entrySet()) {
            System.out.println("Key: " + m.getKey() + " Value: " + m.getValue());
        }
        System.out.println("\nProps contents:\n");
        for (Map.Entry<Object, Object> p : properties.entrySet()) {
            System.out.println("Key: " + p.getKey() + " Value: " + p.getValue());
        }
        System.out.println("\nSet contents:\n");
        for (Object s : set) {
            System.out.println("Value: " + s);
        }
        System.out.println("\nList contents:\n");
        for (Object l : list) {
            System.out.println("Value: " + l);
        }
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
