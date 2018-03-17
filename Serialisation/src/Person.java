import java.io.Serializable;

public class Person implements Serializable{
	String name;
	int age;
	
	public Person(int a, String n) {
		this.name = n;
		this.age = a;
	}
	
	public String getName() {return this.name;}
	
	public int getAge() {return this.age;}
	
	public String toString() {
		return "\tName: "+getName()+"\tAge: "+getAge();
	}
}
