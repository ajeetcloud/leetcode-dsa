class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Integer> taskCompletionMap = new HashMap<>();
        int days = 0;
        int nextValidDay = 0;
        for (int i = 0; i < tasks.length; i++) {
            days++;
            int currentDay = days;
            int currentTask = tasks[i];
            if (taskCompletionMap.containsKey(currentTask)) {
                nextValidDay = taskCompletionMap.get(currentTask) + space + 1;
                if (currentDay < nextValidDay) {
                    i--;
                } else {
                    taskCompletionMap.put(currentTask, currentDay);
                }  
            } else {
                taskCompletionMap.put(currentTask, currentDay);
            }
        }
        return days;
    }
}