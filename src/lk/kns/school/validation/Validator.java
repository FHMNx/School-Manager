package lk.kns.school.validation;

import raven.toast.Notifications;

public class Validator {

    public static boolean isEmailValid(String value) {
        if (value.isBlank()) {
            Notifications.getInstance().show(Notifications.Type.INFO,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "Email input cannot be empty");
            return false;
        } else if (!value.matches(Validation.EMAIL.validate())) {
            Notifications.getInstance().show(Notifications.Type.INFO,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "Enter valid email address");
            return false;
        }
        return true;
    }

//    public static boolean isPasswordValid(String value) {
//
//        if (value.isBlank()) {
//            Notifications.getInstance().show(Notifications.Type.WARNING,
//                    Notifications.Location.TOP_RIGHT,
//                    2000,
//                    "Password input cannot be empty");
//
//            return false;
//        } else if (!value.matches(Validation.PASSWORD.validate())) {
//            Notifications.getInstance().show(Notifications.Type.WARNING,
//                    Notifications.Location.TOP_RIGHT,
//                    2000,
//                    "Enter a Strong password");
//            return false;
//        }
//        return true;
//    }
    public static boolean isMobileValid(String value) {
        if (value.isBlank()) {
            Notifications.getInstance().show(Notifications.Type.INFO,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "Mobile input cannot be empty");

            return false;
        } else if (!value.matches(Validation.MOBILE.validate())) {
            Notifications.getInstance().show(Notifications.Type.INFO,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "Enter a valid mobile number");
            return false;
        }
        return true;
    }

    public static boolean isInputFieldValid(String value) {
        if (value.isBlank()) {
            Notifications.getInstance().show(Notifications.Type.INFO,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "Input field can't be empty");
            return false;
        }
        return true;
    }

    public static boolean isInputFieldsValid(String... values) {
        for (String val : values) {
            if (val == null | val.isBlank()) {
                Notifications.getInstance().show(Notifications.Type.INFO,
                        Notifications.Location.TOP_RIGHT,
                        2000,
                        "Input field can't be empty");
                return false;
            }
        }
        return true;
    }

    public static boolean isSelectedItemValid(int value) {
        if (value == 0) {
            Notifications.getInstance().show(Notifications.Type.INFO,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "Select siutable item");
            return false;
        }
        return true;
    }

}
