package engine.windows;

import java.util.ArrayList;
import java.awt.Graphics;

public class GameLogic {

    private ArrayList<Bullet> ALL_BULLETS = new ArrayList<Bullet>();
    private ArrayList<Plane> ALL_ENEMIES = new ArrayList<Plane>();
    private ArrayList<Plane> ALL_PLANES = new ArrayList<Plane>();
    private long lastUpdateBullet = 0;
    public static int FPS = 60;

    public void addBullet(Bullet b){
        this.ALL_BULLETS.add(b);
    }

    public void addEnemy(Plane p){
        this.ALL_ENEMIES.add(p);
    }

    public void addPlane(Plane p){
        this.ALL_PLANES.add(p);
    }

    public ArrayList<Bullet> getAllBullets(){
        return this.ALL_BULLETS;
    }

    public ArrayList<Plane> getAllEnemies(){
        return this.ALL_ENEMIES;
    }

    public ArrayList<Plane> getAllPlanes(){
        return this.ALL_PLANES;
    }

    public void update(Graphics g){
        updatePlanesStatus(g);
        updateBulletStatus(g);
    }

    public void updatePlanesStatus(Graphics g){
        for (Plane PLANE : this.ALL_PLANES) {
            PLANE.MoveX((PLANE.getPlaneSpeed() * (PLANE.vectorRight - PLANE.vectorLeft)) / GameLogic.FPS);
            PLANE.MoveY((PLANE.getPlaneSpeed() * (PLANE.vectorDown - PLANE.vectorUp)) / GameLogic.FPS);
            PLANE.draw(g);
        }
    }

    public void updateBulletStatus(Graphics g){
        if(System.currentTimeMillis() - this.lastUpdateBullet > (1000 / GameLogic.FPS)){
            int i = 0, k=0;
            int arr[] = new int[this.ALL_BULLETS.size()];
            for (Bullet BULLET : this.ALL_BULLETS) {
                BULLET.MoveX((int) (BULLET.getBulletSpeed() * Math.sin(Math.toRadians(BULLET.getAngle())) / GameLogic.FPS));
                BULLET.MoveY((int) (-1 * BULLET.getBulletSpeed() * Math.cos(Math.toRadians(BULLET.getAngle())) / GameLogic.FPS));
                if(BULLET.x < 0 || BULLET.x > 800 || BULLET.y < 0 || BULLET.y > 600)
                    arr[k++] = i;;
                i++;
            }
            for(int j=0; j<k; j++)
                this.ALL_BULLETS.remove(arr[j]);
            this.lastUpdateBullet = System.currentTimeMillis();
        }
            for (Bullet BULLET : this.ALL_BULLETS) {
            BULLET.draw(g);
        }
    }

}
