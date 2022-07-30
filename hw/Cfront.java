
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
    // #region ��l��
    // demon Demon = new demon();// create a new demon
    ImageIcon imageIcons[] = new ImageIcon[24];// create a new imageIcon array
    ImageIcon imageIcon = new ImageIcon("D://hw//images//isu.png"); // create a new imageIcon
    ImageIcon closeimageIcon = new ImageIcon("D://hw//images//����.png");// create a new imageIcon
    ImageIcon minusimageIcon = new ImageIcon("D://hw//images//�̤p��.png");// create a new imageIcon
    ImageIcon threadimageIcon = new ImageIcon("D://hw//images//����.gif");// create a new imageIcon
    ImageIcon startimageIcon = new ImageIcon("D://hw//images//�g�ߴ��q.png");// create a new imageIcon
    ImageIcon startMaximageIcon = new ImageIcon("D://hw//images//�g�ߴ��q(�j).png");// create a new imageIcon
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
    JLabel HandTextlabel = new JLabel("�ⳡ");// create a new HandTextlabel
    JLabel FoodTextlabel = new JLabel("����");// create a new FoodTextlabel
    JLabel startbutton = new JLabel("�}�l���q")// create a new startbutton
    {
        public Point getToolTipLocation(MouseEvent e) {
            return new Point(15, 80);
        }
    };
    JLabel ChangeStartButton = new JLabel("�}�l���q");// create a new ChangeStartButton
    JLabel stopbutton = new JLabel("������q");// create a new stopbutton
    JLabel ChangeStopButton = new JLabel("������q");// create a new ChangeStopButton
    JLabel againbutton = new JLabel("���s���q");// create a new againbutton 
    JLabel MeridianLabel = new JLabel("�g�ߴ��q");// create a new MeridianLabel
    JLabel AnalyzeLabel = new JLabel("�g�ߤ��R");// create a new AnalyzeLabel
    JLabel MeridianValue = new JLabel("�g�߯�q���w��");// create a new MeridianValue
    JLabel MeasurementPointIcon = new JLabel("���w�I�ϥ�");// create a new MeasurementPointIcon
    JLabel MeasurementBalanceChart = new JLabel("���q���Ź�");// create a new MeasurementBalanceChart
    JLabel LeftRight = new JLabel("��/�k")// create a new LeftRight  
    {
        public Point getToolTipLocation(MouseEvent e) {
            return new Point(40, 70);
        }
    };

    JProgressBar jProgressBar = new JProgressBar();// create a new jProgressBar
    /* create a new font */
    Font font2 = new Font("�L�n������", Font.BOLD, 26); 
    Font font3 = new Font("�L�n������", Font.BOLD, 30);
    Font font1 = new Font("�L�n������", Font.BOLD, 24);  

    XYSeries series = new XYSeries("");// create a new series
    XYDataset xyDataset = new XYSeriesCollection(series);// create a new xyDataset

    JFreeChart lineChart = ChartFactory.createXYLineChart// create a new lineChart
    ("", "", "", xyDataset, PlotOrientation.VERTICAL,
            false, false, true);

    ChartPanel chartPanel = new ChartPanel(lineChart);// create a new chartPanel

    JPanel BlackPanel = new JPanel();// �I�� // create a new BlackPanel
    JPanel Black1Panel = new JPanel();// ��m�ƾ�// create a new Black1Panel
    JPanel Black2Panel = new JPanel();// ��m������// create a new Black2Panel
    JPanel Black3Panel = new JPanel();// ��m��u��// create a new Black3Panel
    JPanel Black4Panel = new JPanel();// ��m�Ϥ�// create a new Black4Panel
    JPanel BlickLinePanel = new JPanel();// �j���W����s�P�U��u��// create a new BlickLinePanel
    JPanel connectBlickLinePanel = new JPanel();// �s���j���W����s�P�U��u��// create a new connectBlickLinePanel
    JPanel MeridianValuePanel = new JPanel();// �g�߯�q���w�ȼ��Ҫ����O// create a new MeridianValuePanel
    JPanel boxPanel = new JPanel();// �̤W��u��C// create a new boxPanel
    JPanel box2Panel = new JPanel();// �̤W��u��C// create a new box2Panel

    JPanel jButton = new JPanel();// create a new jButton

    // Color black = new Color(43, 43, 43);
    Color black = new Color(0, 159, 139);// create a new black
    // Color black1 = new Color(255, 255, 255);
    Color black1 = new Color(66, 136, 166);// create a new black1
    Color black2 = new Color(21, 25, 28);// �ⳡ��r�A������r// create a new black2
    Color blue = new Color(174, 217, 232);// �ⳡ��r�A������r// create a new blue
    Color runblue = new Color(46, 125, 199);// �ƾڮ��ܴ��C��// create a new runblue

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    // #endregion

    Cfront() {
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        // #region ��u��
        // ��u�ϥ[�J��m
        chartPanel.setBounds(25, 80, 955, 370);
        lineChart.setBackgroundPaint(Color.WHITE);
        Black3Panel.add(chartPanel);
        // x,y���a�b�ݩʳ]�m
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
        renderer.setSeriesPaint(0, Color.BLUE);// �]�w��u�ϼƾ��C��

        xyPlot.setBackgroundPaint(Color.WHITE);
        // xyPlot.setBackgroundPaint(null);
        xyPlot.setDomainGridlinePaint(Color.BLACK);
        xyPlot.setRangeGridlinePaint(Color.BLACK);
        xyPlot.setRenderer(renderer);
        xyPlot.setRangeGridlinesVisible(false);// ���ú����
        xyPlot.setDomainGridlinesVisible(false);// ���ú����a

        ValueAxis categoryAxis = xyPlot.getDomainAxis();
        categoryAxis.setTickLabelFont(new Font("�L�n������", Font.BOLD, 20));
        categoryAxis.setTickLabelPaint(Color.BLACK);
        ValueAxis valueAxis2 = xyPlot.getRangeAxis();
        valueAxis2.setTickLabelFont(new Font("�L�n������", Font.BOLD, 20));
        valueAxis2.setTickLabelPaint(Color.BLACK);
        chartPanel.setMouseZoomable(false);// ���i�Y�� 
        // #endregion
        // #region �Ϥ�
        int witgh = 21, i = 0;

        imageIcons[0] = new ImageIcon("D://hw//images//1-24//H1-��ӳ��͸g-�ӲW��_1.png");
        imageIcons[1] = new ImageIcon("D://hw//images//1-24//H2-��ֳ��ߥ]�g-�j����_1.png");
        imageIcons[2] = new ImageIcon("D://hw//images//1-24//H3-��ֳ��߸g-������_1.png");
        imageIcons[3] = new ImageIcon("D://hw//images//1-24//H4-��Ӷ��p�z�g-������_1.png");
        imageIcons[4] = new ImageIcon("D://hw//images//1-24//H5-��ֶ��T�J�g-������_1.png");
        imageIcons[5] = new ImageIcon("D://hw//images//1-24//H6-�⶧���j�z�g-���ƥ�_1.png");
        imageIcons[6] = new ImageIcon("D://hw//images//1-24//H1-��ӳ��͸g-�ӲW��_1.png");
        imageIcons[7] = new ImageIcon("D://hw//images//1-24//H2-��ֳ��ߥ]�g-�j����_1.png");
        imageIcons[8] = new ImageIcon("D://hw//images//1-24//H3-��ֳ��߸g-������_1.png");
        imageIcons[9] = new ImageIcon("D://hw//images//1-24//H4-��Ӷ��p�z�g-������_1.png");
        imageIcons[10] = new ImageIcon("D://hw//images//1-24//H5-��ֶ��T�J�g-������_1.png");
        imageIcons[11] = new ImageIcon("D://hw//images//1-24//H6-�⶧���j�z�g-���ƥ�_1.png");
        imageIcons[12] = new ImageIcon("D://hw//images//1-24//F1-���ӳ��͸g-�ӥե�_1.png");
        imageIcons[13] = new ImageIcon("D://hw//images//1-24//F2-���ֳ��x�g-�ӽĥ�_1.png");
        imageIcons[14] = new ImageIcon("D://hw//images//1-24//F3-���ֳ��Ǹg-�j����_1.png");
        imageIcons[15] = new ImageIcon("D://hw//images//1-24//F4-���Ӷ��H�ָg-������_1.png");
        imageIcons[16] = new ImageIcon("D://hw//images//1-24//F5-���ֶ��x�g-�L�˥�_1.png");
        imageIcons[17] = new ImageIcon("D://hw//images//1-24//F6-�������G�g-���x��_1.png");
        imageIcons[18] = new ImageIcon("D://hw//images//1-24//F1-���ӳ��͸g-�ӥե�_1.png");
        imageIcons[19] = new ImageIcon("D://hw//images//1-24//F2-���ֳ��x�g-�ӽĥ�_1.png");
        imageIcons[20] = new ImageIcon("D://hw//images//1-24//F3-���ֳ��Ǹg-�j����_1.png");
        imageIcons[21] = new ImageIcon("D://hw//images//1-24//F4-���Ӷ��H�ָg-������_1.png");
        imageIcons[22] = new ImageIcon("D://hw//images//1-24//F5-���ֶ��x�g-�L�˥�_1.png");
        imageIcons[23] = new ImageIcon("D://hw//images//1-24//F6-�������G�g-���x��_1.png");
        // #endregion

        // #region ��J��
        datatJTextFields[0] = new JLabel("");
        datatJTextFields[1] = new JLabel("�͸g");
        datatJTextFields[2] = new JLabel("�ߥ]");
        datatJTextFields[3] = new JLabel("�߸g");
        datatJTextFields[4] = new JLabel("�p�z");
        datatJTextFields[5] = new JLabel("�T�J");
        datatJTextFields[6] = new JLabel("�j�z");
        datatJTextFields[7] = new JLabel("�ʸg");
        datatJTextFields[8] = new JLabel("�x�g");
        datatJTextFields[9] = new JLabel("�Ǹg");
        datatJTextFields[10] = new JLabel("�H��");
        datatJTextFields[11] = new JLabel("�x�g");
        datatJTextFields[12] = new JLabel("�G�g");
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
        witgh = 21;// ��l�Ʀ�m
        datatJTextFields[13] = new JLabel("����");
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
        witgh = 21;// ��l�Ʀ�m
        datatJTextFields[26] = new JLabel("�k��");
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
        // #region �\���m
        /**
         * �}�l���q  
         */
        startbutton.setBounds(10, 75, 120, 50);// �]�w�\���m
        startbutton.setFont(font1);// �]�w�L�n������
        startbutton.setForeground(Color.white);// �]�w�r���C��
        startbutton.setOpaque(true);
        startbutton.setBackground(Color.blue);
        startbutton.setHorizontalAlignment(JLabel.CENTER);
        startbutton.setCursor(cursor);
        startbutton.setToolTipText(
                "<html><div style='margin:0 -3 0 -3; padding: 0 3 0 3; background:white; color:black;font-size:16px;font-family:Microsoft JhengHei;'>�}�l���q</div></html>");
        /**
         * �洫�}�l���q  
         */
        ChangeStartButton.setBounds(10, 75, 120, 50);// �]�w�\���m
        ChangeStartButton.setFont(font1);// �]�w�L�n������
        ChangeStartButton.setForeground(Color.white);// �]�w�r���C��
        ChangeStartButton.setOpaque(true);
        ChangeStartButton.setBackground(new Color(220, 220, 220));// �L�Ǧ�
        ChangeStartButton.setHorizontalAlignment(JLabel.CENTER);

        // isulinkbutton.setBounds(1820, 70, 80, 80);
        /**
         * ������q  
         */
        stopbutton.setBounds(150, 75, 120, 50);// �]�w�\���m
        stopbutton.setFont(font1);// �]�w�L�n������
        stopbutton.setForeground(Color.white);// �]�w�r���C��
        stopbutton.setBackground(new Color(220, 220, 220));// �L�Ǧ�
        stopbutton.setOpaque(true);
        stopbutton.setHorizontalAlignment(JLabel.CENTER);

        /**
         * ���s���q  
         */
        againbutton.setBounds(290, 75, 120, 50);// �]�w�\���m
        againbutton.setFont(font1);// �]�w�L�n������
        againbutton.setForeground(Color.white);// �]�w�r���C��
        // againbutton.setBackground(new Color(61, 145, 64));//
        // �⭫�s���q���s�ܦ����N��i�H�ϥ�
        againbutton.setBackground(new Color(220, 220, 220));// �⭫�s���q���s�ܦ����N��i�H�ϥ� 
        againbutton.setOpaque(true);
        againbutton.setHorizontalAlignment(JLabel.CENTER);

        /******************************************
         * �g�ߴ��q  
         ****************************************/
        MeridianLabel.setBounds(715, 75, 120, 50);// �]�w�\���m
        MeridianLabel.setFont(font1);// �]�w�L�n������
        MeridianLabel.setForeground(new Color(25, 25, 112));// �]�w�r���C��
        // MeridianLabel.setOpaque(true);
        // MeridianLabel.setBackground(new Color(61, 145, 64));
        MeridianLabel.setHorizontalAlignment(JLabel.CENTER);

        /******************************************
         * �ƾڤ��R  
         ****************************************/
        AnalyzeLabel.setBounds(865, 75, 120, 50);// �]�w�\���m
        AnalyzeLabel.setFont(font1);// �]�w�L�n������
        AnalyzeLabel.setForeground(new Color(25, 25, 112));// �]�w�r���C��
        // AnalyzeLabel.setBackground(new Color(61, 145, 64));
        // AnalyzeLabel.setOpaque(true);
        AnalyzeLabel.setHorizontalAlignment(JLabel.CENTER);

        /******************************************
         * ���q�Ϥ� 
         ****************************************/
        imagelabel.setBounds(50, 50, 740, 520); // �Ϥ��\���m
        // imagelabel.setBorder(BorderFactory.createLoweredBevelBorder()); // �]�w�W���
        // imagelabel.setBorder(blackline); // �]�w�W���
        imagelabel.setHorizontalAlignment(JLabel.CENTER);
        /******************************************
         * �k�W���������s 
         ****************************************/
        closebutton.setBounds(1870, 0, 50, 50); // �������s�\���m
        /******************************************
         * �k�W��̤p�ƫ��s 
         ****************************************/
        minusbutton.setBounds(1820, 0, 50, 50); // �Y�p���s�\���m
        /*******************************************
         * �ƾڮ�̭����k����
         ****************************************/
        LeftRight.setBounds(23, 85, 137, 50); // �ƾڮ樬�����Ҧ�m
        LeftRight.setFont(font2);
        LeftRight.setForeground(Color.black);
        LeftRight.setHorizontalAlignment(JLabel.CENTER);
        LeftRight.setOpaque(true);
        LeftRight.setToolTipText(
                "<html><div style='margin:0 -3 0 -3; padding: 0 3 0 3; background:white; color:black;font-size:16px;font-family:Microsoft JhengHei;'>��/�k</div></html>");
        // LeftRight.setBorder(BorderFactory.c reateLoweredBevelBorder());
        /******************************************
         * �ƾڮ�ⳡ���� 
         ****************************************/
        HandTextlabel.setBounds(169, 85, 850, 50); // �ƾڮ�ⳡ���Ҧ�m
        HandTextlabel.setFont(font2);
        HandTextlabel.setForeground(Color.black);
        HandTextlabel.setHorizontalAlignment(JLabel.CENTER);
        HandTextlabel.setOpaque(true);
        // HandTextlabel.setBackground(Color.WHITE);
        // HandTextlabel.setBorder(BorderFactory.createLoweredBevelBorder());

        /******************************************
         * �ƾڮ樬������ 
         ****************************************/
        FoodTextlabel.setBounds(1028, 85, 853, 50); // �ƾڮ樬�����Ҧ�m
        FoodTextlabel.setFont(font2);
        FoodTextlabel.setForeground(Color.black);
        FoodTextlabel.setHorizontalAlignment(JLabel.CENTER);
        FoodTextlabel.setOpaque(true);
        // FoodTextlabel.setBorder(BorderFactory.createLoweredBevelBorder());
        // FoodTextlabel.setBackground(Color.WHITE);

        /*******************************************
         * �ƾڮ�̭��g�߯�q���w�ȼ��D
         ****************************************/
        MeridianValue.setBounds(930, 0, 250, 50);
        MeridianValue.setFont(font2);
        MeridianValue.setForeground(Color.WHITE);

        /*******************************************
         * �Ϥ����O�̭����w�I�ϥ�
         ****************************************/
        MeasurementPointIcon.setBounds(0, 0, 885, 50);
        MeasurementPointIcon.setFont(font2);
        MeasurementPointIcon.setOpaque(true);
        MeasurementPointIcon.setBackground(new Color(112, 135, 163));// ���Ŧ�
        MeasurementPointIcon.setHorizontalAlignment(JLabel.CENTER);
        MeasurementPointIcon.setForeground(Color.WHITE);

        /*******************************************
         * ��u�ϸ̭����q���Ź�
         ****************************************/
        MeasurementBalanceChart.setBounds(0, 0, 1005, 50);
        MeasurementBalanceChart.setFont(font2);
        MeasurementBalanceChart.setOpaque(true);
        MeasurementBalanceChart.setBackground(new Color(112, 135, 163));// ���Ŧ�
        MeasurementBalanceChart.setHorizontalAlignment(JLabel.CENTER);
        MeasurementBalanceChart.setForeground(Color.WHITE);

        /******************************************
         * �i�ױ� 
         ****************************************/
        jProgressBar.setBounds(25, 25, 960, 50);
        jProgressBar.setBackground(new Color(241, 241, 241));// ���Ŧ�
        jProgressBar.setForeground(runblue);// �]�w�����C��
        // jProgressBar.setForeground(new Color(112, 135, 163));// ���Ŧ� �]�w�����C��
        jProgressBar.setStringPainted(true);// ��ܦr�Ŧ�or�ʤ���
        jProgressBar.setBorderPainted(false);// �]�w�����ܧ_
        jProgressBar.setFont(font3);// �]�w�L�n������
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);// �]�w�����C��
        UIManager.put("ProgressBar.selectionForeground", Color.WHITE);

        // jButton.setBounds(200, 30, 90, 85);// �]�w�\���m
        /******************************************
         * ��J�Ҧ�����j���O
         ****************************************/
        BlackPanel.setBounds(0, 130, 1920, 950);// �]�w�I���\���m
        // BlackPanel.setBackground(new Color(245, 245, 220));// �]�w�̥��C��
        // BlackPanel.setBackground(new Color(126, 187, 177));// �]�w�Ŧ��C��
        // BlackPanel.setBackground(Color.WHITE);// �]�w�զ��C��
        BlackPanel.setOpaque(true);// �]�m���O�z��
        BlackPanel.setLayout(null);// �]�w�ť���
        /******************************************
         * ��J�̤W��Ҧ��u����s�]�t�����Y�p�A�p���O 
         ****************************************/
        boxPanel.setBounds(0, 0, 1920, 130);// �]�w�I���\���m
        boxPanel.setBackground(Color.WHITE);// �]�w�Ŧ��C��
        boxPanel.setLayout(null);// �]�w�ť���
        /******************************************
         * �������O ���ӦҼ{��令�ƾڤ��R���O�άO�Ȥ��ƭ��O
         ****************************************/
        box2Panel.setBounds(-1920, 100, 1920, 980);// �]�w�I���\���m
        box2Panel.setLayout(null);
        box2Panel.setBackground(new Color(126, 187, 177));// �]�w�Ŧ��C��
        /******************************************
         * ���U�ƾڮ歱�O
         ****************************************/
        Black1Panel.setBounds(10, 595, 1900, 345);// �]�w���U�ƾ��\���m
        Black1Panel.setBorder(blackline);
        Black1Panel.setBackground(Color.WHITE);
        Black1Panel.setLayout(null);// �]�w�ť���
        /******************************************
         * �i�ױ����O
         ****************************************/
        Black2Panel.setBounds(905, 485, 1005, 100);// �]�w�i�ױ��\���m
        // Black2Panel.setBorder(BorderFactory.createLoweredBevelBorder());
        Black2Panel.setBorder(blackline);
        Black2Panel.setBackground(Color.WHITE);
        // Black2Panel.setBackground(new Color(46,125,199));// �]�w�~���C��
        // Black2Panel.setBounds(25, 125, 1005, 440);// �]�w��{�\���m
        Black2Panel.setLayout(null);// �]�w�ť���
        /******************************************
         * ��u�ϭ��O
         ****************************************/
        Black3Panel.setBounds(905, 15, 1005, 460);// �]�w��{�\���m
        // Black3Panel.setBounds(25, 125, 1005, 440);// �]�w��{�\���m
        // Black3Panel.setBorder(BorderFactory.createLoweredBevelBorder());
        Black3Panel.setBackground(Color.WHITE);
        Black3Panel.setBorder(blackline);
        Black3Panel.setLayout(null);// �]�w�ť���
        /******************************************
         * �Ϥ����O
         ****************************************/
        Black4Panel.setBounds(10, 15, 885, 570);// �]�w�Ϥ��\���m
        // Black4Panel.setBounds(1055, 125, 840, 570);// �]�w�Ϥ��\���m
        Black4Panel.setLayout(null);// �]�w�ť���
        Black4Panel.setBackground(Color.WHITE);
        Black4Panel.setBorder(blackline);
        /******************************************
         * �ƾڮ�̭��g�߯�q���w�ȼ��D���O
         ****************************************/
        MeridianValuePanel.setBounds(0, 0, 1900, 50);// �]�w�ƾڮ�̭��g�߯�q���w�ȼ��D���O��m
        MeridianValuePanel.setLayout(null);// �]�w�ť���
        MeridianValuePanel.setBackground(new Color(112, 135, 163));// ���Ŧ�
        /******************************************
         * ���ΤW����s�P���U���O��ɽu
         ****************************************/
        BlickLinePanel.setBounds(0, 123, 1920, 5);
        // BlickLinePanel.setBackground(new Color(3, 168, 158));
        BlickLinePanel.setBackground(Color.WHITE);

        BlickLinePanel.setLayout(null);
        /******************************************
         * �s���W����s�P���U���O��ɽu�ʺA�u��
         ****************************************/
        connectBlickLinePanel.setBounds(715, 0, 120, 5);
        connectBlickLinePanel.setBackground(new Color(25, 25, 112));

        /******************************************
        
        ****************************************/
        jButton.setBounds(480, 270, 960, 540);

        /**
         * �U�ح��O�[�J
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

        setLayout(null);// �]�w�ť���
        setSize(1920, 1080);// �]�w�����j�p
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �]�w�����覡
        setExtendedState(JFrame.MAXIMIZED_BOTH);// �]�w�ù��̤j�� 
        setUndecorated(true);// �]�w����Windows ���� �̤p�� �Y��\��
        // setResizable(false);//�]�w�����Y��
        // setLocationRelativeTo(null);// �]�w�ù��~�����

    }
}
// #endregion

// #endregion