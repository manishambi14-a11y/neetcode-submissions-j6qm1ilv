class Solution {
    public int[] dailyTemperatures(int[] t) {
        // 2 stacks ?
        int result[] = new int[t.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < t.length; i++) {
            while (!st.isEmpty() && t[i] > t[st.peek()]) {
                int prev = st.pop();
                result[prev] = i - prev;
            }
            st.push(i);
        }
        return result;
    }
}
