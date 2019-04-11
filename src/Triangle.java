
public class Triangle implements Visitable {
	
	private static Triangle instance = null;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int culoare1;
	private int culoare2;
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, int culoare1, int culoare2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.culoare1 = culoare1;
		this.culoare2 = culoare2;
	}
	
	public static Triangle getInstance(int x1, int y1, int x2, int y2, int x3, int y3, int culoare1, int culoare2){
		  instance = new Triangle(x1, y1, x2, y2, x3, y3, culoare1, culoare2);
	      return instance;
  }
	
	public int getx1(){
		   return x1;
	}
	
	public int gety1(){
		   return y1;
	}
	
	public int getx2(){
		   return x2;
	}
	
	public int gety2(){
		   return y2;
	}
	
	public int getx3(){
		   return x3;
	}
	
	public int gety3(){
		   return y3;
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