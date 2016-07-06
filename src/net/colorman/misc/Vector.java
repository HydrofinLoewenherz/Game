package net.colorman.misc;

public class Vector {

    /**
     * Double Values of this Vector,
     *
     * length in X and Y direction
     *
     */
    private double lengthX;
    private double lengthY;

    public Vector(double dX, double dY, double length) {
        lengthX = dX;
        lengthY = dY;
        setLength(length);
    }

    /**
     * This Method sets the X and Y length of this Vector to a specific Length
     *
     * @param length    a specific Length
     */
    public void setLength(double length) {
        double m = Math.sqrt(Math.pow(length, 2) / (Math.pow(lengthX, 2) + Math.pow(lengthY, 2)));
        if (Double.isInfinite(m) || Double.isNaN(m)) m = 0;
        lengthX *= m;
        lengthY *= m;
    }

    /**
     * A Getter for the Length
     *
     * @return Double   Length
     */
    public double getLength() {
        double m = Math.sqrt(Math.pow(lengthX,2) + Math.pow(lengthY,2));
        if (Double.isNaN(m)) m = 0;

        return m;
    }

    /**
     * A Getter for the Length in X direction
     *
     * @return Double   lengthX
     */
    public double getLengthX() {
        return lengthX;
    }

    /**
     * A Getter for the Length in Y direction
     *
     * @return Double   lengthY
     */
    public double getLengthY() {
        return lengthY;
    }

    /**
     * A Setter for the X direction length
     *
     * @param lengthX
     */
    public void setLengthX(double lengthX) {
        this.lengthX = lengthX;
    }

    /**
     * A Setter for the Y direction length
     *
     * @param lengthY
     */
    public void setLengthY(double lengthY) {
        this.lengthY = lengthY;
    }

    /**
     * This Method adds an Vector to this Vector
     *
     * @param vector
     */
    public void add(Vector vector) {
        if (vector != null) {
            lengthX += vector.getLengthX();
            lengthY += vector.getLengthY();
            setLength(getLength());
        }
    }

    /**
     * This Method removes an Vector from this Vector
     *
     * @param vector
     */
    public void remove(Vector vector) {
        if (vector != null) {
            lengthX -= vector.getLengthX();
            lengthY -= vector.getLengthY();
            setLength(getLength());
        }
    }

    /**
     * This Method clears the Vector to (0 0)
     *
     */
    public void clear() {
        setLength(0);
    }

    /**
     * This Method decreases the VectorLength by this Modifier
     *
     * @param value
     */
    public void decrease(double value) {
        decreaseX(value);
        decreaseY(value);
    }

    /**
     * This Method decreases the VectorLength in X direction by this Modifier
     *
     * @param value
     */
    public void decreaseX(double value) {
        lengthX /= value;
        if (lengthX < 1 && lengthX > -1) lengthX = 0;
        setLength(getLength());
    }

    /**
     * This Method decreases the VectorLength in Y direction by this Modifier
     *
     * @param value
     */
    public void decreaseY(double value) {
        lengthY /= value;
        if (lengthY < 1 && lengthY > -1) lengthY = 0;
        setLength(getLength());
    }
}
