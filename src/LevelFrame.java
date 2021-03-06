package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import project.User;
import project.CardFrame;

public class LevelFrame extends JFrame
{
	private JLabel Lid, Lpoint, Ibox;
	private JButton Beasy, Bmiddle, Bhard, Bout, Branking;
	private ImageIcon Ititle;
	private User user = new User();
	private UserList UL = new UserList();

	public LevelFrame()
	{
		// 창 설정
		setTitle("MAKE A PAIR GAME");
		setSize(1000,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
		//각 요소 생성, 배치
		Lid = new JLabel("ID");
		Lid.setBounds(55,30,80,30);
		Lpoint = new JLabel("0");
		Lpoint.setBounds(130,30,80,30);
		
		Beasy = new JButton("초급");
		Beasy.setBounds(390, 370, 200, 50);
		Bmiddle = new JButton("중급");
		Bmiddle.setBounds(390, 430, 200, 50);
		Bhard = new JButton("고급");
		Bhard.setBounds(390, 490, 200, 50);
		
		Branking = new JButton("랭킹");
		Branking.setBounds(55, 620, 80, 30);
		Bout = new JButton("끝내기");
		Bout.setBounds(850, 620, 80, 30);
		
		Ititle = new ImageIcon("title.png");
		Ibox = new JLabel(Ititle);
		Ibox.setBounds(240, 130, 500, 200);
		
		//요소 화면에 추가
		c.add(Lid);
		c.add(Lpoint);
		c.add(Beasy);
		c.add(Bmiddle);
		c.add(Bhard);
		c.add(Branking);
		c.add(Bout);
		c.add(Ibox);
		
		//액션 리스너에 버튼 추가
		LevelListner listner = new LevelListner();
		Beasy.addActionListener(listner);
		Bmiddle.addActionListener(listner);
		Bhard.addActionListener(listner);
		Branking.addActionListener(listner);
		Bout.addActionListener(listner);
	}
	
	public class LevelListner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()== Beasy) // 난이도 누르면 게임창띄우고 레벨 설정
			{
				setVisible(false);
				CardFrame Fcard = new CardFrame();
				Fcard.BringData(user,UL,1);
				Fcard.setVisible(true);
				dispose();
			}
			else if (e.getSource()== Bmiddle)
			{
				setVisible(false);
				CardFrame Fcard = new CardFrame();
				Fcard.BringData(user,UL,2);
				Fcard.setVisible(true);
				dispose();
			}
			else if (e.getSource()== Bhard)
			{
				setVisible(false);
				CardFrame Fcard = new CardFrame();
				Fcard.BringData(user,UL,3);
				Fcard.setVisible(true);
				dispose();
			}
			else if (e.getSource()== Branking) // 랭킹 누르면 유저리스트 업데이트하고 랭킹보여주기
			{
				UL.Updateuserlist(user.ToArray());
				UL.ShowRanking();
			}
			else if (e.getSource()== Bout) // 나가기 버튼 누르면 종료전 유저리스트 업데이트 및 완전히 종료
			{
				UL.Updateuserlist(user.ToArray());
				System.exit(0);
			}
		}
	}
	
	public void BringData(User arguser,UserList argUL) //로그인창에서 필요한 정보 가져오기
	{
		user = arguser;
		UL = argUL;
		Lid.setText("ID : " + user.Getid());
		Lpoint.setText(String.valueOf("POINT : " + user.GetPoint()));
	}

}
