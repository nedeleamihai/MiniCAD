
public class Rectangle implements Visitable {
	
	private static Rectangle instance = null;
	private int x;
	private int y;
	private int inaltime;
	private int lungime;
	private int culoare1;
	private int culoare2;
	
	public Rectangle(int x, int y, int inaltime, int lungime, int culoare1, int culoare2){
		this.x = x;
		this.y = y;
		this.inaltime = inaltime;
		this.lungime = lungime;
		this.culoare1 = culoare1;
		this.culoare2 = culoare2;
	}
	
	public static Rectangle getInstance(int x, int y, int inaltime, int lungime, int culoare1, int culoare2){
		  instance = new Rectangle(x, y, inaltime, lungime, culoare1, culoare2);
	      return instance;
  }
	
	public int getx(){
		   return x;
	}
	
	public int gety(){
		   return y;
	}
	
	public int getinaltime(){
		   return inaltime;
	}
	
	public int getlungime(){
		   return lungime;
	}
	
	public int getcolor1(){
		   return culoare1;
	}
	
	public int getcolor2(){
		   return culoare2;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);  
	}
}