// Custom class for a "person"
// Compile: javac Person.java
// Execute (with assertions): java -ea Person.java
public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.age = age; 
    }

    @Override
    public boolean equals(Object obj) {
        // Check for reference equality
        if (this == obj) {
            return true;
        }
        // Check for null and type compatibility
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person other = (Person) obj;

        // Check each significant instance variable
        return firstName.equals(other.firstName) && lastName.equals(other.lastName) 
            && age == other.age;
    }

    // Very simple way to get a hashCode 
    // Note: This might not be the best at getting the uniformity property 
    @Override
    public int hashCode(){
        int result =0; 

        if(firstName != null){
            result += firstName.hashCode(); 
        }
        if(lastName != null){
            result += lastName.hashCode(); 
        }
        result += age; 
        return result; 
    }

    public static void main(String[] args){
        Person person1 = new Person("Donald", "Duck", 30); 
        Person person2 = new Person("Donald", "Duck", 30); 
        Person person3 = new Person("Minnie", "Mouse", 30);
        Person person4 = new Person("Donald", "Duck", 40);

        assert (person1 == person2) == false; 
        assert (person1.equals(person2)) == true; 
        assert (person1.equals(person3)) == false; 
        assert (person1.equals(person4)) == false; 

        System.out.println("person1 hash ="+person1.hashCode());
        System.out.println("person2 hash ="+person2.hashCode());
        System.out.println("person3 hash ="+person3.hashCode());
        System.out.println("person4 hash ="+person4.hashCode());
    }
}