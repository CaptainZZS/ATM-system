import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class withdraw_money_interface extends JFrame{
    static String bankcard_get = Operation_interface.bankcard_get;
//    static String bankcard_get = "622821 2299030127370";
    private static JLabel label1,label2,label3,label4,label6;
    private static TextField label5;
    private static JPasswordField label7;
    private static JButton withdraw_money_Button;
    private static JButton backButton;
    private static JButton exitButton;
    public withdraw_money_interface(){
        super();
        System.out.println(bankcard_get);
        setTitle("取款界面");
        setBounds(500,50,600,800);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql1 = "select name from message1 where bank_card = ?";
        String str1 = template.queryForObject(sql1, String.class, bankcard_get);
        String sql2 = "select balance from message1 where bank_card = ?";
        String str2 = template.queryForObject(sql2, String.class, bankcard_get);
        String sql4 = "select id from message1 where bank_card = ?";
        String str4 = template.queryForObject(sql4, String.class, bankcard_get);

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
        label4.setText("请在下方输入取款金额");
        label4.setBounds(120,150,1000,50);
        getContentPane().add(label4);

        label5 = new TextField();
        label5.setFont(new Font("",Font.BOLD,40));
        label5.setBounds(110,200,350,50);
        getContentPane().add(label5);

        label6 = new JLabel();
        label6.setForeground(new Color(17, 76, 255));
        label6.setFont(new Font("黑体",Font.BOLD,30));
        label6.setText("请在下方输入密码");
        label6.setBounds(150,250,1000,50);
        getContentPane().add(label6);

        label7 = new JPasswordField();
        label7.setFont(new Font("",Font.BOLD,40));
        label7.setBounds(110,300,350,50);
        getContentPane().add(label7);

        withdraw_money_Button = new JButton();
        withdraw_money_Button.setFont(new Font("",Font.BOLD,40));
        withdraw_money_Button.setText("取款");
        withdraw_money_Button.setBounds(210,400,150,50);
        getContentPane().add(withdraw_money_Button);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(210,500,150,50);
        getContentPane().add(backButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(210,600,150,50);
        getContentPane().add(exitButton);

        ActionListener depositButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money_str = label5.getText();
                Double balance = Double.valueOf(str2.toString());
                Double money = Double.valueOf(money_str.toString());
                Integer id = Integer.valueOf(str4.toString());
                char[] password_char = label7.getPassword();
                String password =String.valueOf(password_char);
                String sql5 = "select password from message1 where bank_card = ?";
                String str5 = template.queryForObject(sql5, String.class, bankcard_get);
                if (str5.equals(password)){
                    if (money < 0|money > balance){
                        Warning4 warning4 = new Warning4();
                        label5.setText("");
                    }else{

                        Double new_balance =  balance - money;
                        String sql3 = "update message1 set balance = ? where bank_card = ?";
                        int update = template.update(sql3, new_balance, bankcard_get);
                        if (update == 1){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String ly_time = sdf.format(new java.util.Date());
                            String sql4 =  "insert into message2(number,transfer,amount,type,Collection,datatime) value (?,?,?,?,?,?)";
                            Object args[] = {id,str1,money,"-",str1,ly_time};
                            int flag1 = template.update(sql4,args);
                            withdraw_money_interface deposit_interface = new withdraw_money_interface();
                            deposit_interface.setVisible(true);
                            dispose();
                            Warning7 warning7 = new Warning7();


                        }else{
                            Warning8 warning8 = new Warning8();
                            label5.setText("");
                        }
                    }

                }else{
                    Warning13 warning13 = new Warning13();
                    label7.setText("");
                }

            }
        };withdraw_money_Button.addActionListener(depositButton_ls);

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
        withdraw_money_interface deposit_interface = new withdraw_money_interface();
        deposit_interface.setVisible(true);

    }
}
