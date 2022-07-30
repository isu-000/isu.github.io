
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
  private static int x = 0;// x是用來初始化進度條 nub
  private static double xynumber = 0;// 初始化折線圖Y座標
  private static boolean DataGate;// 數據閘門
  private static boolean StartButton = true;// 開始按鈕閘門
  private static int CalculateNumberMeasurements = 0;// 計算測量次數
  private static int box = 14;// 一開始上方動態長條位置(715,0)
  private static int panle = 0;// 一開始面板位置(0,0)
  private static int panle2 = -1920;// 移動後面板位置(-1920,0)
  private static int connectBlickLinePanel = 715;// 一開始上方動態長條位置(715,0)

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
    cfront.startbutton.addMouseListener(new CMouseAdap());// 開始測量按鈕監聽
    cfront.ChangeStartButton.addMouseListener(new CMouseAdap());// 交換開始測量按鈕監聽
    cfront.againbutton.addMouseListener(new CMouseAdap());// 重新測量按鈕監聽
    cfront.stopbutton.addMouseListener(new CMouseAdap());// 停止測量按鈕監聽
    cfront.isulinkbutton.addMouseListener(new CMouseAdap());// 連結按鈕監聽
    cfront.closebutton.addMouseListener(new CMouseAdap());// 視窗關閉按鈕監聽
    cfront.minusbutton.addMouseListener(new CMouseAdap());// 最小化視窗按鈕監聽
    cfront.AnalyzeLabel.addMouseListener(new CMouseAdap());// 經脈分析標籤監聽
    cfront.MeridianLabel.addMouseListener(new CMouseAdap());// 經脈測量標籤監聽
    register.RegisterButton.addMouseListener(new CMouseAdap());// 註冊按鈕監聽
    register.CreateUserName.addMouseListener(new CMouseAdap());// 建立帳號按鈕監聽
    register.OtherUserName.addMouseListener(new CMouseAdap());// 其他帳號按鈕監聽

    Register.User1.addMouseListener(new CMouseAdap());// 帳號1按鈕監聽
    Register.User2.addMouseListener(new CMouseAdap());// 帳號2按鈕監聽
    Register.User3.addMouseListener(new CMouseAdap());// 帳號3按鈕監聽
    Register.User4.addMouseListener(new CMouseAdap());// 帳號4按鈕監聽
    Register.User5.addMouseListener(new CMouseAdap());// 帳號5按鈕監聽
    Register.User6.addMouseListener(new CMouseAdap());// 帳號6按鈕監聽
    Register.LoginLabel.addMouseListener(new CMouseAdap());// 登入按鈕監聽

    //cfront.setVisible(true);
    register.setVisible(true);

  }

  // ========================================================================
  // 播放音樂方法
  public void playmusic() {
    File file = new File("D://hw//musics//DataGate1s.mp3");
    Player player;
    try {
      player = new Player(new FileInputStream(file));
      player.play();// 播放音樂
    } catch (FileNotFoundException | JavaLayerException e) {
      e.printStackTrace();
    }
    // player.close();//停止播放
  }
  // ========================================================================

  class CMouseAdap extends MouseAdapter {
    // ========================================================================
    // 透過URL 連接外部網站
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
                  cfront.box2Panel.setLocation(panle2, 130);// 模擬面板
                  cfront.connectBlickLinePanel.setLocation(connectBlickLinePanel, 0);// 模擬面板
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
                  cfront.box2Panel.setLocation(panle2, 130);// 模擬面板
                  cfront.connectBlickLinePanel.setLocation(connectBlickLinePanel, 0);// 模擬面板
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

      if (e.getSource() == cfront.closebutton) {// 關閉按鈕
        System.exit(0);
      }
      if (e.getSource() == cfront.minusbutton) { // 最小化按鈕
        cfront.setExtendedState(JFrame.ICONIFIED);
      }
      // ========================================================================
      if (e.getSource() == cfront.againbutton) {// 重新測量按鈕
        if (StartButton == true) {
          ClosePort();
          CleanData();// 清除數據格
          cfront.againbutton.setBackground(new Color(220, 220, 220));
          cfront.stopbutton.setBackground(new Color(220, 220, 220));
          cfront.startbutton.setVisible(true);
          cfront.ChangeStartButton.setVisible(false);
          cfront.imagelabel.setIcon(null);
          cfront.jProgressBar.setValue(0);
        }
      }
      if (e.getSource() == cfront.stopbutton) {// 停止測量按鈕
        Thread StopThread = new Thread() {
          public void run() {
            // 關閉輸入串口
            ClosePort();
            cfront.stopbutton.setBackground(new Color(220, 220, 220));// 把停止測量按鈕背景變灰色代表不可以使用
            cfront.startbutton.setVisible(true);// 有功能開始按鈕測量顯示
            cfront.ChangeStartButton.setVisible(false);// 沒功能交換開始按鈕測量隱藏
          }
        };
        StopThread.start();
      }
      if (e.getSource() == cfront.startbutton) { // 開始測量按鈕
        cfront.startbutton.setVisible(false);// 隱藏開始測量按鈕
        cfront.ChangeStartButton.setVisible(true);// 把沒用功能的交換開始測量按鈕顯示
        cfront.stopbutton.setBackground(Color.RED);// 把停止測量按鈕背景變紅色代表可以使用
        cfront.againbutton.setBackground(new Color(61, 145, 64));// 把重新測量按鈕變成綠色代表可以使用
        cfront.jProgressBar.setIndeterminate(true);
        Thread t = new Thread() {
          public void run() {
            Initialize(); // 啟動rxtx
            if (StartButton == true) {
              if (cfront.imagelabel.getIcon() == (null)) {
                CleanData();// 清空數據格
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
      if (e.getSource() == register.RegisterButton) { // 註冊按鈕
        try {
          register.Write(); // 寫入數據庫
          register.LoginWrite(); // 寫入登錄數據庫
          register.setVisible(false);
          cfront.setVisible(true);
          // register.Read(); // 讀取數據庫
          // register.ReadLine(); // 讀取數據庫
          // Register.readLineVarFile(("D://hw//register.txt"), 1); // 讀取數據庫
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.LoginLabel) { // 登錄按鈕
        try {
          register.setVisible(false);
          cfront.setVisible(true);
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == register.CreateUserName) { // 建立用戶名按鈕
        try {
          register.RegisterPanel.setVisible(true);// 顯示註冊面板
          register.LoginPanel.setVisible(false);// 隱藏登錄面板
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == register.OtherUserName) { // 其他用戶名按鈕
        try {
          register.OtherUserPanel.setVisible(true);// 顯示註冊面板
          register.LoginPanel.setVisible(false);// 隱藏登錄面板
          register.ReadLine(); // 讀取數據庫
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User1) { // 用戶名按鈕
        try {
          cfront.setVisible(true);// 顯示主界面
          register.setVisible(false);// 隱藏註冊面板
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User2) { // 用戶名按鈕
        try {
          cfront.setVisible(true);// 顯示主界面
          register.setVisible(false);// 隱藏註冊面板
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User3) { // 用戶名按鈕
        try {
          cfront.setVisible(true);// 顯示主界面
          register.setVisible(false);// 隱藏註冊面板
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User4) { // 用戶名按鈕
        try {
          cfront.setVisible(true);// 顯示主界面
          register.setVisible(false);// 隱藏註冊面板
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User5) { // 用戶名按鈕
        try {
          cfront.setVisible(true);// 顯示主界面
          register.setVisible(false);// 隱藏註冊面板
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      if (e.getSource() == Register.User6) { // 用戶名按鈕
        try {
          cfront.setVisible(true);// 顯示主界面
          register.setVisible(false);// 隱藏註冊面板
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
  }

  // 初始化串口，將輸入流返回用於事件讀取
  public void Initialize() {
    try {
      portId = CommPortIdentifier.getPortIdentifier(PortName);
      // 由對象打開串口，並為串口命名
      serialPort = (SerialPort) portId.open("JAVA_SERIAL", 2000);
      // 注冊一個SerialPortEventListener事件來監聽串口事件
      serialPort.addEventListener(this);
      // 數據可用則觸發事件
      serialPort.notifyOnDataAvailable(true);
      // 打開輸入輸出流
      in = serialPort.getInputStream();
      // out = serialPort.getOutputStream();
      // 設置串口參數，波特率115200，8位數據位，1位停止位，無奇偶校驗
      serialPort.setSerialPortParams(baud, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
          SerialPort.PARITY_NONE);

    } catch (PortInUseException e) {
      System.out.println("該串口正在使用中");
    } catch (NoSuchPortException e) {
      System.out.println("該串口當前不可使用");
    } catch (UnsupportedCommOperationException e) {
      System.out.println("錯誤的串口參數配置");
    } catch (TooManyListenersException e) {
      System.out.println("該串口已存在監聽器");
    } catch (IOException e) {
      System.out.println("輸入輸出流打開失敗");
    }
  }

  // 關閉串口
  public void ClosePort() {
    serialPort.close();
  }

  // 透過數據有無加入來讓圖片更改，如果有數據加入就換圖片
  public void PhotoReturn() {
    Thread t2 = new Thread() { // 無窮迴圈+圖片線程
      public void run() {
        Boolean a = true;
        int i = 14, j = 1, k = 27; // i是控制第一排數據 j是 排數
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
        i = 14; // 還原初始值，才可以透過按鈕達到無窮迴圈
        j = 1; //
        k = 27; // }
      }
    };
    t2.start();
  }

  // 清空數據格
  public void CleanData() {
    for (int i = 1; i < 14; i++) { // 清空
      cfront.datatJTextFields[i].setBackground(new Color(174, 217, 232));
      cfront.datatJTextFields[i].setForeground(Color.BLACK);
    }
    for (int i = 14; i < 26; i++) { // 清空
      cfront.datatJTextFields[i].setText("");
      cfront.datatJTextFields[i].setBackground(Color.WHITE);
    }
    for (int i = 27; i < 39; i++) { // 清空
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

  // 監聽串口事件
  @Override
  public void serialEvent(SerialPortEvent event) {
    switch (event.getEventType()) {
      case SerialPortEvent.BI:// Break interrupt,通訊中斷
      case SerialPortEvent.OE:// Overrun error，溢位錯誤
      case SerialPortEvent.FE:// Framing error，傳幀錯誤
      case SerialPortEvent.PE:// Parity error，校驗錯誤
      case SerialPortEvent.CD:// Carrier detect，載波檢測
      case SerialPortEvent.CTS:// Clear to send，清除發送
      case SerialPortEvent.DSR:// Data set ready，數據設備就緒
      case SerialPortEvent.RI:// Ring indicator，響鈴指示
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:// Output buffer is empty，輸出緩沖區清空
        break;
      case SerialPortEvent.DATA_AVAILABLE:// Data available at the serial port，端口有可用數據。讀到緩沖數組，輸出到終端
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
        Double tempName = Double.parseDouble(r);// 把接受到的r字串轉換double型態

        /**
         * 1.判斷接受到的數據是否小於600
         * 2.如果值小於600代表使用者再測量
         * 3.CalculateNumberMeasurements 是用來計數，如果計數到10就要關閉
         * 4.沒有測量就設定DataGate = true 開啟 ,  DataGat 
         */
        if (tempName <= 600) {
          if (CalculateNumberMeasurements == 10) {
            cfront.datatJTextFields[box].setIcon(null);
            DataGate = false;
          }

        }
        /**
         * 1.判斷接受到的數據是否大於600
         * 2.如果值大於600代表使用者沒有再測量
         * 3.如果 CalculateNumberMeasurements 關閉 則開啟
         * 4.沒有測量就設定DataGate = true 開啟 ,  DataGat 
         */
        if (tempName >= 600) {
          cfront.datatJTextFields[box].setIcon(null);
          DataGate = true;
        }
        /**
         * 1.數據閘道開啟且進度條值小於100且數據小於600
         * 2.開啟執行續
         * 3.x初始化是0 依序把值+10
         * 4.xynumber是折線圖y軸座標0-5 每次加0.5 做10次 = 0.5 * 10 = 5
         * 5.直到x值大於100中斷執行續
         * 6.在初始化x為0,xynumber=0 達到重復執行
         */
        if (x <= 100 && DataGate == true && tempName <= 600) {
          Thread t4 = new Thread() {
            public void run() {
              cfront.datatJTextFields[box].setIcon(cfront.threadimageIcon);
              cfront.jProgressBar.setValue(x);// 把設定的直放入進度條
              x = x + 10;// 設定0+10給進度條
              cfront.series.add(xynumber, tempName);// 加入x.y值
              xynumber = xynumber + 0.5;// xynumber是折線圖y軸座標0-5 每次加0.5 做10次 = 0.5 * 10 = 5
              if (x > 100) {
                cfront.datatJTextFields[box].setIcon(null);
                box = box + 1;
              }
            }
          };
          t4.start();
        } else if (cfront.datatJTextFields[14].getText().length() == 0 && DataGate == true && tempName <= 600) {
          try {
            // 控制顏色與數據位置
            cfront.datatJTextFields[14].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[14].setText(r);
            cfront.datatJTextFields[1].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[1].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[2].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[2].setBackground(new Color(96, 113, 163));// 外框變色
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
            cfront.datatJTextFields[15].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[15].setText(r);
            cfront.datatJTextFields[2].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[2].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[3].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[3].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[16].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[16].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[16].setText(r);
            cfront.datatJTextFields[3].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[3].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[4].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[4].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[17].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[17].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[17].setText(r);
            cfront.datatJTextFields[4].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[4].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[5].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[5].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[18].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[18].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[18].setText(r);
            cfront.datatJTextFields[5].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[5].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[6].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[6].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[19].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[19].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[19].setText(r);
            cfront.datatJTextFields[6].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[6].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[1].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[1].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[13].setBackground(cfront.blue);// 還原左側外框顏色
            cfront.datatJTextFields[13].setForeground(Color.BLACK);// 還原左側字體變色
            cfront.datatJTextFields[26].setBackground(new Color(96, 113, 163));// 右側外框顏色
            cfront.datatJTextFields[26].setForeground(Color.WHITE);// 右側字體變色
            cfront.datatJTextFields[27].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[27].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[27].setText(r);
            cfront.datatJTextFields[1].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[1].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[2].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[2].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[28].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[28].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[28].setText(r);
            cfront.datatJTextFields[2].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[2].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[3].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[3].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[29].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[29].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[29].setText(r);
            cfront.datatJTextFields[3].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[3].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[4].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[4].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[30].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[30].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[30].setText(r);
            cfront.datatJTextFields[4].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[4].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[5].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[5].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[31].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[31].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[31].setText(r);
            cfront.datatJTextFields[5].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[5].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[6].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[6].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[32].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[32].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[32].setText(r);
            cfront.datatJTextFields[6].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[6].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[7].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[7].setBackground(new Color(96, 113, 163));// 外框變色   
            cfront.datatJTextFields[26].setBackground(cfront.blue);// 還原右側外框顏色
            cfront.datatJTextFields[26].setForeground(Color.BLACK);// 還原右側字體變色
            cfront.datatJTextFields[13].setBackground(new Color(96, 113, 163));// 左側外框顏色
            cfront.datatJTextFields[13].setForeground(Color.WHITE);// 左側字體變色
            cfront.datatJTextFields[20].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[20].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[20].setText(r);
            cfront.datatJTextFields[7].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[7].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[8].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[8].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[21].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[21].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[21].setText(r);
            cfront.datatJTextFields[8].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[8].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[9].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[9].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[22].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[22].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[22].setText(r);
            cfront.datatJTextFields[9].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[9].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[10].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[10].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[23].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[23].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[23].setText(r);
            cfront.datatJTextFields[10].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[10].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[11].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[11].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[24].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[24].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[24].setText(r);
            cfront.datatJTextFields[11].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[11].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[12].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[12].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[25].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[25].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[25].setText(r);
            cfront.datatJTextFields[12].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[12].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[7].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[7].setBackground(new Color(96, 113, 163));// 外框變色   
            cfront.datatJTextFields[13].setBackground(cfront.blue);// 還原左側外框顏色
            cfront.datatJTextFields[13].setForeground(Color.BLACK);// 還原左側字體變色
            cfront.datatJTextFields[26].setBackground(new Color(96, 113, 163));// 右側外框顏色
            cfront.datatJTextFields[26].setForeground(Color.WHITE);// 右側字體變色
            cfront.datatJTextFields[33].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[33].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[33].setText(r);
            cfront.datatJTextFields[7].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[7].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[8].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[8].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[34].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[34].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[34].setText(r);
            cfront.datatJTextFields[8].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[8].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[9].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[9].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[35].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[35].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[35].setText(r);
            cfront.datatJTextFields[9].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[9].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[10].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[10].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[36].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[36].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[36].setText(r);
            cfront.datatJTextFields[10].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[10].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[11].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[11].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[37].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[37].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[37].setText(r);
            cfront.datatJTextFields[11].setForeground(Color.BLACK);// 還原字體變色
            cfront.datatJTextFields[11].setBackground(cfront.blue);// 還原外框變色
            cfront.datatJTextFields[12].setForeground(Color.WHITE);// 字體變色
            cfront.datatJTextFields[12].setBackground(new Color(96, 113, 163));// 外框變色
            cfront.datatJTextFields[38].setBackground(new Color(238, 243, 210));// 測量時背景色
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
            cfront.datatJTextFields[38].setBackground(Color.WHITE);// 還原測量背景色
            cfront.datatJTextFields[38].setText(r);
            cfront.datatJTextFields[12].setBackground(cfront.blue);// 還原外框
            cfront.datatJTextFields[12].setForeground(Color.BLACK);// 還原字體
            cfront.datatJTextFields[26].setBackground(cfront.blue);// 還原右側外框
            cfront.datatJTextFields[26].setForeground(Color.BLACK);// 還原右側字體
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
                // 關閉輸入串口
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
