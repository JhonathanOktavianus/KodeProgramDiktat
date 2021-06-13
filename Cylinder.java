/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */
public class Cylinder extends ThreeDimensionalShape {
    private double radius, height;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI*Math.pow(radius,2)*height;
    }

    @Override
    public double getSurfaceArea() {
        return 2*Math.PI*radius*(radius+height);
    }

    public String toString(){
        return "Cylinder";
    }
}
