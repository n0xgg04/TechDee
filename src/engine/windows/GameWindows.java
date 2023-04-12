/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.windows;


import java.awt.*;
import java.awt.event.WindowAdapter;

/**
 * @author Tdh4vn
 */
public class GameWindows extends Frame implements Runnable {


    public GameWindows() {
        super();
        this.setTitle("Techdee");
        this.setFocusable(true);
        this.setSize(480, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
    }

    //!Assignment
    public void drawSquare(int x, int y, int n) {
        getGraphics().drawRect(x, y, n, n);
    }

    public void printfString(String str, int x, int y) {
        getGraphics().drawString(str, x, y);
    }

    /**
     *  Draw a square with center is (x,y) and width is n
     * @param n Graphics
     * @param x int
     * @param y int
     * @param n int width
     * @param count int number of squares
     */
    public void drawCCSquares(int x, int y, int n, int count,int c) {
        getGraphics().drawRect(x, y, n, n);
        for(int i = 1; i < count; i++) {
            getGraphics().drawRect(x-i*c, y-i*c, n+i*c*2, n+i*c*2);
        }
    }

    public void drawPolygon(int x,int y, int n, int r) {
        int[] xPoints = new int[n];
        int[] yPoints = new int[n];
        for(int i = 0; i < n; i++) {
            xPoints[i] = (int) (x + r * Math.cos(2 * Math.PI * i / n));
            yPoints[i] = (int) (y + r * Math.sin(2 * Math.PI * i / n));
        }
        getGraphics().drawPolygon(xPoints, yPoints, n);
    }
    //!Override function from Frame
    @Override
    public void update(Graphics g) {
    }

    @Override
    public void paint(Graphics g) {
        //?Task 1 : Draw a square
        printfString("Task 1: ", 120, 90);
        drawSquare(100, 100, 100);

        //?Task 2
        printfString( "Task 2: ", 120, 300);
        drawCCSquares(100,250,100,5,10);

        //Draw polygon(x,y,n,r)
        printfString( "Task 3: ", 120, 420);
        drawPolygon(140,500,7,60);



    }

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }

    public void start() {
        Thread mainThread = new Thread(this);
        mainThread.start();
    }
}
