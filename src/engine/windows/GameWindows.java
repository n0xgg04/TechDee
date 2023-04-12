/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.windows;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Tdh4vn
 */
public class GameWindows extends Frame implements Runnable {

    Point start, end;
    boolean updated = true;

    private class MyMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            start = e.getPoint();
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {
            end = e.getPoint();
            updated = false;
        }
    }

    private class MyMouseMotionListener extends MouseAdapter {
        public void mouseDragged(MouseEvent e) {
            end = e.getPoint();
        }
    }

    public GameWindows() {
        super();
        this.setTitle("Mao phắc");
        this.setFocusable(true);
        this.setSize(480, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.addMouseListener(new MyMouseListener());
        Image icon = Toolkit.getDefaultToolkit().getImage("Resources/PLANE1.png");
        if (icon != null) {
            this.setIconImage(icon);
        } else {
            System.out.println("Failed to load icon image");
        }
        this.addMouseMotionListener(new MyMouseMotionListener());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
    }

    public void drawSquare(Graphics g, int x, int y, int n) {
        g.drawRect(x, y, n, n);
    }

    public void printfString(Graphics g, String str, int x, int y) {
        g.drawString(str, x, y);
    }


    public void DrawNSquare(Graphics g, int x,int y,int n,int m){
        g.drawRect(x,y,1,1);
        while(n>0){
            drawSquare(g,x,y,n);
            n-=2*m;
            x+=m;
            y+=m;
        }
    }

    public void drawPolygon(Graphics g, int x, int y, int n, int r) {
        int[] xPoints = new int[n];
        int[] yPoints = new int[n];
        for(int i = 0; i < n; i++) {
            xPoints[i] = (int) (x + r * Math.cos(2 * Math.PI * i / n));
            yPoints[i] = (int) (y + r * Math.sin(2 * Math.PI * i / n));
        }

        for(int i = 0; i < n; i++) {
            g.drawLine(xPoints[i], yPoints[i], xPoints[(i+1)%n], yPoints[(i+1)%n]);
        }

    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw a square
        printfString(g, "Task 1: ", 120, 90);
        drawSquare(g, 100, 100, 100);
//
//        // Draw concentric squares
          printfString(g, "Task 2: ", 120, 270);
          DrawNSquare(g,100,300,100,10);
//
//
          printfString(g, "Task 3: ", 120, 420);
          drawPolygon(g, 140, 500, 5, 60);

        //! Kéo thả chuột để vẽ đoạn thẳng
//        if (start != null && end != null) {
//            g.drawLine(start.x, start.y, end.x, end.y);
//        }

        //Kéo thả để vẽ hình chữ nhật
        if (start != null && end != null) {
            g.drawRect(start.x, start.y, end.x - start.x, end.y - start.y);
        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        Thread mainThread = new Thread(this);
        mainThread.start();
    }
}