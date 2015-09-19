import javax.swing.*;

import poker.*;

import java.awt.*;
import java.awt.event.*;


public class dealergame {

	JFrame frame;
	JPanel main;
	JButton deal;
	JLabel label;
	Deck d;
	cardpanel p1;
	cardpanel p2;
	int x = 0;
	final String CARDBACK = "/cards/b.gif";
	String currentCardString = CARDBACK;
	Card currentCard;
	
	public static void main(String[] args) {
	
		dealergame dealer = new dealergame();
		dealer.go();
	}
		
	public void go() {
		// TODO Auto-generated method stub
		frame = new JFrame("DealDemo");
		main = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		d = new Deck();
		//d.shuffle();
		x = d.getNumCardsLeft();
		label = new JLabel("Cards Left: " + x);
		
		deal = new JButton("Deal!");
		p1 = new cardpanel();
		p2 = new cardpanel();
				
		Dimension s = new Dimension (80, 130);
		
		p1.setPreferredSize(s);
		p2.setPreferredSize(s);
		
		main.add(p1);
		main.add(p2);
		
		deal.addActionListener(new dealit());
				
		frame.getContentPane().add(BorderLayout.CENTER, main);
		frame.getContentPane().add(BorderLayout.SOUTH, deal);
		frame.getContentPane().add(BorderLayout.NORTH, label);
		
		frame.setSize(180,185);
		frame.setVisible(true);
		
		
	}
	
	
	public class cardpanel extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent (Graphics g) {
			Image image = new ImageIcon(getClass().getResource(currentCardString)).getImage();
			g.drawImage(image, 0, 0, this);
		}
		
		public void paintIm (String c) {
			currentCardString = c;
			this.repaint();
		}
	}
	
	public class dealit implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			currentCard = new Card(d.nextcard());
			p2.paintIm("/cards/" + Card.getImage(currentCard) +".gif");
			x = d.getNumCardsLeft();
			label.setText("Cards Left: " + x);
		}
	}

}
