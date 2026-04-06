class Solution {
    public int maxArea(int[] heights) {
        int len = 0, i = 0, j = heights.length-1;
        int maxHold = 0;
        while (i < j) {
            int min = Math.min(heights[i], heights[j]);
            len = j - i;
            maxHold = Math.max(min*len, maxHold);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxHold;
    }
}
