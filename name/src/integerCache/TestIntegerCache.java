package integerCache;

import java.util.LinkedList;
import java.util.Queue;

public class TestIntegerCache {
	public static void main(String args[]){
		/*Integer i1 = 100;
		Integer i2 = 100;
		Integer i3 = 1000;
		Integer i4 = 1000;
		Integer i5 = new Integer(100);
		Integer i6 = new Integer(100);
		Integer i7 = new Integer(1000);
		Integer i8 = new Integer(1000);
		System.out.println("i1==i2:"+(i1==i2));
		System.out.println("i3==i4:"+(i3==i4));
		System.out.println("i5==i6:"+(i5==i6));
		System.out.println("i7==i8:"+(i7==i8));
		char[] c = {'a', 'b', 'c'};
		char[] c2 = c;
		c[1] ='x';
		System.out.println(c2);*/
		Queue<Person> list = new LinkedList<>();
		Person person1 = new Person("peter", 12);
		Person person2 = new Person("tom", 15);
		list.add(person1);
		list.add(person2);
		//list.poll();
		System.out.println(list.iterator().next().getName());
	}
}
class Person{
	private String name;
	private int age;
	public Person(String name, int age){
		this.name = name;
		this.age = age;
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
}