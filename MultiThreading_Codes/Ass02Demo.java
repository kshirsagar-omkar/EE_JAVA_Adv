import java.io.*;



/*

			Threads vs Process 

			Thread: Threads are dependent on the parent process. If the process crashes, all threads are terminated.

			Process: Processes are independent; a crash in one does not affect others.

			answer -> Line Number 92( in main() Method ).



			Thread: Communication between threads is easier since they share the same memory.

			Process: Communication between processes (e.g., IPC) is more complex and slower.


*/



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
				Thread.sleep(100);
			}
			// return; -------------------> Still other threads are executed
			System.exit(0);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}

	} 
}