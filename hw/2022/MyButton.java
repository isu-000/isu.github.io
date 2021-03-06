import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
// import java.awt.Shape;
// import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyButton extends JButton {
    // private Shape shape = null;
    private Color quit = new Color(255, 255, 255);// 离???色

    public MyButton(String s) {
        super(s);
        // addMouseListener(this);
        setContentAreaFilled(false);// 是否?示外?矩形?域 ?否
    }

    public void paintComponent(Graphics g) {
        g.setColor(quit);
        // 填充?角矩形?域 也可以?其它的?形
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
                20, 20);
        // 必?放在最后 否??不出?
        super.paintComponent(g);
    }

    public void paintBorder(Graphics g) {
        // ??界?域
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
                20, 20);
    }

    public static void main(String[] argv) {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        MyButton btn = new MyButton("按我");
        f.setLayout(null);
        btn.setBounds(100, 100, 150, 30);
        f.getContentPane().add(btn, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
