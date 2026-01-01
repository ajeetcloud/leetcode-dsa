class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int k = 10;
        int start = 0;
        int end = 9;
        int hash = 0;
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        // calculate the hash for 1st window
        int power = 9;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            hash += getNum(c) * Math.pow(4, power);
            power--;
        }
        set.add(hash);
        start = 0;
        for (end = 10; end < s.length(); end++) {
            char leavingChar = s.charAt(start);
            start++;
            int leavingNum = getNum(leavingChar);
            hash = hash - (leavingNum * (int)Math.pow(4, k - 1));
            hash = hash * 4;
            char incomingChar = s.charAt(end);
            int incomingNum = getNum(incomingChar);
            hash = hash + incomingNum;
            if (set.contains(hash)) {
                String s1 = s.substring(start, start + k);
                result.add(s1);
            }
            set.add(hash);
        }
        return new ArrayList<>(result);
    }

    public int getNum(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else {
            return 3;
        }
    }
}