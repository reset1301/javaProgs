package com.roma;

import com.roma.entity.User;

import java.util.HashMap;
import java.util.Map;

public class Black {
    public Map<Integer, User> userMap;

//    public static

    public Black() {
        userMap = new HashMap<>();
        int i = 1;
        userMap.put(i++, new User("1", "2", "3"));
        userMap.put(i++, new User("2", "3", "4"));
        userMap.put(i++, new User("3", "3", "4"));
        userMap.put(i++, new User("4", "3", "4"));
        userMap.put(i++, new User("5", "3", "4"));
        userMap.put(i++, new User("6", "3", "4"));
        userMap.put(i++, new User("7", "3", "4"));
        userMap.put(i++, new User("8", "3", "4"));
        userMap.put(i++, new User("9", "3", "4"));
        userMap.put(i++, new User("10", "3", "4"));
        userMap.put(i++, new User("118", "3", "4"));
    }
}
