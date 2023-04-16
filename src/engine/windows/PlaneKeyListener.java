package engine.windows;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * KeyListener của tất cả Plane
 * @construct PlaneKeyListener(ArrayList<Plane> ALL_PLANES)
 * @param ALL_PLANES: ArrayList chứa tất cả Plane
 *                  (có thể là tất cả Plane của game hoặc chỉ là Plane của một Player)
 */
public class PlaneKeyListener implements KeyListener {
    ArrayList<Plane> ALL_PLANES;
    
    public PlaneKeyListener(ArrayList<Plane> ALL_PLANES){
        this.ALL_PLANES = ALL_PLANES;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

   // @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for(Plane PLANE : ALL_PLANES) {
                if(key == PLANE.planeControl.LEFT) {
                    PLANE.vectorLeft = 1;
                    PLANE.rotate(-90);
                }else if(key == PLANE.planeControl.UP) {
                    PLANE.vectorUp = 1;
                    PLANE.rotate(0);
                }else if(key == PLANE.planeControl.DOWN) {
                    PLANE.vectorDown = 1;
                    PLANE.rotate(180);
                }else if(key == PLANE.planeControl.RIGHT) {
                    PLANE.vectorRight = 1;
                    PLANE.rotate(90);
                }else if(key == PLANE.planeControl.SHOOT)
                        PLANE.shoot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(Plane PLANE : ALL_PLANES) {
            if(key == PLANE.planeControl.LEFT)
                PLANE.vectorLeft = 0;
            else if(key == PLANE.planeControl.UP)
                PLANE.vectorUp = 0;
            else if(key == PLANE.planeControl.DOWN)
                PLANE.vectorDown = 0;
            else if(key == PLANE.planeControl.RIGHT)
                PLANE.vectorRight = 0;
        }
    }
}
