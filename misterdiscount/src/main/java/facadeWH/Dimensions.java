package facadeWH;

public class Dimensions {

	private double width ;
    private double height ;
    private double depth ;

    public Dimensions(){
    width = 0 ;
    height = 0 ;
    depth = 0 ;
    }

    public Dimensions(double wi , double h , double d){
    width = wi ;
    height = h ;
    depth = d ;
    }

    public double getWidth(){
    return width;
    }

    public void setWidth(double width){
    this.width = width;
    }

    public double getHeight(){
    return height;
    }

    public void setHeight(double height){
    this.height = height;
    }

    public double getDepth(){
    return depth;
    }

    public void setDepth(double depth){
    this.depth = depth;
    }

    public double volume(){
    return width*height*depth;
    }
}
