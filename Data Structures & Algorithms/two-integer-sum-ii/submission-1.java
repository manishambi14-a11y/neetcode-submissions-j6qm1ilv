class Solution {
    public int[] twoSum(int[] n, int target) {
        int i = 0, j = n.length - 1;
        while (i < j) {
            if (n[i] + n[j] > target) {
                j--;
            } else if (n[i] + n[j] < target) {
                i++;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{0, 0};
    }
}
