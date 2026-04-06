class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if(!st.isEmpty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else if (s.charAt(i) == '}') {
                    if(!st.isEmpty() && st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }

                } else if (s.charAt(i) == ']') {
                    if(!st.isEmpty() && st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }

                }
            }
            i++;
        }
        return st.isEmpty();
    }
}
