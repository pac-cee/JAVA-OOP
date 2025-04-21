import java.util.*;

public class JobSequencing {
    static class Job implements Comparable<Job> {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id; this.deadline = deadline; this.profit = profit;
        }
        public int compareTo(Job j) { return j.profit - this.profit; }
    }
    public static void scheduleJobs(Job[] jobs) {
        Arrays.sort(jobs);
        int n = jobs.length;
        boolean[] slot = new boolean[n];
        int totalProfit = 0;
        System.out.print("Scheduled jobs: ");
        for (Job job : jobs) {
            for (int j = Math.min(n, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    System.out.print(job.id + " ");
                    break;
                }
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27),
            new Job(4, 1, 25), new Job(5, 3, 15)
        };
        scheduleJobs(jobs);
    }
}
