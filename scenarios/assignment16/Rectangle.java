public class Rectangle {
    private final int x0;
    private final int y0;
    private final int width;
    private final int height;

    public Rectangle(final int x0, final int y0, final int width, final int height) {
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
    }

    void draw(Canvas canvas) {
        canvas.drawRectangle(x0, y0, width, height);
    }

    Rectangle[] splitHorizontally() {
        Rectangle[] split = new Rectangle[2];
        split[0] = new Rectangle(x0, y0, width / 2, height);
        split[1] = new Rectangle(x0 + width / 2, y0, width / 2, height);

        return split;
    }

    Rectangle[] splitVertically() {
        Rectangle[] split = new Rectangle[2];
        split[0] = new Rectangle(x0, y0, width, height / 2);
        split[1] = new Rectangle(x0, y0 + height / 2, width, height / 2);
 
        return split;
    }

    Rectangle move(int xOffset, int yOffset) {
        return new Rectangle(x0 + xOffset, y0 + yOffset, width, height);
    }

    boolean isArea() {
        if ((width == 1)||(width == 2)||(height == 2)||(height == 1)) {
            return true;
        }

        return false;
    }

    boolean contains(int x, int y){
        if (x < x0 || x0 + width - 1 < x) {
            return false;
        }
        if (y < y0 || y0 + height -1 < y) {
            return false;
        }
        return true;
    }

    boolean intersects(Rectangle other) {
        if (((other.x0 + other.width) <= (this.x0))
        ||((other.x0) >= (this.x0 + this.width))
        ||((other.y0) >= (this.y0 + this.height))
        ||((other.y0 + other.height) <= (this.y0))){

            return false;
        }

        return true;
    }
}