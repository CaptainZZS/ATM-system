import java.awt.*;		//导包
import javax.swing.*;
public class Swing_JComboBox extends JFrame{	//继承JFrame顶层容器类

    //定义组件
    JPanel jp1,jp2;		//定义面板
    JLabel jlb1,jlb2;	//定义标签
    JComboBox jcb1;		//定义下拉框
    JList jl1;			//定义列表框
    JScrollPane jsp1;	//定义滚动窗条
    public static void main(String[] args) {	//主函数
        Swing_JComboBox a=new Swing_JComboBox();

    }
    public Swing_JComboBox()	//构造函数
    {
        //创建组件
        jp1=new JPanel();		//创建面板
        jp2=new JPanel();
        jlb1=new JLabel("你的籍贯");	//创建标签
        jlb2=new JLabel("旅游景点");
        String []ct= {"北京","上海","苏州","徐州","常州"};	//创建城市
        jcb1=new JComboBox(ct);		//把城市添加到下拉框中
        String []dd= {"东方明珠","苏州园林","云龙山","故宫","嬉戏谷","杭州乐园"};	//创建经典
        jl1=new JList(dd);		//把经典添加到列表框中
        jl1.setVisibleRowCount(4);        //列表框只显示4个信息（必须要有滚动窗格连用才生效）
        jsp1=new JScrollPane(jl1);	//给列表框加一个滚动窗格

        //设置布局管理器
        this.setLayout(new GridLayout(2,1));	//设置网格布局，2行1列

        //加入组件
        this.add(jp1);	//添加两个面板
        this.add(jp2);

        jp1.add(jlb1);	//添加面板1的组件
        jp1.add(jcb1);

        jp2.add(jlb2);	//添加面板2的组件
        jp2.add(jsp1);    //注意！！这里不添加列表框，直接添加滚动窗格！！

        //设置窗体属性
        this.setTitle("用户注册界面");		//设置界面标题
        this.setSize(300, 250);				//设置界面像素
        this.setLocation(200, 200);			//设置界面初始位置
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置虚拟机和界面一同关闭
        this.setVisible(true);				//设置界面可视化
    }
}