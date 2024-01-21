package q316;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        if (n == 1) {
            return s;
        }

        char[] inputs = s.toCharArray();
        
        int[] lastIndices = new int[26];
        for (int i = 0; i < n; i++) {
            lastIndices[indexOf(inputs[i])] = i;
        }

        Deque<Character> unique = new ArrayDeque<>();
        boolean[] used = new boolean[26];
        for (int i = 0; i < n; i++) {
            char input = inputs[i];
            int index = indexOf(input);
            
            if (used[index]) {
                continue;
            }

            while (!unique.isEmpty() 
                && input < unique.peekLast() 
                && lastIndices[indexOf(unique.peekLast())] > i) {
                    used[indexOf(unique.pop())] = false;
            }

            unique.addLast(input);
            used[index] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char value : unique) {
            result.append(value);
        }

        return result.toString();
    }

    private int indexOf(char c) {
        return c - 'a';
    }
}
