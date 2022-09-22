import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Change_password_interface extends JFrame{
    private static JLabel label1,label3,label5;
    private static JPasswordField label2,label4,label6;
    private static JButton exitButton,Changepassword_Button,backButton;
//    static String bankcard_get = "622821 2299030127370";
    static String bankcard_get = Operation_interface.bankcard_get;
    public Change_password_interface(){
        super();
        setTitle("改密界面");
        setBounds(500,50,600,800);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel();
        label1.setForeground(new Color(255, 0, 0));
        label1.setFont(new Font("",Font.BOLD,40));
        label1.setText("请输入密码");
        label1.setBounds(180,20,1000,50);
        add(label1);

        label2 = new JPasswordField();
        label2.setFont(new Font("",Font.BOLD,40));
        label2.setBounds(110,70,350,50);
        add(label2);

        label3 = new JLabel();
        label3.setForeground(new Color(255, 0, 0));
        label3.setFont(new Font("",Font.BOLD,40));
        label3.setText("请输入新密码");
        label3.setBounds(160,150,1000,50);
        add(label3);

        label4 = new JPasswordField();
        label4.setFont(new Font("",Font.BOLD,40));
        label4.setBounds(110,200,350,50);
        add(label4);

        label5 = new JLabel();
        label5.setForeground(new Color(255, 0, 0));
        label5.setFont(new Font("",Font.BOLD,40));
        label5.setText("请再次输入新密码");
        label5.setBounds(115,280,1000,50);
        add(label5);

        label6 = new JPasswordField();
        label6.setFont(new Font("",Font.BOLD,40));
        label6.setBounds(110,330,350,50);
        add(label6);

        Changepassword_Button = new JButton();
        Changepassword_Button.setFont(new Font("",Font.BOLD,40));
        Changepassword_Button.setText("确认");
        Changepassword_Button.setBounds(210,450,150,50);
        add(Changepassword_Button);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(210,550,150,50);
        add(backButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(210,650,150,50);
        add(exitButton);

        ActionListener Changepassword_Button_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password1_char=label2.getPassword();
                String password1=String.valueOf(password1_char);
                char[] password2_char=label4.getPassword();
                String password2=String.valueOf(password2_char);
                char[] password3_char=label6.getPassword();
                String password3=String.valueOf(password3_char);
                JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
                String sql1 = "select password from message1 where bank_card = ?";
                String str1 = template.queryForObject(sql1, String.class, bankcard_get);
                if (str1.equals(password1)){
                    if (password2.equals(password3) & password2 != ""){
                        String sql2 = "update message1 set password = ? where bank_card = ?";
                        int update = template.update(sql2,password2, bankcard_get);
                        if (update == 1){
                            Warning14 warning14 = new Warning14();
                            dispose();
                        }
                    }else{
                        Warning15 warning15 = new Warning15();
                        label4.setText("");
                        label6.setText("");
                    }
                }else{
                    Warning13 warning13 = new Warning13();
                    label2.setText("");
                }
            }
        };Changepassword_Button.addActionListener(Changepassword_Button_ls);


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
        Change_password_interface change_password_interface = new Change_password_interface();
        change_password_interface.setVisible(true);

    }
}
