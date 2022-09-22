import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transfer_accounts_interface extends JFrame {
    private static JLabel label1,label2,label3,label4,label6,label8;
    private static TextField label5,label7,label9;
    static String Opposite_account,Opposite_name,str1,str2,str4,money_str;
    private static JButton transfer_accounts_Button,backButton,exitButton;
//    static String bankcard_get = "622821 2299030127370";
    static String bankcard_get = Operation_interface.bankcard_get;
    public transfer_accounts_interface(){
        super();
        setTitle("转账界面");
        setBounds(500,50,600,800);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql1 = "select name from message1 where bank_card = ?";
        str1 = template.queryForObject(sql1, String.class, bankcard_get);
        String sql2 = "select balance from message1 where bank_card = ?";
        str2 = template.queryForObject(sql2, String.class, bankcard_get);
        String sql4 = "select id from message1 where bank_card = ?";
        str4 = template.queryForObject(sql4, String.class, bankcard_get);

        label1 = new JLabel();
        label1.setForeground(new Color(17, 76, 255));
        label1.setFont(new Font("黑体",Font.BOLD,30));
        label1.setText("用户："+str1);
        label1.setBounds(50,10,1000,100);
        getContentPane().add(label1);

        label2 = new JLabel();
        label2.setForeground(new Color(17, 76, 255));
        label2.setFont(new Font("黑体",Font.BOLD,30));
        label2.setText("银行卡号："+bankcard_get);
        label2.setBounds(50,40,1000,100);
        getContentPane().add(label2);

        label3 = new JLabel();
        label3.setForeground(new Color(17, 76, 255));
        label3.setFont(new Font("黑体",Font.BOLD,30));
        label3.setText("账户余额："+str2);
        label3.setBounds(50,70,1000,100);
        getContentPane().add(label3);

        label4 = new JLabel();
        label4.setForeground(new Color(17, 76, 255));
        label4.setFont(new Font("黑体",Font.BOLD,30));
        label4.setText("请在下方输入对方账号");
        label4.setBounds(120,150,1000,50);
        getContentPane().add(label4);

        label5 = new TextField();
        label5.setFont(new Font("",Font.BOLD,40));
        label5.setBounds(110,200,350,50);
        getContentPane().add(label5);

        label6 = new JLabel();
        label6.setForeground(new Color(17, 76, 255));
        label6.setFont(new Font("黑体",Font.BOLD,30));
        label6.setText("请在下方输入对方用户名");
        label6.setBounds(110,250,1000,50);
        getContentPane().add(label6);

        label7 = new TextField();
        label7.setFont(new Font("",Font.BOLD,40));
        label7.setBounds(110,300,350,50);
        getContentPane().add(label7);

        label8 = new JLabel();
        label8.setForeground(new Color(17, 76, 255));
        label8.setFont(new Font("黑体",Font.BOLD,30));
        label8.setText("请在下方输入转账金额");
        label8.setBounds(110,350,1000,50);
        getContentPane().add(label8);

        label9 = new TextField();
        label9.setFont(new Font("",Font.BOLD,40));
        label9.setBounds(110,400,350,50);
        getContentPane().add(label9);

        transfer_accounts_Button = new JButton();
        transfer_accounts_Button.setFont(new Font("",Font.BOLD,40));
        transfer_accounts_Button.setText("转账");
        transfer_accounts_Button.setBounds(210,475,150,50);
        getContentPane().add(transfer_accounts_Button);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(210,550,150,50);
        getContentPane().add(backButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(210,625,150,50);
        getContentPane().add(exitButton);

        ActionListener transfer_accounts_Button_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                money_str = label9.getText();
                Double balance = Double.valueOf(str2.toString());
                Double money = Double.valueOf(money_str.toString());
                if ( money<0 | money>balance){
                    Warning4 warning4 = new Warning4();
                    label9.setText("");
                }else{
                    Opposite_account = label5.getText();
                    Opposite_name = label7.getText();
                    String str3 = template.queryForObject(sql1, String.class, Opposite_account);
                    if (str3.equals(Opposite_name)){
                        Warning9 warning9 = new Warning9();
                        warning9.setVisible(true);
                        dispose();
                    }else{
                        Warning10 warning10 = new Warning10();
                        label5.setText("");
                        label7.setText("");
                    }


                }


                dispose();
            }
        };transfer_accounts_Button.addActionListener(transfer_accounts_Button_ls);

        ActionListener backButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };backButton.addActionListener(backButton_ls);

        ActionListener exitButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };exitButton.addActionListener(exitButton_ls);

    }


    public static void main(String[] args) {
        transfer_accounts_interface transfer_accounts_interface = new transfer_accounts_interface();
        transfer_accounts_interface.setVisible(true);
    }
}
