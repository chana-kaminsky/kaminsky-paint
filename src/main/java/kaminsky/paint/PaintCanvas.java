package kaminsky.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PaintCanvas extends Canvas
{

    final GraphicsContext context = getGraphicsContext2D();

    boolean draw = true;
    Color color;

    public PaintCanvas()
    {
        addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (draw) {
                            context.setStroke(color);
                            context.strokeLine(event.getX(), event.getY(), event.getX(), event.getY());
                        }
                        else {
                            context.clearRect(event.getX()-5, event.getY()-5, 10, 10);
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

}
