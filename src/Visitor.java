public interface Visitor {
       public void visit(Canvas c);
       public void visit(Line l);
       public void visit(Square s);
       public void visit(Picture p);
       public void visit(Rectangle r);
       public void visit(Circle c);
       public void visit(Triangle t);
       public void visit(Polygon p);
       public void visit(Diamond p);
       public void visit(Paint p);
}
