package zad3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;

public class listastavki extends Panel{
	private ArrayList<stavka> stavke;
	public listastavki()
	{
		stavke=new ArrayList<stavka>();
		this.setLayout(new BorderLayout());
		
	}
	public void dodajstavku(stavka s)
	{
		stavke.add(s);
		add(s,BorderLayout.WEST);
		setVisible(true);
		revalidate();
	}
	public void izbacistavku(stavka s)
	{
		stavke.remove(s);
	}
}
