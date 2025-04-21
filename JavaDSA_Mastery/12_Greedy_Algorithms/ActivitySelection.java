import java.util.*;

public class ActivitySelection {
    static class Activity implements Comparable<Activity> {
        int start, finish;
        Activity(int s, int f) { start = s; finish = f; }
        public int compareTo(Activity a) { return this.finish - a.finish; }
    }
    public static void selectActivities(Activity[] activities) {
        Arrays.sort(activities);
        System.out.print("Selected activities: ");
        int lastFinish = -1;
        for (Activity act : activities) {
            if (act.start >= lastFinish) {
                System.out.print("[" + act.start + "," + act.finish + "] ");
                lastFinish = act.finish;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Activity[] acts = {
            new Activity(1, 3), new Activity(2, 5), new Activity(0, 6),
            new Activity(8, 9), new Activity(5, 7), new Activity(5, 9)
        };
        selectActivities(acts);
    }
}
