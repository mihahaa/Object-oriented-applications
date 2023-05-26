package zad2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class polje extends Canvas{
	private mreza owner;
	private int broj;
	private statusi status;
	enum statusi
	{
		SLOBODNO,
		IZABRANO
	}
	public statusi getStatus() {
		return status;
	}
	public void setStatus(statusi status) {
		this.status = status;
	}
	public int getBroj() {
		return broj;
	}
	public polje(mreza m,int b)
	{
		this(m, b, statusi.SLOBODNO);
	}
	public polje(mreza m,int b,statusi s )
	{
		owner=m;
		status=s;
		broj=b;
		int brojpolja;
		brojpolja=owner.getColumns()*owner.getRows();
		setBackground (Color.ORANGE);
		setSize(75,75);
		setVisible(true);
		
		//repaint();
		addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{						
						if (status==statusi.IZABRANO) 
						{
							int tren=0;
							status=statusi.SLOBODNO;
							owner.oduzmihes(broj);
							for (Integer i:owner.hes)
							{ tren++;}
							double kv=(double)(brojpolja)/(double)(tren);
							owner.owner.podesikvotu(kv);
							owner.owner.podesidobitak(kv);
							oduzmi();

						} 
						else if (status==statusi.SLOBODNO) 
						{
							int tren=0;
							status=statusi.IZABRANO; 
							owner.dodajhes(broj); 
							for (Integer i:owner.hes)
							{
								tren++;
							}
							double kv=(double)(brojpolja)/(double)(tren);
							kv=Math.round(kv*100.0)/100.0;
							owner.owner.podesikvotu(kv);
							owner.owner.podesidobitak(kv);
							dodaj();
							}		
						if (owner.hes.size()!=0) owner.owner.igraj.setEnabled(true);
						else {owner.owner.igraj.setEnabled(false); owner.owner.kvota.setText("5"); owner.owner.dobitak.setText(String.valueOf(5*Double.valueOf(owner.owner.ulog.getText())));}
						repaint();
				}
				}
				);
		
	}
	

@Override
public void paint(Graphics g) {
	if (status==statusi.SLOBODNO)
	{
	    FontMetrics metrics = g.getFontMetrics(new Font("TimesRoman", Font.PLAIN,getWidth()/3));
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN,getWidth()/3)); 
		g.drawString(Integer.toString(broj), (getWidth()-metrics.stringWidth(Integer.toString(broj)))/2,(getHeight()-metrics.getHeight())/2+ metrics.getAscent());
		
	}
	if (status==statusi.IZABRANO)
	{
			g.setColor(Color.BLUE);
			g.fillOval(0, 0, getWidth(), getHeight());
		 	FontMetrics metrics = g.getFontMetrics(new Font("TimesRoman", Font.PLAIN,getWidth()/3));
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN,getWidth()/3)); 
			g.drawString(Integer.toString(broj), (getWidth()-metrics.stringWidth(Integer.toString(broj)))/2,(getHeight()-metrics.getHeight())/2+ metrics.getAscent());		}	
	
}
void dodaj()
{
	owner.dodajpolje(this);
	
}
void oduzmi()
{
	owner.izbacipolje(this);
	
}
}
