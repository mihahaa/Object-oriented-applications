package zad4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class igra extends Frame{

	private basta bastica;
	private static igra tren;
	private Label povrce=new Label();
	private Button igraj=new Button("Kreni");
	private CheckboxGroup lvlgroup=new CheckboxGroup();
	private Checkbox lako=new Checkbox("Lako",true,lvlgroup);
	private Checkbox srednje=new Checkbox("Srednje",false,lvlgroup);
	private Checkbox tesko=new Checkbox("Tesko",false,lvlgroup);
	public igra()
	{
		setSize(500,500);
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		setVisible(true);
		namesti();
	}
	
	
	private void namesti()
	{
		bastica= new basta(4,4);
		bastica.setIgrica(this);
		bastica.setBrpovrca(100);
		namestipovrce(bastica.getBrpovrca());
		add(bastica,BorderLayout.CENTER);
		Label tezina=new Label("Tezina");
		Font fontic=new Font("TimesRoman",Font.BOLD,14);
		povrce.setFont(fontic);
		tezina.setFont(fontic);
		
		Panel desniskroz= new Panel(new GridLayout(0,1));
		Panel desnigore=new Panel();
		Panel desnidole=new Panel(new BorderLayout());
		desnidole.add(povrce,BorderLayout.CENTER);
		Panel desni=new Panel(new GridLayout(0,1));
		Panel dodatni=new Panel(new BorderLayout());
		dodatni.add(tezina,BorderLayout.CENTER);
		desni.add(dodatni);
		desni.add(lako);
		desni.add(srednje);
		desni.add(tesko);
		desni.add(igraj);
		desniskroz.add(desni);
		desniskroz.add(desnidole);
		add(desniskroz,BorderLayout.EAST);
		igraj.addActionListener((ae)->{
			if (igraj.getLabel().equals("Stani"))
			{
				igraj.setLabel("Kreni");
				lako.setEnabled(true);
				srednje.setEnabled(true);
				tesko.setEnabled(true);
				bastica.setStopirao(true);
				this.bastica.stopskroz();
			}
			else 
			{
				igraj.setLabel("Stani");
				bastica.setStopirao(false);
				if (lako.getState())
				{
					bastica.setIntervalcek(1000);
					bastica.setBrkoraci(10);

				}
				else if (srednje.getState())
				{
					bastica.setIntervalcek(750);
					bastica.setBrkoraci(8);
					
				}
				else if (tesko.getState())
				{
					bastica.setIntervalcek(500);
					bastica.setBrkoraci(6);
				}
				bastica.setBrpovrca(100);
				namestipovrce(bastica.getBrpovrca());
				lako.setEnabled(false);
				srednje.setEnabled(false);
				tesko.setEnabled(false);
				bastica.stvorib();
				bastica.pokrenib();
			}
			
			
		});
		revalidate();
	}
	public void namestipovrce(int i)
	{
		povrce.setText("Povrce: "+Integer.toString(i));
	}
	public void namestikreni()
	{
		igraj.setLabel("Kreni");
		lako.setEnabled(true);
		srednje.setEnabled(true);
		tesko.setEnabled(true);
	}
	public static void main(String[] args) {
		if (tren==null) tren=new igra();
	}
	
}
