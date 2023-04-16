package engine.windows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class GameTools {
    public static void setGameBackGround(Graphics g){
        try {
            g.drawImage(ImageIO.read(new File("Resources/Background.png")), 0, 0, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
