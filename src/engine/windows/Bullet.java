package engine.windows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class Bullet extends GameTypeDefinition implements PositionLogic{
    BufferedImage bulletImage,originBulletImage;
    public int x;
    public int y;
    private int BULLET_OF_ID;
    private int BULLET_SPEED = 300;
    private double angle = 0;

    public Bullet(int x, int y, Bullet_Type type, int _id, double angle) {
        this.x = x;
        this.y = y;
        this.setImageByType(type);
        this.BULLET_OF_ID = _id;
        this.originBulletImage = this.bulletImage;
        if(angle != 0){
            this.angle = angle;
            this.bulletImage = this.rotateImage(this.originBulletImage, this.angle);
        }
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

    @Override
    public void rotate(double angle){
        this.angle =  angle;
        this.bulletImage = this.rotateImage(this.bulletImage, this.angle);
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(this.bulletImage, this.x, this.y, null);
    }

    public void MoveX(int x){
        this.x += x;
    }

    public void MoveY(int y){
        this.y += y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getSpeed(){
        return this.BULLET_SPEED;
    }

    public int getID(){
        return this.BULLET_OF_ID;
    }

    public void setSpeed(int speed){
        this.BULLET_SPEED = speed;
    }

    public int getBulletSpeed(){
        return this.BULLET_SPEED;
    }

    public void setID(int id){
        this.BULLET_OF_ID = id;
    }

    public double getAngle(){
       return this.angle;
    }

}
