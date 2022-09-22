import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning14 extends JFrame {
    private static JFrame jf;
    private static JLabel jl;
    private static JButton exitButton;
    private static JButton backButton;
    public Warning14(){
        jf=new JFrame("Warning");
        jf.setVisible(true);
        jf.setBounds(150,100,1200,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl=new JLabel();
        jf.add(jl);
        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("密码修改成功！请重新登录！点击退出系统自动关闭！");
        label.setBounds(150,150,1000,100);
        jl.add(label);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("退出");
        backButton.setBounds(500,300,150,100);
        jl.add(backButton);



        ActionListener backButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        };
        backButton.addActionListener(backButton_ls);



    }

    public static void main(String[] args) {
        Warning14 pe = new Warning14();
        pe.setVisible(true);


    }
}

