package engine.windows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class GameBackground extends GameTypeDefinition{
    private BufferedImage image;
    private Point p;

    void GameBackGround(BG_Type type){
        this.setImageByType(type);
    }

    private void setImageByType(BG_Type type){
        switch(type){
            case BG1:
            case BG2:
            case BG3:
                this.setImage("Resources/Background.png");
                break;
        }
    }

    private void setImage(String path){
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getImage(){
        return this.image;
    }

    public void draw(Graphics g){
        g.drawImage(this.image, this.p.x, this.p.y, null);
    }

    public Point getBulletPosition(){
        return new Point(this.p.x, this.p.y);
    }

    public void setPosition(Point p){
        this.p = p;
    }

    public void rotate(double angle) {
        System.out.println("Rotate");
    }


}
