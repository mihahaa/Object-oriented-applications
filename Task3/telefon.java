package zad3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class telefon extends Panel{
	private broj brojfona;
	private Color boja;
	private imenik imen=new imenik();
	private tastatura owner=new tastatura();
	Label br=new Label("");
	Label ime=new Label("");
	private String prosli;
	private boolean poceo;
	private int nakomsam;
	private boolean iskljucen=false;
	public broj getBrojfona()
	{
		return brojfona;
	}
	public telefon(Color bojica,broj foncic)
	{
		setLayout(new BorderLayout());
		poceo=false;
		Panel lapo=new Panel(new GridLayout(0,1));
		lapo.add(owner);
		setBackground(bojica);
		Panel natpisi=new Panel(new GridLayout(0,1));
		natpisi.add(br);
		natpisi.add(ime);
		add(natpisi,BorderLayout.NORTH);
		Button dodajkontakt=new Button("Dodaj kontakt");
		Button iskljucitelefon=new Button("IskljuciTelefon");
		iskljucitelefon.setBackground(Color.LIGHT_GRAY);
		Panel dugmici=new Panel(new GridLayout(1,2));
		dugmici.add(dodajkontakt);
		dugmici.add(iskljucitelefon);
		Panel josispod=new Panel(new GridLayout(0,3));
		Label brtel=new Label(foncic.toString());
		josispod.add(new Label(""));
		josispod.add(brtel);
		josispod.add(new Label(""));
		Panel ispod=new Panel(new BorderLayout());
		ispod.add(dugmici,BorderLayout.NORTH);
		ispod.add(josispod,BorderLayout.CENTER);
		Panel main=new Panel(new BorderLayout());
		main.add(imen,BorderLayout.CENTER);
		main.add(ispod,BorderLayout.SOUTH);
		lapo.add(main);
		add(lapo,BorderLayout.CENTER);
		dodajkontakt.addActionListener((ae)->{
			if (owner.dalisubr()) owner.promenirezim();
			else 
			{
				owner.promenirezim();
				imen.dodajstavku(new kontakt(new broj((br.getText()).toString()),(ime.getText())));
				br.setText("");
				ime.setText("");
			}
		});
		iskljucitelefon.addActionListener((ae)->{
			if (!iskljucen) {iskljucitelefon.setLabel("UkljuciTelefon");
			iskljucitelefon.setBackground(Color.RED); iskljucen=true;
			}
			else {
				iskljucitelefon.setLabel("IskljuciTelefon");
				iskljucitelefon.setBackground(Color.LIGHT_GRAY); iskljucen=false;
			}
		});
		for (Button b:owner.getDugmici())
		{
			b.addActionListener((ae)->{
				if (owner.dalisubr()) {br.setText(br.getText()+b.getLabel());owner.sadpromeninatpis(b.getLabel());}
				else 
				{
					if (!poceo)
					{
						poceo=true;
						owner.getTh().start();
						ime.setText(ime.getText()+b.getLabel().substring(0,1));
						owner.sadpromeninatpis(b.getLabel().substring(0,1));
						nakomsam=1;					}
					else 
					{

						if (!prosli.equals(b.getLabel())) 
						{
							owner.setS(0);
							ime.setText(ime.getText()+b.getLabel().substring(0,1));
							owner.sadpromeninatpis(b.getLabel().substring(0,1));
							nakomsam=1;
						}
						else 
						{
							if (owner.getS()>1000) 
							{
								owner.setS(0);
								ime.setText(ime.getText()+b.getLabel().substring(0,1));
								owner.sadpromeninatpis(b.getLabel().substring(0,1));
								nakomsam=1;
							}
							else 
							{
								owner.setS(0);
								ime.setText(ime.getText().substring(0,ime.getText().length()-1));
								ime.setText(ime.getText()+b.getLabel().substring(nakomsam,nakomsam+1));
								owner.sadpromeninatpis(b.getLabel().substring(nakomsam,nakomsam+1));
								nakomsam++;
								if (nakomsam==b.getLabel().length()) nakomsam=0;
							}
						}
					}
					prosli=new String(b.getLabel());
				}
			});
		}
		
		setVisible(true);
		revalidate();
	}

}
