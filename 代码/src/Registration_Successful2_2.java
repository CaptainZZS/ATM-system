import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration_Successful2_2 extends JFrame {
    private static JFrame jf;
    private static JLabel jl;
    private static JButton exitButton;
    private static JButton backButton;
    public Registration_Successful2_2(){
        jf=new JFrame("Successful");
        jf.setVisible(true);
        jf.setBounds(150,100,1200,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl=new JLabel();
        jf.add(jl);
        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("注册成功！您的工号是"+Registration_Successful2_1.job_number);
        label.setBounds(350,150,1000,100);
        jl.add(label);
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(255, 0, 0));
        label2.setFont(new Font("",Font.BOLD,40));
        label2.setText("请牢记！点击返回重新登录");
        label2.setBounds(350,200,1000,100);
        jl.add(label2);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(500,450,150,100);
        jl.add(backButton);



        ActionListener backButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Login_interface login_interface = new Login_interface();
                login_interface.setVisible(true);
                jf.dispose();//终止当前程序
            }
        };
        backButton.addActionListener(backButton_ls);



    }

    public static void main(String[] args) {
        Registration_Successful2_2 pe = new Registration_Successful2_2();
        pe.setVisible(true);


    }
}

