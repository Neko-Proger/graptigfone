package sample;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class Paint {

    javafx.scene.canvas.Canvas canv(Double x, Double y) {
        javafx.scene.canvas.Canvas canvas = new javafx.scene.canvas.Canvas(x / 2, y / 2);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setStroke(Color.BLACK);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        graphicsContext.beginPath();
                        graphicsContext.moveTo(event.getX(), event.getY());
                        graphicsContext.stroke();
                    }
                });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        graphicsContext.lineTo(event.getX(), event.getY());
                        graphicsContext.stroke();
                    }
                });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {

                    }
                });
        return canvas;
    }
    void save(javafx.scene.canvas.Canvas canvas, int x, int y, String str){
        File file = new File(str);
        try {
            WritableImage writableImage = new WritableImage((int) x/2 , (int) y/2);
            canvas.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            ImageIO.write(renderedImage, "png", file);
        } catch (IOException ex) {
            System.out.println("Error!");
        }
    }
}

