class Solution {
  public int leastInterval(char[] tasks, int n) {
    int freq[] = new int[26];
    for (int i = 0; i < tasks.length; i++) {
      freq[tasks[i] - 'A']++;
    }
    Arrays.sort(freq);
    int gaps = freq[25] - 1;
    int idleSlots = gaps * n;
    for (int i = 24; i >= 0 && freq[i] > 0; i--) {
      idleSlots = idleSlots - Math.min(gaps, freq[i]);
      if (idleSlots < 0) {
        idleSlots = 0;
        break;
      }
    }
    return tasks.length + idleSlots;
  }
}