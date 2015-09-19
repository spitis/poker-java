import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import poker.Monte;
import poker.Range;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class PowerRanger extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBar1;
	private AbstractAction rangesHelp;
	private JDialog supportedRangesDialog;
	private AbstractAction evaluateAction;
	private JLabel equityLabel2;
	private JLabel equityLabel1;
	private JButton calculateButton;
	private JTextField rangeField2;
	private JTextField rangeField1;
	private JLabel rangeLabel1;
	private JLabel rangeLabel2;
	private AbstractAction closeDialogAction;
	private JLabel supportedRangesLabel;
	private JButton closeDialog;
	private JMenuItem rangesHelpMenuItem;
	private AbstractAction exitAction;
	private JMenuItem exitMenuItem;
	private JMenu helpMenu;
	private JMenu fileMenu;
	
	private boolean calculating = false;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PowerRanger inst = new PowerRanger();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PowerRanger() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getRangeField1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRangeLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getEquityLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getRangeField2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRangeLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getEquityLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(0, 44, Short.MAX_VALUE)
				.addComponent(getCalculateButton(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(getRangeLabel2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRangeLabel1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(getRangeField2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRangeField1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getEquityLabel2(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 78, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getEquityLabel1(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 78, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 29, Short.MAX_VALUE)
				        .addComponent(getCalculateButton(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getEquityLabel2(), getEquityLabel1()});
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getRangeField1(), getRangeField2()});
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getRangeLabel2(), getRangeLabel1()});
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Power Ranger");
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					fileMenu = new JMenu();
					jMenuBar1.add(fileMenu);
					fileMenu.setText("File");
					{
						exitMenuItem = new JMenuItem();
						fileMenu.add(exitMenuItem);
						exitMenuItem.setText("Exit");
						exitMenuItem.setAction(getExitAction());
					}
				}
				{
					helpMenu = new JMenu();
					jMenuBar1.add(helpMenu);
					helpMenu.setText("Help");
					helpMenu.add(getRangesHelpMenuItem());
				}
			}
			pack();
			this.setSize(354, 191);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getExitAction() {
		if(exitAction == null) {
			exitAction = new AbstractAction("Exit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return exitAction;
	}

	private AbstractAction getRangesHelp() {
		if(rangesHelp == null) {
			rangesHelp = new AbstractAction("Supported Ranges", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					getSupportedRangesDialog().pack();
					getSupportedRangesDialog().setLocationRelativeTo(null);
					getSupportedRangesDialog().setVisible(true);
				}
			};
		}
		return rangesHelp;
	}
	
	private JMenuItem getRangesHelpMenuItem() {
		if(rangesHelpMenuItem == null) {
			rangesHelpMenuItem = new JMenuItem();
			rangesHelpMenuItem.setText("Supported Ranges");
			rangesHelpMenuItem.setAction(getRangesHelp());
		}
		return rangesHelpMenuItem;
	}
	
	private JDialog getSupportedRangesDialog() {
		if(supportedRangesDialog == null) {
			supportedRangesDialog = new JDialog(this);
			GroupLayout supportedRangesDialogLayout = new GroupLayout((JComponent)supportedRangesDialog.getContentPane());
			supportedRangesDialog.getContentPane().setLayout(supportedRangesDialogLayout);
			supportedRangesDialog.setPreferredSize(new java.awt.Dimension(421, 259));
			supportedRangesDialog.setSize(421, 259);
			supportedRangesDialogLayout.setHorizontalGroup(supportedRangesDialogLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(supportedRangesDialogLayout.createParallelGroup()
				    .addComponent(getSupportedRangesLabel(), GroupLayout.Alignment.LEADING, 0, 401, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, supportedRangesDialogLayout.createSequentialGroup()
				        .addGap(0, 328, Short.MAX_VALUE)
				        .addComponent(getCloseDialog(), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			supportedRangesDialogLayout.setVerticalGroup(supportedRangesDialogLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getSupportedRangesLabel(), 0, 182, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addComponent(getCloseDialog(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
		}
		return supportedRangesDialog;
	}
	
	private JButton getCloseDialog() {
		if(closeDialog == null) {
			closeDialog = new JButton();
			closeDialog.setText("Ok");
			closeDialog.setAction(getCloseDialogAction());
		}
		return closeDialog;
	}
	
	private JLabel getSupportedRangesLabel() {
		if(supportedRangesLabel == null) {
			supportedRangesLabel = new JLabel();
			supportedRangesLabel.setText("<html>Currently supported range inputs (seperate entries by commas):<br><ul><li>XX: Pocket pair XX</li><li>XYo: Offsuit cards XY</li><li>XYs: Suited cards XY</li><li>XuYv: Cards X and Y of suits u and v respectively</li><li>RP##: Top ## percentile of a push range</li><li>RC##: Top ## percentile of a call range</li><li>RL##: Top ## percentile of a low equity range</li></ul></html>");
			supportedRangesLabel.setIgnoreRepaint(true);
			supportedRangesLabel.setInheritsPopupMenu(false);
			supportedRangesLabel.setVerticalAlignment(SwingConstants.TOP);
		}
		return supportedRangesLabel;
	}
	
	private AbstractAction getCloseDialogAction() {
		if(closeDialogAction == null) {
			closeDialogAction = new AbstractAction("Ok", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					getSupportedRangesDialog().dispose();
				}
			};
		}
		return closeDialogAction;
	}
	
	private JLabel getRangeLabel1() {
		if(rangeLabel1 == null) {
			rangeLabel1 = new JLabel();
			rangeLabel1.setText("P1 Range:");
		}
		return rangeLabel1;
	}
	
	private JLabel getRangeLabel2() {
		if(rangeLabel2 == null) {
			rangeLabel2 = new JLabel();
			rangeLabel2.setText("P2 Range:");
		}
		return rangeLabel2;
	}
	private JTextField getRangeField1() {
		if(rangeField1 == null) {
			rangeField1 = new JTextField();
		}
		return rangeField1;
	}
	
	private JTextField getRangeField2() {
		if(rangeField2 == null) {
			rangeField2 = new JTextField();
		}
		return rangeField2;
	}
	
	private JButton getCalculateButton() {
		if(calculateButton == null) {
			calculateButton = new JButton();
			calculateButton.setText("Evaluate Equity");
			calculateButton.setAction(getEvaluateAction());
		}
		return calculateButton;
	}
	
	private JLabel getEquityLabel1() {
		if(equityLabel1 == null) {
			equityLabel1 = new JLabel();
			equityLabel1.setText("P1 Equity");
		}
		return equityLabel1;
	}
	
	private JLabel getEquityLabel2() {
		if(equityLabel2 == null) {
			equityLabel2 = new JLabel();
			equityLabel2.setText("P2 Equity");
		}
		return equityLabel2;
	}
	
	private AbstractAction getEvaluateAction() {
		if(evaluateAction == null) {
			evaluateAction = new AbstractAction("Evaluate Equity", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					if (calculating) {
						calculating = false;
						calculateButton.setText("Evaluate Equity");
					} else {
						calculating = true;
						calculateButton.setText("Calculating...");
						Thread t = new Thread(new runnableMonte());
						t.start();
					}
				}
			};
		}
		return evaluateAction;
	}
	
	private class runnableMonte implements Runnable {

		@Override
		public void run() 
		{
			Range r1 = new Range();
			Range r2 = new Range();
			r1.add(getRangeField1().getText().trim());
			r2.add(getRangeField2().getText().trim());
			int[] val2 = new int[3];
			long[] val = {0,0,0};
			long trials = 0;
			while (calculating) {
				trials += 30000;
				val2 = Monte.pfRangeEquity(r1,r2, 30000);
				for (int x = 0; x<3; x++) {
					val[x] += val2[x];
				}
				String s = Double.toString((val[0]+(0.5*val[2]))/(val[0]+val[1]+val[2]));
				String t = Double.toString(1-(val[0]+(0.5*val[2]))/(val[0]+val[1]+val[2]));
				getEquityLabel1().setText(s);	
				getEquityLabel2().setText(t);
				if (trials > 10000000) {break;}
			}
			calculating = false;
		}
		
	}

}
