public class CommandLineArgumentsOne{
	
	public static void main(String[] args){
		int[] arrays;
		
	
		if(args.length > 0){
			arrays = new int[Integer.parseInt(args[0])];
		}else{
			arrays = new int[10];
		}
		System.out.println("Array size is " + arrays.length);		
	}
	
}