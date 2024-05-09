package Week7;

public class ArrayStack {
    int[] stack;
    int capacity;
    int cur_len;
    ArrayStack() {
        stack = new int[10];
        capacity = 10;
        cur_len = 0;
    }
    boolean isEmpty() {
        return cur_len == 0;
    }
    void push(int n) {
        if(this.isEmpty()) {
            stack[0] = n;
            cur_len++;
            System.out.printf("Element pushed: %d\n\n", n);
            return;
        }

        if(cur_len < capacity) {
            for (int i = cur_len-1; i >= 0; i--) {
                stack[i+1] = stack[i];
            }
            stack[0] = n;
            cur_len++;
        } else if(cur_len == capacity) {
            int[] tmp = new int[capacity*2];
            System.arraycopy(stack, 0, tmp, 0, cur_len);
            stack = new int[capacity*2];
            System.arraycopy(tmp, 0, stack, 0, cur_len);
            capacity *= 2;
            for (int i = cur_len-1; i >= 0; i--) {
                stack[i+1] = stack[i];
            }
            stack[0] = n;
            cur_len++;
        }
        System.out.printf("Element pushed: %d\n\n", n);
    }
    int pop() {
        if(isEmpty()) {
            return 0;
        }
        int tmp = stack[0];
        for(int i = 1; i < cur_len; i++) {
            stack[i-1] = stack[i];
        }
        cur_len--;
        return tmp;
    }
    int peek() {
        if(isEmpty()) return 0;
        return stack[0];
    }
}
