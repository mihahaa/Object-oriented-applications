package zad3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;

public class dva extends Frame{
	public dva(){
	setLayout(new GridLayout(0,2));
	telefon t1=new telefon(Color.GREEN,new broj("+381645657267"));
	telefon t2=new telefon(Color.YELLOW,new broj("+381645657267"));
	add(t1);
	add(t2);
	setVisible(true);
	pack();
	revalidate();
	}
	public static void main(String[] args) {
		new dva();
	}
}
