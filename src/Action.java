import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by N on 31/03/2017.
 */
public class Action extends KeyAdapter {

    public void keyPressed(KeyEvent press) {
        if (press.getKeyChar() == 's' || press.getKeyChar() == 'S') {

            System.out.println(press.getKeyChar());
            Timer delay = new Timer();

//            TimerTask task = new TimerTask() {
//                @Override
//                public void run() {
            try {
                Rectangle screen = new Rectangle((Toolkit.getDefaultToolkit().getScreenSize()));
                BufferedImage capture = new Robot().createScreenCapture(screen);
                ImageIO.write(capture, "png", new File("screenshot" + Run.count +
                        ".png"));
            } catch (Exception e) {
                System.out.println("Screen capture failed, Exception: " + e);
            }
//                }
//            };
//            delay.schedule(task, 3000);

            Run.names.add("screenshot" + Run.count + ".png");
            Run.count++;
        }

        if (press.getKeyChar() == 'p' || press.getKeyChar() == 'P') {
            PDFWrite.pdfExport();
        }


        if (press.getKeyChar() == 'c' || press.getKeyChar() == 'C') {
            System.out.println("Crop");
            Window.crop();
        }

    }

}
