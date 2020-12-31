package com.hyunjin.customer_app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
class ImagePanel extends JPanel {
	private Image img;
	public ImagePanel(Image img) {
		this.img =img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
public class CustomerApp {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel mainPanel;
	private JLabel lblNewLabel_3;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerApp window = new CustomerApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer customer = new Customer();
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/hyunjin/eclipse-workspace/swing/img/welcome.jpg").getImage());
		welcomePanel.setBounds(0, 0, 796, 506);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 796, 479);
		tablePanel.setVisible(false);
		String[][] data = customer.getCustomers();
		String[] headers = new String[] {"Name","Phone","Gender","Age","Note"};
		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif",Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(600,400);
		table.setPreferredScrollableViewportSize(new Dimension(600,400));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 41, 602, 428);
		tablePanel.add(scrollPane);
		
		frame.getContentPane().add(tablePanel);
		
		search = new JTextField();
		search.setFont(new Font("굴림", Font.PLAIN, 14));
		search.setBounds(101, 0, 601, 31);
		tablePanel.add(search);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
				
			}
		}); 
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(10);
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(10);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 796, 479);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		lblNewLabel_3 = new JLabel("Welcome this is mainPanel");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(252, 0, 284, 63);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(22, 55, 185, 58);
		mainPanel.add(lblNewLabel_4);
		
		JLabel age_label = new JLabel("Age");
		age_label.setHorizontalAlignment(SwingConstants.CENTER);
		age_label.setFont(new Font("Arial", Font.BOLD, 16));
		age_label.setBounds(22, 97, 185, 58);
		mainPanel.add(age_label);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("gender");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1_1.setBounds(22, 144, 185, 58);
		mainPanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Phone");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_2.setBounds(354, 55, 185, 58);
		mainPanel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Birthday");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_3.setBounds(354, 111, 185, 58);
		mainPanel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Name");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_4.setBounds(351, 161, 185, 58);
		mainPanel.add(lblNewLabel_4_4);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.BOLD, 16));
		name.setBounds(171, 65, 152, 40);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("Arial", Font.BOLD, 16));
		age.setColumns(10);
		age.setBounds(171, 118, 152, 40);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setFont(new Font("Arial", Font.BOLD, 16));
		phone.setColumns(10);
		phone.setBounds(508, 65, 152, 40);
		mainPanel.add(phone);
		
		birthday = new JTextField();
		birthday.setFont(new Font("Arial", Font.BOLD, 16));
		birthday.setColumns(10);
		birthday.setBounds(508, 118, 152, 40);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male","Female"});
		gender.setFont(new Font("Arial", Font.BOLD, 16));
		gender.setBackground(Color.WHITE);
		gender.setBounds(171, 165, 152, 48);
		mainPanel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setBounds(508, 163, 247, 229);
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(note);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = age.getText();
//				String bTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				customer.createCustomer(nameTxt, phoneTxt, genderTxt,ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Your data has been ssaved successfully");
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(217, 351, 232, 83);
		mainPanel.add(btnNewButton_1);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(303, 170, 158, 67);
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
		welcomePanel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(273, 234, 141, 46);
		id.setToolTipText("ID");
		welcomePanel.add(id);
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(273, 288, 141, 46);
		password.setToolTipText("password");
		welcomePanel.add(password);
		
		lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(239, 232, 33, 46);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		welcomePanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("PW:");
		lblNewLabel_2.setBounds(239, 286, 33, 46);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		welcomePanel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(239, 344, 217, 83);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("I am clicked");
//				System.out.println(id.getText());
//				System.out.println(password.getPassword());
				if(id.getText().equals("hyunjin")&&Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Hello hyunjin");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
				//getpassword 함수는 char[] 를 리턴하므로 equals 메서드로 비교불가 equals 는 string value 비교
//				if(password.getPassword().equals("1234")) {
//					System.out.println("you are right");
//				}
				
			}
		});
		welcomePanel.add(btnNewButton);
		frame.setJMenuBar(menuBar());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menuBar() {
		JMenuBar bar =new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		return bar;
	}

}
