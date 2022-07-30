import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
// import java.awt.Shape;
// import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyButton extends JButton {
    // private Shape shape = null;
    private Color quit = new Color(255, 255, 255);// ��???��

    public MyButton(String s) {
        super(s);
        // addMouseListener(this);
        setContentAreaFilled(false);// �O�_?�ܥ~?�x��?�� ?�_
    }

    public void paintComponent(Graphics g) {
        g.setColor(quit);
        // ��R?���x��?�� �]�i�H?�䥦��?��
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
                20, 20);
        // ��?��b�̦Z �_??���X?
        super.paintComponent(g);
    }

    public void paintBorder(Graphics g) {
        // ??��?��
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
                20, 20);
    }

    public static void main(String[] argv) {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        MyButton btn = new MyButton("����");
        f.setLayout(null);
        btn.setBounds(100, 100, 150, 30);
        f.getContentPane().add(btn, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
