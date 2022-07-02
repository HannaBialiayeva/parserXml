package com.itacademy.parsersXml.object;

public class HotKey {

    private String hotkey;

    public HotKey(String hotkey) {
        this.hotkey = hotkey;
    }

    @Override
    public String toString() {
        return "\n\t\t\t\tHotKey{" +
                "hotkey='" + hotkey + '\'' +
                '}';
    }
}
