package zad3;

public class broj {
	private int kodDrzave;
	private int pozivniBroj;
	private int brojPretplatnika;
	public broj(int k,int pb,int bp )
	{
		kodDrzave=k;
		pozivniBroj=pb;
		brojPretplatnika=bp;
	}
	public boolean istaDrzava(broj b)
	{
		if (b==null) return false;
		if (b==this) return true;
		if (b.kodDrzave==this.kodDrzave) return true;
		return false;
	}
	public boolean istaMreza(broj b)
	{
		if (b==null) return false;
		if (b==this) return true;
		if (b.kodDrzave==this.kodDrzave && b.pozivniBroj==this.pozivniBroj) return true;
		return false;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==null) return false;
		if (obj==this) return true;
		if (!(obj instanceof broj)) return false;
		broj b=(broj)obj;
		if (b.brojPretplatnika==this.brojPretplatnika && b.kodDrzave==this.kodDrzave && b.pozivniBroj==this.pozivniBroj) return true;
		return false;
	}
	public broj(char[] c)
	{
		String s=String.valueOf(c);
		String ss;
		ss=s.substring(1, 3);
		kodDrzave=(int)Integer.valueOf(ss);
		ss=s.substring(4,5);
		pozivniBroj=(int)Integer.valueOf(ss);
		ss.substring(6, s.length()-1);
		brojPretplatnika=(int)Integer.valueOf(ss);
	}
	public broj(String s)
	{
		String ss;
		ss=s.substring(1, 4);
		kodDrzave=(int)Integer.valueOf(ss);
		ss=s.substring(4,6);
		pozivniBroj=(int)Integer.valueOf(ss);
		ss=s.substring(6, s.length());
		brojPretplatnika=(int)Integer.valueOf(ss);
	}
	@Override
	public String toString() {
		return "+"+kodDrzave+" "+pozivniBroj+" "+brojPretplatnika;
	}
	
}
