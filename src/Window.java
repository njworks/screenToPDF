import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Created by N on 31/03/2017.
 */
public class Window {

    public static void mainWindow(){
        JFrame frame = new JFrame("Screen To PDF");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.addKeyListener(new Action());
        JPanel text = new JPanel();
        JLabel intro = new JLabel("Press S or s to take screenshot");
        text.add(intro);
        JLabel pdf = new JLabel("Press P or p to create PDF");
        text.add(pdf);
        frame.add(text);
        frame.setBounds(50, 50, 300, 85);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static void crop(){
        try{
            for (int i =0; i < Run.names.size(); i++){
                String each = (String) Run.names.get(i);
                BufferedImage orgImg = ImageIO.read(new File(each));
                BufferedImage newImg = orgImg.getSubimage(300, 150, 200, 200);
                File out = new File(each);
                ImageIO.write(newImg, "png", out);
            }
        }catch (Exception e){
            System.out.println("Problem cropping image, Exception: "+ e);
        }


    }

}
