
public class Square implements Visitable {
	
	private static Square instance = null;
	private int x;
	private int y;
	private int latura;
	private int culoare1;
	private int culoare2;
	
	public Square(int x, int y, int latura, int culoare1, int culoare2){
		this.x = x;
		this.y = y;
		this.latura = latura;
		this.culoare1 = culoare1;
		this.culoare2 = culoare2;
	}
	
	public static Square getInstance(int x, int y, int latura, int culoare, int culoare2){
		  instance = new Square(x, y, latura, culoare, culoare2);
	      return instance;
  }
	
	public int getx(){
		   return x;
	}
	
	public int gety(){
		   return y;
	}
	
	public int getlatura(){
		   return latura;
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