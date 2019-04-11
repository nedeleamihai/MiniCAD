import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Desen implements Visitor {
	
	BufferedImage image;
	Algoritmidesenare algorithm = new Algoritmidesenare();
	
	public Desen(int inaltime, int latime){
		   this.image = new BufferedImage(latime, inaltime, BufferedImage.TYPE_INT_ARGB);
	}
	
	@Override
	public void visit(Canvas e) {		   
		   for(int i = 0; i < e.getinaltime(); i++){
			   for(int j = 0; j < e.getlatime(); j++){
				   image.setRGB(j, i, e.getcolor());
			   }
		   }		   
	}
	
	@Override
	public void visit(Line l) {
		   image = algorithm.bresenham(l.getxstart(), l.getystart(), l.getxfinal(), l.getyfinal(), l.getcolor(), image);
	}
	
	@Override
	public void visit(Square s) {
		   int xfinal, yfinal;
		   
		   xfinal = s.getx() + s.getlatura() - 1;
		   yfinal = s.gety() + s.getlatura() - 1;
		   
		   algorithm.bresenham(s.getx(), s.gety(), xfinal, s.gety(), s.getcolor1(), image);
		   algorithm.bresenham(xfinal, s.gety(), xfinal, yfinal, s.getcolor1(), image);
		   algorithm.bresenham(xfinal, yfinal, s.getx(), yfinal, s.getcolor1(), image);
		   algorithm.bresenham(s.getx(), yfinal, s.getx(), s.gety(), s.getcolor1(), image);
		   
		   algorithm.floodfill(s.getx() + 1, s.gety() + 1, s.getcolor1(), s.getcolor2(), image);
	}
	
	public void visit(Rectangle r) {
		   int xfinal, yfinal;
		   
		   xfinal = r.getx() + r.getlungime() - 1;
		   yfinal = r.gety() + r.getinaltime() - 1;
		   
		   algorithm.bresenham(r.getx(), r.gety(), xfinal, r.gety(), r.getcolor1(), image);
		   algorithm.bresenham(xfinal, r.gety(), xfinal, yfinal, r.getcolor1(), image);
		   algorithm.bresenham(xfinal, yfinal, r.getx(), yfinal, r.getcolor1(), image);
		   algorithm.bresenham(r.getx(), yfinal, r.getx(), r.gety(), r.getcolor1(), image);
		   
		   algorithm.floodfill(r.getx() + 1, r.gety() + 1, r.getcolor1(), r.getcolor2(), image);
		   
	}	

	@Override
	public void visit(Circle c) {
		   algorithm.bresenhamcircle(c.getxc(), c.getyc(), c.getraza(), c.getcolor1(), image);
		   algorithm.floodfill(c.getxc(), c.getyc(), c.getcolor1(), c.getcolor2(), image);
	}
	
	@Override
	public void visit(Triangle t) {
		   algorithm.bresenham(t.getx1(), t.gety1(), t.getx2(), t.gety2(), t.getcolor1(), image);
		   algorithm.bresenham(t.getx2(), t.gety2(), t.getx3(), t.gety3(), t.getcolor1(), image);
		   algorithm.bresenham(t.getx3(), t.gety3(), t.getx1(), t.gety1(), t.getcolor1(), image);
		   
		   algorithm.floodfill((t.getx1() + t.getx2() + t.getx3())/3, (t.gety1() + t.gety2() + t.gety3())/3, t.getcolor1(), t.getcolor2(), image);
	}
	
	@Override
	public void visit(Diamond p){
		
		   int ny = p.gety() - Math.round(p.getverticala() / 2);
		   int sy = p.gety() + Math.round(p.getverticala() / 2);
		   int wx = p.getx() - Math.round(p.getorizontala() / 2);
		   int ex = p.getx() + Math.round(p.getorizontala() / 2);
				   
		   algorithm.bresenham(p.getx(), ny, ex, p.gety(), p.getcolor1(), image);
		   algorithm.bresenham(ex, p.gety(), p.getx(), sy, p.getcolor1(), image);
		   algorithm.bresenham(p.getx(), sy, wx, p.gety(), p.getcolor1(), image);
		   algorithm.bresenham(p.getx(), ny, wx, p.gety(), p.getcolor1(), image);
		   
		   algorithm.floodfill(p.getx(), p.gety(), p.getcolor1(), p.getcolor2(), image);
	}
	
	@Override
	public void visit(Polygon p){
		   int xg = 0, yg = 0;
		   
		   for(int i = 0; i < p.getn() - 1; i++){
			   algorithm.bresenham(p.getx().get(i), p.gety().get(i), p.getx().get(i + 1), p.gety().get(i + 1), p.getcolor1(), image);
		   }
		   algorithm.bresenham(p.getx().get(p.getn() - 1), p.gety().get(p.getn() - 1), p.getx().get(0), p.gety().get(0), p.getcolor1(), image);
		   
		   for(int i = 0; i < p.getn(); i++){
			   xg += p.getx().get(i); 
			   yg += p.gety().get(i);
		   }
		   
		   algorithm.floodfill(xg/p.getn(), yg/p.getn(), p.getcolor1(), p.getcolor2(), image);
	}
	
	@Override
	public void visit(Paint p) {
		   algorithm.paint(p.getx(), p.gety(), image.getRGB(p.getx(), p.gety()), p.getcolor(), image);
	}
	
	@Override
	public void visit(Picture p) {
		try {
			File outputfile = new File("drawing.png");
            ImageIO.write(image, "png", outputfile);
            System.out.println("GATA");
		}catch (IOException e) {
	
		}
	}
       
}