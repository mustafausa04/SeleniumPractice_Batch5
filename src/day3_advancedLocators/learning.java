package day3_advancedLocators;

public class learning {

	public static void main(String[] args) {
		//this is just for learning and get some knowledge about a few things
		
		//in order to access a class properties, we need to create an object of that class like below
		learning day2 = new learning();
		//for task1() and task2() we create an object day2 for them to call them in the methods below because the methods
		//below are void
		day2.task1();
		day2.task2();
		//in task3() we don't need to create an object for it because the method for task3() below is static and static
		//properties belongs to the class itself so you don;t need to create an object
		task3();
	}
    
	public void task1() {
		System.out.println("This is task1");
	}
	
	public void task2() {
		System.out.println("This is task2");
	}
	
	public static void task3() {
		System.out.println("This is task3");
	}
}
