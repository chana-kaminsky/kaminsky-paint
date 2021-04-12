package kaminsky.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PaintCanvas extends Canvas
{
    protected GraphicsContext context = getGraphicsContext2D();

    boolean draw = true;
    Color color;

    public PaintCanvas()
    {
        addEvent();
    }

    public void addEvent()
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

    public void draw(Color color)
    {
        context.setLineWidth(5);
        this.color = color;
        draw = true;
    }

    public void erase()
    {
        context.setLineWidth(10);
        draw = false;
    }

    public void clear()
    {
        context.clearRect(0,0,getWidth(), getHeight());
    }
}
