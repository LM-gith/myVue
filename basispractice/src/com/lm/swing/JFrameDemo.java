package com.lm.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author luoming
 * @date 2019/12/25
 */
@SuppressWarnings("serial")
public class JFrameDemo extends JFrame {

    public static void main(String[] args) {
        JFrameDemo jFrameDemo = new JFrameDemo();
        jFrameDemo.jFrameDemo8(jFrameDemo);
    }

    public void jFrameDemo8(JFrameDemo frame) {
        frame.setTitle("Java示例程序");
        // 创建横向Box容器
        Box b1 = Box.createHorizontalBox();
        // 创建横向Box容器
        Box b2 = Box.createHorizontalBox();
        // 将外层横向Box添加进窗体
        frame.add(b1);
        // 添加高度为500的垂直框架
        b1.add(Box.createVerticalStrut(200));
        b1.add(new JTextField(28));
        // 添加按钮1
        b2.add(new JButton("西"));
        // 添加长度为140的水平框架
        b2.add(Box.createHorizontalStrut(100));
        // 添加按钮2
        b2.add(new JButton("东"));
        // 添加水平胶水
        b2.add(Box.createHorizontalGlue());
        // 添加嵌套的纵向Box容器
        b1.add(b2);

        // 设置窗口的关闭动作、标题、大小位置以及可见性等
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 200);
        frame.setVisible(true);
    }

    public void JFrameDemo11(JFrameDemo frame) {
        frame.setTitle("Java文本框组件示例"); // 创建Frame窗口
        JPanel jp = new JPanel(); // 创建面板
        JTextField txtfield1 = new JTextField(); // 创建文本框
        txtfield1.setText("普通文本框"); // 设置文本框的内容
        JTextField txtfield2 = new JTextField(28);
        txtfield2.setFont(new Font("楷体", Font.BOLD, 16)); // 修改字体样式
        txtfield2.setText("指定长度和字体的文本框");
        JTextField txtfield3 = new JTextField(30);
        txtfield3.setText("居中对齐");
        txtfield3.setHorizontalAlignment(JTextField.CENTER); // 居中对齐
        jp.add(txtfield1);
        jp.add(txtfield2);
        jp.add(txtfield3);
        frame.add(jp);
        frame.setBounds(300, 200, 400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void JFrameDemo7(JFrameDemo frame) {
        frame.setTitle("拨号盘");
        GridBagLayout gbaglayout = new GridBagLayout(); // 创建GridBagLayout布局管理器
        GridBagConstraints constraints = new GridBagConstraints();
        frame.setLayout(gbaglayout); // 使用GridBagLayout布局管理器
        constraints.fill = GridBagConstraints.BOTH; // 组件填充显示区域
        constraints.weightx = 0.0; // 恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER; // 结束行
        JTextField tf = new JTextField("13612345678");
        gbaglayout.setConstraints(tf, constraints);
        frame.add(tf);
        constraints.weightx = 0.5; // 指定组件的分配区域
        constraints.weighty = 0.2;
        constraints.gridwidth = 1;
        makeButton("7", frame, gbaglayout, constraints); // 调用方法，添加按钮组件
        makeButton("8", frame, gbaglayout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER; // 结束行
        makeButton("9", frame, gbaglayout, constraints);
        constraints.gridwidth = 1; // 重新设置gridwidth的值

        makeButton("4", frame, gbaglayout, constraints);
        makeButton("5", frame, gbaglayout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("6", frame, gbaglayout, constraints);
        constraints.gridwidth = 1;

        makeButton("1", frame, gbaglayout, constraints);
        makeButton("2", frame, gbaglayout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("3", frame, gbaglayout, constraints);
        constraints.gridwidth = 1;

        makeButton("返回", frame, gbaglayout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("拨号", frame, gbaglayout, constraints);
        constraints.gridwidth = 1;
        frame.setBounds(400, 400, 400, 400); // 设置容器大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 向JFrame中添加JButton按钮
    public static void makeButton(String title, JFrame frame, GridBagLayout gridBagLayout,
                                  GridBagConstraints constraints) {
        JButton button = new JButton(title); // 创建Button对象
        gridBagLayout.setConstraints(button, constraints);
        frame.add(button);
    }

    public void JFrameDemo10(JFrameDemo frame) {
        frame.setTitle("Java按钮组件示例"); // 创建Frame窗口
        frame.setSize(400, 200);
        JPanel jp = new JPanel(); // 创建JPanel对象
        JButton btn1 = new JButton("我是普通按钮"); // 创建JButton对象
        JButton btn2 = new JButton("我是带背景颜色按钮");
        JButton btn3 = new JButton("我是不可用按钮");
        JButton btn4 = new JButton("我是底部对齐按钮");
        jp.add(btn1);
        btn2.setBackground(Color.YELLOW); // 设置按钮背景色
        jp.add(btn2);
        btn3.setEnabled(false); // 设置按钮不可用
        jp.add(btn3);
        Dimension preferredSize = new Dimension(160, 60); // 设置尺寸
        btn4.setPreferredSize(preferredSize); // 设置按钮大小
        btn4.setVerticalAlignment(SwingConstants.BOTTOM); // 设置按钮垂直对齐方式
        jp.add(btn4);
        frame.add(jp);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void JFrameDemo9(JFrameDemo frame) {
        frame.setTitle("Java标签组件示例"); // 创建Frame窗口
        JPanel jp = new JPanel(); // 创建面板
        JLabel label1 = new JLabel("普通标签"); // 创建标签
        JLabel label2 = new JLabel();
        label2.setText("调用setText()方法");
        ImageIcon img = new ImageIcon("C:\\Users\\luoming\\Pictures\\Saved Pictures\\com.lm.test.jpg"); // 创建一个图标
        // 创建既含有文本又含有图标的JLabel对象
        JLabel label3 = new JLabel("开始理财", img, JLabel.CENTER);
        jp.add(label1); // 添加标签到面板
        jp.add(label2);
        jp.add(label3);
        frame.add(jp);
        frame.setBounds(300, 200, 400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void JFrameDemo6(JFrameDemo frame) {
        frame.setTitle("GridLayou布局计算器");
        JPanel panel = new JPanel(); // 创建面板
        // 指定面板的布局为GridLayout，4行4列，间隙为5
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        panel.add(new JButton("7")); // 添加按钮
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("/"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("*"));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("-"));
        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));
        panel.add(new JButton("+"));
        frame.add(panel); // 添加面板到容器
        frame.setBounds(300, 200, 200, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void jFrameDemo5(JFrameDemo frame) {
        frame.setTitle("Java第五个程序"); // 创建Frame窗口
        JPanel p1 = new JPanel(); // 面板1
        JPanel p2 = new JPanel(); // 面板2
        JPanel cards = new JPanel(new CardLayout()); // 卡片式布局的面板
        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(new JButton("找回密码按钮"));
        p2.add(new JTextField("用户名文本框", 20));
        p2.add(new JTextField("密码文本框", 20));
        p2.add(new JTextField("验证码文本框", 20));
        cards.add(p1, "card1"); // 向卡片式布局面板中添加面板1
        cards.add(p2, "card2"); // 向卡片式布局面板中添加面板2
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1"); // 调用show()方法显示面板2
        frame.add(cards);
        frame.setBounds(300, 200, 400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void jFrameDemo4(JFrameDemo jFrame) {
        jFrame.setTitle("Java第四个GUI程序"); // 创建Frame窗口
        JPanel jPanel = new JPanel(); // 创建面板
        JButton btn1 = new JButton("1"); // 创建按钮
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        jPanel.add(btn1); // 面板中添加按钮
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        // 向JPanel添加FlowLayout布局管理器，将组件间的横向和纵向间隙都设置为20像素
        jPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        // 设置背景色
        jPanel.setBackground(Color.gray);
        // 添加面板到容器
        jFrame.add(jPanel);
        // 设置容器的大小
        jFrame.setBounds(300, 200, 300, 150);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void JFrameDemo3(JFrameDemo jFrameDemo) {
        // 创建Frame窗口
        jFrameDemo.setTitle("Java第三个GUI程序");
        jFrameDemo.setSize(400, 200);
        // 为Frame窗口设置布局为BorderLayout
        jFrameDemo.setLayout(new BorderLayout());
        JButton button1 = new JButton("上");
        JButton button2 = new JButton("左");
        JButton button3 = new JButton("中");
        JButton button4 = new JButton("右");
        JButton button5 = new JButton("下");
        jFrameDemo.add(button1, BorderLayout.NORTH);
        jFrameDemo.add(button2, BorderLayout.WEST);
        jFrameDemo.add(button3, BorderLayout.CENTER);
        jFrameDemo.add(button4, BorderLayout.EAST);
        jFrameDemo.add(button5, BorderLayout.SOUTH);
        jFrameDemo.setBounds(300, 200, 600, 300);
        jFrameDemo.setVisible(true);
        jFrameDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void jFrameDemo2(JFrameDemo jFrameDemo) {
        // 创建一个JFrame对象
        jFrameDemo.setTitle("Java第二个GUI程序");
        // 设置窗口位置和大小
        jFrameDemo.setBounds(600, 300, 400, 200);
        // 创建一个JPanel对象
        JPanel jp = new JPanel();
        // 创建一个标签
        JLabel jl = new JLabel("这是放在JPanel上的标签");
        jl.setForeground(Color.white);
        // 设置背景色
        jp.setBackground(Color.darkGray);
        // 将标签添加到面板
        jp.add(jl);
        // 将面板添加到窗口
        jFrameDemo.add(jp);
        // 设置窗口可见
        jFrameDemo.setVisible(true);
    }

    public void jFrameDemo1(JFrameDemo jFrameDemo) {
        // 设置显示窗口标题
        jFrameDemo.setTitle("Java 第一个 GUI 程序");
        // 设置窗口显示尺寸
        jFrameDemo.setSize(400, 200);
        // 置窗口是否可以关闭
        jFrameDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 创建一个标签
        JLabel jl = new JLabel("这是使用JFrame类创建的窗口");
        // 获取当前窗口的内容窗格
        Container c = getContentPane();
        // 将标签组件添加到内容窗格上
        c.add(jl);
        // 设置窗口是否可见
        jFrameDemo.setVisible(true);
    }
}
