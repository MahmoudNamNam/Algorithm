import edu.princeton.cs.algs4.StdDraw;
import java.awt.Color;

public class DrawingExample {
    public static void main(String[] args) {
        // Set up the canvas for drawing
        StdDraw.setCanvasSize(400, 400);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        // Set the background color
        StdDraw.clear(StdDraw.LIGHT_GRAY);

        // Draw a very simplified soccer ball
        drawSoccerBall(0.5, 0.5, 0.3);

        // Show the drawing on the screen
        StdDraw.show();
    }

    public static void drawSoccerBall(double x, double y, double radius) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, radius);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(x, y, radius * 0.95);
    }
}
