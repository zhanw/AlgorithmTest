package zhanw.test;

public class ObjectTest {
	public static void main(String[] args) {
		Person person = new StubPerson();
		person.printAge();
	}
	
}
class Person{
	int age = 5;
	
	protected void printAge(){
		System.out.println(age);
	}
}

class StubPerson extends Person{
//	int age; //print 5 if uncomment this line
	public StubPerson(){
		super();
		this.age = 6;
	}
	
//	@Override
//	protected void printAge() {
//		// TODO Auto-generated method stub
//		super.printAge();
//	}
}