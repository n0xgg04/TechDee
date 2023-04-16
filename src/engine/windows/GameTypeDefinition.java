package engine.windows;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameTypeDefinition {
    public static enum Game_Type{
        GAME1, GAME2, GAME3, GAME4
    }

    public static enum Plane_Type{
        PLANE1, PLANE2, PLANE3, PLANE4
    }

    public static enum Bullet_Type{
        BULLET1, BULLET2, BULLET3, BULLET4
    }

    public static enum Enemy_Type{
        ENEMY1, ENEMY2, ENEMY3, ENEMY4
    }

    public static enum BG_Type{
        BG1, BG2, BG3, BG4
    }

    /**
     * Xoay ảnh
     * @param buffImage ảnh cần xoay
     * @param angle góc xoay
     * @return ảnh đã xoay
     */
    public BufferedImage rotateImage(BufferedImage buffImage, double angle) {
        double radian = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radian));
        double cos = Math.abs(Math.cos(radian));

        int width = buffImage.getWidth();
        int height = buffImage.getHeight();

        int nWidth = (int) Math.floor((double) width * cos + (double) height * sin);
        int nHeight = (int) Math.floor((double) height * cos + (double) width * sin);

        BufferedImage rotatedImage = new BufferedImage(
                nWidth, nHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = rotatedImage.createGraphics();

        graphics.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        graphics.translate((nWidth - width) / 2, (nHeight - height) / 2);
        // rotation around the center point
        graphics.rotate(radian, (double) (width / 2), (double) (height / 2));
        graphics.drawImage(buffImage, 0, 0, null);
        graphics.dispose();

        return rotatedImage;
    }

    abstract public void rotate(double angle);
}
