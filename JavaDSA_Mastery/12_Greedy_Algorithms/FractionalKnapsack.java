import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int value, weight;
        Item(int v, int w) { value = v; weight = w; }
    }
    public static double getMaxValue(Item[] items, int W) {
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        double totalValue = 0;
        for (Item item : items) {
            if (W == 0) break;
            if (item.weight <= W) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                totalValue += item.value * ((double)W / item.weight);
                W = 0;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int W = 50;
        System.out.println("Max value in knapsack: " + getMaxValue(items, W));
    }
}
