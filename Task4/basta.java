package zad4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class basta extends Panel implements Runnable{
	
	private int brpovrca;
	private rupa[][] rupe;
	private int rows;
	private int columns;
	private int intervalcek;
	private double pom;
	private int brkoraci;
	private boolean slobodna;
	private Thread nit;
	private igra igrica;
	private boolean stopirao;
	
	public boolean isStopirao() {
		return stopirao;
	}
	public void setStopirao(boolean stopirao) {
		this.stopirao = stopirao;
	}
	public void setIgrica(igra igrica)
	{
		this.igrica=igrica;
	}
	public igra getIgrica()
	{
		return igrica;
	}
	public int getIntervalcek() {
		return intervalcek;
	}

	public void setIntervalcek(int intervalcek) {
		this.intervalcek = intervalcek;
		this.pom=intervalcek;
	}

	public basta (int r,int c) 
	{
		rows=r;
		columns=c;
		setBackground(Color.GREEN);
		brpovrca=100;
		rupe=new rupa[r][c];
		setLayout(new GridLayout(rows,columns,15,15));
		for (int i=0;i<rows;i++)
		for (int j=0;j<columns;j++)
		{
			add(rupe[i][j]=new rupa(this));
			rupe[i][j].setSlobodna(true);
		}
		setVisible(true);
		revalidate();
	}

	public int getBrkoraci() {
		return brkoraci;
	}

	public void setBrkoraci(int brkoraci) {
		this.brkoraci = brkoraci;
		for (int i=0;i<rows;i++)
			for (int j=0;j<columns;j++)
				rupe[i][j].setKorak(brkoraci);
	}
	public synchronized void smanji()
	{
		brpovrca--;
	}

	@Override
	public void run() {
		int x;
		int y;
		try {
		while (1==1)
		{
			x=(int)(Math.random()*rows);
			y=(int)(Math.random()*columns);
			if (!rupe[x][y].isSlobodna()) continue;
			else
			{
				nit.sleep(intervalcek);
				pom=pom*0.99;
				intervalcek=(int)(pom);
				rupe[x][y].setZiv(new krtica(rupe[x][y]));	
				rupe[x][y].stvori();
				rupe[x][y].pokreni();
			}
		}
		}
		catch (InterruptedException e) {}
	}
	public void stopskroz()
	{
		stopb();
		for (int i=0;i<rows;i++)
			for (int j=0;j<columns;j++)
			{
				rupe[i][j].stopnit();
			}
		igrica.namestipovrce(100);
	}
	public int getBrpovrca() {
		return brpovrca;
	}

	public void setBrpovrca(int brpovrca) {
		this.brpovrca = brpovrca;
	}

	public void pokrenib()
	{
		nit.start();
	}
	public void stvorib()
	{
		nit=new Thread(this);
	}
	private void stopb()
	{
		nit.interrupt();
		nit=null;
	}
	public void proveri()
	{
		if (brpovrca==0) {igrica.namestikreni();stopirao=true;stopskroz();}
	}
}
