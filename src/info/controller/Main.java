package info.controller;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> loginView = Class.forName("network.view.Login");
            Method login = loginView.getDeclaredMethod("login");
            login.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
