package kaminsky.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PaintControllerTest
{
    private PaintCanvas paintCanvas;
    private ColorPicker colorPicker;
    private PaintController controller;
    private GraphicsContext context;

    @BeforeClass
    public static void beforeClass()
    {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void initialize()
    {
        // given
        givenPaintController();
        doNothing().when(colorPicker).setValue(Color.BLACK);
        doNothing().when(context).setLineWidth(5);

        // when
        controller.initialize();

        // then
        verify(colorPicker).setValue(Color.BLACK);
        verify(paintCanvas.context).setLineWidth(5);

    }

    @Test
    public void draw()
    {
        // given
        givenPaintController();

        // when
        controller.draw();

        // then
        verify(paintCanvas).draw(colorPicker.getValue());
    }

    @Test
    public void erase()
    {
        // given
        givenPaintController();

        // when
        controller.erase();

        // then
        verify(paintCanvas).erase();
    }

    @Test
    public void clear()
    {
        // given
        givenPaintController();

        // when
        controller.clear();

        // then
        verify(paintCanvas).clear();
    }

    private void givenPaintController()
    {
        controller = new PaintController();
        paintCanvas = mock(PaintCanvas.class);
        controller.paintCanvas = paintCanvas;
        colorPicker = mock(ColorPicker.class);
        controller.colorPicker = colorPicker;
        context = mock(GraphicsContext.class);
        controller.paintCanvas.context = context;
    }
}
