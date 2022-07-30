import javax.swing.*; // for JFrame, JPanel, JLabel, JTextField, JButton, JOptionPane
import java.awt.*;// for BorderLayout, GridLayout, FlowLayout, Dimension
import java.io.BufferedReader;// for BufferedReader
import java.io.BufferedWriter;// for BufferedWriter
import java.io.File;// for File
import java.io.FileInputStream;// for FileInputStream
import java.io.FileReader;// for FileReader
import java.io.FileWriter;// for FileWriter
import java.io.IOException;// for IOException
import java.io.InputStreamReader;// for InputStreamReader
import java.io.LineNumberReader;// for LineNumberReader
import java.awt.Graphics;

public class Register extends JFrame {
    JPanel RegisterPanel = new JPanel();// create a new RegisterPanel
    JPanel LoginPanel = new JPanel();// create a new LoginPanel
    JPanel OtherUserPanel = new JPanel();// create a new OtherUserPanel
    mypanle panel = new mypanle();

    JLabel UserName = new JLabel("�m�W");// create a new UserName label
    JLabel Sex = new JLabel("�ʧO");// create a new Sex label
    JLabel CreateUserName = new JLabel("�s�W�ϥΪ�");// create a new CreateUserName label
    JLabel OtherUserName = new JLabel("�ϥΨ�L�����n�J");//creat e a new OtherUserName label

    static JLabel User1 = new JLabel();// create a new User1 label
    static JLabel User2 = new JLabel();// create a new User2 label
    static JLabel User3 = new JLabel();// create a new User3 label
    static JLabel User4 = new JLabel();// create a new User4 label
    static JLabel User5 = new JLabel();// create a new User5 label
    static JLabel User6 = new JLabel();// create a new User6 label
    static JLabel LoginLabel = new JLabel();// create a new Login label

    JTextField UserNameTextField = new JTextField();// create a new UserName TextField
    JTextField SexTextField = new JTextField();// create a new Sex TextField

    JButton RegisterButton = new JButton("Register");// create a new Register Button

    Color color = new Color(112, 135, 163);// create a new color ���Ŧ�

    Font font = new Font("�L�n������", Font.BOLD, 26); // create a new font
    Font font1 = new Font("�L�n������", Font.BOLD, 20); // create a new font

    Register() {
        super();

        UserName.setBounds(250, 150, 70, 50);// set the bounds of the Username label
        UserName.setFont(font);// set the font of the Username label

        UserNameTextField.setBounds(350, 150, 200, 50);// set the bounds of the UserName TextField
        UserNameTextField.setFont(font);// set the font of the UserName TextField

        Sex.setBounds(250, 250, 70, 50);// set the bounds of the Sex label
        Sex.setFont(font);// set the font of the Sex label

        SexTextField.setBounds(350, 250, 200, 50);// set the bounds of the Sex TextField
        SexTextField.setFont(font);// set the font of the Sex TextField

        RegisterButton.setBounds(350, 350, 150, 50);// set the bounds of the Login Button
        RegisterButton.setFont(font);// set the font of the Login Button

        RegisterPanel.setBounds(0, 0, 1015, 690);// set the bounds of the RegisterPanel
        RegisterPanel.setBackground(color);// set the background color of the RegisterPanel
        RegisterPanel.setVisible(false);// set the visibility of the RegisterPanel to false
        RegisterPanel.setLayout(null);// set the layout of the RegisterPanel

        LoginPanel.setBounds(0, 0, 1015, 690);// set the bounds of the LoginPanel
        LoginPanel.setBackground(color);// set the background color of the LoginPanel
        LoginPanel.setLayout(null);// set the layout of the LoginPanel
        LoginPanel.setVisible(false);// set the visibility of the LoginPanel to true

        LoginLabel.setBounds(400, 250, 150, 50);// set the bounds of the LoginLabel
        LoginLabel.setFont(font);// set the font of the LoginLabel
        LoginLabel.setOpaque(true);// set the opaque of the LoginLabel
        LoginLabel.setBackground(Color.YELLOW);// set the background color of the LoginLabel
        LoginLabel.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the LoginLabel
        LoginLabel.setVisible(false);// set the visibility of the LoginLabel to false

        CreateUserName.setBounds(525, 350, 100, 50);// set the bounds of the LoginLabel
        CreateUserName.setFont(font1);// set the font of the LoginLabel
        CreateUserName.setForeground(Color.WHITE);// set the foreground color of the LoginLabel
        CreateUserName.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the LoginLabel
        CreateUserName.setVisible(false);// set the visibility of the LoginLabel to false

        OtherUserName.setBounds(300, 350, 170, 50);// set the bounds of the LoginLabel
        OtherUserName.setFont(font1);// set the font of the LoginLabel
        OtherUserName.setForeground(Color.WHITE);// set the foreground color of the LoginLabel
        OtherUserName.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the LoginLabel
        OtherUserName.setVisible(false);// set the visibility of the LoginLabel to false

        OtherUserPanel.setBounds(0, 0, 1015, 690);// set the bounds of the OtherUserPanel
        OtherUserPanel.setBackground(color);// set the background color of the OtherUserPanel
        OtherUserPanel.setLayout(null);// set the layout of the OtherUserPanel
        OtherUserPanel.setVisible(false);// set the visibility of the OtherUserPanel to false

        User1.setBounds(200, 250, 150, 50);// set the bounds of the User1
        User1.setFont(font);// set the font of the User1
        User1.setOpaque(true);// set the opaque of the User1
        User1.setBackground(Color.YELLOW);// set the background color of the User1
        User1.setVisible(false);// set the visibility of the User1 to false
        User1.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the User1

        User2.setBounds(400, 250, 150, 50);// set the bounds of the User2
        User2.setFont(font);// set the font of the User2
        User2.setOpaque(true);// set the opaque of the User2
        User2.setBackground(Color.YELLOW);// set the background color of the User2
        User2.setVisible(false);// set the visibility of the User2 to false
        User2.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the User2

        User3.setBounds(600, 250, 150, 50);// set the bounds of the User3
        User3.setFont(font);// set the font of the User3
        User3.setOpaque(true);// set the opaque of the User3
        User3.setBackground(Color.YELLOW);// set the background color of the User3
        User3.setVisible(false);// set the visibility of the User3 to false
        User3.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the User3

        User4.setBounds(200, 350, 150, 50);// set the bounds of the User4
        User4.setFont(font);// set the font of the User4
        User4.setOpaque(true);// set the opaque of the User4
        User4.setBackground(Color.YELLOW);// set the background color of the User4
        User4.setVisible(false);// set the visibility of the User4 to false
        User4.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the User4

        User5.setBounds(400, 350, 150, 50);// set the bounds of the User5
        User5.setFont(font);// set the font of the User5
        User5.setOpaque(true);// set the opaque of the User5
        User5.setBackground(Color.YELLOW);// set the background color of the User5
        User5.setVisible(false);// set the visibility of the User5 to false
        User5.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the User5

        User6.setBounds(600, 350, 150, 50);// set the bounds of the User6
        User6.setFont(font);// set the font of the User6
        User6.setOpaque(true);// set the opaque of the User6
        User6.setBackground(Color.YELLOW);// set the background color of the User6
        User6.setVisible(false);// set the visibility of the User6 to false
        User6.setHorizontalAlignment(JLabel.CENTER);// set the horizontal alignment of the User6

        LoginPanel.add(LoginLabel);// add the LoginLabel to the LoginPanel
        LoginPanel.add(CreateUserName);// add the CreateUserName to the LoginPanel
        LoginPanel.add(OtherUserName);// add the CreateUserName to the OtherUserName
        LoginPanel.add(panel);

        RegisterPanel.add(UserName);// add the Username to the panel
        RegisterPanel.add(Sex);// add the Sex to the panel
        RegisterPanel.add(UserNameTextField);// add the UserNameTextField to the panel
        RegisterPanel.add(SexTextField);// add the SexTextField to the panel
        RegisterPanel.add(RegisterButton);// add the LoginButton to the panel


        OtherUserPanel.add(User1);// add the User1 to the OtherUserPanel
        OtherUserPanel.add(User2);// add the User2 to the OtherUserPanel
        OtherUserPanel.add(User3);// add the User3 to the OtherUserPanel
        OtherUserPanel.add(User4);// add the User4 to the OtherUserPanel
        OtherUserPanel.add(User5);// add the User5 to the OtherUserPanel
        OtherUserPanel.add(User6);// add the User6 to the OtherUserPanel

        add(RegisterPanel);// add the RegisterPanel to the frame
        add(LoginPanel);// add the LoginPanel to the frame
        add(OtherUserPanel);// add the OtherUserPanel to the frame
        setLayout(null);// set layout to null
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the window when the user clicks the close button
        setSize(1015, 690);// set frame size
        setLocationRelativeTo(null);// set the frame to the center of the screen
        // Frame.setVisible(true);
        setResizable(false);// set the frame to not be resizable
    }

    

    public void Write() throws Exception { // write the data to the file

        FileWriter fos = new FileWriter("register.txt", true);// create a new FileWriter
        BufferedWriter writer = new BufferedWriter(fos);// create a new BufferedWriter
        String UserNameString = UserNameTextField.getText() + " " + SexTextField.getText(); // create a new string
        writer.write(UserNameString);// write the UserNameString to the file
        writer.newLine();// write a new line
        writer.close();// close the BufferedWriter
    }

    public void LoginWrite() throws Exception { // write the data to the file

        FileWriter fos = new FileWriter("Login.txt");// create a new FileWriter
        BufferedWriter writer = new BufferedWriter(fos);// create a new BufferedWriter
        String UserNameString = UserNameTextField.getText() + " " + SexTextField.getText(); // create a new string
        writer.write(UserNameString);// write the UserNameString to the file
        writer.newLine();// write a new line
        writer.close();// close the BufferedWriter
    }

    public void Read() throws IOException {// read the data from the file
        FileReader fis = new FileReader("register.txt");// create a new FileReader
        BufferedReader br = new BufferedReader(fis);// create a new BufferedReader
        while (true) {// while true
            String line = br.readLine();// read a line
            if (line == null) {// if the line is null
                RegisterPanel.setVisible(true);// set the RegisterPanel to visible
                LoginPanel.setVisible(false);// set the LoginPanel to not be visible
                break;
            }
            LoginPanel.setVisible(true);// set the LoginPanel to visible
            RegisterPanel.setVisible(false);// set the RegisterPanel to not be visible
            readLineVarFile(("D://hw//Login.txt"), 1); // Ū���ƾڮw
            break;// break the loop
            // System.out.println(line);// print the line
        }
        br.close();// close the BufferedReader
    }

    public void ReadLine() throws IOException { // read the data from the file
        File file = new File("D:\\hw\\register.txt");// create a new File
        if (file.exists()) {// if the file exists
            long fileLength = file.length();// get the file length
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));// create a new
            lineNumberReader.skip(fileLength);// skip the file length
            int lines = lineNumberReader.getLineNumber();// get the line number
            if (lines == 1) {
                User1.setVisible(true);// set the User1 to visible
                readLineVarFile1(("D://hw//register.txt"), 1); // Ū���ƾڮw
            }
            if (lines == 2) {
                User1.setVisible(true);// set the User1 to visible
                User2.setVisible(true);// set the User2 to visible
                readLineVarFile1(("D://hw//register.txt"), 1); // Ū���ƾڮw
                readLineVarFile2(("D://hw//register.txt"), 2); // Ū���ƾڮw

            }
            if (lines == 3) {
                User1.setVisible(true);// set the User1 to visible
                User2.setVisible(true);// set the User2 to visible
                User3.setVisible(true);// set the User3 to visible
                readLineVarFile1(("D://hw//register.txt"), 1); // Ū���ƾڮw
                readLineVarFile2(("D://hw//register.txt"), 2); // Ū���ƾڮw
                readLineVarFile3(("D://hw//register.txt"), 3); // Ū���ƾڮw

            }
            if (lines == 4) {
                User1.setVisible(true);// set the User1 to visible
                User2.setVisible(true);// set the User2 to visible
                User3.setVisible(true);// set the User3 to visible
                User4.setVisible(true);// set the User4 to visible
                readLineVarFile1(("D://hw//register.txt"), 1); // Ū���ƾڮw
                readLineVarFile2(("D://hw//register.txt"), 2); // Ū���ƾڮw
                readLineVarFile3(("D://hw//register.txt"), 3); // Ū���ƾڮw
                readLineVarFile4(("D://hw//register.txt"), 4); // Ū���ƾڮw

            }
            if (lines == 5) {
                User1.setVisible(true);// set the User1 to visible
                User2.setVisible(true);// set the User2 to visible
                User3.setVisible(true);// set the User3 to visible
                User4.setVisible(true);// set the User4 to visible
                User5.setVisible(true);// set the User5 to visible
                readLineVarFile1(("D://hw//register.txt"), 1); // Ū���ƾڮw
                readLineVarFile2(("D://hw//register.txt"), 2); // Ū���ƾڮw
                readLineVarFile3(("D://hw//register.txt"), 3); // Ū���ƾڮw
                readLineVarFile4(("D://hw//register.txt"), 4); // Ū���ƾڮw
                readLineVarFile5(("D://hw//register.txt"), 5); // Ū���ƾڮw

            }
            if (lines == 6) {
                User1.setVisible(true);// set the User1 to visible
                User2.setVisible(true);// set the User2 to visible
                User3.setVisible(true);// set the User3 to visible
                User4.setVisible(true);// set the User4 to visible
                User5.setVisible(true);// set the User5 to visible
                User6.setVisible(true);// set the User6 to visible
                readLineVarFile1(("D://hw//register.txt"), 1); // Ū���ƾڮw
                readLineVarFile2(("D://hw//register.txt"), 2); // Ū���ƾڮw
                readLineVarFile3(("D://hw//register.txt"), 3); // Ū���ƾڮw
                readLineVarFile4(("D://hw//register.txt"), 4); // Ū���ƾڮw
                readLineVarFile5(("D://hw//register.txt"), 5); // Ū���ƾڮw
                readLineVarFile6(("D://hw//register.txt"), 6); // Ū���ƾڮw
            }
            // System.out.println(lines);// print the total number of lines
            lineNumberReader.close();// close the LineNumberReader
        } else {
            System.out.println("File does not exists!");
        }
    }

    static int getTotalLines(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        LineNumberReader reader = new LineNumberReader(br);
        String s = reader.readLine(); // �w�q���
        int lines = 0;
        while (s != null) // �T�w���
        {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        br.close();
        return lines; // ��^���
    }

    static void readLineVarFile(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        String line = reader.readLine(); // �w�q���
        String[] s = new String[1];
        if (lineNumber <= 0 || lineNumber > getTotalLines(fileName)) // �T�w��J����ƬO�_�����e
        {
            System.out.println("���b�ɮת���ƽd�򤧤��C"); 
        }
        int num = 0;
        while (line != null) // ���Ƥ����ŮɡA��X�Ӧ椺�e�Φr����
        {
            if (lineNumber == ++num) {
                // System.out.println(line);// ��X�Ӧ椺�e
                s = line.split(" ");// �N�Ӧ椺�e���Φ��r����
                LoginLabel.setText(s[0]);// ��X�Ĥ@�Ӧr����
                // System.out.println(s[1]);// ��X�ĤG�Ӧr����
            }
            line = reader.readLine();
        }
        reader.close();
    }

    static void readLineVarFile1(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        String line = reader.readLine(); // �w�q���
        String[] s = new String[1];
        if (lineNumber <= 0 || lineNumber > getTotalLines(fileName)) // �T�w��J����ƬO�_�����e
        {
            System.out.println("���b�ɮת���ƽd�򤧤��C"); 
        }
        int num = 0;
        while (line != null) // ���Ƥ����ŮɡA��X�Ӧ椺�e�Φr����
        {
            if (lineNumber == ++num) {
                // System.out.println(line);// ��X�Ӧ椺�e
                s = line.split(" ");// �N�Ӧ椺�e���Φ��r����
                User1.setText(s[0]);// ��X�Ĥ@�Ӧr����
                // System.out.println(s[1]);// ��X�ĤG�Ӧr����
            }
            line = reader.readLine();
        }
        reader.close();
    }

    static void readLineVarFile2(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        String line = reader.readLine(); // �w�q���
        String[] s = new String[1];
        if (lineNumber <= 0 || lineNumber > getTotalLines(fileName)) // �T�w��J����ƬO�_�����e
        {
            System.out.println("���b�ɮת���ƽd�򤧤��C"); 
        }
        int num = 0;
        while (line != null) // ���Ƥ����ŮɡA��X�Ӧ椺�e�Φr����
        {
            if (lineNumber == ++num) {
                // System.out.println(line);// ��X�Ӧ椺�e
                s = line.split(" ");// �N�Ӧ椺�e���Φ��r����
                User2.setText(s[0]);// ��X�Ĥ@�Ӧr����
                // System.out.println(s[1]);// ��X�ĤG�Ӧr����
            }
            line = reader.readLine();
        }
        reader.close();
    }

    static void readLineVarFile3(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        String line = reader.readLine(); // �w�q���
        String[] s = new String[1];
        if (lineNumber <= 0 || lineNumber > getTotalLines(fileName)) // �T�w��J����ƬO�_�����e
        {
            System.out.println("���b�ɮת���ƽd�򤧤��C"); 
        }
        int num = 0;
        while (line != null) // ���Ƥ����ŮɡA��X�Ӧ椺�e�Φr����
        {
            if (lineNumber == ++num) {
                // System.out.println(line);// ��X�Ӧ椺�e
                s = line.split(" ");// �N�Ӧ椺�e���Φ��r����
                User3.setText(s[0]);// ��X�Ĥ@�Ӧr����
                // System.out.println(s[1]);// ��X�ĤG�Ӧr����
            }
            line = reader.readLine();
        }
        reader.close();
    }

    static void readLineVarFile4(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        String line = reader.readLine(); // �w�q���
        String[] s = new String[1];
        if (lineNumber <= 0 || lineNumber > getTotalLines(fileName)) // �T�w��J����ƬO�_�����e
        {
            System.out.println("���b�ɮת���ƽd�򤧤��C"); 
        }
        int num = 0;
        while (line != null) // ���Ƥ����ŮɡA��X�Ӧ椺�e�Φr����
        {
            if (lineNumber == ++num) {
                // System.out.println(line);// ��X�Ӧ椺�e
                s = line.split(" ");// �N�Ӧ椺�e���Φ��r����
                User4.setText(s[0]);// ��X�Ĥ@�Ӧr����
                // System.out.println(s[1]);// ��X�ĤG�Ӧr����
            }
            line = reader.readLine();
        }
        reader.close();
    }

    static void readLineVarFile5(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        String line = reader.readLine(); // �w�q���
        String[] s = new String[1];
        if (lineNumber <= 0 || lineNumber > getTotalLines(fileName)) // �T�w��J����ƬO�_�����e
        {
            System.out.println("���b�ɮת���ƽd�򤧤��C"); 
        }
        int num = 0;
        while (line != null) // ���Ƥ����ŮɡA��X�Ӧ椺�e�Φr����
        {
            if (lineNumber == ++num) {
                // System.out.println(line);// ��X�Ӧ椺�e
                s = line.split(" ");// �N�Ӧ椺�e���Φ��r����
                User5.setText(s[0]);// ��X�Ĥ@�Ӧr����
                // System.out.println(s[1]);// ��X�ĤG�Ӧr����
            }
            line = reader.readLine();
        }
        reader.close();
    }

    static void readLineVarFile6(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); // �ϥνw�İϪ���k�N���Ū�J��w�İϤ�
        String line = reader.readLine(); // �w�q���
        String[] s = new String[1];
        if (lineNumber <= 0 || lineNumber > getTotalLines(fileName)) // �T�w��J����ƬO�_�����e
        {
            System.out.println("���b�ɮת���ƽd�򤧤��C"); 
        }
        int num = 0;
        while (line != null) // ���Ƥ����ŮɡA��X�Ӧ椺�e�Φr����
        {
            if (lineNumber == ++num) {
                // System.out.println(line);// ��X�Ӧ椺�e
                s = line.split(" ");// �N�Ӧ椺�e���Φ��r����
                User6.setText(s[0]);// ��X�Ĥ@�Ӧr����
                // System.out.println(s[1]);// ��X�ĤG�Ӧr����
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public void CreateFile() throws IOException { // create a new file
        // �p�G�䤣���ɮ�
        if (!new File("register.txt").exists()) {
            FileWriter file = new FileWriter("register.txt"); // create a new FileWriter
            file.close(); // close the FileWriter
        }
        if (!new File("Login.txt").exists()) {
            FileWriter file = new FileWriter("Login.txt"); // create a new FileWriter
            file.close(); // close the FileWriter
        }
    }
}
class mypanle extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        int fieldX = 50;
        int fieldY = 0;
        int fieldWeight = 200;
        int fieldHeight = 300;
        Graphics2D g2d = (Graphics2D) g;
        Color bg = new Color(0, 0, 0, 50);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(bg); // �C��
        g.fillRoundRect(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20); // ��m
        super.paintChildren(g);
    }
}