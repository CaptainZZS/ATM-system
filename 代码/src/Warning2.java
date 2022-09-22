import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning2 extends JFrame {
    private static JFrame jf;
    private static JLabel jl;
    private static JButton registButton;
    private static JButton backButton;
    public Warning2(){
        jf=new JFrame("Warning");
        jf.setVisible(true);
        jf.setBounds(150,100,1200,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl=new JLabel();
        jf.add(jl);
        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("        卡号不存在！请重新输入");
        label.setBounds(250,150,1000,100);
        jl.add(label);
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(255, 0, 0));
        label2.setFont(new Font("",Font.BOLD,40));
        label2.setText("           若没有卡号请注册！");
        label2.setBounds(250,200,1000,100);
        jl.add(label2);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(750,450,150,100);
        jl.add(backButton);

        registButton = new JButton();
        registButton.setFont(new Font("",Font.BOLD,40));
        registButton.setText("注册");
        registButton.setBounds(250,450,150,100);
        jl.add(registButton);

        ActionListener registButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration_interface registration_interface = new Registration_interface();
                registration_interface.setVisible(true);
                jf.dispose();//终止当前程序
            }
        };registButton.addActionListener(registButton_ls);

        ActionListener backButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();;//终止当前程序
            }
        };backButton.addActionListener(backButton_ls);

    }

    public static void main(String[] args) {
        Warning2 warning2 = new Warning2();
        warning2.setVisible(true);
    }
}

