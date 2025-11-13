public class LocalVariable {
	static int x = 20;
	public static void main(String[] args){
		int num = 16;
		int result = myPrintMethod();
		System.out.println(num);
		System.out.printf("%d%n",result);
		myMethod1();
		
	}
	public static void myMethod1(){
		int x = 20;
		System.out.println(x);
	}
	public static int myPrintMethod(){
		int x = 50;
		return x;
	}
}