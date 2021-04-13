package kaminsky.paint;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * PaintController is a class that has
 * methods called by paint_application.fxml.
 */
public class PaintController
{
    @FXML
    PaintCanvas paintCanvas;

    @FXML
    ColorPicker colorPicker;

    /**
     * Sets initial color and line width
     */
    public void initialize()
    {
        colorPicker.setValue(Color.BLACK);
        paintCanvas.context.setLineWidth(5);
    }

    /**
     * Calls PaintCanvas's draw() method
     * with a color from colorPicker
     */
    public void draw()
    {
        paintCanvas.draw(colorPicker.getValue());
    }

    /**
     * Calls PaintCanvas's erase() method
     */
    public void erase()
    {
        paintCanvas.erase();
    }

    /**
     * Calls PaintCanvas's clear() method
     */
    public void clear()
    {
        paintCanvas.clear();
    }
}