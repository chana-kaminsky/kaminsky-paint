package kaminsky.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * PaintCanvas is a class that draws on, erases, and
 * clears a GraphicsContext in response to mouse events.
 */
public class PaintCanvas extends Canvas
{
    protected GraphicsContext context = getGraphicsContext2D();

    boolean draw = true;
    Color color;

    public PaintCanvas()
    {
        addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        context.setStroke(color);
                        context.beginPath();
                    }
                });

        addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (draw) {
                            context.lineTo(event.getX(), event.getY());
                            context.stroke();
                        }
                        else {
                            context.clearRect(event.getX()-10, event.getY()-10, 20, 20);
                        }
                    }
                });
    }

    /**
     * Sets draw to true, so that context responds to
     * a mouse event by drawing with the given color
     * @param color
     */
    public void draw(Color color)
    {
        context.setLineWidth(5);
        this.color = color;
        draw = true;
    }

    /**
     * Sets draw to false, so that context
     * responds to a mouse event by erasing
     */
    public void erase()
    {
        context.setLineWidth(10);
        draw = false;
    }

    /**
     * Clears the entire context
     */
    public void clear()
    {
        context.clearRect(0,0,getWidth(), getHeight());
    }
}