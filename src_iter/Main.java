import java.awt.BorderLayout;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import javax.swing.*;
import javax.swing.plaf.SliderUI;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Problème du carrefour - Version itérative");
        CrossRoadsPanel panel = new CrossRoadsPanel();
        CrossRoadsLogic logic = new CrossRoadsLogic();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.repaint();

        while (true)
        {
            logic.step();
            panel.updateGraphicsFromLogic(logic.getCells());
            panel.repaint();
            frame.repaint();
            frame.pack();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}