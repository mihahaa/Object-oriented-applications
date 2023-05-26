package zad11;

import java.awt.Canvas;
import java.awt.Graphics;

public class mestozatocenje extends Canvas implements Runnable{
	
	private aparatzatocenje owner;
	private Thread thread;
	 private boolean work;
	private ukus kusic; 
	private sladoled slatko;
	public mestozatocenje(aparatzatocenje owner) {
		work=false;
		this.owner=owner;
		slatko=new sladoled(200);
	}
	public sladoled getSladoled() {
		return slatko;
	}
	public synchronized void setKusic(ukus u)
	{
		kusic=u;
	}
	public synchronized void finish()
	{

		while (thread!=null)
		{
			thread.interrupt();
			thread=null;
			break;
		}
	}
	
	public synchronized void pause()
	{
		work=false;
	}
	public synchronized void go()
	{
		work=true;
		notify();
	}
	
	@Override
	public void paint(Graphics g) {
		finish();
		thread=new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		Graphics g=this.getGraphics();
		try
		{
				int i=0;
				while (i<(owner.dajh())/10*10)
{
	synchronized(this)
	{
		while(!work) wait();
	}
				slatko.dodajMl(20, kusic);
				g.setColor(kusic.getBoja());
				owner.namestitxt(slatko.toString());
				g.fillRect(owner.dajx(),owner.dajy()-owner.dajh()/10-i,owner.dajw(),owner.dajh()/10);
				thread.sleep(500);
				i+=(owner.dajh())/10;
}
				slatko=new sladoled(200);
				owner.namestiprodaj(true);
				finish();
				
		}
		catch(InterruptedException e) {}
		synchronized (this)
		{
			go();
			work=false;
		}
	}
	
	
}
