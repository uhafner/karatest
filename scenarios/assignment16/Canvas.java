public class Canvas {
    private boolean [][] world;

    public Canvas(int width, int height) {
        this.world = new boolean[height][width];
    }

    void drawPoint(final int x, final int y) {
        world[y][x] = true;
    }

    void clearPoint(final int x, final int y) {
        world[y][x] = false;
    }

    void drawHorizontalLine(final int x0, final int y0, final int length) {
        for(int x = x0; x < x0 + length; x++) {
            world[y0][x] = true;
        }	
    }

    void clearHorizontalLine(final int x0, final int y0, final int length) {
        for(int x = x0; x < x0 + length; x++) {
            world[y0][x] = false;
        }	
    }

    void clearVerticalLine(final int x0, final int y0, final int length) {
        for (int y = y0; y < y0 + length; y++) {
            world[y][x0] = false;
        }
    }

    void drawVerticalLine(final int x0, final int y0, final int length) {
        for (int y = y0; y < y0 + length; y++) {
            world[y][x0] = true;
        }
    }

    void drawRectangle(final int x0, final int y0, final int width, final int height) {
        drawHorizontalLine(x0, y0, width);
        drawHorizontalLine(x0, y0 + height - 1, width);
        drawVerticalLine(x0, y0 + 1, height - 2);
        drawVerticalLine(x0 + width - 1, y0 + 1, height - 2);
    } 

    void clearRectangle(final int x0, final int y0, final int width, final int height) {
        clearHorizontalLine(x0, y0, width);
        clearHorizontalLine(x0, y0 + height - 1, width);
        clearVerticalLine(x0, y0 + 1, height - 2);
        clearVerticalLine(x0 + width - 1, y0 + 1, height - 2);
    }

    void fillArea(final int x0, final int y0, final int width, final int height) {
        for (int y = 0; y < height; y++) {
            drawHorizontalLine(x0, y0 + y, width);
        }
    }

    void clearArea(final int x0, final int y0, final int width, final int height) {
        for (int y = 0; y < height; y++) {
            clearHorizontalLine(x0, y0 + y, width);

        }
    }

    public boolean[][]getBuffer() {
        return world;
    }
}