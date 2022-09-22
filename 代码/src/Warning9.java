import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Warning9 extends JFrame {
    private static JLabel label1,label3;
    private static JPasswordField label2,label4;
    static String Opposite_account,Opposite_name,bankcard_get;
    private static JButton exitButton,transfer_accounts_Button,backButton;
    public Warning9(){
        super();
        setTitle("转账界面");
        setBounds(500,50,600,800);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel();
        label1.setForeground(new Color(255, 0, 0));
        label1.setFont(new Font("",Font.BOLD,40));
        label1.setText("请输入密码");
        label1.setBounds(170,50,1000,50);
        add(label1);

        label2 = new JPasswordField();
        label2.setFont(new Font("",Font.BOLD,40));
        label2.setBounds(110,120,350,50);
        add(label2);

        label3 = new JLabel();
        label3.setForeground(new Color(255, 0, 0));
        label3.setFont(new Font("",Font.BOLD,40));
        label3.setText("请再次输入密码");
        label3.setBounds(130,200,1000,50);
        add(label3);

        label4 = new JPasswordField();
        label4.setFont(new Font("",Font.BOLD,40));
        label4.setBounds(110,270,350,50);
        add(label4);

        transfer_accounts_Button = new JButton();
        transfer_accounts_Button.setFont(new Font("",Font.BOLD,40));
        transfer_accounts_Button.setText("确认");
        transfer_accounts_Button.setBounds(210,400,150,50);
        add(transfer_accounts_Button);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(210,500,150,50);
        add(backButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(210,600,150,50);
        add(exitButton);

        ActionListener transfer_accounts_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password1_char=label2.getPassword();
                String password1=String.valueOf(password1_char);
                char[] password2_char=label4.getPassword();
                String password2=String.valueOf(password2_char);
                if (password1.equals(password2)){
                    Opposite_account = transfer_accounts_interface.Opposite_account;
                    Opposite_name = transfer_accounts_interface.Opposite_name;
                    bankcard_get = transfer_accounts_interface.bankcard_get;
                    String str1 = transfer_accounts_interface.str1;
                    String str2 = transfer_accounts_interface.str2;
                    String str3 = transfer_accounts_interface.str4;
                    String money_str = transfer_accounts_interface.money_str;
                    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
                    String sql1 = "update message1 set balance = ? where bank_card = ?";
                    Double balance1 = Double.valueOf(str2.toString());
                    Double money = Double.valueOf(money_str.toString());
                    Double new_balance1 = balance1-money;
                    int update1 = template.update(sql1, new_balance1, bankcard_get);
                    if (update1 == 1){
                        String sql2 = "select balance from message1 where bank_card = ?";
                        String balance2_str = template.queryForObject(sql2, String.class, Opposite_account);
                        Double balance2 = Double.valueOf(balance2_str.toString());
                        Double new_balance2 = balance2+money;
                        int update2 = template.update(sql1, new_balance2, Opposite_account);
                        if (update2 == 1){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String ly_time = sdf.format(new java.util.Date());
                            String sql3 =  "insert into message2(number,transfer,amount,type,Collection,datatime) value (?,?,?,?,?,?)";
                            String sql4 = "select id from message1 where bank_card = ?";
                            String str4 = template.queryForObject(sql4, String.class, Opposite_account);
                            Object args1[] = {str3,str1,money,"-",Opposite_name,ly_time};
                            Object args2[] = {str4,Opposite_name,money,"+",str1,ly_time};
                            int flag1 = template.update(sql3,args1);
                            int flag2 = template.update(sql3,args2);
                            if (flag1 == 1 & flag2 == 1){
                                transfer_accounts_interface transfer_accounts_interface = new transfer_accounts_interface();
                                transfer_accounts_interface.setVisible(true);
                                dispose();
                                Warning11 warning11 = new Warning11();

                            }else{
                                System.out.println(flag1);
                                System.out.println(flag2);
                            }
                        }else{
                            int update3 = template.update(sql1, balance1, bankcard_get);
                        }
                    }else{
                        transfer_accounts_interface transfer_accounts_interface = new transfer_accounts_interface();
                        transfer_accounts_interface.setVisible(true);
                        dispose();
                        Warning12 warning12 = new Warning12();
                    }

                }
            }
        };transfer_accounts_Button.addActionListener(transfer_accounts_ls);

        ActionListener backButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();;//终止当前程序
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
        Warning9 pe = new Warning9();
        pe.setVisible(true);


    }
}

