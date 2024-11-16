import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {


    public static void main(String[] args) {

    }

    private static boolean isPalindrome(String str) {
//        String str = "A man, a plan, a canal : Panama";
//        System.out.println(isPalindrome(str));
        int i = 0, j = str.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static List<List<Integer>> findTriplets(int[] nums) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        System.out.println(findTriplets(nums));
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static int maxArea(int[] heights) {
//        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(maxArea(heights));
        int maxArea = 0;
        int i = 0, j = heights.length - 1;
        while (i < j) {
            int currentArea = Math.min(heights[i], heights[j]) * (j - i);
            maxArea = Math.max(maxArea, currentArea);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }


}
