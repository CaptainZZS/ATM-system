import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Management_interface extends JFrame {
    static String bankcard_get = Login_interface.textField.getText();
//    static String bankcard_get = "622821 2299030127370";
    private static JLabel label,label1,label2;
    private static JButton Message1_Button,Message2_Button,exitButton;

    public Management_interface(){
        super();
        setTitle("管理界面");
        setBounds(500,50,600,700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql1 = "select name from message1 where bank_card = ?";
        String str1 = template.queryForObject(sql1, String.class, bankcard_get);

        label = new JLabel();
        label.setForeground(new Color(255, 0, 40));
        label.setFont(new Font("黑体",Font.BOLD,35));
        label.setText("欢迎使用管理界面！");
        label.setBounds(130,5,1000,100);
        getContentPane().add(label);

        label1 = new JLabel();
        label1.setForeground(new Color(17, 76, 255));
        label1.setFont(new Font("黑体",Font.BOLD,30));
        label1.setText("用户："+str1);
        label1.setBounds(50,50,1000,100);
        getContentPane().add(label1);

        label2 = new JLabel();
        label2.setForeground(new Color(17, 76, 255));
        label2.setFont(new Font("黑体",Font.BOLD,30));
        label2.setText("工号："+bankcard_get);
        label2.setBounds(50,80,1000,100);
        getContentPane().add(label2);


        Message1_Button = new JButton();
        Message1_Button.setFont(new Font("",Font.BOLD,40));
        Message1_Button.setText("查询信息一");
        Message1_Button.setBounds(150,250,250,50);
        getContentPane().add(Message1_Button);

        Message2_Button = new JButton();
        Message2_Button.setFont(new Font("",Font.BOLD,40));
        Message2_Button.setText("查询信息二");
        Message2_Button.setBounds(150,350,250,50);
        getContentPane().add(Message2_Button);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(150,450,250,50);
        getContentPane().add(exitButton);

        ActionListener Message1_Button_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message1_interface message1_interface = new Message1_interface();
                message1_interface.setVisible(true);
            }
        };Message1_Button.addActionListener(Message1_Button_ls);

        ActionListener Message2_Button_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message2_interface message1_interface = new Message2_interface();
                message1_interface.setVisible(true);
            }
        };Message2_Button.addActionListener(Message2_Button_ls);

        ActionListener exitButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };exitButton.addActionListener(exitButton_ls);

    }

    public static void main(String[] args) {
        Management_interface management_interface = new Management_interface();
        management_interface.setVisible(true);
    }
}
