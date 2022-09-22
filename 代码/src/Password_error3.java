import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password_error3 extends JFrame {
    private static JFrame jf;
    private static JLabel jl;
    private static JButton exitButton;
    private static JButton backButton;
    public Password_error3(){
        jf=new JFrame("Password_error");
        jf.setVisible(true);
        jf.setBounds(150,100,1200,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl=new JLabel();
        jf.add(jl);
        final JLabel label1 = new JLabel();
        label1.setForeground(new Color(255, 0, 0));
        label1.setFont(new Font("",Font.BOLD,40));
        label1.setText("密码格式不正确（六位0~9数字）/两次输入密码不相同");
        label1.setBounds(100,150,1000,100);
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(255, 0, 0));
        label2.setFont(new Font("",Font.BOLD,40));
        label2.setText("请返回重新输入！");
        label2.setBounds(450,200,1000,100);
        jl.add(label1);
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
                jf.dispose();;//终止当前程序
            }
        };
        backButton.addActionListener(backButton_ls);



    }

    public static void main(String[] args) {
        Password_error3 pe = new Password_error3();



    }
}

