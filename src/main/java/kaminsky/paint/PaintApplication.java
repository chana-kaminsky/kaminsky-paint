package kaminsky.paint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaintApplication extends Application
{
    public void start(Stage stage) throws Exception
    {
        PaintController controller = new PaintController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/paint_application.fxml"));
        loader.setController(controller);

        Parent parent = loader.load();
        Scene scene = new Scene(parent, 500, 350);

        stage.setTitle("Paint Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}