package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private Register register;
    
    /**
     * In JDK 6 use Console class instead.
     * @see readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };
    
    public ConsoleUI(Register register) {
        this.register = register;
    }
    
    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }
    
    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();
        
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");
        
        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);
        
        return Option.values()[selection - 1];
    }

    private void printRegister() {
        for (int i = 0; i < register.getCount(); i++) {
         	Person person = register.getPerson(i);
			System.out.print(i + 1 + ". " + person.getName() + " (" + person.getPhoneNumber() + ")\n");
		}
    }
    
    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();   
        boolean check = true;
        
        for (int i = 0; i < register.getCount(); i++) {
    		Person person = register.getPerson(i);
    		if ((name.equals(person.getName())) || (phoneNumber.equals(person.getPhoneNumber()))) {
    			check = false;
			}
    			
		}
        
        if (check == true) {
        	register.addPerson(new Person(name, phoneNumber));
		} else {
			System.out.println("Already exists file");
		}
        
    }
    
    private void updateRegister() {
    	System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        
    	System.out.println("1: For update name");
    	System.out.println("2: For update phone number");
    	int option = Integer.parseInt(readLine());
  
    	if (option == 1) {
    		System.out.println("Enter name:");
    		String s = readLine(); 
    		person.setName(s);
		} else if (option == 2) {
			System.out.println("Enter phone number:");
			String s = readLine(); 
			person.setPhoneNumber(s);
		} else {
			System.out.println("Wrong choice, please try again");
			updateRegister();
		}
    	
    }
    
    private void findInRegister() {
    	System.out.println("1: For find by name");
    	System.out.println("2: For find by phone number");
    	int option = Integer.parseInt(readLine());
    	
    	if (option == 1) {
    		System.out.println("Enter name:");
    		String findingName = readLine();
			register.findPersonByName(findingName);
		} else if (option == 2) {
			System.out.println("Enter phone number:");
			String findingPhoneNumber = readLine();
			register.findPersonByPhoneNumber(findingPhoneNumber);
		} else {
			System.out.println("Wrong choice, please try again");
			findInRegister();
		}
    	
    }
    
    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index);
        register.removePerson(person);
    }

}
