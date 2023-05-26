package zad3;

public class timer extends Thread{
	private boolean work;
	private long s;
	public void run()
	{
		try 
		{
			while(!isInterrupted())
			{
				synchronized(this)
				{
					sleep(1);
					s++;
				}
				
			}
		}
		catch(InterruptedException e) {}
	}
	public synchronized long getS()
	{
		return s;
	}
	public synchronized void setS(long ns)
	{
		s=ns;
	}
	
}
