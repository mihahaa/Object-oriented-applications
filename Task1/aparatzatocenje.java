package zad11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class aparatzatocenje extends Panel{
	 private mestozatocenje mzt;
	 private ArrayList<ukus> lista=new ArrayList<>();
	 private Button prodaj= new Button("Prodaj");
	 private Panel tocenjePanel=new Panel();
	 private Label sastav=new Label("");
	 private Panel dodatiUkusi=new Panel();
	public aparatzatocenje()
	{
		populatew();
		
		prodaj.addActionListener((ae)->{
			mzt.repaint();
			prodaj.setEnabled(false);
		});
		setVisible(true);
		revalidate();
	}

	public void dodajDugme(ukus rukus)
	{
		if(lista.contains(rukus)) return;
		lista.add(rukus);
		if (lista.size()>=2) dodatiUkusi.setLayout(new GridLayout(0,2));
		else dodatiUkusi.setLayout(new GridLayout(1,1));
		Button dodavanje=new Button();
		dodavanje.setLabel(rukus.getNaziv());
		dodavanje.setBackground(rukus.getBoja());
		dodatiUkusi.add(dodavanje);
		dodavanje.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent evt)
			{
				mzt.pause();
			}
			public void mousePressed(MouseEvent evt)
			{
				mzt.setKusic(rukus);
				mzt.go();
			}
			
		});
		revalidate();
		}

	public void namestiprodaj(boolean ovo)
	{
		prodaj.setEnabled(ovo);
	}
	public int dajx()
	{
		return tocenjePanel.getX();
	}
	public int dajy()
	{
		return tocenjePanel.getY();
	}
	public int dajh()
	{
		return tocenjePanel.getHeight();
	}
	public int dajw()
	{
		return tocenjePanel.getWidth();
	}
	public void namestitxt (String s)
	{
		sastav.setText(s);
	}
	private void populatew()
	{
		setLayout(new BorderLayout());
		Panel donji=new Panel(new BorderLayout());
		Label lslad=new Label("Sladoled:");
		donji.add(lslad,BorderLayout.WEST);
		lslad.setLocation(50, 50);
		donji.add(sastav,BorderLayout.CENTER);
		mzt=new mestozatocenje(this);
		Panel gornji=new Panel(new GridLayout(0,2));
		Panel desni=new Panel(new GridLayout(0,1));
		prodaj.setEnabled(false);
		prodaj.setSize(desni.getWidth(), desni.getHeight()/2);
		desni.add(prodaj);
		tocenjePanel.setLayout(new BorderLayout());
		tocenjePanel.setSize(desni.getWidth(), desni.getHeight()/2);
		tocenjePanel.add(mzt);
		desni.add(tocenjePanel);
		gornji.add(dodatiUkusi);
		gornji.add(desni);	
		add(gornji,BorderLayout.CENTER);
		donji.setBackground(Color.GRAY);
		add(donji,BorderLayout.SOUTH);
	}
	
}
