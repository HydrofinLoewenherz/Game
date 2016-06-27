package net.colorman.misc;

/**
 * Created by Paul on 14.06.2016.
 */
public class Vector {

    private double lengthX, lengthY, length;

    public Vector(double dX, double dY, double length) {
        lengthX = dX;
        lengthY = dY;
        setLength(length);
    }

    public void setLength(double length) {
        this.length = length;
        double m = Math.sqrt(Math.pow(length, 2) / (Math.pow(lengthX, 2) + Math.pow(lengthY, 2)));
        if (Double.isInfinite(m)) m = 0;
        lengthX *= m;
        lengthY *= m;
    }

    public double getLength() {
        return length;
    }

    public double getLengthX() {
        return lengthX;
    }

    public double getLengthY() {
        return lengthY;
    }

    public void add(Vector vector) {
        length += vector.getLength();
        lengthX += vector.getLengthX();
        lengthY += vector.getLengthY();
    }

    public void clear() {
        setLength(0);
    }
}
