class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product = product * nums[i];
            } else {
                zeroCount++;
            }
        }
        //int res[] = new int[nums.length];
        if ( zeroCount > 1) {
            return new int[nums.length];
        } else if (zeroCount == 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product / nums[i];
            }
            return nums;
        } else {
            for (int i = 0; i < nums.length; i++) {
               if (nums[i] == 0) {
                    nums[i] = product;
               } else {
                nums[i] = 0;
               }
            }
            return nums;
        }
    }
}  
