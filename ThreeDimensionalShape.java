import java.text.DecimalFormat;

/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */
public abstract class ThreeDimensionalShape extends Shape {
    public abstract double getVolume();

    public abstract double getSurfaceArea();

    public void showDetail() {
        System.out.println("Volume of "+toString()+" is: "+ getVolume());
        System.out.println("Surface area of "+toString()+" is: "+ getSurfaceArea());
    }
}
