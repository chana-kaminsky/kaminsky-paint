package kaminsky.paint;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class PaintController
{
    @FXML
    PaintCanvas paintCanvas;

    public void initialize()
    {
        paintCanvas.draw();
    }
}
