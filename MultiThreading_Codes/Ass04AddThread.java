import java.io.*;





class AddThread extends Thread{
	private int a[];
	private int start;
	private int end;
	private int sum;


	public AddThread(int a[], int start, int end){
		this.a = a;
		this.start = start;
		this.end = end;
		this.sum = 0;
	}


	public int getSum(){
		return sum;
	}


	public void run(){
		for(int i=start; i<=end; ++i){
			this.sum += this.a[i];
		}
	}

}



public class Ass04AddThread {


	public static void main(String []args) throws InterruptedException{

		int a[] = new int[]{1,1,1,1,1,1,1,1,1,1};

		AddThread ob1 = new AddThread(a, 0, 4);
		AddThread ob2 = new AddThread(a, 5, 9);

		ob1.start();
		ob2.start();




		ob1.join();
		ob2.join();




		int total = ob1.getSum() + ob2.getSum();


		System.out.println("Total : " + total);

	}

}