import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(input));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> validTriplets = new HashSet<>();

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i] - 1) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int one = nums[i];
                int two = nums[left];
                int three = nums[right];
                int sum = one + two + three;
                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(one, two, three);
                    validTriplets.add(triplet);
                    while (left + 1 < right && two == nums[left + 1]) {
                        left++;
                    }
                    while (right - 1 > left && one == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(validTriplets);
    }
}
