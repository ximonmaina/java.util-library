package StringHandling.tostring;

public class Box {

    public double width;
    public double height;
    public double depth;

    public Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    public String toString() {
        return "Dimensions are " + width + " by " +
                depth + " by " + height + ".";
    }
}
