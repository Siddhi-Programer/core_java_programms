import java.lang.reflect.*;

public class Object_Methods {

	public static void main(String[] args) {

		Person p1 = new Person("Ajay", 21, "Pune");
		Person p3 = p1;
		System.out.println("Person p1 : " + (p1)); // internaly calls toString()
		Person p2 = new Person("Ajay", 21, "Pune");
		Person p4 =new Person("Gauri",25,"Latur");
		p4 = null;

		System.out.println(p2.equals(p1)); // content Comparison overriding equals()

		System.out.println(p1.hashCode());
		System.out.println(p1.hashCode());
		System.out.println(p3.hashCode()); // unique integer generated by jvm

		// getClass() method - to get Runtie Class defination of an object
		System.out.println(p1.getClass().getName());
		Class c = p1.getClass();
		Field[] f = c.getDeclaredFields();
		int i = 1;
		for (Field field : f) {
			System.out.println(i + ") " + field);
			i++;
		}

		Method[] m = c.getDeclaredMethods();
		int j = 1;
		for (Method method : m) {
			System.out.println("\n" + j + ") " + method);
			j++;
		}
		System.out.println("Hashcode of p1 : " + p1.hashCode());

	}

}


class Person {

	String name;
	int age;
	String city;

	public Person(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return this.name + " - " + this.age + " - " + this.city;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.age * 2 + 10;
	}

	// to content comparison of 2 person
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			int age1 = this.age;
			String name1 = this.name;
			String city1 = this.city;
			Person newP = (Person) obj;
			if (age1 == newP.age && name1.equals(newP.name) && city1.equals(newP.city)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
	
	// called by gc before desroying object 
	// to perform cleanup activity 
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("inside finalize method");
		super.finalize();
	}

	// wait() , wait(long), wait(long,int)
	// notify(),notifyAll()   cant be overriden from object 
	// as above methods are final methods 
	// used for inter-thread communication 

}
