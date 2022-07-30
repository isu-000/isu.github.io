import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class test extends JFrame {
    // mypanle myp;
    mypanle panel = new mypanle();
    JPanel panel2 = new JPanel();
    JLabel label = new JLabel("Hello World");
    // mypanle1 panel1 = new mypanle1();

    public static void main(String args[]) {
        new test();
    }

    test(){
        super();
        label.setBounds(0, 0, 100, 10);
        panel2.setBounds(0, 0, 1015, 100);
        panel2.setBackground(Color.BLACK);
        // myp = new mypanle();
        panel.setLayout(null);
        panel.add(label);
        panel.add(panel2);
        add(panel);
        setSize(1015, 690);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);// set the frame to the center of the screen

    }
}

class mypanle extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        int fieldX = 200;
        int fieldY = 0;
        int fieldWeight = 200;
        int fieldHeight = 300;
        // int fieldX1 = 300;
        // int fieldY1 = 0;
        // int fieldWeight1 = 200;
        // int fieldHeight1 = 300;
        Graphics2D g2d = (Graphics2D) g;
        Color bg = new Color(0, 0, 0, 50);
       // Color bg1 = new Color(100, 100, 0, 50);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 顏色
        g.setColor(bg);
        // 位置
        g.fillRoundRect(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);
        // // 顏色
        // g.setColor(bg1);
        // // 位置
        // g.fillRoundRect(fieldX1, fieldY1, fieldWeight1, fieldHeight1, 20, 20);
        super.paintChildren(g);
    }
}
// class mypanle1 extends JPanel {
// public void paint(Graphics g) {
// super.paint(g);
// int fieldX1 = 300;
// int fieldY1 = 0;
// int fieldWeight1 = 200;
// int fieldHeight1 = 300;
// Graphics2D g2d = (Graphics2D) g;
// Color bg = new Color(0, 0, 0, 50);
// g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
// RenderingHints.VALUE_ANTIALIAS_ON);
// g.setColor(bg);
// g.fillRoundRect(fieldX1, fieldY1, fieldWeight1, fieldHeight1, 20, 20);
// super.paintChildren(g);
// }
