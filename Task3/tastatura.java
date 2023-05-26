package zad3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;

public class tastatura extends Panel implements Runnable{
	private Label natpis=new Label("");
	private long s;
	private Thread th;
	private boolean subrojevi;
	private CardLayout card=new CardLayout();
	private Panel cardpanel;
	private ArrayList<Button> dugmici=new ArrayList<Button>(); 
	
	public ArrayList<Button> getDugmici() {
		return dugmici;
	}
	public void setDugmici(ArrayList<Button> dugmici) {
		this.dugmici = dugmici;
	}
	public boolean dalisubr()
	{
		return subrojevi;
	}
	public synchronized long getS()
	{
		return s;
	}
	public synchronized void setS(long ns)
	{
		s=ns;
	}
	public tastatura()
	{
		th=new Thread(this);
		subrojevi=true;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(250,250));
		cardpanel=new Panel(card);
		Button b1=new Button("1");
		Button b2=new Button("2");
		Button b3=new Button("3");
		Button b4=new Button("4");
		Button b5=new Button("5");
		Button b6=new Button("6");
		Button b7=new Button("7");
		Button b8=new Button("8");
		Button b9=new Button("9");
		Button bzvezda=new Button("*");
		Button b0=new Button("0");
		Button bplus=new Button("+");
		dugmici.add(b1);
		dugmici.add(b2);
		dugmici.add(b3);
		dugmici.add(b4);
		dugmici.add(b5);
		dugmici.add(b6);
		dugmici.add(b7);
		dugmici.add(b8);
		dugmici.add(b9);
		dugmici.add(bzvezda);
		dugmici.add(b0);
		dugmici.add(bplus);
		Panel kartica=new Panel();
		kartica.setLayout(new GridLayout(4,3));
		for (Button b:dugmici)
			kartica.add(b);
		cardpanel.add(kartica);
		Button ba=new Button("ABC");
		Button bd=new Button("DEF");
		Button bg=new Button("GHI");
		Button bj=new Button("JKL");
		Button bm=new Button("MNO");
		Button bp=new Button("PQRS");
		Button bt=new Button("TUV");
		Button bw=new Button("WXYZ");
		Button bp1=new Button("");
		bp1.setEnabled(false);	
		Button bp2=new Button("");
		Button bp3=new Button("");
		bp2.setEnabled(false);
		bp3.setEnabled(false);	
		Button bspace=new Button("_");
		dugmici.add(bp1);
		dugmici.add(ba);
		dugmici.add(bd);
		dugmici.add(bg);
		dugmici.add(bj);
		dugmici.add(bm);
		dugmici.add(bp);
		dugmici.add(bt);
		dugmici.add(bw);
		dugmici.add(bp2);
		dugmici.add(bspace);
		dugmici.add(bp3);
		Panel kartica1=new Panel();
		kartica1.setLayout(new GridLayout(4,3));
		kartica1.add(bp1);
		kartica1.add(ba);
		kartica1.add(bd);
		kartica1.add(bg);
		kartica1.add(bj);
		kartica1.add(bm);
		kartica1.add(bp);
		kartica1.add(bt);
		kartica1.add(bw);
		kartica1.add(bp2);
		kartica1.add(bspace);
		kartica1.add(bp3);
		cardpanel.add(kartica1);
		add(cardpanel,BorderLayout.CENTER);
		setVisible(true);
		revalidate();
	}
	public Thread getTh() {
		return th;
	}
	public void setTh(Thread th) {
		this.th = th;
	}
	public void promenirezim()
	{
		if (subrojevi) {card.next(cardpanel); subrojevi=false;}
		else {card.previous(cardpanel);subrojevi=true;}
	}	
	public void promeninatpis(String s)
	{
		natpis.setText(s);
	}
	public void sadpromeninatpis(String s)
	{
		natpis.setText(natpis.getText()+s);
	}
	@Override
	public void run() {
		try 
		{
			while(!th.isInterrupted())
			{
				synchronized(this)
				{
					th.sleep(1);
					s++;
				}
				
			}
		}
		catch(InterruptedException e) {}		
	}
}
