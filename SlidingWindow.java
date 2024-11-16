import java.util.HashSet;

public class SlidingWindow {
    public static void main(String[] args) {
        String str = "abcadcbb";
        System.out.println(lengthOfLongestSubString(str));
    }

    public static int lengthOfLongestSubString(String str) {
        int maxLength = 0;
        int i = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int j = 0; j < str.length(); j++) {
            while (hashSet.contains(str.charAt(j))) {
                hashSet.remove(str.charAt(i));
                i++;
            }
            hashSet.add(str.charAt(j));
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    public static int maxProfit(int[] prices) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfit(prices));
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
