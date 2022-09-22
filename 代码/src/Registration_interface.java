import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Registration_interface extends JFrame {
    static String bank_card = "622821 229903012";
    static String Job_number = "";
    private static JLabel usernameLabel;
    private static JLabel passwordLabel;
    private static JLabel passwordLabel_again;
    private static JLabel usertypeLabel;
    private static JLabel idcardLabel;
    private static JLabel phoneLabel;
    private static JTextField textField1;
    private static JPasswordField textField2;
    private static JPasswordField textField3;
    private static JTextField textField4;
    private static JTextField textField5;
    private static JButton exitButton;
    private static JButton RegistButton;
    private static JButton ResetButton;
    static String admin;
    static  String password2_get;
    static String usertype_get;
    static String idcard_get;
    static String phone_get;
    public Registration_interface(){
        super();
        setTitle("注册界面");
        setBounds(150,100,1200,700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("欢迎注册！");
        label.setBounds(500,10,1000,100);
        getContentPane().add(label);

        usernameLabel = new JLabel();
        usernameLabel.setFont(new Font("",Font.BOLD,30));
        usernameLabel.setText("用户名：");
        usernameLabel.setBounds(100,130,150,50);
        getContentPane().add(usernameLabel);
        textField1 = new JTextField();
        textField1.setFont(new Font("",Font.BOLD,40));
        textField1.setBounds(210,130,300,50);
        getContentPane().add(textField1);

        passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("",Font.BOLD,30));
        passwordLabel.setText("密 码：");
        passwordLabel.setBounds(650,130,150,50);
        getContentPane().add(passwordLabel);
        textField2 = new JPasswordField();
        textField2.setFont(new Font("",Font.BOLD,40));
        textField2.setBounds(750,130,300,50);
        getContentPane().add(textField2);

        passwordLabel_again = new JLabel();
        passwordLabel_again.setFont(new Font("",Font.BOLD,30));
        passwordLabel_again.setText("确认密码：");
        passwordLabel_again.setBounds(600,220,170,50);
        getContentPane().add(passwordLabel_again);
        textField3 = new JPasswordField();
        textField3.setFont(new Font("",Font.BOLD,40));
        textField3.setBounds(750,220,300,50);
        getContentPane().add(textField3);

        usertypeLabel = new JLabel();
        usertypeLabel.setFont(new Font("",Font.BOLD,30));
        usertypeLabel.setText("用户类别：");
        usertypeLabel.setBounds(70,220,170,50);
        getContentPane().add(usertypeLabel);
        String []type= {"普通用户","管理员"};
        JComboBox jcb1=new JComboBox(type);
        jcb1.setFont(new Font("",Font.BOLD,30));
        jcb1.setBounds(210,220,300,50);
        getContentPane().add(jcb1);

        idcardLabel = new JLabel();
        idcardLabel.setFont(new Font("",Font.BOLD,30));
        idcardLabel.setText("身份证号：");
        idcardLabel.setBounds(70,300,170,50);
        getContentPane().add(idcardLabel);
        textField4 = new JTextField();
        textField4.setFont(new Font("",Font.BOLD,40));
        textField4.setBounds(210,300,300,50);
        getContentPane().add(textField4);

        phoneLabel = new JLabel();
        phoneLabel.setFont(new Font("",Font.BOLD,30));
        phoneLabel.setText("电话号码：");
        phoneLabel.setBounds(600,300,170,50);
        getContentPane().add(phoneLabel);
        textField5 = new JTextField();
        textField5.setFont(new Font("",Font.BOLD,40));
        textField5.setBounds(750,300,300,50);
        getContentPane().add(textField5);

        RegistButton = new JButton();
        RegistButton.setFont(new Font("",Font.BOLD,40));
        RegistButton.setText("注册");
        RegistButton.setBounds(250,450,150,100);
        getContentPane().add(RegistButton);

        ResetButton = new JButton();
        ResetButton.setFont(new Font("",Font.BOLD,40));
        ResetButton.setText("重置");
        ResetButton.setBounds(500,450,150,100);
        getContentPane().add(ResetButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(750,450,150,100);
        getContentPane().add(exitButton);

//        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        ActionListener RegistButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin=textField1.getText();
                char[] password1=textField2.getPassword();
                String password1_get=String.valueOf(password1);
                char[] password2=textField2.getPassword();
                password2_get=String.valueOf(password2);
                idcard_get = textField4.getText();
                phone_get = textField5.getText();
                usertype_get = (String) jcb1.getSelectedItem();

                if ((admin.equals(""))||(password1_get.equals(""))||(password2_get.equals(""))||(idcard_get.equals(""))||(phone_get.equals(""))){
                    Warning1 warning1 = new Warning1();
                }else{
                    Boolean flag2 = password1_get.length() == 6;
                    Boolean flag3 = password1_get.equals(password2_get);
                    if (usertype_get.equals("普通用户")){
                        System.out.println("yes");
                        Random random=new Random();
                        int i=4;
                        while(i>0){
                            i--;
                            String a=String.valueOf(random.nextInt(10));
                            bank_card += a;
                        }
                        if (flag2&flag3) {
                            System.out.println(bank_card);
                            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
                            String sql = "insert into message1(id,name,password,user_type,bank_card,id_card,balance,phone_number) value (?,?,?,?,?,?,?,?)";
                            Object args[] = {null,admin,password2_get,usertype_get,bank_card,idcard_get,0,phone_get};
                            int flag1 = template.update(sql,args);
                            if (flag1 == 1){
                                Registration_Successful1 registration_successful1 = new Registration_Successful1();
                                dispose();
                            }
                        }else{
                            System.out.println(password1_get.equals(password2_get));
                            System.out.println(password1_get.length() == 6);
                            Password_error3 pe3 = new Password_error3();
                            textField2.setText("");
                            textField3.setText("");
                        }
                    }else{
                        Random random=new Random();
                        int i=4;
                        while(i>0){
                            i--;
                            int a=random.nextInt(10);
                            Job_number += a;
                        }
                        if (flag2&flag3) {
                            Registration_Successful2_1 registration_successful2_1 = new Registration_Successful2_1();
                            dispose();


                        }else{
                            System.out.println(password1_get.equals(password2_get));
                            System.out.println(password1_get.length() == 6);
                            Password_error3 pe3 = new Password_error3();
                            textField2.setText("");
                            textField3.setText("");
                        }
                    }


                    }

                }
        };RegistButton.addActionListener(RegistButton_ls);

        ActionListener ResetButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
            }
        };ResetButton.addActionListener(ResetButton_ls);

        ActionListener exitButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };exitButton.addActionListener(exitButton_ls);
    }

    public static void main(String[] args) {
        Registration_interface ri = new Registration_interface();
        ri.setVisible(true);



    }
}
