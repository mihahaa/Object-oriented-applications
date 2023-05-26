package zad3;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class stavka extends Panel{
	private Label naslov=new Label();
	private Label tekst=new Label();
	public stavka(String n,String t)
	{
		setLayout(new GridLayout(0,1));
		naslov.setText(n);
		naslov.setFont(new Font(Font.DIALOG,Font.BOLD,12));
		add(naslov);
		tekst.setText(t);
		add(tekst);
		setVisible(true);
		revalidate();
	}
	public void setNaslov(String n)
	{
		naslov.setText(n);
	}
	public Label getTekst()
	{
		return tekst;
	}
	public Label getNaslov()
	{
		return naslov;
	}
}
