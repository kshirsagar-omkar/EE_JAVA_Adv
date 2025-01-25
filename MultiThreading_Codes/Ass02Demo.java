import java.io.*;




class A extends Thread
{
	public void run()
	{
		try
		{
			for(int i=0; i<5; ++i)
			{
				//Write Processing Logic here 
				//Dont write io Operations here
				System.out.println("BCA");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}


class B implements Runnable
{
	public void run()
	{
		try
		{
			for(int i=0; i<5; ++i)
			{
				//Write Processing Logic here 
				//Dont write io Operations here
				System.out.println("BCS");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}




public class Ass02Demo
{
	public static void main(String []args)
	{
		A ob1 = new A();
		ob1.start();


		Thread t = new Thread( new B() ); 
		t.start();

		try
		{
			for(int i=0; i<5; ++i)
			{
				//Write Processing Logic here 
				//Dont write io Operations here
				System.out.println("MAIN");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}

	} 
}