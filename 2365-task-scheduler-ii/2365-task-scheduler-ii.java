class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> lastPerformedDay = new HashMap<>();
        long currentDay = 0;
        for (int task: tasks) {
            // Try to do it the next day
            currentDay++;

            // If we have done this task, check if we need to wait
            if (lastPerformedDay.containsKey(task)) {
                long nextAvailableDay = lastPerformedDay.get(task) + space + 1;

                // If current day is too early, jump to next available day
                currentDay = Math.max(currentDay, nextAvailableDay);
            }

            // Record when we performed this task
            lastPerformedDay.put(task, currentDay);
        }
        return currentDay;
    }
}