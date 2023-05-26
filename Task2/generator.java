package zad2;

public class generator {
	private int vrednost;
	public generator (int a,int b)
	{
		int range=b-a+1;
		range++;
		double trnt;
		while (true)
		{
			trnt=Math.random()*range;
			if (trnt+a<=b+1) break;
		}
		vrednost=(int)(trnt+a);
	}
	public int uzmiVrednost()
	{
		return vrednost;
	}
	public static void main(String[] args) {
		for (int i=0;i<=100;i++)
		{
		generator gen=new generator(3,20);
		int vr=gen.uzmiVrednost();
		System.out.println(vr);
		}
	}
}

