package kaminsky.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaintCanvasTest
{
    private PaintCanvas canvas;
    private GraphicsContext context;
    private boolean draw;
    private Color color;

    @BeforeClass
    public static void beforeClass()
    {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void addEvent_drawTrue()
    {
        // given
        givenPaintCanvas();
        MouseEvent event = mock(MouseEvent.class);

        // when
        canvas.addEvent();

        // then
        verify(context).setStroke(color);
        verify(context).beginPath();
        verify(context).lineTo(event.getX(), event.getY());
        verify(context).stroke();

    }

    @Test
    public void addEvent_drawFalse()
    {
        // given
        givenPaintCanvas();
        draw = false;
        MouseEvent event = mock(MouseEvent.class);

        // when
        canvas.addEvent();

        // then
        verify(context).setStroke(color);
        verify(context).beginPath();
        verify(context).clearRect(event.getX()-10, event.getY()-10, 20, 20);
    }

    @Test
    public void draw()
    {
        // given
        givenPaintCanvas();

        // when
        canvas.draw(color);

        // then
        verify(context).setLineWidth(5);
        // test this.color...?
        Assert.assertTrue(canvas.draw);
    }

    @Test
    public void erase()
    {
        // given
        givenPaintCanvas();

        // when
        canvas.erase();

        // then
        verify(context).setLineWidth(10);
        Assert.assertFalse(canvas.draw);
    }

    @Test
    public void clear()
    {
        // given
        givenPaintCanvas();

        // when
        canvas.clear();

        // then
        verify(context).clearRect(0,0,canvas.getWidth(), canvas.getHeight());
    }

    private void givenPaintCanvas()
    {
        canvas = new PaintCanvas();
        context = mock(GraphicsContext.class);
        canvas.context = context;
        color = mock(Color.class);
        canvas.color = color;
    }
}
