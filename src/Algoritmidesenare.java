import java.awt.image.BufferedImage;
import java.util.*;

public class Algoritmidesenare {
	
  public boolean isValid(int row, int col, int n, int m){
        return (row >= 0) && (row < m) && (col >= 0) && (col < n);
  }
  
  public BufferedImage bresenham(int x1, int y1, int x2, int y2, int culoare, BufferedImage image){
	     
	  if ((x1 == x2) && (y1 == y2)) {       
		    image.setRGB(x1, y1, culoare);
	  } else {
		  if(isValid(x1, y1, image.getHeight(), image.getWidth())){
		    image.setRGB(x1, y1, culoare);
		  }
		    int dx = Math.abs(x2 - x1);
		    int dy = Math.abs(y2 - y1);
		    int rozdil = dx - dy;

		    int posun_x, posun_y;

		    if (x1 < x2) posun_x = 1; else posun_x = -1;
		    if (y1 < y2) posun_y = 1; else posun_y = -1;

		    while ((x1 != x2) || (y1 != y2)) {  

		        int p = 2 * rozdil;

		        if (p > -dy) {
		            rozdil = rozdil - dy;
		            x1 = x1 + posun_x;
		        }
		        if (p < dx) {
		            rozdil = rozdil + dx;
		            y1 = y1 + posun_y;
		        }
		        if(isValid(x1, y1, image.getHeight(), image.getWidth())){
		           image.setRGB(x1, y1, culoare);
		        }
		    }
	  }	     
	  return image;
  }
  
  public BufferedImage drawCircle(int xc, int yc, int x, int y, int culoare, BufferedImage image){
	  if(isValid(xc + x, yc + y, image.getHeight(), image.getWidth())){
	      image.setRGB(xc + x, yc + y, culoare);
	  }
	  if(isValid(xc - x, yc + y, image.getHeight(), image.getWidth())){
		  image.setRGB(xc - x, yc + y, culoare);
	  }
	  if(isValid(xc + x, yc - y, image.getHeight(), image.getWidth())){
		  image.setRGB(xc + x, yc - y, culoare);
	  }
	  if(isValid(xc - x, yc - y, image.getHeight(), image.getWidth())){
		  image.setRGB(xc - x, yc - y, culoare);
	  }
	  if(isValid(xc + y, yc + x, image.getHeight(), image.getWidth())){
		  image.setRGB(xc + y, yc + x, culoare);
	  }
	  if(isValid(xc - y, yc + x, image.getHeight(), image.getWidth())){
		  image.setRGB(xc - y, yc + x, culoare);
	  }
	  if(isValid(xc + y, yc - x, image.getHeight(), image.getWidth())){
		  image.setRGB(xc + y, yc - x, culoare);
	  }
	  if(isValid(xc - y, yc - x, image.getHeight(), image.getWidth())){
		  image.setRGB(xc - y, yc - x, culoare);
	  }
	  
	  return image;
  }
  
  public BufferedImage bresenhamcircle(int xc, int yc, int r, int culoare, BufferedImage image){
      int x = 0, y = r;
      int d = 3 - 2 * r;
      while (y >= x){
          image = drawCircle(xc, yc, x, y, culoare, image);
          x++;
          if (d > 0) {
              y--; 
              d = d + 4 * (x - y) + 10;
          }else{
              d = d + 4 * x + 6;
          }
          image = drawCircle(xc, yc, x, y, culoare, image);
      }
      
      return image;
  }
  
  public BufferedImage floodfill(int x, int y, int target, int replace, BufferedImage image){
      
      if(isValid(x, y, image.getHeight(), image.getWidth()) && target == image.getRGB(x, y)){
    	  return image;
      }
    
      Queue<Integer> Qx = new LinkedList<Integer>();      
      Queue<Integer> Qy = new LinkedList<Integer>();
      
      if(isValid(x, y, image.getHeight(), image.getWidth())){
          image.setRGB(x, y, replace);
      }

      Qx.add(x);
      Qy.add(y);
      
      while(!Qx.isEmpty()){
    	  int n = Qx.poll();
    	  int m = Qy.poll();    	  
    	  
    	  if(isValid(n - 1, m, image.getHeight(), image.getWidth()) && image.getRGB(n - 1, m) != target && image.getRGB(n - 1, m) != replace){
    		  image.setRGB(n - 1, m, replace);
    		  Qx.add(n - 1);
    		  Qy.add(m);
    	  }
    	  
    	  if(isValid(n + 1, m, image.getHeight(), image.getWidth()) && image.getRGB(n + 1, m) != target && image.getRGB(n + 1, m) != replace){
    		  image.setRGB(n + 1, m, replace);
    		  Qx.add(n + 1);
    		  Qy.add(m);
    	  }
    	  
    	  if(isValid(n, m - 1, image.getHeight(), image.getWidth()) && image.getRGB(n, m - 1) != target && image.getRGB(n, m - 1) != replace){
    		  image.setRGB(n, m - 1, replace);
    		  Qx.add(n);
    		  Qy.add(m - 1);
    	  }
    	  
    	  if(isValid(n, m + 1, image.getHeight(), image.getWidth()) && image.getRGB(n, m + 1) != target && image.getRGB(n, m + 1) != replace){
    		  image.setRGB(n, m + 1, replace);
    		  Qx.add(n);
    		  Qy.add(m + 1);
    	  }
      }   
	  
      return image;
  }
  
  public BufferedImage paint(int x, int y, int target, int replace, BufferedImage image){
	  
	  Queue<Integer> Qx = new LinkedList<Integer>();      
      Queue<Integer> Qy = new LinkedList<Integer>();
      
      if(isValid(x, y, image.getHeight(), image.getWidth())){
          image.setRGB(x, y, replace);
      }

      Qx.add(x);
      Qy.add(y);
      
      while(!Qx.isEmpty()){
    	  int n = Qx.poll();
    	  int m = Qy.poll();    	  
    	  
    	  if(isValid(n - 1, m, image.getHeight(), image.getWidth()) && image.getRGB(n - 1, m) == target && image.getRGB(n - 1, m) != replace){
    		  image.setRGB(n - 1, m, replace);
    		  Qx.add(n - 1);
    		  Qy.add(m);
    	  }
    	  
    	  if(isValid(n + 1, m, image.getHeight(), image.getWidth()) && image.getRGB(n + 1, m) == target && image.getRGB(n + 1, m) != replace){
    		  image.setRGB(n + 1, m, replace);
    		  Qx.add(n + 1);
    		  Qy.add(m);
    	  }
    	  
    	  if(isValid(n, m - 1, image.getHeight(), image.getWidth()) && image.getRGB(n, m - 1) == target && image.getRGB(n, m - 1) != replace){
    		  image.setRGB(n, m - 1, replace);
    		  Qx.add(n);
    		  Qy.add(m - 1);
    	  }
    	  
    	  if(isValid(n, m + 1, image.getHeight(), image.getWidth()) && image.getRGB(n, m + 1) == target && image.getRGB(n, m + 1) != replace){
    		  image.setRGB(n, m + 1, replace);
    		  Qx.add(n);
    		  Qy.add(m + 1);
    	  }
      }   
	  
      return image;
  }
}
