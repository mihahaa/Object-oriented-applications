package zad4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;

public class krtica extends zivotinja{

	public krtica(rupa r) {
		super(r);
	}

	@Override
	public void crtaj() {
		
		Graphics g = getRupa().getGraphics();
		g.setColor(Color.DARK_GRAY);
		 int w=(int)((double)this.getRupa().getWidth()*((double)this.getRupa().getTrenkorak()/(double)this.getRupa().getKorak()));
		 int h=(int)((double)this.getRupa().getHeight()*((double)this.getRupa().getTrenkorak()/(double)this.getRupa().getKorak()));
			g.translate(this.getRupa().getWidth()/2-w/2, this.getRupa().getHeight()/2-h/2);
		 g.fillOval(0, 0, w,h );
		
	}

	@Override
	public void udarena() {
		if (this.getRupa().getZiv()!=null)
		{
			 this.getRupa().setUdario(1);
			this.getRupa().stopnit();
		}
		
	}

	@Override
	public void pobegla() {
		this.getRupa().getOwner().smanji();
		this.getRupa().getOwner().proveri();
		this.getRupa().getOwner().getIgrica().namestipovrce(this.getRupa().getOwner().getBrpovrca());
	}
	

	
	
}
