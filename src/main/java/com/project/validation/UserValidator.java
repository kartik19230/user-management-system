package com.project.validation;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(String name, String email, String phone, String pwd, String ageStr) {

        List<String> errors = new ArrayList<>();

        name = name != null ? name.trim() : "";
        email = email != null ? email.trim() : "";
        phone = phone != null ? phone.trim() : "";
        pwd = pwd != null ? pwd.trim() : "";

        if (name.isEmpty()) {
            errors.add("Enter valid name");
        }

        if (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
            errors.add("Enter valid email");
        }

        if (phone.isEmpty() || !phone.matches("\\d{10}")) {
            errors.add("Phone must be 10 digits");
        }

        if (pwd.isEmpty() || pwd.length() < 6) {
            errors.add("Password must be at least 6 characters");
        }

        if (ageStr == null || ageStr.trim().isEmpty()) {
            errors.add("Age is required");
        } else {
            try {
                int age = Integer.parseInt(ageStr);
                if (age <= 0) {
                    errors.add("Enter valid age");
                }
            } catch (Exception e) {
                errors.add("Invalid age format");
            }
        }

        return errors;
    }
}