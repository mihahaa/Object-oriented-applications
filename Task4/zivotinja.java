package zad4;

public abstract class zivotinja {

	private rupa owner;
	
	public abstract void crtaj();
	public abstract void udarena();
	public abstract void pobegla();
	public zivotinja(rupa o)
	{
		owner=o;
	}
	public rupa getRupa() {
		return owner;
	}
}
