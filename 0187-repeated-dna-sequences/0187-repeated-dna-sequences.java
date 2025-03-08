class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {

        int k = 10;
        int length = s.length();
        if (k >= length) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int a = 4;
        int start = 0;
        int end = start + k - 1;
        int h = 0;
        int p = k - 1;
        // calculate initial hash
        for (int i = 0; i <= end; i++) {
            char c = s.charAt(i);
            h += map.get(c) * (Math.pow(a, p));
            p--;
        }
        Set<Integer> seen = new HashSet<>();
        Set<String> results = new HashSet<>();
        seen.add(h);

        while (end <= length - 2) {
            char prevC = s.charAt(start);
            start++;
            end++;
            h = h - ((map.get(prevC)) * (int)(Math.pow(a, k - 1)));
            h *= a;
            char endC = s.charAt(end);
            h += ((map.get(endC)) * (int)(Math.pow(a, 0)));
            if (seen.contains(h)) {
                results.add(s.substring(start, start + k));
            }
            seen.add(h);
        }
        return new ArrayList<>(results);
    }
}