	package zad2;
	
	import java.awt.Color;
	import java.awt.GridLayout;
	import java.awt.Panel;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.util.ArrayList;
	import java.util.HashSet;
	
	import zad2.polje.statusi;
	
	public class mreza extends Panel{
		private int rows;
		private int columns;
		HashSet<Integer> hes=new HashSet<Integer>();
		ArrayList<polje> izabrana=new ArrayList<>();
		igra owner;
		private polje[][] polja;
		public int getRows() {
			return rows;
		}
		public void setRows(int rows) {
			this.rows = rows;
		}
		public int getColumns() {
			return columns;
		}
		public void setColumns(int columns) {
			this.columns = columns;
		}
		public ArrayList<polje> getIzabrana() {
			return izabrana;
		}
		public HashSet<Integer> getHes()
		{
			return hes;
		}
		public mreza(igra i)
		{
			this(4,5,i);
		}
		public mreza(int r,int c,igra i)
		{
			
			rows=r;
			columns=c;
			owner=i;
			polja=new polje[r][c];
			setBackground(Color.BLACK);
			setLayout(new GridLayout(r,c,3,3));
			 
			for (int t=0;t<r;t++)
			{
				for (int j=0;j<c;j++) 
				{ 	
					polja[t][j]=new polje(this,t*columns+j);
					add(polja[t][j]);
					polja[t][j].repaint();
	
				}
			}
			
			setVisible(true);
			revalidate();
		}
		public void dodajhes(int b)
		{
			hes.add(Integer.valueOf(b));
		}
		public void oduzmihes(int b)
		{
			hes.remove(Integer.valueOf(b));
		}
		public void dodajpolje(polje p)
		{
			izabrana.add(p);
		}
		public void izbacipolje(polje p)
		{
			izabrana.remove(p);
		}
		
	
	}
