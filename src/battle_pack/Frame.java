package battle_pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.ComponentOrientation;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.TextField;

public class Frame {
	int UserHP = 0;
	int EnemyHP = 0;
	static Scanner keyboard = new Scanner(System.in); // create input
	String UpdatedText = "sample";
	int wins = 0;
	int losses = 0;

	private JFrame frmBattleRoyal;
	private JTextField txtWelcomeToThe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frmBattleRoyal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Maincode m = new Maincode();
		String Name = m.GetName();
		
		frmBattleRoyal = new JFrame();
		frmBattleRoyal.setTitle("Battle Royal");
		frmBattleRoyal.getContentPane().setLocation(new Point(10, 50));
		frmBattleRoyal.setBounds(100, 100, 502, 354);
		frmBattleRoyal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattleRoyal.getContentPane().setLayout(null);
		
		txtWelcomeToThe = new JTextField();
		txtWelcomeToThe.setDisabledTextColor(Color.WHITE);
		txtWelcomeToThe.setBackground(SystemColor.menu);
		txtWelcomeToThe.setSelectedTextColor(Color.BLACK);
		txtWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeToThe.setBounds(15, 7, 463, 41);
		txtWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtWelcomeToThe.setText("Welcome to the Battle Royal");
		frmBattleRoyal.getContentPane().add(txtWelcomeToThe);
		txtWelcomeToThe.setColumns(10);
		JProgressBar EnemyHPBar = new JProgressBar();
		EnemyHPBar.setStringPainted(true);
		EnemyHPBar.setBounds(297, 102, 181, 41);
		EnemyHPBar.setValue(100);
		frmBattleRoyal.getContentPane().add(EnemyHPBar);
		
		JProgressBar UserHPBar = new JProgressBar();
		UserHPBar.setValue(100);
		UserHPBar.setStringPainted(true);
		UserHPBar.setBounds(15, 102, 181, 41);
		frmBattleRoyal.getContentPane().add(UserHPBar);
		
		JLabel User_HP_label = new JLabel(Name + " HP");
		User_HP_label.setHorizontalAlignment(SwingConstants.CENTER);
		User_HP_label.setLabelFor(UserHPBar);
		User_HP_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		User_HP_label.setBounds(15, 52, 157, 32);
		frmBattleRoyal.getContentPane().add(User_HP_label);
		
		JLabel Enemy_HP_Label = new JLabel("Enemy HP");
		Enemy_HP_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Enemy_HP_Label.setLabelFor(Enemy_HP_Label);
		Enemy_HP_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Enemy_HP_Label.setBounds(308, 58, 150, 25);
		frmBattleRoyal.getContentPane().add(Enemy_HP_Label);
		
		TextArea OutputText = new TextArea();
		OutputText.setFont(new Font("Arial", Font.PLAIN, 17));
		OutputText.setText("Begin Battle!");
		OutputText.setEditable(false);
		OutputText.setBounds(15, 224, 463, 83);
		frmBattleRoyal.getContentPane().add(OutputText);
		
		JButton AttackBtn = new JButton("ATTACK");
		AttackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert attack method
				Maincode m = new Maincode();
				
				//get current damage
				int UserDamage = m.GetDamage();
				int EnemyDamage = m.GetDamage();

				
				//get HP
				if (UserHP <= 0 || EnemyHP <= 0) {
					UserHP = 100;
					EnemyHP = 100;
				}
				UserHP = m.GetHP(UserHP);	
				EnemyHP = m.GetHP(EnemyHP);
				
				//apply damage to targets
				EnemyHP = m.Attack(EnemyHP, EnemyDamage);
				UserHP = m.Attack(UserHP, UserDamage);

				
				UserHPBar.setValue(UserHP);
				EnemyHPBar.setValue(EnemyHP);
				//display winner
				if (UserHP > 0 & EnemyHP > 0) {
				} else if (UserHP <= 0 && EnemyHP <= 0) {
					JOptionPane jOptionPane3 = new JOptionPane();
					jOptionPane3.setMessage("WOW it was a tie!");
					m.GetText(UpdatedText, "WOW it was a tie!");
					OutputText.setText(UpdatedText);
				} else if(UserHP <= 0) {
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.setMessage("Sorry, " + Name + " lost the battle. the enemy won with " + EnemyHP +
							" remaining.");
					UpdatedText = "Sorry, " + Name + " lost the battle. the enemy won with " + EnemyHP +
							" remaining.";
					OutputText.setText(UpdatedText);
					m.GetWins(losses);
				} else if(EnemyHP <= 0 ) {
					JOptionPane jOptionPane2 = new JOptionPane();
					jOptionPane2.setMessage("Congradulations " + Name + " won with " + UserHP +
							" remaining.");
					UpdatedText = "Congradulations " + Name + " won with " + UserHP +
							" remaining.";
					OutputText.setText(UpdatedText);
					m.GetWins(wins);
				}
				}
				
			}
		);
		AttackBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AttackBtn.setBounds(175, 177, 143, 41);
		frmBattleRoyal.getContentPane().add(AttackBtn);
		


		
	}
}