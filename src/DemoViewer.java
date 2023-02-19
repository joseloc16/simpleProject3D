import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class DemoViewer {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    Container pane = frame.getContentPane();
    pane.setLayout(new BorderLayout());

    // control deslizante para controlar la rotación horizontal
    JSlider headingSlider = new JSlider(0,360,180);
    pane.add(headingSlider, BorderLayout.SOUTH);

    //control deslizante para controlar la rotación vertical
    JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
    pane.add(pitchSlider, BorderLayout.EAST);

    //panel para mostrar los resultados del renderizado
    JPanel renderPanel = new JPanel() {
      public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());

        //la magia de renderizado sucederá aquí
        ArrayList<Triangle> tris = new ArrayList();
        tris.add(new Triangle(
            new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(-100, 100, -100),
            Color.WHITE));

        tris.add(new Triangle(
            new Vertex(100, 100, 100),
            new Vertex(-100, -100, 100),
            new Vertex(100, -100, -100),
            Color.RED));

        tris.add(new Triangle(
            new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(100, 100, 100),
            Color.GREEN));

        tris.add(new Triangle(
            new Vertex(-100, 100, -100),
            new Vertex(100, -100, -100),
            new Vertex(-100, -100, 100),
            Color.BLUE));

        g2.translate(getWidth()/2, getHeight()/2);
        g2.setColor(Color.WHITE);
        for(Triangle triangle : tris) {
          Path2D path = new Path2D.Double();
          path.moveTo(triangle.v1.x, triangle.v1.y);
          path.lineTo(triangle.v2.x, triangle.v2.y);
          path.lineTo(triangle.v3.x, triangle.v3.y);
          path.closePath();
          g2.draw(path);
        }
      }
    };
    pane.add(renderPanel, BorderLayout.CENTER);

    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}
