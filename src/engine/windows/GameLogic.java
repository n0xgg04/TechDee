package engine.windows;

import java.util.ArrayList;

public class GameLogic {

    private ArrayList<Bullet> ALL_BULLETS = new ArrayList<Bullet>();
    private ArrayList<Plane> ALL_ENEMIES = new ArrayList<Plane>();
    private ArrayList<Plane> ALL_PLANES = new ArrayList<Plane>();
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



}
