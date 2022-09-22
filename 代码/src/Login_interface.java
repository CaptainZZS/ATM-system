import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_interface extends JFrame {
    public static JTextField textField;
    static int count=3;
    static String bankcard_get = "";
    public static void main(String[] args) {
        Login_interface frame = new Login_interface();
        frame.setVisible(true);
}

    public Login_interface(){
        super();
        setTitle("网上银行");
        setBounds(150,100,1200,700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("  网上银行系统");
        label.setBounds(430,50,300,100);
        getContentPane().add(label);

        final JLabel usernameLabel = new JLabel();
        usernameLabel.setFont(new Font("",Font.BOLD,30));
        usernameLabel.setText("卡 号：");
        usernameLabel.setBounds(350,200,150,100);
        getContentPane().add(usernameLabel);

        textField = new JTextField();
        textField.setFont(new Font("",Font.BOLD,40));
        textField.setBounds(500,200,300,80);
        getContentPane().add(textField);

        final JLabel passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("",Font.BOLD,30));
        passwordLabel.setText("密 码：");
        passwordLabel.setBounds(350,300,150,100);
        getContentPane().add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("",Font.BOLD,40));
        passwordField.setBounds(500,320,300,80);
        getContentPane().add(passwordField);

        final JButton exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(700,450,150,100);
        getContentPane().add(exitButton);

        final JButton landButton = new JButton();
        landButton.setFont(new Font("",Font.BOLD,40));
        landButton.setText("登录");
        landButton.setBounds(300,450,150,100);
        getContentPane().add(landButton);

        final JButton registerButton = new JButton();
        registerButton.setFont(new Font("",Font.BOLD,40));
        registerButton.setText("注册");
        registerButton.setBounds(500,450,150,100);
        getContentPane().add(registerButton);

        ActionListener landButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                bankcard_get = textField.getText();
                char[] password=passwordField.getPassword();
                String str=String.valueOf(password); //将char数组转化为string类型
                if (bankcard_get.length() == 20){
                    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
                    String sql = "select password from message1 where bank_card = ?";
                    try {
                        String flag1 = template.queryForObject(sql, String.class, bankcard_get);
                        if(flag1.equals(str)){
                            System.out.println(bankcard_get);
                            System.out.println(str);
                            if (bankcard_get.length() != 4){
                                Operation_interface operation_interface = new Operation_interface();
                                operation_interface.setVisible(true);
                                dispose();
                            }else {

                            }

                        }else{
                            count--;
                            System.out.println("error");
                            if(count!=0){
                                Password_error1 pe = new Password_error1();
                                dispose();
                            }else {
                                Password_error2 pe = new Password_error2();
                                dispose();
                            }
                        }
                    }catch (Exception e){
                        Warning2 warning2 = new Warning2();
                    }
                }else {
                    try{
                        Management_interface management_interface = new Management_interface();
                        management_interface.setVisible(true);}
                    catch (Exception e){
                        Warning2 warning2 = new Warning2();
                    }

                }

            }
        };landButton.addActionListener(landButton_ls);

        ActionListener registerButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration_interface registration_interface = new Registration_interface();
                registration_interface.setVisible(true);
                dispose();
            }
        };registerButton.addActionListener(registerButton_ls);

        ActionListener exitButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };exitButton.addActionListener(exitButton_ls);
    }

}
