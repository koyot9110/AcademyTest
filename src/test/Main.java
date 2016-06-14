package test;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new ArrayRegister(20);

        register.addPerson(new Person("Janko", "0900123456"));
        register.addPerson(new Person("Jan", "0900123"));
        register.addPerson(new Person("Jank", "0900456"));

        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
        
        
    }
}
