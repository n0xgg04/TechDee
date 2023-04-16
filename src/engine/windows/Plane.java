package engine.windows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Tạo đối tượng Plane
 * @construct Plane(Point position, Plane_Type _type, int _dame, int _hp, int _id, GameLogic _gameControl, PlaneControl _planeControl)
 * @param position: vị trí của máy bay
 *                _type: loại máy bay
 *                _dame: sát thương của máy bay
 *                _hp: máu của máy bay
 *                _id: id của máy bay
 *                _gameControl: bộ điều khiển game
 *                _planeControl: bộ điều khiển máy bay
 */
public class Plane extends GameTypeDefinition implements PositionLogic{

    private BufferedImage imagePlane, originImagePlane;
    private int PLANE_DAME = 300;
    private int PLANE_HP = 100;
    private int PLANE_ID;
    public int vectorUp, vectorRight, vectorDown, vectorLeft;
    private Point PLANE_POSITION;
    private int PLANE_SPEED = 300;
    private double angle = 0;
    private int type;
    private GameLogic gameControl;
    public PlaneControl planeControl;



    public Plane(Point position, Plane_Type _type, int _dame, int _hp, int _id, GameLogic _gameControl, PlaneControl _planeControl) {
        this.PLANE_POSITION = position;
        this.PLANE_DAME = _dame;
        this.PLANE_HP = _hp;
        this.PLANE_ID = _id;
        this.gameControl = _gameControl;
        this.planeControl = _planeControl;
        this.setImageByType(_type);
    }

    private void setImageByType(Plane_Type _type){
        switch(_type){
            case PLANE1:
                this.type = 1;
                this.setImage("Resources/PLANE1.pnsetg");
                break;
            case PLANE2:
                this.type = 2;
                this.setImage("Resources/PLANE2.png");
                break;
            case PLANE3:
                this.type = 3;
                this.setImage("Resources/PLANE3.png");
                break;
            case PLANE4:
                this.type = 4;
                this.setImage("Resources/PLANE4.png");
                break;
        }
        this.originImagePlane = this.imagePlane;
    }

    private void setImage(String path){
        try {
            this.imagePlane = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedImage getImagePlane(){
        return this.imagePlane;
    }

    int getPlaneSpeed(){
        return this.PLANE_SPEED;
    }

    public void setSpeed(int SPEED){
        this.PLANE_SPEED = SPEED;
    }

    public void setDame(int DAME){
        this.PLANE_DAME = DAME;
    }

    public void setHP(int HP){
        this.PLANE_HP = HP;
    }

    public void changeType(Plane_Type _type){
        this.setImageByType(_type);
    }

    public void draw(Graphics g){
        g.drawImage(this.imagePlane, this.PLANE_POSITION.x, this.PLANE_POSITION.y, null);
    }

    public void setX(int x){
        this.PLANE_POSITION.x = x;
    }

    public void setY(int y){
        this.PLANE_POSITION.y = y;
    }

    public int getX(){
        return this.PLANE_POSITION.x;
    }

    public int getY(){
        return this.PLANE_POSITION.y;
    }

    public void MoveX(int x){
        this.PLANE_POSITION.x += x;
    }

    public void MoveY(int y){
        this.PLANE_POSITION.y += y;
    }

    public void shoot(){
        //find center of plane imageto shoot

        Bullet bullet = new Bullet(this.PLANE_POSITION.x + this.imagePlane.getWidth()/2, this.PLANE_POSITION.y, Bullet_Type.BULLET1, this.PLANE_ID, this.angle);
        this.gameControl.addBullet(bullet);
    }
    public void rotate(double angle){
        this.angle = angle;
        this.imagePlane = this.rotateImage(this.originImagePlane, angle);
    }

    public double getAngle(){
        return this.angle;
    }

}
