package asmatupaketea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pantaila extends JFrame{
	
	JLabel szenb = new JLabel();
	JTextField testua = new JTextField(13);
	JButton botoia = new JButton();
	JPanel panela = new JPanel();
	JPanel panela2 = new JPanel();
	JPanel panela3 = new JPanel();
	JTextField testua2 = new JTextField(25);
	int rd ;
	static Pantaila pant = new Pantaila();
	
	public Pantaila() {
		
		setTitle("Egin beharreko ariketa");
		
		botoia.setText("Asmatu");
		botoia.setActionCommand("asmatu");
		szenb.setText("Sartu Zenbakia:");
		testua.setActionCommand("testua");
		
		
	}

	public void hasi(){
		
		rd= new Random().nextInt(100);
		testua.setText("");
		testua2.setText("");
		panela.add(szenb);
		panela.add(testua);
		panela2.add(botoia);
		panela3.add(testua2);
		getContentPane().add(panela,BorderLayout.NORTH);
		getContentPane().add(panela2,BorderLayout.SOUTH);
		getContentPane().add(panela3,BorderLayout.CENTER);
		
		setVisible(true);
		setSize(300,200);
		setLocation(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void entzuleakSartu(){
		botoia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					konparazioaEgin();
			}
			
		});
		testua.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()== KeyEvent.VK_ENTER){
					konparazioaEgin();
				}	
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	private void konparazioaEgin(){
		try{
			if(rd==Integer.parseInt(testua.getText())){
				JOptionPane.showMessageDialog(null, "Berdinak dira!");
				int reply = JOptionPane.showConfirmDialog(null,"Berriro jokatu nahi duzu?", "amaitzeko ordua da?" , JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.NO_OPTION){
					System.exit(0);
				}else{
				dispose();
				pant.hasi();
				pant.entzuleakSartu();
				}
			}else if(rd>Integer.parseInt(testua.getText())){
				testua2.setText("Sartu zenbaki handiago bat mesedez");
				testua.setText("");
			}else if(rd<Integer.parseInt(testua.getText())){
				testua2.setText("Sartu zenbaki txikiago bat mesedez");
				testua.setText("");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(pant, "Hori ez da zenabaki bat", "Error", JOptionPane.ERROR_MESSAGE);
			testua.setText("");
		}
	}

}
