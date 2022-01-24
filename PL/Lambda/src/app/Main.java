package app;

import estDatos.*;

public class Main {

	public static void main (String[] args) {
		
		// ----------	LAMBDA FUNCTIONS	----------
		MyInterface myAnonymousInterface = new MyInterface () {
			public void message (String message) {
				System.out.printf("This is the message from Anonymous:\n\t%s\n", message);
			}
		};

		MyInterface myLambdaInterface = (String message) -> System.out.printf("This is the message from Lambda:\n\t%s\n", message);

		MyInterface myLongLambdaInterface = (String message) -> {
			System.out.printf("This is the message from Long Lambda:\n\t%s\n", message);
			System.out.println("End of Long Lambda message.");
		};

		myAnonymousInterface.message("Hello Anonymous.");
		myLambdaInterface.message("Hello Lambda.");
		myLongLambdaInterface.message("Hello Long Lambda.");
			
		System.out.println();	// Separator
		
		//----------	ANONYMOUS CLASSES	----------
		Greeting greetingClass = new Greeting ();
		Greeting greetingAnonymous = new Greeting () {
			
			@Override
			public void greeting () {
				System.out.println("Hi there!\n\t~Anonymous Greeter.\n");
			}
		};
		
		greetingClass.greeting();
		greetingAnonymous.greeting();
	}
}
