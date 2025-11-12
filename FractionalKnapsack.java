import java.util.*;

class Item {
    int value, weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {
    static double getMaxValue(int W, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double totalValue = 0.0;
        int currentWeight = 0;
        for (Item item : items) {
            if (currentWeight + item.weight <= W) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                int remainingWeight = W - currentWeight;
                totalValue += item.ratio * remainingWeight;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }
        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();
        double maxValue = getMaxValue(W, items);
        System.out.printf("\nMaximum value in Knapsack = %.2f\n", maxValue);
        sc.close();
    }
}



//  Total Time Complexity : O(n log n)
//  Space Complexity      : O(1)