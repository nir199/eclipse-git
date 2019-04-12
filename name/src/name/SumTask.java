package name;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
	static final int THRE=100;
	long[] array;
	int start;
	int end;
	SumTask(long[] array,int start,int end) {
		this.array=array;
		this.start=start;
		this.end=end;
	}
	@Override
	protected Long compute(){
		if (end-start<=THRE) {
			long sum=0;
			for(int i=start;i<end;i++){
				sum+=array[i];
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(String.format("compute %d~%d=%d", start,end,sum));
			return sum;
		}
		int middle=(start+end)/2;
		System.out.println(String.format("split %d~%d==>%d~%d,%d~%d", start,end,start,middle,middle,end));
		SumTask sumTask1=new SumTask(array, start, middle);
		SumTask sumTask2=new SumTask(array, middle, end);
		invokeAll(sumTask1,sumTask2);
		Long result1=sumTask1.join();
		Long result2=sumTask2.join();
		Long result=result1+result2;
		System.out.println(String.format("result=%d+%d==>%d", result1,result2,result));
		return result;
	}
	public static void main(String args[]){
		long[] array=new long[400];
		for(int i=0;i<400;i++){
			array[i]=(long)(100*(Math.random()+1));
		}
		ForkJoinPool forkJoinPool=new ForkJoinPool(4);
		ForkJoinTask<Long> task=new SumTask(array, 0, array.length);
		long startTime=System.currentTimeMillis();
		Long result=forkJoinPool.invoke(task);
		long endTime=System.currentTimeMillis();
		System.out.println(String.format("sum:%d in %d ms", result,endTime-startTime));
	}
}
