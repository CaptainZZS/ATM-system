import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration_Successful2_1 extends JFrame {
    private static JFrame jf;
    private static JLabel jl;
    static String job_number = "";
    private static JButton registButton;
    private static JButton backButton;
    public Registration_Successful2_1(){
        jf=new JFrame("Secret_Key");
        jf.setVisible(true);
        jf.setBounds(150,100,1200,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl=new JLabel();
        jf.add(jl);
        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("请输入密钥：");
        label.setBounds(300,150,300,100);
        jl.add(label);
        final TextField label2 = new TextField();
        label2.setForeground(new Color(255, 0, 0));
        label2.setFont(new Font("",Font.BOLD,40));
        label2.setBounds(600,175,300,50);
        jl.add(label2);

        registButton = new JButton();
        registButton.setFont(new Font("",Font.BOLD,40));
        registButton.setText("注册");
        registButton.setBounds(300,300,150,100);
        jl.add(registButton);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("退出");
        backButton.setBounds(700,300,150,100);
        jl.add(backButton);

        ActionListener registButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String miyao = label2.getText();
                if (miyao.equals("fynroot")){
                    job_number = Registration_interface.Job_number;
                    String admin = Registration_interface.admin;
                    String password2_get = Registration_interface.password2_get;
                    String usertype_get = Registration_interface.usertype_get;
                    String idcard_get = Registration_interface.idcard_get;
                    String phone_get = Registration_interface.phone_get;
                    System.out.println(job_number);
                    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
                    String sql = "insert into message1(id,name,password,user_type,bank_card,id_card,balance,phone_number) value (?,?,?,?,?,?,?,?)";
                    Object args[] = {null,admin,password2_get,usertype_get,job_number,idcard_get,0,phone_get};
                    int flag1 = template.update(sql,args);
                    if(flag1 == 1){
                        Registration_Successful2_2 registration_successful2_2 = new Registration_Successful2_2();
                        registration_successful2_2.setVisible(true);
                    }


                }else{

                    Warning3 warning3 = new Warning3();

                }
                jf.dispose();//终止当前程序
            }
        };
        registButton.addActionListener(registButton_ls);

        ActionListener backButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                /*Login_interface login_interface = new Login_interface();
                login_interface.setVisible(true);*/
                jf.dispose();//终止当前程序
            }
        };
        backButton.addActionListener(backButton_ls);



    }

    public static void main(String[] args) {
        Registration_Successful2_1 pe = new Registration_Successful2_1();
        pe.setVisible(true);


    }
}

