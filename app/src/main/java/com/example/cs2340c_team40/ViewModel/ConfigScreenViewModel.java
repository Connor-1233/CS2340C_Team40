package com.example.cs2340c_team40.ViewModel;

public class ConfigScreenViewModel {

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
