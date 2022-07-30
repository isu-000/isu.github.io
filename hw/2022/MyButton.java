import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
// import java.awt.Shape;
// import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyButton extends JButton {
    // private Shape shape = null;
    private Color quit = new Color(255, 255, 255);// 置???︹

    public MyButton(String s) {
        super(s);
        // addMouseListener(this);
        setContentAreaFilled(false);// 琌?ボ?痻?办 ?
    }

    public void paintComponent(Graphics g) {
        g.setColor(quit);
        // 恶?à痻?办 ?ㄤウ?
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
                20, 20);
        // ゲ?程 ??ぃ?
        super.paintComponent(g);
    }

    public void paintBorder(Graphics g) {
        // ???办
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
                20, 20);
    }

    public static void main(String[] argv) {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        MyButton btn = new MyButton("и");
        f.setLayout(null);
        btn.setBounds(100, 100, 150, 30);
        f.getContentPane().add(btn, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
