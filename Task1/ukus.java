package zad11;

import java.awt.Color;

public class ukus {

	
		private String naziv;
		private Color boja;
		public String getNaziv() {
			return naziv;
		}
		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}
		public Color getBoja() {
			return boja;
		}
		public void setBoja(Color boja) {
			this.boja = boja;
		}
		@Override
		public boolean equals(Object obj) {
			if (obj==null) return false;
			if (obj==this) return true;
			if (!(obj instanceof ukus)) return false;
			ukus u=(ukus) obj;
			return u.naziv.equals(this.naziv);
		}
		@Override
		public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[").append(this.naziv).append("]");
		return sb.toString();
		}
		public ukus(String n,Color bo)
		{
			this.boja=bo;
			this.naziv=n;
		}
}
