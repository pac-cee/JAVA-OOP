package utils;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    private static Set<String> studentIds = new HashSet<>();

    public static boolean isNameValid(String name) {
        return name != null && name.matches("[A-Za-z ]+");
    }

    public static boolean isStudentIdUnique(String id) {
        if (studentIds.contains(id)) {
            return false;
        }
        studentIds.add(id);
        return true;
    }
} 