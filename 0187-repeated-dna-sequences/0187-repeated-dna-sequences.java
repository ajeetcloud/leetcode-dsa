class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int start = 0;
        int end = 9;
        int sum = 0;
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        // calculate the sum for 1st window
        int power = 9;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            sum += getNum(c) * Math.pow(4, power);
            power--;
        }
        set.add(sum);
        start = 0;
        for (end = 10; end < s.length(); end++) {
            char leavingChar = s.charAt(start);
            start++;
            int leavingNum = getNum(leavingChar);
            sum = sum - (leavingNum * (int)Math.pow(4, 9));
            sum = sum * 4;
            char incomingChar = s.charAt(end);
            int incomingNum = getNum(incomingChar);
            sum = sum + incomingNum;
            if (set.contains(sum)) {
                String s1 = s.substring(start, start + 10);
                result.add(s1);
            }
            set.add(sum);
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