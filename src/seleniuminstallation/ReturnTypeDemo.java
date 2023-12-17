package seleniuminstallation;

public class ReturnTypeDemo {

	public static void main(String[] args) {
		//this is ex to show what method returns value and what method just print out the value with out returning it
		
		ReturnTypeDemo type = new ReturnTypeDemo();
		type.sum(2, 4);    //here printing only doesn't return anything so you can not save it
		
		int additionSum = type.addition(5, 5);//here returns 10
		System.out.println(additionSum + 5);  //here we stored the returns 10 then we added 5 

	}
	
    //here method just print out that's why it is void it means doesn't return anything so we can save the value here
	// access modifier //return type //name of the function // parameters/arguments
	     public            void             sum               (int num1, int num2) {
		System.out.println(num1 + num2);
	}
	     
    //here method returns value so we can save the value that's why it's not void
    // access modifier    // return type   // name of the function      
	      private              int            addition(int num1, int num2) {

		return num1 + num2;
	}
	

}
