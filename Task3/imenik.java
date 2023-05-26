package zad3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

public class imenik extends listastavki{
	private ArrayList<kontakt> kontakti;
	public imenik()
	{
		super();
		kontakti=new ArrayList<kontakt>();
		setPreferredSize(new Dimension(300,200));
		setLayout(new GridLayout(5,4));
	}
	@Override
	public void dodajstavku(stavka s) {
		if (s instanceof kontakt) super.dodajstavku(s);
	}
	public String getIme(broj b) throws GNePostoji
	{
		boolean nasao=false;
		String nas=new String();
		for (kontakt k:kontakti)
		{
			if (b.equals(new broj(k.getTekst().getText()))) {nasao=true; nas=new String(k.getNaslov().getText()); }
		}
		if (!nasao) throw new GNePostoji();
		return nas;
	}
	public broj getBroj(String ime) throws GNePostoji
	{
		boolean nasao=false;
		String nas=new String();
		for (kontakt k:kontakti)
		{
			if (ime.equals(k.getNaslov().getText())) {nasao=true; nas=new String(k.getTekst().getText());}
		}
		if (!nasao) throw new GNePostoji();
		return new broj(nas);
	}	
	public void podesiboju(Color c)
	{
		setBackground(c);
		revalidate();
	}
	
}
