package LinkedStack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		
		for ( int i = 0; i < 10; i++){
			stack.push(i);
		}
		
		for (Integer i : stack){
			System.out.print("[ "+i+" ] ");
		}
			
		
		for ( int i = 0; i < 10; i++){
			System.out.println(stack.pop());
		}
		System.out.println(stack.size());
	}

}
