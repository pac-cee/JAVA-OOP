import java.util.HashMap;

public class HashingApplications {
    // Frequency counter using HashMap
    public static void frequencyCounter(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) freq.put(num, freq.getOrDefault(num, 0) + 1);
        System.out.println("Frequencies: " + freq);
    }

    // Check if two strings are anagrams
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4};
        frequencyCounter(arr);
        System.out.println("Are 'listen' and 'silent' anagrams? " + areAnagrams("listen", "silent"));
    }
}
