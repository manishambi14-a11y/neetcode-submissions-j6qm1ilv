class MinStack {
    Stack<Integer> res;
    Stack<Integer> minStack;
    public MinStack() {
        res = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        res.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (res.isEmpty()) return;
        int top = res.pop();
        if (minStack.peek().equals(top)) {
            minStack.pop();
        } 
    }
    
    public int top() {
        return res.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
