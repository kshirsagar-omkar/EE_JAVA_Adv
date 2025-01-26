import java.io.*;





class A extends Thread
{
	private int n;
	private String msg;


	public A(String msg, int n)
	{
		this.msg = msg;
		this.n = n;
	}



	public void run()
	{
		try
		{
			for(int i=0; i<n; ++i)
			{
				System.out.println(msg);
				Thread.sleep(600);
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}






public class Ass03PrintTextThread
{
	public static void main(String []args) throws InterruptedException
	{



		A t1 = new A("BCA", 3);
		A t2 = new A("BCS", 5);

		t1.start();
		t2.start();


		t1.join();
		t2.join();

		try
		{
			for(int i=0; i<5; ++i)
			{
				System.out.println("Main");
				Thread.sleep(600);
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}

	}
}