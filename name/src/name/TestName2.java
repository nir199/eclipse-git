package name;

class Test2 {
	public static void prints(String[] args) {
		System.out.println("ssss");
	}
}
class Test1 {
	public static void printa(String[] args) {
		System.out.println("aaaa");
		Test2.prints(args);
		
	}
	public void printv() {
		printp();
	}
	private void printp() {
		
	}
}

class Te extends Test1 implements B {
	public void see() {
		printv();
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}

}
interface Faction {
	int f();
}
interface B {
	void f();
}