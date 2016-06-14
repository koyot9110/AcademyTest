package test;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
    /** register.Person array. */
    private Person[] persons;
    
    /** Number of persons in this register. */
    private int count;
    
    /**
     * Constructor creates an empty register with maximum size specified.
     * @param size maximum size of the register
     */
    public ArrayRegister(int size) {
        persons = new Person[size];
        count = 0;
    }
    
    /* (non-Javadoc)
	 * @see test.Register#getCount()
	 */
    @Override
	public int getCount() {
        return count;
    }
    
    /* (non-Javadoc)
	 * @see test.Register#getSize()
	 */
    @Override
	public int getSize() {
        return persons.length;
    }
    
    /* (non-Javadoc)
	 * @see test.Register#getPerson(int)
	 */
    @Override
	public Person getPerson(int index) {
        return persons[index];
    }

    /* (non-Javadoc)
	 * @see test.Register#addPerson(test.Person)
	 */
    @Override
	public void addPerson(Person person) {
        persons[count] = person;
        count++;
    }       
    
    /* (non-Javadoc)
	 * @see test.Register#findPersonByName(java.lang.String)
	 */
    @Override
	public Person findPersonByName(String name) {
    	for (int i = 0; i < getCount(); i++) {
    		Person person = getPerson(i);
    		if (name.equals(person.getName())) {
    			System.out.println("Found matches:");
    			System.out.print(i + 1 + ". " + person.getName() + " (" + person.getPhoneNumber() + ")\n");
    			return getPerson(i);
			} 
    			
		}
    	return null;
    }
    
    /* (non-Javadoc)
	 * @see test.Register#findPersonByPhoneNumber(java.lang.String)
	 */
    @Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
    	for (int i = 0; i < getCount(); i++) {
    		Person person = getPerson(i);
    		if (phoneNumber.equals(person.getPhoneNumber())) {
    			System.out.println("Found matches:");
    			System.out.print(i + 1 + ". " + person.getName() + " (" + person.getPhoneNumber() + ")\n");
    			return getPerson(i);
			}
    			
		}
    	return null;
    }
    
    /* (non-Javadoc)
	 * @see test.Register#removePerson(test.Person)
	 */
    @Override
    public void removePerson(Person person) {
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].equals(person)) {
				persons[i] = persons[i + 1];
				count--;
			} else {
				System.out.println(person.getName() + " not found in file");
			}
		}

	}
    
}
