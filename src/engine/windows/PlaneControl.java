package engine.windows;

/**
 * Bộ điều khiển máy bay
 * @construct PlaneControl(int UP, int RIGHT, int DOWN, int LEFT,int SHOOT)
 * @method UP: Đi lên
 * @method DOWN: Đi xuống
 * @method LEFT: Đi trái
 * @method RIGHT: Đi phải
 * @method SHOOT: Bắn
 */
public class PlaneControl {
    public int UP;
    public int DOWN;
    public int LEFT;
    public int RIGHT;
    public int SHOOT;

    public PlaneControl(int UP, int RIGHT, int DOWN, int LEFT,int SHOOT){
        this.UP = UP;
        this.DOWN = DOWN;
        this.LEFT = LEFT;
        this.RIGHT = RIGHT;
        this.SHOOT = SHOOT;
    }
}
