import javax.swing.*;
import java.awt.*;

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
      }
    };
    pane.add(renderPanel, BorderLayout.CENTER);

    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}
