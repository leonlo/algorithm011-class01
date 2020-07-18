import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /**
     * Greedy algorithm solution
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    ten++;
                    five--;
                    break;
                case 20:
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                    break;
                default:
                    break;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Stupid solution
     * @param bills
     * @return
     */
    private boolean directlySolution(int[] bills) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int bill : bills) {
            int change = bill - 5;
            while (change > 0) {
                if (queue.size() <= 0) {
                    return false;
                }
                boolean isFound = false;
                for (Integer i : queue) {
                    if (change - i >= 0) {
                        change = change - i;
                        queue.remove(i);
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    return false;
                }
            }

            if (bill < 20) {
                queue.add(bill);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        boolean res = new Solution().lemonadeChange(new int[] { 5,5,5,10,20 });
        System.out.println(res);
    }
}
