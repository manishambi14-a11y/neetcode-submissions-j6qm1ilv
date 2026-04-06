class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length-1;
        int c = matrix[0].length-1;
        int i = 0, j = 0;
        while (i <= r) {
            if (matrix[i][0] <= target && matrix[i][c] >= target) {
                break;
            }
            i++;
        }
        if (i > r) return false;
        int right = c;
        while (j <= right) {
            int mid = j + (right - j) / 2;
            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] < target) {
                j = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
