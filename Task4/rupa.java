package zad4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class rupa extends Canvas implements Runnable{

	private basta owner;
	private zivotinja ziv;
	private int korak;
	private int trenkorak;
	private int udario;
	private boolean slobodna;
	public int getTrenkorak() {
		return trenkorak;
	}
	public void setTrenkorak(int trenkorak) {
		this.trenkorak = trenkorak;
	}
	public int getKorak() {
		return korak;
	}
	public void setKorak(int korak) {
		this.korak = korak;
	}
	private Thread nit;
	private int brojkoraka,trenutnikorak;
	public zivotinja getZiv() {
		return ziv;
	}
	public void setZiv(zivotinja ziv) {
		this.ziv = ziv;
	}
	public void zgazi()
	{
		if (ziv!=null)
		ziv.udarena();
	}
	public basta getOwner() {
		return owner;
	}
	public void setOwner(basta owner) {
		this.owner = owner;
	}
	public Thread getNit() {
		return nit;
	}
	public void setNit(Thread nit) {
		this.nit = nit;
	}
	public int getBrojkoraka() {
		return brojkoraka;
	}
	public void setBrojkoraka(int brojkoraka) {
		this.brojkoraka = brojkoraka;
	}
	public int getTrenutnikorak() {
		return trenutnikorak;
	}
	public void setTrenutnikorak(int trenutnikorak) {
		this.trenutnikorak = trenutnikorak;
	}
	@Override
	public void run() {
		if (ziv!=null)
		{
			try
			{
				trenkorak=0;
				while (trenkorak<korak)
				{
					nit.sleep(100);
					trenkorak++;
					repaint();

				}
				udario=2;
				nit.sleep(2000);
				repaint();
				stopnit();
			}
			catch (InterruptedException e) {}
		}
	}
	public void pokreni()
	{
		slobodna=false;
		udario=0;
		nit.start();
	}
	public int getUdario() {
		return udario;
	}
	public void setUdario(int udario) {
		this.udario = udario;
	}
	public void stvori()
	{
		nit=new Thread(this);
	}
	public rupa (basta b)
	{
		owner=b;
		setBackground(Color.MAGENTA);
		addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent me)
					{
					if (ziv!=null)
					{
						ziv.udarena();
						repaint();
					}
					}
				});
	}
	@Override
	public void paint(Graphics g) {
		if (ziv!=null) ziv.crtaj();	
		 }
	public void stopnit()
	{	
		if (!owner.isStopirao())
		{
		if (udario==2) if (ziv!=null) ziv.pobegla();
		udario=0;
		ziv=null;
		slobodna=true;
		if (nit!=null)
		{
			nit.interrupt();
			nit=null;
		}
		repaint();
		}
		else
		{
			udario=0;
			ziv=null;
			slobodna=true;
			if (nit!=null)
			{
				nit.interrupt();
				nit=null;
			}
			repaint();
		}
	}
	public boolean isSlobodna() {
		return slobodna;
	}
	public void setSlobodna(boolean slobodna) {
		this.slobodna = slobodna;
	}
	
	
}
