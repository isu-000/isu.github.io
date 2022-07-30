
//#region import*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.TooManyListenersException;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

//import java.awt.event.ActionListener;
//import java.io.OutputStream;
//#endregion
class SerialBean implements SerialPortEventListener {
  private static String PortName;
  private static CommPortIdentifier portId;
  private static SerialPort serialPort;
  private static InputStream in;
  // private static OutputStream out;
  public static int baud = 9600;
  private static int x = 0;// x�O�ΨӪ�l�ƶi�ױ� nub
  private static double xynumber = 0;// ��l�Ƨ�u��Y�y��
  private static boolean DataGate;// �ƾڹh��
  private static boolean StartButton = true;// �}�l���s�h��
  private static int CalculateNumberMeasurements = 0;// �p����q����
  private static int box = 14;// �@�}�l�W��ʺA������m(715,0)
  private static int panle = 0;// �@�}�l���O��m(0,0)
  private static int panle2 = -1920;// ���ʫ᭱�O��m(-1920,0)
  private static int connectBlickLinePanel = 715;// �@�}�l�W��ʺA������m(715,0)

  public SerialBean(String com, int baud) {
    SerialBean.PortName = com;
    SerialBean.baud = baud;
  }

  Cfront cfront = new Cfront();
  Register register = new Register();

  SerialBean() {
    try {
      register.CreateFile();
      register.Read();
    } catch (IOException e) {
      e.printStackTrace();
    }
    cfront.startbutton.addMouseListener(new CMouseAdap());// �}�l���q���s��ť
    cfront.ChangeStartButton.addMouseListener(new CMouseAdap());// �洫�}�l���q���s��ť
    cfront.againbutton.addMouseListener(new CMouseAdap());// ���s���q���s��ť
    cfront.stopbutton.addMouseListener(new CMouseAdap());// ������q���s��ť
    cfront.isulinkbutton.addMouseListener(new CMouseAdap());// �s�����s��ť
    cfront.closebutton.addMouseListener(new CMouseAdap());// �����������s��ť
    cfront.minusbutton.addMouseListener(new CMouseAdap());// �̤p�Ƶ������s��ť
    cfront.AnalyzeLabel.addMouseListener(new CMouseAdap());// �g�ߤ��R���Һ�ť
    cfront.MeridianLabel.addMouseListener(new CMouseAdap());// �g�ߴ��q���Һ�ť
    register.RegisterButton.addMouseListener(new CMouseAdap());// ���U���s��ť
    register.CreateUserName.addMouseListener(new CMouseAdap());// �إ߱b�����s��ť
    register.OtherUserName.addMouseListener(new CMouseAdap());// ��L�b�����s��ť

    Register.User1.addMouseListener(new CMouseAdap());// �b��1���s��ť
    Register.User2.addMouseListener(new CMouseAdap());// �b��2���s��ť
    Register.User3.addMouseListener(new CMouseAdap());// �b��3���s��ť
    Register.User4.addMouseListener(new CMouseAdap());// �b��4���s��ť
    Register.User5.addMouseListener(new CMouseAdap());// �b��5���s��ť
    Register.User6.addMouseListener(new CMouseAdap());// �b��6���s��ť
    Register.LoginLabel.addMouseListener(new CMouseAdap());// �n�J���s��ť

    //cfront.setVisible(true);
    register.setVisible(true);

  }

  // ========================================================================
  // ���񭵼֤�k
  public void playmusic() {
    File file = new File("D://hw//musics//DataGate1s.mp3");
    Player player;
    try {
      player = new Player(new FileInputStream(file));
      player.play();// ���񭵼�
    } catch (FileNotFoundException | JavaLayerException e) {
      e.printStackTrace();
    }
    // player.close();//�����
  }
  // ========================================================================

  class CMouseAdap extends MouseAdapter {
    // ========================================================================
    // �z�LURL �s���~������
    public void mouseEntered(MouseEvent e) {
      if (e.getSource() == cfront.startbutton) {
        cfront.startbutton.setFont(cfront.font2);
        
      }

      if (e.getSource() == cfront.ChangeStartButton) {
        cfront.ChangeStartButton.setFont(cfront.font2);
      }
      if (e.getSource() == cfront.stopbutton) {
        cfront.stopbutton.setFont(cfront.font2);
      }
      if (e.getSource() == cfront.againbutton) {
        cfront.againbutton.setFont(cfront.font2);
      }
      if (e.getSource() == cfront.MeridianLabel) {
        cfront.MeridianLabel.setFont(cfront.font2);
      }
      if (e.getSource() == cfront.AnalyzeLabel) {
        cfront.AnalyzeLabel.setFont(cfront.font2);
      }
      if (e.getSource() == cfront.closebutton) {
        cfront.closebutton.setOpaque(true);
        cfront.closebutton.setBackground(Color.RED);
      }
      if (e.getSource() == cfront.minusbutton) {
        cfront.minusbutton.setOpaque(true);
        cfront.minusbutton.setBackground(new Color(241, 241, 241));
      }
    }

    public void mouseExited(MouseEvent e) {
      if (e.getSource() == cfront.startbutton) {
        cfront.startbutton.setFont(cfront.font1);
      }
      if (e.getSource() == cfront.ChangeStartButton) {
        cfront.ChangeStartButton.setFont(cfront.font1);
      }
      if (e.getSource() == cfront.stopbutton) {
        cfront.stopbutton.setFont(cfront.font1);
      }
      if (e.getSource() == cfront.againbutton) {
        cfront.againbutton.setFont(cfront.font1);
      }
      if (e.getSource() == cfront.MeridianLabel) {
        cfront.MeridianLabel.setFont(cfront.font1);
      }
      if (e.getSource() == cfront.AnalyzeLabel) {
        cfront.AnalyzeLabel.setFont(cfront.font1);
      }
      if (e.getSource() == cfront.closebutton) {
        cfront.closebutton.setBackground(null);
      }
      if (e.getSource() == cfront.minusbutton) {
        cfront.minusbutton.setBackground(null);
      }

    }

    public void mousePressed(MouseEvent e) {
      if (e.getSource() == cfront.isulinkbutton) {
        try {
          Desktop.getDesktop().browse(new URL("https://www.isu.edu.tw/2018/homepage_v01.php?dept_mno=652").toURI());
        } catch (Exception a) {
          JOptionPane.showMessageDialog(null, e);
        }
      }

      if (e.getSource() == cfront.AnalyzeLabel) {
        Thread paneThread = new Thread() {
          public void run() {
            if (panle < 1920) {
              cfront.startbutton.setVisible(false);
              cfront.stopbutton.setVisible(false);
              cfront.againbutton.setVisible(false);
              cfront.ChangeStartButton.setVisible(false);
              while (panle < 1920) {
                try {
                  connectBlickLinePanel = connectBlickLinePanel + 15;
                  panle = panle + 192;
                  panle2 = panle2 + 192;
                  cfront.BlackPanel.setLocation(panle, 130);
                  cfront.box2Panel.setLocation(panle2, 130);// �������O
                  cfront.connectBlickLinePanel.setLocation(connectBlickLinePanel, 0);// �������O
                  Thread.sleep(5);
                  // cfront.BlackPanel.setLocation(1920, 0);
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            }

          }
        };
        paneThread.start();

      }
      // ========================================================================
      if (e.getSource() == cfront.MeridianLabel) {
        Thread pane1Thread = new Thread() {

          public void run() {
            if (panle > 0) {
              cfront.startbutton.setVisible(true);
              cfront.stopbutton.setVisible(true);
              cfront.againbutton.setVisible(true);
              while (panle > 0) {
                try {
                  connectBlickLinePanel = connectBlickLinePanel - 15;
                  panle = panle - 192;
                  panle2 = panle2 - 192;
                  cfront.BlackPanel.setLocation(panle, 130);
                  cfront.box2Panel.setLocation(panle2, 130);// �������O
                  cfront.connectBlickLinePanel.setLocation(connectBlickLinePanel, 0);// �������O
                  Thread.sleep(5);
                  // cfront.BlackPanel.setLocation(1920, 0);
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            }

          }
        };
        pane1Thread.start();

      }
      // ========================================================================

      if (e.getSource() == cfront.closebutton) {// �������s
        System.exit(0);
      }
      if (e.getSource() == cfront.minusbutton) { // �̤p�ƫ��s
        cfront.setExtendedState(JFrame.ICONIFIED);
      }
      // ========================================================================
      if (e.getSource() == cfront.againbutton) {// ���s���q���s
        if (StartButton == true) {
          ClosePort();
          CleanData();// �M���ƾڮ�
          cfront.againbutton.setBackground(new Color(220, 220, 220));
          cfront.stopbutton.setBackground(new Color(220, 220, 220));
          cfront.startbutton.setVisible(true);
          cfront.ChangeStartButton.setVisible(false);
          cfront.imagelabel.setIcon(null);
          cfront.jProgressBar.setValue(0);
        }
      }
      if (e.getSource() == cfront.stopbutton) {// ������q���s
        Thread StopThread = new Thread() {
          public void run() {
            // ������J��f
            ClosePort();
            cfront.stopbutton.setBackground(new Color(220, 220, 220));// �ⰱ����q���s�I���ܦǦ�N���i�H�ϥ�
            cfront.startbutton.setVisible(true);// ���\��}�l���s���q���
            cfront.ChangeStartButton.setVisible(false);// �S�\��洫�}�l���s���q����
          }
        };
        StopThread.start();
      }
      if (e.getSource() == cfront.startbutton) { // �}�l���q���s
        cfront.startbutton.setVisible(false);// ���ö}�l���q���s
        cfront.ChangeStartButton.setVisible(true);// ��S�Υ\�઺�洫�}�l���q���s���
        cfront.stopbutton.setBackground(Color.RED);// �ⰱ����q���s�I���ܬ���N��i�H�ϥ�
        cfront.againbutton.setBackground(new Color(61, 145, 64));// �⭫�s���q���s�ܦ����N��i�H�ϥ�
        cfront.jProgressBar.setIndeterminate(true);
        Thread t = new Thread() {
          public void run() {
            Initialize(); // �Ұ�rxtx
            if (StartButton == true) {
              if (cfront.imagelabel.getIcon() == (null)) {
                CleanData();// �M�żƾڮ�
                cfront.imagelabel.setIcon(cfront.imageIcons[0]);
                cfront.datatJTextFields[1].setBackground(new Color(96, 113, 163));
                cfront.datatJTextFields[1].setForeground(Color.white);
                cfront.datatJTextFields[13].setBackground(new Color(96, 113, 163));
                cfront.datatJTextFields[13].setForeground(Color.white);
                cfront.datatJTextFields[14].setBackground(new Color(238, 243, 210));
              }
            }
          }
        };
        t.start();
        // ========================================================================
        PhotoReturn();
      }
      if (e.getSource() == register.RegisterButton) { // ���U���s
        try {
          register.Write(); // �g�J�ƾڮw
          register.LoginWrite(); // �g�J�n���ƾڮw
          register.setVisible(false);
          cfront.setVisible(true);
          // register.Read(); // Ū���ƾڮw
          // register.ReadLine(); // Ū���ƾڮw
          // Register.readLineVarFile(("D://hw//register.txt"), 1); // Ū���ƾڮw
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.LoginLabel) { // �n�����s
        try {
          register.setVisible(false);
          cfront.setVisible(true);
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == register.CreateUserName) { // �إߥΤ�W���s
        try {
          register.RegisterPanel.setVisible(true);// ��ܵ��U���O
          register.LoginPanel.setVisible(false);// ���õn�����O
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == register.OtherUserName) { // ��L�Τ�W���s
        try {
          register.OtherUserPanel.setVisible(true);// ��ܵ��U���O
          register.LoginPanel.setVisible(false);// ���õn�����O
          register.ReadLine(); // Ū���ƾڮw
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User1) { // �Τ�W���s
        try {
          cfront.setVisible(true);// ��ܥD�ɭ�
          register.setVisible(false);// ���õ��U���O
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User2) { // �Τ�W���s
        try {
          cfront.setVisible(true);// ��ܥD�ɭ�
          register.setVisible(false);// ���õ��U���O
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User3) { // �Τ�W���s
        try {
          cfront.setVisible(true);// ��ܥD�ɭ�
          register.setVisible(false);// ���õ��U���O
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User4) { // �Τ�W���s
        try {
          cfront.setVisible(true);// ��ܥD�ɭ�
          register.setVisible(false);// ���õ��U���O
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User5) { // �Τ�W���s
        try {
          cfront.setVisible(true);// ��ܥD�ɭ�
          register.setVisible(false);// ���õ��U���O
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User6) { // �Τ�W���s
        try {
          cfront.setVisible(true);// ��ܥD�ɭ�
          register.setVisible(false);// ���õ��U���O
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
  }

  // ��l�Ʀ�f�A�N��J�y��^�Ω�ƥ�Ū��
  public void Initialize() {
    try {
      portId = CommPortIdentifier.getPortIdentifier(PortName);
      // �ѹ�H���}��f�A�ì���f�R�W
      serialPort = (SerialPort) portId.open("JAVA_SERIAL", 2000);
      // �`�U�@��SerialPortEventListener�ƥ�Ӻ�ť��f�ƥ�
      serialPort.addEventListener(this);
      // �ƾڥi�ΫhĲ�o�ƥ�
      serialPort.notifyOnDataAvailable(true);
      // ���}��J��X�y
      in = serialPort.getInputStream();
      // out = serialPort.getOutputStream();
      // �]�m��f�ѼơA�i�S�v115200�A8��ƾڦ�A1�찱���A�L�_������
      serialPort.setSerialPortParams(baud, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
          SerialPort.PARITY_NONE);

    } catch (PortInUseException e) {
      System.out.println("�Ӧ�f���b�ϥΤ�");
    } catch (NoSuchPortException e) {
      System.out.println("�Ӧ�f��e���i�ϥ�");
    } catch (UnsupportedCommOperationException e) {
      System.out.println("���~����f�Ѽưt�m");
    } catch (TooManyListenersException e) {
      System.out.println("�Ӧ�f�w�s�b��ť��");
    } catch (IOException e) {
      System.out.println("��J��X�y���}����");
    }
  }

  // ������f
  public void ClosePort() {
    serialPort.close();
  }

  // �z�L�ƾڦ��L�[�J�����Ϥ����A�p�G���ƾڥ[�J�N���Ϥ�
  public void PhotoReturn() {
    Thread t2 = new Thread() { // �L�a�j��+�Ϥ��u�{
      public void run() {
        Boolean a = true;
        int i = 14, j = 1, k = 27; // i�O����Ĥ@�Ƽƾ� j�O �Ƽ�
        try {
          while (a) {
            Thread.sleep(15);
            if (i <= 19) {
              if (cfront.datatJTextFields[i].getText().length() > 0) {
                cfront.imagelabel.setIcon(cfront.imageIcons[j]);
                i++;
                j++;

              }
            } else if (k <= 32) {
              if (cfront.datatJTextFields[k].getText().length() > 0) {
                cfront.imagelabel.setIcon(cfront.imageIcons[j]);
                j++;
                k++;

              }
            } else if (i <= 25) {
              if (cfront.datatJTextFields[i].getText().length() > 0) {
                i++;
                cfront.imagelabel.setIcon(cfront.imageIcons[j]);
                j++;

              }
            } else if (k < 39) {
              if (cfront.datatJTextFields[k].getText().length() > 0) {
                k++;
                if (k < 39) {
                  cfront.imagelabel.setIcon(cfront.imageIcons[j]);
                  j++;

                }
              }
            }
            if (cfront.datatJTextFields[38].getText().length() > 0) {
              break;
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        a = true; // {
        i = 14; // �٭��l�ȡA�~�i�H�z�L���s�F��L�a�j��
        j = 1; //
        k = 27; // }
      }
    };
    t2.start();
  }

  // �M�żƾڮ�
  public void CleanData() {
    for (int i = 1; i < 14; i++) { // �M��
      cfront.datatJTextFields[i].setBackground(new Color(174, 217, 232));
      cfront.datatJTextFields[i].setForeground(Color.BLACK);
    }
    for (int i = 14; i < 26; i++) { // �M��
      cfront.datatJTextFields[i].setText("");
      cfront.datatJTextFields[i].setBackground(Color.WHITE);
    }
    for (int i = 27; i < 39; i++) { // �M��
      cfront.datatJTextFields[i].setText("");
      cfront.datatJTextFields[i].setBackground(Color.WHITE);
    }

    StartButton = false;
    x = 0;
    xynumber = 0;
    box = 14;
    cfront.series.clear();
    DataGate = false;
    StartButton = true;
    CalculateNumberMeasurements = 0;
  }

  // ��ť��f�ƥ�
  @Override
  public void serialEvent(SerialPortEvent event) {
    switch (event.getEventType()) {
      case SerialPortEvent.BI:// Break interrupt,�q�T���_
      case SerialPortEvent.OE:// Overrun error�A������~
      case SerialPortEvent.FE:// Framing error�A�ǴV���~
      case SerialPortEvent.PE:// Parity error�A������~
      case SerialPortEvent.CD:// Carrier detect�A���i�˴�
      case SerialPortEvent.CTS:// Clear to send�A�M���o�e
      case SerialPortEvent.DSR:// Data set ready�A�ƾڳ]�ƴN��
      case SerialPortEvent.RI:// Ring indicator�A�T�a����
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:// Output buffer is empty�A��X�w�R�ϲM��
        break;
      case SerialPortEvent.DATA_AVAILABLE:// Data available at the serial port�A�ݤf���i�μƾڡCŪ��w�R�ƲաA��X��׺�
        String r = "";
        int c;
        cfront.jProgressBar.setIndeterminate(false);
        try {
          if (in != null) {
            while (in.available() > 0) {
              c = in.read();
              Character d = new Character((char) c);
              r = r.concat(d.toString());

            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        Double tempName = Double.parseDouble(r);// �Ⱶ���쪺r�r���ഫdouble���A

        /**
         * 1.�P�_�����쪺�ƾڬO�_�p��600
         * 2.�p�G�Ȥp��600�N��ϥΪ̦A���q
         * 3.CalculateNumberMeasurements �O�Ψӭp�ơA�p�G�p�ƨ�10�N�n����
         * 4.�S�����q�N�]�wDataGate = true �}�� ,  DataGat 
         */
        if (tempName <= 600) {
          if (CalculateNumberMeasurements == 10) {
            cfront.datatJTextFields[box].setIcon(null);
            DataGate = false;
          }

        }
        /**
         * 1.�P�_�����쪺�ƾڬO�_�j��600
         * 2.�p�G�Ȥj��600�N��ϥΪ̨S���A���q
         * 3.�p�G CalculateNumberMeasurements ���� �h�}��
         * 4.�S�����q�N�]�wDataGate = true �}�� ,  DataGat 
         */
        if (tempName >= 600) {
          cfront.datatJTextFields[box].setIcon(null);
          DataGate = true;
        }
        /**
         * 1.�ƾڹh�D�}�ҥB�i�ױ��Ȥp��100�B�ƾڤp��600
         * 2.�}�Ұ�����
         * 3.x��l�ƬO0 �̧ǧ��+10
         * 4.xynumber�O��u��y�b�y��0-5 �C���[0.5 ��10�� = 0.5 * 10 = 5
         * 5.����x�Ȥj��100���_������
         * 6.�b��l��x��0,xynumber=0 �F�쭫�_����
         */
        if (x <= 100 && DataGate == true && tempName <= 600) {
          Thread t4 = new Thread() {
            public void run() {
              cfront.datatJTextFields[box].setIcon(cfront.threadimageIcon);
              cfront.jProgressBar.setValue(x);// ��]�w������J�i�ױ�
              x = x + 10;// �]�w0+10���i�ױ�
              cfront.series.add(xynumber, tempName);// �[�Jx.y��
              xynumber = xynumber + 0.5;// xynumber�O��u��y�b�y��0-5 �C���[0.5 ��10�� = 0.5 * 10 = 5
              if (x > 100) {
                cfront.datatJTextFields[box].setIcon(null);
                box = box + 1;
              }
            }
          };
          t4.start();
        } else if (cfront.datatJTextFields[14].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            // �����C��P�ƾڦ�m
            cfront.datatJTextFields[14].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[14].setText(r);
            cfront.datatJTextFields[1].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[1].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[2].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[2].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[15].setBackground(new Color(238, 243, 210));
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[15].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[15].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[15].setText(r);
            cfront.datatJTextFields[2].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[2].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[3].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[3].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[16].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[16].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[16].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[16].setText(r);
            cfront.datatJTextFields[3].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[3].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[4].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[4].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[17].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[17].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[17].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[17].setText(r);
            cfront.datatJTextFields[4].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[4].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[5].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[5].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[18].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[18].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[18].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[18].setText(r);
            cfront.datatJTextFields[5].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[5].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[6].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[6].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[19].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[19].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[19].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[19].setText(r);
            cfront.datatJTextFields[6].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[6].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[1].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[1].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[13].setBackground(cfront.blue);// �٭쥪���~���C��
            cfront.datatJTextFields[13].setForeground(Color.BLACK);// �٭쥪���r���ܦ�
            cfront.datatJTextFields[26].setBackground(new Color(96, 113, 163));// �k���~���C��
            cfront.datatJTextFields[26].setForeground(Color.WHITE);// �k���r���ܦ�
            cfront.datatJTextFields[27].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            box = 27;
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[27].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[27].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[27].setText(r);
            cfront.datatJTextFields[1].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[1].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[2].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[2].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[28].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[28].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[28].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[28].setText(r);
            cfront.datatJTextFields[2].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[2].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[3].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[3].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[29].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[29].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[29].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[29].setText(r);
            cfront.datatJTextFields[3].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[3].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[4].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[4].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[30].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[30].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[30].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[30].setText(r);
            cfront.datatJTextFields[4].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[4].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[5].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[5].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[31].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[31].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[31].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[31].setText(r);
            cfront.datatJTextFields[5].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[5].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[6].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[6].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[32].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[32].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[32].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[32].setText(r);
            cfront.datatJTextFields[6].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[6].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[7].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[7].setBackground(new Color(96, 113, 163));// �~���ܦ�   
            cfront.datatJTextFields[26].setBackground(cfront.blue);// �٭�k���~���C��
            cfront.datatJTextFields[26].setForeground(Color.BLACK);// �٭�k���r���ܦ�
            cfront.datatJTextFields[13].setBackground(new Color(96, 113, 163));// �����~���C��
            cfront.datatJTextFields[13].setForeground(Color.WHITE);// �����r���ܦ�
            cfront.datatJTextFields[20].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            box = 20;
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[20].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[20].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[20].setText(r);
            cfront.datatJTextFields[7].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[7].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[8].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[8].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[21].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[21].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[21].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[21].setText(r);
            cfront.datatJTextFields[8].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[8].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[9].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[9].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[22].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[22].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[22].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[22].setText(r);
            cfront.datatJTextFields[9].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[9].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[10].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[10].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[23].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[23].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[23].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[23].setText(r);
            cfront.datatJTextFields[10].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[10].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[11].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[11].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[24].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[24].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[24].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[24].setText(r);
            cfront.datatJTextFields[11].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[11].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[12].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[12].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[25].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[25].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[25].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[25].setText(r);
            cfront.datatJTextFields[12].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[12].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[7].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[7].setBackground(new Color(96, 113, 163));// �~���ܦ�   
            cfront.datatJTextFields[13].setBackground(cfront.blue);// �٭쥪���~���C��
            cfront.datatJTextFields[13].setForeground(Color.BLACK);// �٭쥪���r���ܦ�
            cfront.datatJTextFields[26].setBackground(new Color(96, 113, 163));// �k���~���C��
            cfront.datatJTextFields[26].setForeground(Color.WHITE);// �k���r���ܦ�
            cfront.datatJTextFields[33].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            box = 33;
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[33].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[33].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[33].setText(r);
            cfront.datatJTextFields[7].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[7].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[8].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[8].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[34].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[34].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[34].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[34].setText(r);
            cfront.datatJTextFields[8].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[8].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[9].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[9].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[35].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[35].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[35].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[35].setText(r);
            cfront.datatJTextFields[9].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[9].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[10].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[10].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[36].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[36].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[36].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[36].setText(r);
            cfront.datatJTextFields[10].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[10].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[11].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[11].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[37].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[37].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[37].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[37].setText(r);
            cfront.datatJTextFields[11].setForeground(Color.BLACK);// �٭�r���ܦ�
            cfront.datatJTextFields[11].setBackground(cfront.blue);// �٭�~���ܦ�
            cfront.datatJTextFields[12].setForeground(Color.WHITE);// �r���ܦ�
            cfront.datatJTextFields[12].setBackground(new Color(96, 113, 163));// �~���ܦ�
            cfront.datatJTextFields[38].setBackground(new Color(238, 243, 210));// ���q�ɭI����
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            cfront.series.clear();
            DataGate = false;
            CalculateNumberMeasurements = 0;
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else if (cfront.datatJTextFields[38].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            cfront.datatJTextFields[38].setBackground(Color.WHITE);// �٭���q�I����
            cfront.datatJTextFields[38].setText(r);
            cfront.datatJTextFields[12].setBackground(cfront.blue);// �٭�~��
            cfront.datatJTextFields[12].setForeground(Color.BLACK);// �٭�r��
            cfront.datatJTextFields[26].setBackground(cfront.blue);// �٭�k���~��
            cfront.datatJTextFields[26].setForeground(Color.BLACK);// �٭�k���r��
            cfront.jProgressBar.setValue(0);
            x = 0;
            xynumber = 0;
            box = 14;
            cfront.series.clear();
            DataGate = false;
            StartButton = true;
            CalculateNumberMeasurements = 0;
            cfront.imagelabel.setIcon(null);
            JOptionPane.showMessageDialog(null, "plete the measuremenmeasurement");
            Thread.sleep(5);
            Thread t1 = new Thread() {

              public void run() {
                // ������J��f
                ClosePort();
              }
            };
            t1.start();
          } catch (

          Exception e) {
            e.printStackTrace();
          }
        }
        break;
    }
  }
}
