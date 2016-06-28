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
        if (Double.isInfinite(m) || Double.isNaN(m)) m = 0;
        lengthX *= m;
        lengthY *= m;
    }

    public double getLength() {
        double m = Math.sqrt(Math.pow(lengthX,2) + Math.pow(lengthY,2));
        if (Double.isNaN(m)) m = 0;

        return m;
    }

    public double getLengthX() {
        return lengthX;
    }

    public double getLengthY() {
        return lengthY;
    }

    public void setLengthX(double lengthX) {
        this.lengthX = lengthX;
    }

    public void setLengthY(double lengthY) {
        this.lengthY = lengthY;
    }

    public void add(Vector vector) {
        if (vector != null) {
            lengthX += vector.getLengthX();
            lengthY += vector.getLengthY();
            setLength(getLength());
        }
    }

    public void remove(Vector vector) {
        if (vector != null) {
            lengthX -= vector.getLengthX();
            lengthY -= vector.getLengthY();
            setLength(getLength());
        }
    }

    public void clear() {
        setLength(0);
    }

    public void decrease(double value) {
        decreseX(value);
        decreseY(value);
    }

    public void decreseX(double value) {
        lengthX /= value;
        if (lengthX < 1 && lengthX > -1) lengthX = 0;
        setLength(getLength());
    }

    public void decreseY(double value) {
        lengthY /= value;
        if (lengthY < 1 && lengthY > -1) lengthY = 0;
        setLength(getLength());
    }
}
