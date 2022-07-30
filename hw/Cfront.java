
//#region import*
import javax.swing.*;// for JFrame, JPanel, JLabel, JTextField, JButton, JOptionPane
import javax.swing.border.Border;// for Border
import java.awt.*;// for BorderLayout, GridLayout, FlowLayout, Dimension
import org.jfree.chart.ChartPanel;// for ChartPanel
import org.jfree.chart.ChartFactory;// for ChartFactory
import org.jfree.chart.JFreeChart;// for JFreeChart
import org.jfree.chart.plot.PlotOrientation;// for PlotOrientation
import org.jfree.data.xy.XYDataset;// for XYDataset
import org.jfree.data.xy.XYSeries;// for XYSeries
import org.jfree.data.xy.XYSeriesCollection;// for XYSeriesCollection
import org.jfree.chart.plot.XYPlot;// for XYPlot
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;// for XYLineAndShapeRenderer
import org.jfree.chart.axis.*;// for Axis
import java.awt.event.*;
//#endregion

public class Cfront extends JFrame {
    // #region 初始化
    // demon Demon = new demon();// create a new demon
    ImageIcon imageIcons[] = new ImageIcon[24];// create a new imageIcon array
    ImageIcon imageIcon = new ImageIcon("D://hw//images//isu.png"); // create a new imageIcon
    ImageIcon closeimageIcon = new ImageIcon("D://hw//images//關閉.png");// create a new imageIcon
    ImageIcon minusimageIcon = new ImageIcon("D://hw//images//最小化.png");// create a new imageIcon
    ImageIcon threadimageIcon = new ImageIcon("D://hw//images//等待.gif");// create a new imageIcon
    ImageIcon startimageIcon = new ImageIcon("D://hw//images//經脈測量.png");// create a new imageIcon
    ImageIcon startMaximageIcon = new ImageIcon("D://hw//images//經脈測量(大).png");// create a new imageIcon
    // ImageIcon cur = new ImageIcon("D://hw//images//cur.png");// create a new
    // imageIcon

    // Toolkit tk = Toolkit.getDefaultToolkit();
    // Image img = tk.getImage("D://hw//images//cur.png");
    // Cursor cu = tk.createCustomCursor(img, new Point(16, 16), "null");

    JLabel datatJTextFields[] = new JLabel[39];// create a new datatJTextFields array
    JLabel imagelabel = new JLabel();// create a new imagelabel
    JLabel isulinkbutton = new JLabel(imageIcon);// create a new isulinkbutton
    JLabel closebutton = new JLabel(closeimageIcon);// create a new closebutton
    JLabel minusbutton = new JLabel(minusimageIcon);// create a new minusbutton
    JLabel HandTextlabel = new JLabel("手部");// create a new HandTextlabel
    JLabel FoodTextlabel = new JLabel("足部");// create a new FoodTextlabel
    JLabel startbutton = new JLabel("開始測量")// create a new startbutton
    {
        public Point getToolTipLocation(MouseEvent e) {
            return new Point(15, 80);
        }
    };
    JLabel ChangeStartButton = new JLabel("開始測量");// create a new ChangeStartButton
    JLabel stopbutton = new JLabel("停止測量");// create a new stopbutton
    JLabel ChangeStopButton = new JLabel("停止測量");// create a new ChangeStopButton
    JLabel againbutton = new JLabel("重新測量");// create a new againbutton 
    JLabel MeridianLabel = new JLabel("經脈測量");// create a new MeridianLabel
    JLabel AnalyzeLabel = new JLabel("經脈分析");// create a new AnalyzeLabel
    JLabel MeridianValue = new JLabel("經脈能量測定值");// create a new MeridianValue
    JLabel MeasurementPointIcon = new JLabel("測定點圖示");// create a new MeasurementPointIcon
    JLabel MeasurementBalanceChart = new JLabel("測量平衡圖");// create a new MeasurementBalanceChart
    JLabel LeftRight = new JLabel("左/右")// create a new LeftRight  
    {
        public Point getToolTipLocation(MouseEvent e) {
            return new Point(40, 70);
        }
    };

    JProgressBar jProgressBar = new JProgressBar();// create a new jProgressBar
    /* create a new font */
    Font font2 = new Font("微軟正黑體", Font.BOLD, 26); 
    Font font3 = new Font("微軟正黑體", Font.BOLD, 30);
    Font font1 = new Font("微軟正黑體", Font.BOLD, 24);  

    XYSeries series = new XYSeries("");// create a new series
    XYDataset xyDataset = new XYSeriesCollection(series);// create a new xyDataset

    JFreeChart lineChart = ChartFactory.createXYLineChart// create a new lineChart
    ("", "", "", xyDataset, PlotOrientation.VERTICAL,
            false, false, true);

    ChartPanel chartPanel = new ChartPanel(lineChart);// create a new chartPanel

    JPanel BlackPanel = new JPanel();// 背景 // create a new BlackPanel
    JPanel Black1Panel = new JPanel();// 放置數據// create a new Black1Panel
    JPanel Black2Panel = new JPanel();// 放置長條圖// create a new Black2Panel
    JPanel Black3Panel = new JPanel();// 放置折線圖// create a new Black3Panel
    JPanel Black4Panel = new JPanel();// 放置圖片// create a new Black4Panel
    JPanel BlickLinePanel = new JPanel();// 隔絕上方按鈕與下方線條// create a new BlickLinePanel
    JPanel connectBlickLinePanel = new JPanel();// 連接隔絕上方按鈕與下方線條// create a new connectBlickLinePanel
    JPanel MeridianValuePanel = new JPanel();// 經脈能量測定值標籤的面板// create a new MeridianValuePanel
    JPanel boxPanel = new JPanel();// 最上方工具列// create a new boxPanel
    JPanel box2Panel = new JPanel();// 最上方工具列// create a new box2Panel

    JPanel jButton = new JPanel();// create a new jButton

    // Color black = new Color(43, 43, 43);
    Color black = new Color(0, 159, 139);// create a new black
    // Color black1 = new Color(255, 255, 255);
    Color black1 = new Color(66, 136, 166);// create a new black1
    Color black2 = new Color(21, 25, 28);// 手部文字，足部文字// create a new black2
    Color blue = new Color(174, 217, 232);// 手部文字，足部文字// create a new blue
    Color runblue = new Color(46, 125, 199);// 數據格變換顏色// create a new runblue

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    // #endregion

    Cfront() {
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        // #region 折線圖
        // 折線圖加入位置
        chartPanel.setBounds(25, 80, 955, 370);
        lineChart.setBackgroundPaint(Color.WHITE);
        Black3Panel.add(chartPanel);
        // x,y橫縱軸屬性設置
        XYPlot xyPlot = lineChart.getXYPlot();
        NumberAxis domainAxis = (NumberAxis) xyPlot.getDomainAxis();
        domainAxis.setRange(0, 5);
        NumberAxis rangeAxis = (NumberAxis) xyPlot.getRangeAxis();
        domainAxis.setTickUnit(new NumberTickUnit(1));
        rangeAxis.setRange(0, 700);
        rangeAxis.setTickUnit(new NumberTickUnit(100));

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(5));
        renderer.setBaseShapesVisible(false);
        renderer.setSeriesPaint(0, Color.BLUE);// 設定折線圖數據顏色

        xyPlot.setBackgroundPaint(Color.WHITE);
        // xyPlot.setBackgroundPaint(null);
        xyPlot.setDomainGridlinePaint(Color.BLACK);
        xyPlot.setRangeGridlinePaint(Color.BLACK);
        xyPlot.setRenderer(renderer);
        xyPlot.setRangeGridlinesVisible(false);// 隱藏網格橫
        xyPlot.setDomainGridlinesVisible(false);// 隱藏網格縱

        ValueAxis categoryAxis = xyPlot.getDomainAxis();
        categoryAxis.setTickLabelFont(new Font("微軟正黑體", Font.BOLD, 20));
        categoryAxis.setTickLabelPaint(Color.BLACK);
        ValueAxis valueAxis2 = xyPlot.getRangeAxis();
        valueAxis2.setTickLabelFont(new Font("微軟正黑體", Font.BOLD, 20));
        valueAxis2.setTickLabelPaint(Color.BLACK);
        chartPanel.setMouseZoomable(false);// 不可縮放 
        // #endregion
        // #region 圖片
        int witgh = 21, i = 0;

        imageIcons[0] = new ImageIcon("D://hw//images//1-24//H1-手太陰肺經-太淵穴_1.png");
        imageIcons[1] = new ImageIcon("D://hw//images//1-24//H2-手厥陰心包經-大陵穴_1.png");
        imageIcons[2] = new ImageIcon("D://hw//images//1-24//H3-手少陰心經-神門穴_1.png");
        imageIcons[3] = new ImageIcon("D://hw//images//1-24//H4-手太陽小腸經-陽谷穴_1.png");
        imageIcons[4] = new ImageIcon("D://hw//images//1-24//H5-手少陽三焦經-陽池穴_1.png");
        imageIcons[5] = new ImageIcon("D://hw//images//1-24//H6-手陽明大腸經-陽谿穴_1.png");
        imageIcons[6] = new ImageIcon("D://hw//images//1-24//H1-手太陰肺經-太淵穴_1.png");
        imageIcons[7] = new ImageIcon("D://hw//images//1-24//H2-手厥陰心包經-大陵穴_1.png");
        imageIcons[8] = new ImageIcon("D://hw//images//1-24//H3-手少陰心經-神門穴_1.png");
        imageIcons[9] = new ImageIcon("D://hw//images//1-24//H4-手太陽小腸經-陽谷穴_1.png");
        imageIcons[10] = new ImageIcon("D://hw//images//1-24//H5-手少陽三焦經-陽池穴_1.png");
        imageIcons[11] = new ImageIcon("D://hw//images//1-24//H6-手陽明大腸經-陽谿穴_1.png");
        imageIcons[12] = new ImageIcon("D://hw//images//1-24//F1-足太陰肺經-太白穴_1.png");
        imageIcons[13] = new ImageIcon("D://hw//images//1-24//F2-足厥陰肝經-太衝穴_1.png");
        imageIcons[14] = new ImageIcon("D://hw//images//1-24//F3-足少陰腎經-大鐘穴_1.png");
        imageIcons[15] = new ImageIcon("D://hw//images//1-24//F4-足太陽膀胱經-束骨穴_1.png");
        imageIcons[16] = new ImageIcon("D://hw//images//1-24//F5-足少陽膽經-俠溪穴_1.png");
        imageIcons[17] = new ImageIcon("D://hw//images//1-24//F6-足陽明胃經-內庭穴_1.png");
        imageIcons[18] = new ImageIcon("D://hw//images//1-24//F1-足太陰肺經-太白穴_1.png");
        imageIcons[19] = new ImageIcon("D://hw//images//1-24//F2-足厥陰肝經-太衝穴_1.png");
        imageIcons[20] = new ImageIcon("D://hw//images//1-24//F3-足少陰腎經-大鐘穴_1.png");
        imageIcons[21] = new ImageIcon("D://hw//images//1-24//F4-足太陽膀胱經-束骨穴_1.png");
        imageIcons[22] = new ImageIcon("D://hw//images//1-24//F5-足少陽膽經-俠溪穴_1.png");
        imageIcons[23] = new ImageIcon("D://hw//images//1-24//F6-足陽明胃經-內庭穴_1.png");
        // #endregion

        // #region 輸入格
        datatJTextFields[0] = new JLabel("");
        datatJTextFields[1] = new JLabel("肺經");
        datatJTextFields[2] = new JLabel("心包");
        datatJTextFields[3] = new JLabel("心經");
        datatJTextFields[4] = new JLabel("小腸");
        datatJTextFields[5] = new JLabel("三焦");
        datatJTextFields[6] = new JLabel("大腸");
        datatJTextFields[7] = new JLabel("脾經");
        datatJTextFields[8] = new JLabel("肝經");
        datatJTextFields[9] = new JLabel("腎經");
        datatJTextFields[10] = new JLabel("膀胱");
        datatJTextFields[11] = new JLabel("膽經");
        datatJTextFields[12] = new JLabel("胃經");
        for (; i < 13; i++) {
            datatJTextFields[i].setFont(font2);
            datatJTextFields[i].setForeground(Color.black);
            datatJTextFields[i].setBorder(blackline);
            datatJTextFields[i].setOpaque(true);
            datatJTextFields[i].setHorizontalAlignment(JLabel.CENTER);
            datatJTextFields[i].setBounds(witgh, 165, 143, 55);
            datatJTextFields[i].setBackground(blue);
            witgh = witgh + 143;
            Black1Panel.add(datatJTextFields[i]);
        }
        witgh = 21;// 初始化位置
        datatJTextFields[13] = new JLabel("左側");
        datatJTextFields[13].setForeground(Color.black);
        datatJTextFields[13].setBackground(blue);
        datatJTextFields[13].setFont(font2);
        datatJTextFields[13].setHorizontalAlignment(JLabel.CENTER);
        datatJTextFields[i].setBorder(blackline);
        datatJTextFields[i].setOpaque(true);
        datatJTextFields[13].setBounds(witgh, 220, 143, 55);
        witgh = witgh + 143;
        Black1Panel.add(datatJTextFields[13]);

        for (i = 14; i < 26; i++) {
            datatJTextFields[i] = new JLabel("");
            datatJTextFields[i].setFont(font2);
            datatJTextFields[i].setForeground(Color.black);
            datatJTextFields[i].setBorder(blackline);
            datatJTextFields[i].setOpaque(true);
            datatJTextFields[i].setHorizontalAlignment(JLabel.CENTER);
            datatJTextFields[i].setBounds(witgh, 220, 143, 55);
            datatJTextFields[i].setBackground(Color.WHITE);
            witgh = witgh + 143;
            Black1Panel.add(datatJTextFields[i]);
        }
        witgh = 21;// 初始化位置
        datatJTextFields[26] = new JLabel("右側");
        datatJTextFields[26].setBackground(blue);
        datatJTextFields[26].setForeground(Color.BLACK);
        datatJTextFields[26].setFont(font2);
        datatJTextFields[26].setHorizontalAlignment(JLabel.CENTER);
        datatJTextFields[i].setBorder(blackline);
        datatJTextFields[i].setOpaque(true);
        datatJTextFields[26].setBounds(witgh, 275, 143, 55);
        witgh = witgh + 143;
        Black1Panel.add(datatJTextFields[26]);

        for (i = 27; i < 39; i++) {
            datatJTextFields[i] = new JLabel("");
            datatJTextFields[i].setFont(font2);
            datatJTextFields[i].setForeground(Color.black);
            datatJTextFields[i].setBorder(blackline);
            datatJTextFields[i].setOpaque(true);
            datatJTextFields[i].setHorizontalAlignment(JLabel.CENTER);
            datatJTextFields[i].setBounds(witgh, 275, 143, 55);
            datatJTextFields[i].setBackground(Color.WHITE);
            witgh = witgh + 143;
            Black1Panel.add(datatJTextFields[i]);
        }
        // #endregion
        // #region 擺放位置
        /**
         * 開始測量  
         */
        startbutton.setBounds(10, 75, 120, 50);// 設定擺放位置
        startbutton.setFont(font1);// 設定微軟正黑體
        startbutton.setForeground(Color.white);// 設定字體顏色
        startbutton.setOpaque(true);
        startbutton.setBackground(Color.blue);
        startbutton.setHorizontalAlignment(JLabel.CENTER);
        startbutton.setCursor(cursor);
        startbutton.setToolTipText(
                "<html><div style='margin:0 -3 0 -3; padding: 0 3 0 3; background:white; color:black;font-size:16px;font-family:Microsoft JhengHei;'>開始測量</div></html>");
        /**
         * 交換開始測量  
         */
        ChangeStartButton.setBounds(10, 75, 120, 50);// 設定擺放位置
        ChangeStartButton.setFont(font1);// 設定微軟正黑體
        ChangeStartButton.setForeground(Color.white);// 設定字體顏色
        ChangeStartButton.setOpaque(true);
        ChangeStartButton.setBackground(new Color(220, 220, 220));// 淺灰色
        ChangeStartButton.setHorizontalAlignment(JLabel.CENTER);

        // isulinkbutton.setBounds(1820, 70, 80, 80);
        /**
         * 停止測量  
         */
        stopbutton.setBounds(150, 75, 120, 50);// 設定擺放位置
        stopbutton.setFont(font1);// 設定微軟正黑體
        stopbutton.setForeground(Color.white);// 設定字體顏色
        stopbutton.setBackground(new Color(220, 220, 220));// 淺灰色
        stopbutton.setOpaque(true);
        stopbutton.setHorizontalAlignment(JLabel.CENTER);

        /**
         * 重新測量  
         */
        againbutton.setBounds(290, 75, 120, 50);// 設定擺放位置
        againbutton.setFont(font1);// 設定微軟正黑體
        againbutton.setForeground(Color.white);// 設定字體顏色
        // againbutton.setBackground(new Color(61, 145, 64));//
        // 把重新測量按鈕變成綠色代表可以使用
        againbutton.setBackground(new Color(220, 220, 220));// 把重新測量按鈕變成綠色代表可以使用 
        againbutton.setOpaque(true);
        againbutton.setHorizontalAlignment(JLabel.CENTER);

        /******************************************
         * 經脈測量  
         ****************************************/
        MeridianLabel.setBounds(715, 75, 120, 50);// 設定擺放位置
        MeridianLabel.setFont(font1);// 設定微軟正黑體
        MeridianLabel.setForeground(new Color(25, 25, 112));// 設定字體顏色
        // MeridianLabel.setOpaque(true);
        // MeridianLabel.setBackground(new Color(61, 145, 64));
        MeridianLabel.setHorizontalAlignment(JLabel.CENTER);

        /******************************************
         * 數據分析  
         ****************************************/
        AnalyzeLabel.setBounds(865, 75, 120, 50);// 設定擺放位置
        AnalyzeLabel.setFont(font1);// 設定微軟正黑體
        AnalyzeLabel.setForeground(new Color(25, 25, 112));// 設定字體顏色
        // AnalyzeLabel.setBackground(new Color(61, 145, 64));
        // AnalyzeLabel.setOpaque(true);
        AnalyzeLabel.setHorizontalAlignment(JLabel.CENTER);

        /******************************************
         * 測量圖片 
         ****************************************/
        imagelabel.setBounds(50, 50, 740, 520); // 圖片擺放位置
        // imagelabel.setBorder(BorderFactory.createLoweredBevelBorder()); // 設定凹邊框
        // imagelabel.setBorder(blackline); // 設定凹邊框
        imagelabel.setHorizontalAlignment(JLabel.CENTER);
        /******************************************
         * 右上方關閉按鈕 
         ****************************************/
        closebutton.setBounds(1870, 0, 50, 50); // 關閉按鈕擺放位置
        /******************************************
         * 右上方最小化按鈕 
         ****************************************/
        minusbutton.setBounds(1820, 0, 50, 50); // 縮小按鈕擺放位置
        /*******************************************
         * 數據格裡面左右標籤
         ****************************************/
        LeftRight.setBounds(23, 85, 137, 50); // 數據格足部標籤位置
        LeftRight.setFont(font2);
        LeftRight.setForeground(Color.black);
        LeftRight.setHorizontalAlignment(JLabel.CENTER);
        LeftRight.setOpaque(true);
        LeftRight.setToolTipText(
                "<html><div style='margin:0 -3 0 -3; padding: 0 3 0 3; background:white; color:black;font-size:16px;font-family:Microsoft JhengHei;'>左/右</div></html>");
        // LeftRight.setBorder(BorderFactory.c reateLoweredBevelBorder());
        /******************************************
         * 數據格手部標籤 
         ****************************************/
        HandTextlabel.setBounds(169, 85, 850, 50); // 數據格手部標籤位置
        HandTextlabel.setFont(font2);
        HandTextlabel.setForeground(Color.black);
        HandTextlabel.setHorizontalAlignment(JLabel.CENTER);
        HandTextlabel.setOpaque(true);
        // HandTextlabel.setBackground(Color.WHITE);
        // HandTextlabel.setBorder(BorderFactory.createLoweredBevelBorder());

        /******************************************
         * 數據格足部標籤 
         ****************************************/
        FoodTextlabel.setBounds(1028, 85, 853, 50); // 數據格足部標籤位置
        FoodTextlabel.setFont(font2);
        FoodTextlabel.setForeground(Color.black);
        FoodTextlabel.setHorizontalAlignment(JLabel.CENTER);
        FoodTextlabel.setOpaque(true);
        // FoodTextlabel.setBorder(BorderFactory.createLoweredBevelBorder());
        // FoodTextlabel.setBackground(Color.WHITE);

        /*******************************************
         * 數據格裡面經脈能量測定值標題
         ****************************************/
        MeridianValue.setBounds(930, 0, 250, 50);
        MeridianValue.setFont(font2);
        MeridianValue.setForeground(Color.WHITE);

        /*******************************************
         * 圖片面板裡面測定點圖示
         ****************************************/
        MeasurementPointIcon.setBounds(0, 0, 885, 50);
        MeasurementPointIcon.setFont(font2);
        MeasurementPointIcon.setOpaque(true);
        MeasurementPointIcon.setBackground(new Color(112, 135, 163));// 莫藍色
        MeasurementPointIcon.setHorizontalAlignment(JLabel.CENTER);
        MeasurementPointIcon.setForeground(Color.WHITE);

        /*******************************************
         * 折線圖裡面測量平衡圖
         ****************************************/
        MeasurementBalanceChart.setBounds(0, 0, 1005, 50);
        MeasurementBalanceChart.setFont(font2);
        MeasurementBalanceChart.setOpaque(true);
        MeasurementBalanceChart.setBackground(new Color(112, 135, 163));// 莫藍色
        MeasurementBalanceChart.setHorizontalAlignment(JLabel.CENTER);
        MeasurementBalanceChart.setForeground(Color.WHITE);

        /******************************************
         * 進度條 
         ****************************************/
        jProgressBar.setBounds(25, 25, 960, 50);
        jProgressBar.setBackground(new Color(241, 241, 241));// 莫藍色
        jProgressBar.setForeground(runblue);// 設定移動顏色
        // jProgressBar.setForeground(new Color(112, 135, 163));// 莫藍色 設定移動顏色
        jProgressBar.setStringPainted(true);// 顯示字符串or百分比
        jProgressBar.setBorderPainted(false);// 設定邊框顯示否
        jProgressBar.setFont(font3);// 設定微軟正黑體
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);// 設定移動顏色
        UIManager.put("ProgressBar.selectionForeground", Color.WHITE);

        // jButton.setBounds(200, 30, 90, 85);// 設定擺放位置
        /******************************************
         * 放入所有元件大面板
         ****************************************/
        BlackPanel.setBounds(0, 130, 1920, 950);// 設定背景擺放位置
        // BlackPanel.setBackground(new Color(245, 245, 220));// 設定米白顏色
        // BlackPanel.setBackground(new Color(126, 187, 177));// 設定藍色顏色
        // BlackPanel.setBackground(Color.WHITE);// 設定白色顏色
        BlackPanel.setOpaque(true);// 設置面板透明
        BlackPanel.setLayout(null);// 設定空布局
        /******************************************
         * 放入最上方所有工具按鈕包含關閉縮小，小面板 
         ****************************************/
        boxPanel.setBounds(0, 0, 1920, 130);// 設定背景擺放位置
        boxPanel.setBackground(Color.WHITE);// 設定藍色顏色
        boxPanel.setLayout(null);// 設定空布局
        /******************************************
         * 切換面板 未來考慮更改成數據分析面板或是客戶資料面板
         ****************************************/
        box2Panel.setBounds(-1920, 100, 1920, 980);// 設定背景擺放位置
        box2Panel.setLayout(null);
        box2Panel.setBackground(new Color(126, 187, 177));// 設定藍色顏色
        /******************************************
         * 底下數據格面板
         ****************************************/
        Black1Panel.setBounds(10, 595, 1900, 345);// 設定底下數據擺放位置
        Black1Panel.setBorder(blackline);
        Black1Panel.setBackground(Color.WHITE);
        Black1Panel.setLayout(null);// 設定空布局
        /******************************************
         * 進度條面板
         ****************************************/
        Black2Panel.setBounds(905, 485, 1005, 100);// 設定進度條擺放位置
        // Black2Panel.setBorder(BorderFactory.createLoweredBevelBorder());
        Black2Panel.setBorder(blackline);
        Black2Panel.setBackground(Color.WHITE);
        // Black2Panel.setBackground(new Color(46,125,199));// 設定外表顏色
        // Black2Panel.setBounds(25, 125, 1005, 440);// 設定折現擺放位置
        Black2Panel.setLayout(null);// 設定空布局
        /******************************************
         * 折線圖面板
         ****************************************/
        Black3Panel.setBounds(905, 15, 1005, 460);// 設定折現擺放位置
        // Black3Panel.setBounds(25, 125, 1005, 440);// 設定折現擺放位置
        // Black3Panel.setBorder(BorderFactory.createLoweredBevelBorder());
        Black3Panel.setBackground(Color.WHITE);
        Black3Panel.setBorder(blackline);
        Black3Panel.setLayout(null);// 設定空布局
        /******************************************
         * 圖片面板
         ****************************************/
        Black4Panel.setBounds(10, 15, 885, 570);// 設定圖片擺放位置
        // Black4Panel.setBounds(1055, 125, 840, 570);// 設定圖片擺放位置
        Black4Panel.setLayout(null);// 設定空布局
        Black4Panel.setBackground(Color.WHITE);
        Black4Panel.setBorder(blackline);
        /******************************************
         * 數據格裡面經脈能量測定值標題面板
         ****************************************/
        MeridianValuePanel.setBounds(0, 0, 1900, 50);// 設定數據格裡面經脈能量測定值標題面板位置
        MeridianValuePanel.setLayout(null);// 設定空布局
        MeridianValuePanel.setBackground(new Color(112, 135, 163));// 莫藍色
        /******************************************
         * 分割上方按鈕與底下面板交界線
         ****************************************/
        BlickLinePanel.setBounds(0, 123, 1920, 5);
        // BlickLinePanel.setBackground(new Color(3, 168, 158));
        BlickLinePanel.setBackground(Color.WHITE);

        BlickLinePanel.setLayout(null);
        /******************************************
         * 連接上方按鈕與底下面板交界線動態線條
         ****************************************/
        connectBlickLinePanel.setBounds(715, 0, 120, 5);
        connectBlickLinePanel.setBackground(new Color(25, 25, 112));

        /******************************************
        
        ****************************************/
        jButton.setBounds(480, 270, 960, 540);

        /**
         * 各種面板加入
         */
        BlackPanel.add(Black1Panel);
        BlackPanel.add(Black2Panel);
        BlackPanel.add(Black3Panel);
        BlackPanel.add(Black4Panel);

        box2Panel.add(jButton);
        boxPanel.add(closebutton);
        boxPanel.add(minusbutton);
        boxPanel.add(startbutton);
        boxPanel.add(isulinkbutton);
        boxPanel.add(againbutton);
        boxPanel.add(stopbutton);
        boxPanel.add(ChangeStartButton);
        boxPanel.add(BlickLinePanel);
        boxPanel.add(MeridianLabel);
        boxPanel.add(AnalyzeLabel);

        BlickLinePanel.add(connectBlickLinePanel);

        Black1Panel.add(HandTextlabel);
        Black1Panel.add(FoodTextlabel);
        Black1Panel.add(MeridianValuePanel);
        Black1Panel.add(LeftRight);

        Black2Panel.add(jProgressBar);

        Black3Panel.add(MeasurementBalanceChart);

        Black4Panel.add(imagelabel);
        Black4Panel.add(MeasurementPointIcon);

        MeridianValuePanel.add(MeridianValue);

        add(BlackPanel);
        add(boxPanel);
        add(box2Panel);

        setLayout(null);// 設定空布局
        setSize(1920, 1080);// 設定視窗大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 設定關閉方式
        setExtendedState(JFrame.MAXIMIZED_BOTH);// 設定螢幕最大化 
        setUndecorated(true);// 設定關閉Windows 關閉 最小化 縮放功能
        // setResizable(false);//設定不能縮放
        // setLocationRelativeTo(null);// 設定螢幕居中顯示

    }
}
// #endregion

// #endregion