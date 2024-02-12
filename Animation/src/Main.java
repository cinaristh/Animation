import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Main extends JFrame {

    Ball b[] = new Ball[10];


    Timer t;


    public static void main(String[] args) {
        // write your code here
        new Main();

    }

    public Main() {
        this.setSize(400, 437);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PaintSurface canvas = new PaintSurface();
        this.setTitle("test...");
        this.add(canvas);
        t = new Timer(20, e -> {
            canvas.updateObjectPositions();
            canvas.repaint();
        });
        setup();
        t.start();
        this.setVisible(true);
    }

    class PaintSurface extends JComponent {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


            Shape s = new Rectangle2D.Float(0, 0, 400, 403);
            g2.setColor(Color.BLACK);
            g2.fill(s);

            for (int x = 0; x<10; x++){
                s = new Ellipse2D.Float((float) b[x].getX(), (int) b[x].getY(), 20, 20);
                g2.setColor(Color.YELLOW);
                g2.fill(s);


            }

        }

        public void updateObjectPositions() {
            for (int i = 0; i < 10; i++) {
                b[i].updatePosition();
            }




        }



    }
    public void setup () {
        for (int i = 0; i < 10; i++) b[i] = new Ball();
    }
}

