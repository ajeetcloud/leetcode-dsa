class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        int index = 0;
        int segments = 0;
        backtrack(result, new StringBuilder(), s, index, segments);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, String s, int index, int segments) {

        if (segments == 4 && index == s.length()) {
            result.add(sb.toString());
            return;
        }

        // This is a nice trick
        if (segments == 4 || index == s.length()) {
            return;
        }

        int num = 0;
        for (int i = index; i < Math.min(index + 3, s.length()); i++) {

            num = (num * 10 ) + (s.charAt(i) - '0');
            if (num > 255) {
                break;
            }
            if (s.charAt(index) == '0' && i > index) {
                break;
            }

            int origLength = sb.length();
            sb.append(s, index, i + 1); // Choose
            if (segments < 3) {
                sb.append(".");
            } 

            backtrack(result, sb, s, i + 1, segments + 1); // Recurse

            sb.setLength(origLength);
        }
    }
}