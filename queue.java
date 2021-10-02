import java.util.*;
import javax.swing.*;
import BreezySwing.*;

public class queue {
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	public void enqueue(int i) {
		while(stack1.isEmpty() == false) {
			stack2.push(stack1.pop());
		}
		stack1.push(i);
		while (stack2.isEmpty() == false) {
			stack1.push(stack2.pop());
		}
	}
	public int dequeue() {
		if(stack1.isEmpty()) {
			return -999;
		}
		return stack1.pop();
	}
	public boolean isEmpty() {
		return (stack1.isEmpty());
	}
	public int size() {
		return (stack1.size());
	}
	public String toString() {
		return null;
	}
	
}