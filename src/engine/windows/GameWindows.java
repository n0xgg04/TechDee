/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.windows;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Tdh4vn
 */
public class GameWindows extends Frame implements Runnable {

    public Plane PLANE1;
    private GameLogic GameLogic;
    private int PLANE_SPEED = 300; // Pixel per second;
    private  int UPDATE_PER_SECOND = 120;
    BufferedImage background;
    BufferedImage plane;
    int x = 300;
    int y = 300;
    int vectorLeft = 0;
    int vectorRight = 0;
    int vectorUp = 0;
    int vectorDown = 0;
    int mouseX = -1;
    int mouseY = -1;
    private Image image;
    private Graphics second;

    public GameWindows() {
        super();
        this.setTitle("Mao mạch");
        this.setFocusable(true);
        this.setSize(480, 800);
        this.setVisible(true);
        this.setResizable(false);
        GameLogic = new GameLogic();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });

        try {
            background = ImageIO.read(new File("Resources/Background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GameLogic.addPlane(new Plane(
                new Point(300,400),
                Plane.Plane_Type.PLANE2,
                1000,
                10000,
                1,
                GameLogic,
                new PlaneControl(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_SPACE)
        ));

        GameLogic.addPlane(new Plane(
                new Point(100,400),
                Plane.Plane_Type.PLANE4,
                1000,
                10000,
                1,
                GameLogic,
                new PlaneControl(KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_Q)
        ));
        this.addKeyListener(new PlaneKeyListener(GameLogic.getAllPlanes()));


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    mouseX = e.getX();
                    mouseY = e.getY();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            //Tạo một 1 graphics ẩn
            second = image.getGraphics();
            //Lấy graphics ẩn
        }
        paint(second);
        //Vẽ trên graphics ẩn
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        if(GameLogic!=null) {
            for (Plane PLANE : GameLogic.getAllPlanes()) {
                PLANE.MoveX((PLANE.getPlaneSpeed() * (PLANE.vectorRight - PLANE.vectorLeft)) / GameLogic.FPS);
                PLANE.MoveY((PLANE.getPlaneSpeed() * (PLANE.vectorDown - PLANE.vectorUp)) / GameLogic.FPS);
                PLANE.draw(g);
            }
        }
//        if(PLANE1 != null) {
//            this.PLANE_SPEED = PLANE1.getPlaneSpeed();
//            //Draw theo phím
//            PLANE1.MoveX((PLANE_SPEED * (vectorRight - vectorLeft)) / GameLogic.FPS);
//            PLANE1.MoveY((PLANE_SPEED * (vectorDown - vectorUp)) / GameLogic.FPS);

            //Draw theo chuột

//            if (!reachMouseDestination()) {
//                float vectorX = mouseX - PLANE1.getX();
//                float vectorY = mouseY - PLANE1.getY();
//
//                if (Math.abs(vectorX) > Math.abs(vectorY)) {
//                    vectorY = vectorY / Math.abs(vectorX);
//                    if (vectorX > 0) {
//                        vectorX = 1;
//                    } else {
//                        vectorX = -1;
//                    }
//                } else {
//                    vectorX = vectorX / Math.abs(vectorY);
//                    if (vectorY > 0) {
//                        vectorY = 1;
//                    } else {
//                        vectorY = -1;
//                    }
//                }
//
//                PLANE1.MoveX((int) vectorX * PLANE_SPEED / GameLogic.FPS);
//                PLANE1.MoveY((int) vectorY * PLANE_SPEED / GameLogic.FPS);
//            } else {
//                mouseX = -1;
//            }
//            PLANE1.draw(g);
//        }
    }

//    public boolean reachMouseDestination() {
//        return mouseX < 0 || Math.abs(x - mouseX) < 5 && Math.abs(y - mouseY) < 5;
//    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1000 / GameLogic.FPS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void start() {
        Thread mainThread = new Thread(this);
        mainThread.start();
    }
}
