package zad11;

import java.util.ArrayList;

public class sladoled{
	private int tkol;
	private int kol;
	public sladoled(int k)
	{kol=k;}
	public int getTkol() {
		return tkol;
	}
	public void setTkol(int tkol) {
		this.tkol = tkol;
	}
	public int getKol() {
		return kol;
	}
	public void setKol(int kol) {
		this.kol = kol;
	}
	ArrayList<ukus> ukusi=new ArrayList<>();
	ArrayList<Integer> ml=new ArrayList<>();
	public sladoled dodajMl (int k,ukus u)
	{
		if (tkol+k>kol) k=kol-tkol;
		if (k==0) return this;
		int i=0;
		for (ukus uk:ukusi)
		{
			if (uk.equals(u)) 
			{
				ml.set(i, ml.get(i)+k);
				tkol+=k;
				return this;
			}
			i++;
		}

		ukusi.add(u);
		ml.add(k);
		tkol+=k;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		int i=0;
		for (ukus uk:ukusi)
		{
			sb.append(ml.get(i));
			sb.append("ml ");
			sb.append(uk);
			sb.append("\n");
			i++;
		}
		return sb.toString();
		}
	
}
