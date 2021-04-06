package kaminsky.paint;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class PaintCanvas extends Canvas
{
    public void draw()
    {
        GraphicsContext context = getGraphicsContext2D();
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, getWidth(), getHeight());
        context.setStroke(Color.DARKRED);
        context.setLineWidth(5);

        addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        context.strokeLine(event.getX(), event.getY(), event.getX(), event.getY());
                    }
                });
    }


}
