import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Peli extends JFrame 
{
	Rand random = new Rand();
	Timer swingtimer = new Timer(1111, new SwingTimerActionListener());
	JButton btn1 = new JButton("PUNAINEN");
	JButton btn2 = new JButton("SININEN");
	JButton btn3 = new JButton("VIHREÄ");
	JButton btn4 = new JButton("ORANSSI");
	JButton btn5 = new JButton("ALOITA");
	JLabel lbl1 = new JLabel("ORANSSI");
	JLabel lbltime = new JLabel("");
	JLabel lblend = new JLabel("");
	
	Color corrCol;
	String a;
	int rounds = 0;
	int times = 0;
	int points = 0;
		
	private JPanel contentPane;
	private JTextField tf1;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
					try 
					{
						Peli frame = new Peli();
						frame.setVisible(true);
					} 
					catch (Exception e) 
					{
						System.out.println("Tapahtui virhe.");
					}
			}
		});
	}

	public Peli() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 695);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 0, 841, 640);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl1.setForeground(Color.BLACK);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lbl1.setBounds(274, 90, 310, 73);
		panel.add(lbl1);
		
		
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rightAns(random.GetColbyName(btn1.getText()));
			}
		});
		btn1.setBackground(Color.WHITE);
		btn1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn1.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn1.setBackground(Color.white);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn1.setBounds(204, 244, 234, 44);
		panel.add(btn1);
		
		btn2.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e) 
				{
					rightAns(random.GetColbyName(btn2.getText()));
				}
		});
		
		btn2.setBackground(Color.WHITE);
		btn2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn2.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn2.setBackground(Color.white);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.setBounds(448, 244, 234, 44);
		panel.add(btn2);
		
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rightAns(random.GetColbyName(btn3.getText()));
			}
		});
		btn3.setBackground(Color.WHITE);
		btn3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn3.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn3.setBackground(Color.white);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn3.setBounds(204, 299, 234, 44);
		panel.add(btn3);
		
		btn4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rightAns(random.GetColbyName(btn4.getText()));
			}
		});
		btn4.setBackground(Color.WHITE);
		btn4.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn4.setBackground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn4.setBackground(Color.white);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn4.setBounds(448, 299, 234, 44);
		panel.add(btn4);
		
		JLabel lbl2 = new JLabel("VALITSE TEKSTIN V\u00C4RI OIKEIN");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(253, 53, 351, 26);
		panel.add(lbl2);
		
		btn5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rounds < 1)
				{
					start();
					swingtimer.start();
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5.setBounds(394, 174, 89, 23);
		panel.add(btn5);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf1.setHorizontalAlignment(SwingConstants.CENTER);
		tf1.setBounds(204, 377, 478, 44);
		panel.add(tf1);
		tf1.setColumns(10);
		
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltime.setBounds(204, 174, 58, 23);
		panel.add(lbltime);
		
		lblend.setHorizontalAlignment(SwingConstants.CENTER);
		lblend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblend.setBounds(204, 432, 478, 44);
		panel.add(lblend);
	}
	
	public void btnCol()
	{
		String[] suffleCol = new String[] {"PUNAINEN","SININEN","VIHREÄ","ORANSSI"};
		List<String> suffCol = Arrays.asList(suffleCol);
		Collections.shuffle(suffCol);
		suffleCol = suffCol.toArray(new String[suffCol.size()]);
		btn1.setText(suffCol.get(0));
		btn2.setText(suffCol.get(1));
		btn3.setText(suffCol.get(2));
		btn4.setText(suffCol.get(3));
	}
	
	public void rightAns(Color guess)
	{
		if(corrCol.equals(guess))
		{
			tf1.setText("Oikein");
			points ++;
			start();
		}
		else
		{
			tf1.setText("Peli loppui, sait " + points + " pistettä.");
			swingtimer.stop();
			end();
		}
	}

	private void start() 
	{
		if(rounds < 7)
		{
			rounds++;
			corrCol = random.RandomColor();
			lbl1.setForeground(corrCol);
			a = random.RandomText();
			lbl1.setText(a);
			btnCol();
		}
		else
		{
			tf1.setText("Sait kaikki oikein! Peli loppui.");
			swingtimer.stop();
			String blaa = String.valueOf((times++)-1);
			if(((times++)-1) > 10)
			{
				lblend.setText("Käytit aikaa " + blaa + " sekuntia. Nukahditko?");
			}
			else if(((times++)-1) < 6)
			{
				lblend.setText("Käytit aikaa " + blaa + " sekuntia. Oletko yli-ihminen?");
			}
			else
			{
				lblend.setText("Käytit aikaa " + blaa + " sekuntia. Mnäääääh, ihan ok.");
			}
			end();
		}
	}
	
	private void end()
	{
		btn1.setVisible(false);
		btn2.setVisible(false);
		btn3.setVisible(false);
		btn4.setVisible(false);
		btn5.setVisible(false);
	}
	
	class SwingTimerActionListener implements ActionListener 
	{
		  public void actionPerformed(ActionEvent e) 
		  {
		    lbltime.setText(String.valueOf(times++));
		  }
	}	  	
}
