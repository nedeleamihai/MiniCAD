
public class Circle implements Visitable {
	
	private static Circle instance = null;
	private int xc;
	private int yc;
	private int raza;
	private int culoare1;
	private int culoare2;
	
	public Circle(int xc, int yc, int raza, int culoare1, int culoare2){
		this.xc = xc;
		this.yc = yc;
		this.raza = raza;
		this.culoare1 = culoare1;
		this.culoare2 = culoare2;
	}
	
	public static Circle getInstance(int xc, int yc, int raza, int culoare1, int culoare2){
		  instance = new Circle(xc, yc, raza, culoare1, culoare2);
	      return instance;
  }
	
	public int getxc(){
		   return xc;
	}
	
	public int getyc(){
		   return yc;
	}
	
	public int getraza(){
		   return raza;
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
