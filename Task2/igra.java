package zad2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class igra extends Frame{
	private mreza mrez;
	 Label kvota=new Label("5");
	 Label balans=new Label("0");
	 Label dobitak=new Label("500");
	 TextField ulog=new TextField("100");
	 Button igraj=new Button("Igraj");
	public mreza getMrez()
	{
		return mrez;
	}

	public igra()
	{
		setTitle("Igra");
		mrez=new mreza(this);
		setVisible(true);
		igraj.setEnabled(false);
		add(mrez,BorderLayout.CENTER);
		Panel panelcic=new Panel(new GridLayout(0,2));
		Label lbalans=new Label("Balans:");
		Label lulog=new Label("Ulog:");
		Label lkvota=new Label("Kvota:");
		Label ldobitak=new Label("Dobitak:");
		panelcic.add(lbalans);
		panelcic.add(balans);
		panelcic.add(lulog);
		Panel zaulog=new Panel(new BorderLayout());
		zaulog.add(new Label(""),BorderLayout.NORTH);
		zaulog.add(ulog,BorderLayout.CENTER);
		zaulog.add(new Label(""),BorderLayout.SOUTH);
		panelcic.add(zaulog);
		panelcic.add(lkvota);
		panelcic.add(kvota);
		panelcic.add(ldobitak);
		panelcic.add(dobitak);
		Panel traka=new Panel();
		Label tracica=new Label();
		traka.setBackground(Color.DARK_GRAY);
		add(traka,BorderLayout.SOUTH);
		Panel prazan=new Panel();
		panelcic.add(prazan);
		Panel zadugme=new Panel();
		zadugme.add(igraj);
		panelcic.add(zadugme);
		add(panelcic,BorderLayout.EAST);
		pack();
		revalidate();

		igraj.addActionListener((ae)->{
			generator gen=new generator(0,19);
			int vrednost=gen.uzmiVrednost();
			tracica.setText(tracica.getText()+" "+Integer.valueOf(vrednost).toString());
			boolean dobar=false;
			for (Integer i:mrez.hes)
			{
				if (i.equals(Integer.valueOf(vrednost))) {dobar=true;
				System.out.println(vrednost);
				}
				
			}
			if (!dobar) {traka.setBackground(Color.RED); System.out.println(vrednost);			balans.setText(Double.valueOf(Double.valueOf(balans.getText())-Double.valueOf(ulog.getText())).toString());}
			else {				traka.setBackground(Color.GREEN); 
balans.setText(Double.valueOf(Double.valueOf(balans.getText())+Double.valueOf(dobitak.getText())).toString());}
			traka.add(tracica);
			setVisible(true);
			revalidate();
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		ulog.addTextListener((te)->

			 {
				
				dobitak.setText(Double.toString(Double.valueOf(kvota.getText())*Double.valueOf(ulog.getText())));			}
			
		);

	}
	public void podesikvotu(double k)
	{
		kvota.setText(Double.valueOf(k).toString());
	}
	public void podesidobitak(double k)
	{
		dobitak.setText(Double.toString(k*Double.valueOf(ulog.getText())));			

	}
	public static void main(String[] args) {
		new igra();
	}
	
}
