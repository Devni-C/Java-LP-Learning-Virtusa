public class InnerClassDemo {
/*Creating an inner class is quite simple. 
You just need to write a class within a class. 
Unlike a class, an inner class can be private and 
once you declare an inner class private, 
it cannot be accessed from an object outside the class*/


	private String firstName = "Devni";
	
	private class InnerDemo {
		public void innerPrintName() {
			System.out.println("Hello " + firstName + ".. This is a demonstration of an Inner Class!");
		}		
	}

	public void accessInner() {
		InnerDemo inner = new InnerDemo();
		inner.innerPrintName();
	}

}
