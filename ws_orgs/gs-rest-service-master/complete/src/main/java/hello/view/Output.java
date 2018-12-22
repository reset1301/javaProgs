package hello.view;

import hello.dao.Users;
import hello.dao.interfaces.DocsCountries;
import hello.dao.interfaces.OfficeOrganization;

import java.util.HashMap;
import java.util.Map;

public class Output {
    private static Output ourInstance = new Output();

    public static Output getInstance() {
        return ourInstance;
    }

    private Output() {
    }

    public Map<String, String> getStringStringMap(Users u) {
        Map<String, String> usr = new HashMap<>();
        usr.put("id", String.valueOf(u.getId()));
        usr.put("firstName", u.getFirstName());
        usr.put("secondName", u.getSecondName());
        usr.put("middleName", u.getMiddleName());
        usr.put("position", u.getPosition().getName());
        return usr;
    }

    public Map<String, String> getStringStringMap(OfficeOrganization o) {
        Map<String, String> off = new HashMap<>();
        off.put("id", String.valueOf(o.getId()));
        off.put("name", o.getName());
        off.put("isActive", String.valueOf(o.isActive()));
        return off;
    }

    public Map<String, String> getStringStringMap(DocsCountries d) {
        Map<String, String> json = new HashMap<>();
        json.put("name", d.getName());
        json.put("code", d.getCode());
        return json;
    }
}
