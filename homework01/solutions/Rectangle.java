// Rectangle.java
public class Rectangle implements Comparable<Rectangle> {

  private int length;
  private int width;

  public Rectangle(int length, int width) {
  	this.length = length;
    this.width = width;
  }

  public int getLength(){
    return length;
  }

  public int getWidth(){
    return width;
  }

  @Override
  public int compareTo(Rectangle r) {
    int are = length * width;
    int r_area = r.getLength() * r.getWidth();
    return area - r_area;
  }

  public String toString() {
    return String.format("Length:%d Width: %d", length, width);
  }
}