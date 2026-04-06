class Solution {
    public int[] dailyTemperatures(int[] t) {
        // 2 stacks ?
        int result[] = new int[t.length];
        result[t.length-1] = 0;
        Stack<Integer> st = new Stack<>();
        Stack<Integer> stTemp = new Stack<>();
        st.push(t.length-1);
        for (int i = t.length-2; i >= 0; i--) {
            boolean index = false;;
            int count = 0;
            stTemp.clear();
            while (!st.isEmpty()) {
                int currIndex = st.pop();

                if (t[currIndex] > t[i]) {
                    result[i] = currIndex - i;
                    index = true;
                    stTemp.push(currIndex);
                    break;
                }

                stTemp.push(currIndex);
            }
            if (!index) {
                result[i] = 0;
            }
            while (!stTemp.isEmpty()) {
                st.push(stTemp.pop());
            }
            st.push(i);
        }
        return result;
    }
}
