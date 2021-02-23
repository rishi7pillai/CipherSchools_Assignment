package HashMap;

import java.util.HashMap;

public class SmallestWindow {
    
    public static int findMinimumWindow(String s, String p)
    {
        HashMap<Character, Integer> patternMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            if (patternMap.containsKey(p.charAt(i))) {
                int count = patternMap.get(p.charAt(i));
                count++;
                patternMap.put(p.charAt(i), count);
            } else {
                patternMap.put(p.charAt(i), 1);
            }
        }

        int start = 0;
        int index = 0;
        int targetCount = p.length();
        int matchingCount = 0;
        
        HashMap<Character, Integer> stringsMap = new HashMap<>();
        int ansSize = 0;

        while (index < s.length())
        {
            char ch = s.charAt(index);
            stringsMap.put(ch, stringsMap.getOrDefault(ch, 0) + 1);

            if (stringsMap.getOrDefault(ch, 0) <= patternMap.getOrDefault(ch, 0))
            {
                matchingCount++;
            }

            while (start < index && matchingCount == targetCount)
            {
                int tempAns = s.substring(start, index + 1).length();
                if (ansSize == 0 || tempAns < ansSize)
                    ansSize = tempAns;

                char beginCharacter = s.charAt(start);

                if(stringsMap.getOrDefault(beginCharacter, 0) == 1) {
                    stringsMap.remove(beginCharacter);
                } else {
                    stringsMap.put(beginCharacter, stringsMap.get(beginCharacter) - 1);
                }
                if(stringsMap.getOrDefault(beginCharacter, 0) < patternMap.getOrDefault(beginCharacter, 0)) {
                    matchingCount--;
                }
                start++;
            }
            index++;
        }
        return  ansSize;
    }


    public static void main(String[] args) {

        String string = "this is a test string";
        String pattern  = "tist";

        System.out.print(findMinimumWindow(string, pattern));
    }
}
