package ru.undefined.bugurter;

public class BugurtHelper {
    public static String toBugurt(String text){
        return text
            .toUpperCase()
            .replaceAll("\n", "\n@\n");
    }
    public static String toText(String bugurt){
        return bugurt
            .toLowerCase()
            .replaceAll("\n@\n", "\n");
    }
}