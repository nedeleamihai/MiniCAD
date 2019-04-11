import java.awt.Color;
import java.util.*;

final class ShapeFactory  {
    static final int HEX = 16;
    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;
    static final int FIVE = 5;
    static final int SIX = 6;
    static final int SEVEN = 7;
    static final int EIGHT = 8;
    static final int NINE = 9;
    static final int TEN = 10;
    
    public Visitable getShape(final String[] strings) {
        
        int i, rONE, gONE, bONE, aONE, rTWO, gTWO, bTWO, aTWO;
        Color culoare, culoareTWO;
        
        if (strings[0].equals("CANVAS")) {                       
            int inaltime = Integer.parseInt(strings[ONE]);
            int latime = Integer.parseInt(strings[TWO]);           
            rONE = Integer.parseInt(strings[THREE].substring(ONE, THREE),  HEX);
            gONE = Integer.parseInt(strings[THREE].substring(THREE, FIVE),  HEX);
            bONE = Integer.parseInt(strings[THREE].substring(FIVE, SEVEN),  HEX);
            aONE = Integer.parseInt(strings[FOUR]);
            culoare = new Color(rONE, gONE, bONE, aONE);
            
            return Canvas.getInstance(inaltime,  latime,  culoare.getRGB());
        }
        
        if (strings[0].equals("LINE")) {
            int xstart = Integer.parseInt(strings[ONE]);
            int ystart = Integer.parseInt(strings[TWO]);
            int xfinal = Integer.parseInt(strings[THREE]);
            int yfinal = Integer.parseInt(strings[FOUR]);
            rONE = Integer.parseInt(strings[FIVE].substring(ONE, THREE),  HEX);
            gONE = Integer.parseInt(strings[FIVE].substring(THREE, FIVE),  HEX);
            bONE = Integer.parseInt(strings[FIVE].substring(FIVE, SEVEN),  HEX);
            aONE = Integer.parseInt(strings[SIX]);
            culoare = new Color(rONE, gONE, bONE, aONE);
            
            return Line.getInstance(xstart,  ystart,  xfinal,  yfinal,  culoare.getRGB());
        }
        
        if (strings[0].equals("SQUARE")) {
            int x = Integer.parseInt(strings[ONE]);
            int y = Integer.parseInt(strings[TWO]);
            int latura = Integer.parseInt(strings[THREE]);
            rONE = Integer.parseInt(strings[FOUR].substring(ONE, THREE),  HEX);
            gONE = Integer.parseInt(strings[FOUR].substring(THREE, FIVE),  HEX);
            bONE = Integer.parseInt(strings[FOUR].substring(FIVE, SEVEN),  HEX);
            aONE = Integer.parseInt(strings[FIVE]);
            culoare = new Color(rONE, gONE, bONE, aONE);            
            rTWO = Integer.parseInt(strings[SIX].substring(ONE, THREE),  HEX);
            gTWO = Integer.parseInt(strings[SIX].substring(THREE, FIVE),  HEX);
            bTWO = Integer.parseInt(strings[SIX].substring(FIVE, SEVEN),  HEX);
            aTWO = Integer.parseInt(strings[SEVEN]);
            culoareTWO = new Color(rTWO, gTWO, bTWO, aTWO);
            
            return Square.getInstance(x,  y,  latura,  culoare.getRGB(),  culoareTWO.getRGB());
        }
        
        if (strings[0].equals("RECTANGLE")) {
            int x = Integer.parseInt(strings[ONE]);
            int y = Integer.parseInt(strings[TWO]);
            int inaltime = Integer.parseInt(strings[THREE]);
            int lungime = Integer.parseInt(strings[FOUR]);
            rONE = Integer.parseInt(strings[FIVE].substring(ONE, THREE),  HEX);
            gONE = Integer.parseInt(strings[FIVE].substring(THREE, FIVE),  HEX);
            bONE = Integer.parseInt(strings[FIVE].substring(FIVE, SEVEN),  HEX);
            aONE = Integer.parseInt(strings[SIX]);
            culoare = new Color(rONE, gONE, bONE, aONE);            
            rTWO = Integer.parseInt(strings[SEVEN].substring(ONE, THREE),  HEX);
            gTWO = Integer.parseInt(strings[SEVEN].substring(THREE, FIVE),  HEX);
            bTWO = Integer.parseInt(strings[SEVEN].substring(FIVE, SEVEN),  HEX);
            aTWO = Integer.parseInt(strings[EIGHT]);
            culoareTWO = new Color(rTWO, gTWO, bTWO, aTWO);
            
            return Rectangle.getInstance(x,  y,  inaltime,  lungime,  culoare.getRGB(),  culoareTWO.getRGB());
        }
        
        if (strings[0].equals("CIRCLE")) {
                int xc = Integer.parseInt(strings[ONE]);
                int yc = Integer.parseInt(strings[TWO]);
                int raza = Integer.parseInt(strings[THREE]);
                rONE = Integer.parseInt(strings[FOUR].substring(ONE, THREE),  HEX);
                gONE = Integer.parseInt(strings[FOUR].substring(THREE, FIVE),  HEX);
                bONE = Integer.parseInt(strings[FOUR].substring(FIVE, SEVEN),  HEX);
                aONE = Integer.parseInt(strings[FIVE]);
                culoare = new Color(rONE, gONE, bONE, aONE);                
                rTWO = Integer.parseInt(strings[SIX].substring(ONE, THREE),  HEX);
                gTWO = Integer.parseInt(strings[SIX].substring(THREE, FIVE),  HEX);
                bTWO = Integer.parseInt(strings[SIX].substring(FIVE, SEVEN),  HEX);
                aTWO = Integer.parseInt(strings[SEVEN]);
                culoareTWO = new Color(rTWO, gTWO, bTWO, aTWO);
                
                return Circle.getInstance(xc,  yc,  raza,  culoare.getRGB(),  culoareTWO.getRGB());
       }
        
        if (strings[0].equals("TRIANGLE")) {
                int xONE = Integer.parseInt(strings[ONE]);
                int yONE = Integer.parseInt(strings[TWO]);
                int xTWO = Integer.parseInt(strings[THREE]);
                int yTWO = Integer.parseInt(strings[FOUR]);
                int xTHREE = Integer.parseInt(strings[FIVE]);
                int yTHREE = Integer.parseInt(strings[SIX]);
                rONE = Integer.parseInt(strings[SEVEN].substring(ONE, THREE),  HEX);
                gONE = Integer.parseInt(strings[SEVEN].substring(THREE, FIVE),  HEX);
                bONE = Integer.parseInt(strings[SEVEN].substring(FIVE, SEVEN),  HEX);
                aONE = Integer.parseInt(strings[EIGHT]);
                culoare = new Color(rONE, gONE, bONE, aONE);                
                rTWO = Integer.parseInt(strings[NINE].substring(ONE, THREE),  HEX);
                gTWO = Integer.parseInt(strings[NINE].substring(THREE, FIVE),  HEX);
                bTWO = Integer.parseInt(strings[NINE].substring(FIVE, SEVEN),  HEX);
                aTWO = Integer.parseInt(strings[TEN]);
                culoareTWO = new Color(rTWO, gTWO, bTWO, aTWO);

                return Triangle.getInstance(xONE,  yONE,  xTWO,  yTWO,  xTHREE,  yTHREE,  culoare.getRGB(),  culoareTWO.getRGB());
         }
        
        if (strings[0].equals("DIAMOND")) {
                int x = Integer.parseInt(strings[ONE]);
                int y = Integer.parseInt(strings[TWO]);
                int orizontala = Integer.parseInt(strings[THREE]);
                int verticala = Integer.parseInt(strings[FOUR]);
                rONE = Integer.parseInt(strings[FIVE].substring(ONE, THREE),  HEX);
                gONE = Integer.parseInt(strings[FIVE].substring(THREE, FIVE),  HEX);
                bONE = Integer.parseInt(strings[FIVE].substring(FIVE, SEVEN),  HEX);
                aONE = Integer.parseInt(strings[SIX]);
                culoare = new Color(rONE, gONE, bONE, aONE);                
                rTWO = Integer.parseInt(strings[SEVEN].substring(ONE, THREE),  HEX);
                gTWO = Integer.parseInt(strings[SEVEN].substring(THREE, FIVE),  HEX);
                bTWO = Integer.parseInt(strings[SEVEN].substring(FIVE, SEVEN),  HEX);
                aTWO = Integer.parseInt(strings[EIGHT]);
                culoareTWO = new Color(rTWO, gTWO, bTWO, aTWO);
                
                return Diamond.getInstance(x,  y,  orizontala,  verticala,  culoare.getRGB(),  culoareTWO.getRGB());
            }
        
        if (strings[0].equals("POLYGON")) {
                int n = Integer.parseInt(strings[ONE]);
                List<Integer> x = new ArrayList<Integer>(n);
                List<Integer> y = new ArrayList<Integer>(n);                
                for (i = TWO; i <= TWO * n + ONE; i += TWO) {
                    x.add(Integer.parseInt(strings[i]));
                    y.add(Integer.parseInt(strings[i + ONE]));
                }
                rONE = Integer.parseInt(strings[TWO * n + TWO].substring(ONE, THREE),  HEX);
                gONE = Integer.parseInt(strings[TWO * n + TWO].substring(THREE, FIVE),  HEX);
                bONE = Integer.parseInt(strings[TWO * n + TWO].substring(FIVE, SEVEN),  HEX);
                aONE = Integer.parseInt(strings[TWO * n + THREE]);
                culoare = new Color(rONE, gONE, bONE, aONE);                
                rTWO = Integer.parseInt(strings[TWO * n + FOUR].substring(ONE, THREE),  HEX);
                gTWO = Integer.parseInt(strings[TWO * n + FOUR].substring(THREE, FIVE),  HEX);
                bTWO = Integer.parseInt(strings[TWO * n + FOUR].substring(FIVE, SEVEN),  HEX);
                aTWO = Integer.parseInt(strings[TWO * n + FIVE]);
                culoareTWO = new Color(rTWO, gTWO, bTWO, aTWO);
                
                return Polygon.getInstance(x,  y,  n,  culoare.getRGB(),  culoareTWO.getRGB());
        }
        
        if (strings[0].equals("PAINT")) {
            int x = Integer.parseInt(strings[ONE]);
            int y = Integer.parseInt(strings[TWO]);
            
            rONE = Integer.parseInt(strings[THREE].substring(ONE, THREE),  HEX);
            gONE = Integer.parseInt(strings[THREE].substring(THREE, FIVE),  HEX);
            bONE = Integer.parseInt(strings[THREE].substring(FIVE, SEVEN),  HEX);
            aONE = Integer.parseInt(strings[FOUR]);
            culoare = new Color(rONE, gONE, bONE, aONE);
            
            return Paint.getInstance(x, y, culoare.getRGB());
        }
        
        return null;        
    }
}
