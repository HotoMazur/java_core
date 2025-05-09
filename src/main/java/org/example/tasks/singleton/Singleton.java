package org.example.tasks.singleton;

public final class Singleton {
    private static Singleton instance;
    private static String str;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void setStr(String str) {
        Singleton.str = str;
    }
    public String getStr() {
        return str;
    }
}
