class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // find min and then from there try to find max
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int isItMin = nums[i];
            while (set.contains(isItMin-1)) {
                isItMin = isItMin - 1;
            }
            count = 1;
            while (set.contains(isItMin + 1)) {
                isItMin = isItMin + 1;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
