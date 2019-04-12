package staticblock;

class Test{
	public static int x = 100;
	public final static int y = 200;
	public Test(){
		System.out.println("Test构造函数执行");
	}
	static{
		System.out.println("static语句块执行");
	}
	public static void display(){
		System.out.println("静态方法被执行");
	}
	public void display_1(){
		System.out.println("实例方法被执行");
	}
}

public class StaticBlockTest {
	public static void main(String args[]){
		try {
			//Test test = new Test();
			//Class.forName("staticblock.Test");//forName参数的类名前要加包名
			//Test t = (Test)Class.forName("Test").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
