class Rectangle{
   int x1, y1, x2, y2;
   Rectangle(int x1, int y1, int x2, int y2){
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
   }
   Rectangle(Point p1, Point p2){
      this.x1 = p1.x;
      this.y1 = p1.y;
      this.x2 = p2.x;
      this.y2 = p2.y;
   }
   int area(){
      return (x2-x1)*(y2-y1);
   }
   int perimeter(){
      return 2*(x2+y2-x1-y1);
   }
   boolean pointInside(Point p){
      if(p.x >= this.x1 && p.x <=this.x2 && p.y >= this.y1 && p.y <= this.y2){
         return true;
      }
      else{
         return false;
      }
   }
   boolean rectangleInside(Rectangle r){
      Point rp1 = new Point(r.x1, r.y1);
      Point rp2 = new Point(r.x2, r.y2);
      if(pointInside(rp1) && pointInside(rp2)){
         return true;
      }
      else{
         return false;
      }
   }
}