package kaminsky.paint;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class PaintController
{
    @FXML
    PaintCanvas paintCanvas;

    @FXML
    ColorPicker colorPicker;

    public void initialize()
    {
        colorPicker.setValue(Color.BLACK);
        paintCanvas.context.setLineWidth(5);
    }

    public void draw()
    {
        paintCanvas.draw(colorPicker.getValue());
    }

    public void erase()
    {
        paintCanvas.erase();
    }

    public void clear()
    {
        paintCanvas.clear();
    }
}
