package zad11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class sladoledzinica extends Frame {
	 private aparatzatocenje azt;
	public static Color hexa(int[] t) {
	    return new Color(t[0],t[1],t[2]);
	}
	public static int[] getRGB(final String rgb)
	{
	    final int[] ret = new int[3];
	    for (int i = 0; i < 3; i++)
	    {
	        ret[i] = Integer.parseInt(rgb.substring(i * 2, i * 2 + 2), 16);
	    }
	    return ret;
	}
	
		
		
	
	public sladoledzinica() {
		 Button bukus=new Button("Dodaj ukus!");
			TextField naziv=new TextField(10);
			TextField boja=new TextField(10);
		 bukus.addActionListener((ae)->{
				int[] tr=getRGB(boja.getText());
				azt.dodajDugme(new ukus(naziv.getText(), hexa(tr)));	
			});
		setBounds(800,300,500,400);
		setTitle("Sladoledzinica");
		setLayout(new BorderLayout());
		azt=new aparatzatocenje();
		add(azt,BorderLayout.CENTER);	
		Panel paneldugmici=new Panel();
		paneldugmici.setLayout(new FlowLayout());
		paneldugmici.setBackground(Color.CYAN);
		paneldugmici.add(new Label("Naziv: "));
		paneldugmici.add(naziv);
		paneldugmici.add(new Label("Boja: "));
		paneldugmici.add(boja);
		paneldugmici.add(bukus);
		add(paneldugmici,BorderLayout.SOUTH);
				addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setVisible(true);
		pack();
		revalidate();

	}
	

	
	public static void main(String[] args) {
		new sladoledzinica();
	}
	
	

}