package engine.windows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class Bullet extends GameTypeDefinition implements PositionLogic{
    BufferedImage bulletImage;
    public int x;
    public int y;
    private int BULLET_OF_ID;
    private int BULLET_SPEED = 300;

    public Bullet(int x, int y, Bullet_Type type, int _id) {
        this.x = x;
        this.y = y;
        this.setImageByType(type);
        this.BULLET_OF_ID = _id;
    }

    public void setImage(String path) {
        try {
            this.bulletImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setImageByType(Bullet_Type type) {
        switch (type) {
            case BULLET1:
            case BULLET2:
            case BULLET3:
            case BULLET4:
                this.setImage("Resources/BULLET.png");
                break;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.bulletImage, this.x, this.y, null);
    }

}
