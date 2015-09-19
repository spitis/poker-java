import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.event.*;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;

import poker.Monte;
import poker.Range;
import poker.hh.M;


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
public class EquilibriumEV extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar jMenuBar1;
	private JLabel raiserPositionLabel;
	private JRadioButton raise25Button;
	private JTextArea outputTextArea;
	private AbstractAction calculateEvAction;
	private AbstractAction calculateEqAction;
	private AbstractAction buAction;
	private AbstractAction sbAction;
	private AbstractAction raise3Action;
	private AbstractAction raise25Action;
	private AbstractAction raise2Action;
	private JButton calcEvButton;
	private JButton calcEqButton;
	private JTextField cRangeText;
	private JTextField sRangeText;
	private JLabel callRangeLabel;
	private JLabel shoveRangeLabel;
	private JPanel outputPanel;
	private JRadioButton raise3Button;
	private JRadioButton raise2Button;
	private JRadioButton buButton;
	private JRadioButton sbButton;
	private JLabel raiseSizeLabel;
	private JSlider stackSlider;
	private JLabel eStacksValueLabel;
	private JLabel effectiveStacksLabel;
	private JLabel rRangeValueLabel;
	private JSlider rangeSlider;
	private JLabel raiserRangeLabel;
	private AbstractAction abstractAction1;
	private JPanel inputPanel;
	private JLabel aboutDialogLabel;
	private AbstractAction exitAboutDialogAction;
	private JButton exitAboutDialog;
	private JDialog aboutDialog;
	private AbstractAction exitAction;
	private JMenuItem exitMenuItem;
	private AbstractAction aboutAction;
	private JMenuItem aboutMenuItem;
	private JMenu helpMenu;
	private JMenu fileMenu;
	
	//Input Variables
	private int raiserRange = 30;
	private int effectiveStack = 20;
	private double raiseSize = 2;
	private double sb = 0.5;
	
	//Output Variables
	private double shoveRange = 0;
	private double callRange = 0;
	
	//Thread Variables
	private boolean calculatingEq = false;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EquilibriumEV inst = new EquilibriumEV();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EquilibriumEV() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Equilibrium EV");
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getInputPanel(), GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getOutputPanel(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getCalcEqButton(), GroupLayout.Alignment.BASELINE, 0, 47, Short.MAX_VALUE)
				    .addComponent(getCalcEvButton(), GroupLayout.Alignment.BASELINE, 0, 47, Short.MAX_VALUE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(getInputPanel(), GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(getOutputPanel(), GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getCalcEqButton(), GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 18, Short.MAX_VALUE)
				        .addComponent(getCalcEvButton(), GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			thisLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getCalcEvButton(), getCalcEqButton()});
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getCalcEvButton(), getCalcEqButton()});
			this.setPreferredSize(new java.awt.Dimension(442, 372));
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					fileMenu = new JMenu();
					jMenuBar1.add(fileMenu);
					fileMenu.setText("File");
					fileMenu.add(getExitMenuItem());
				}
				{
					helpMenu = new JMenu();
					jMenuBar1.add(helpMenu);
					helpMenu.setText("Help");
					{
						aboutMenuItem = new JMenuItem();
						helpMenu.add(aboutMenuItem);
						aboutMenuItem.setText("About");
						aboutMenuItem.setAction(getAbstractAction1());
					}
				}
			}
			pack();
			this.setSize(442, 372);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAboutAction() {
		if(aboutAction == null) {
			aboutAction = new AbstractAction("About", null) {
				public void actionPerformed(ActionEvent evt) {
				}
			};
		}
		return aboutAction;
	}
	
	private JMenuItem getExitMenuItem() {
		if(exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.setAction(getExitAction());
		}
		return exitMenuItem;
	}
	
	private AbstractAction getExitAction() {
		if(exitAction == null) {
			exitAction = new AbstractAction("Exit", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return exitAction;
	}
	
	private AbstractAction getAbstractAction1() {
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("About", null) {
				public void actionPerformed(ActionEvent evt) {
					
					getAboutDialog().pack();
					getAboutDialog().setLocationRelativeTo(null);
					getAboutDialog().setVisible(true);
				}
			};
		}
		return abstractAction1;
	}
	
	private JDialog getAboutDialog() {
		if(aboutDialog == null) {
			aboutDialog = new JDialog(this);
			GroupLayout aboutDialogLayout = new GroupLayout((JComponent)aboutDialog.getContentPane());
			aboutDialog.setLayout(aboutDialogLayout);
			aboutDialog.setPreferredSize(new java.awt.Dimension(344, 122));
			aboutDialog.setTitle("About");
			aboutDialog.setSize(344, 122);
			aboutDialogLayout.setHorizontalGroup(aboutDialogLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(aboutDialogLayout.createParallelGroup()
				    .addComponent(getAboutDialogLabel(), GroupLayout.Alignment.LEADING, 0, 393, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, aboutDialogLayout.createSequentialGroup()
				        .addGap(0, 320, Short.MAX_VALUE)
				        .addComponent(getExitAboutDialog(), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			aboutDialogLayout.setVerticalGroup(aboutDialogLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getAboutDialogLabel(), 0, 200, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
				.addComponent(getExitAboutDialog(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
		}
		return aboutDialog;
	}
	
	private JButton getExitAboutDialog() {
		if(exitAboutDialog == null) {
			exitAboutDialog = new JButton();
			exitAboutDialog.setText("Ok");
			exitAboutDialog.setAction(getExitAboutDialogAction());
		}
		return exitAboutDialog;
	}
	
	private AbstractAction getExitAboutDialogAction() {
		if(exitAboutDialogAction == null) {
			exitAboutDialogAction = new AbstractAction("Ok", null) {
				public void actionPerformed(ActionEvent evt) {
					
					getAboutDialog().dispose();
				}
			};
		}
		return exitAboutDialogAction;
	}
	
	private JLabel getAboutDialogLabel() {
		if(aboutDialogLabel == null) {
			aboutDialogLabel = new JLabel();
			aboutDialogLabel.setText("<html><p>This program calculates the game theory optimal push and shove ranges in a HU game.</p></html>");
			aboutDialogLabel.setVerticalAlignment(SwingConstants.TOP);
		}
		return aboutDialogLabel;
	}
	
	private JPanel getInputPanel() {
		if(inputPanel == null) {
			inputPanel = new JPanel();
			GroupLayout inputPanelLayout = new GroupLayout((JComponent)inputPanel);
			inputPanel.setLayout(inputPanelLayout);
			inputPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			inputPanel.setFont(new java.awt.Font("Verdana",0,12));
						inputPanelLayout.setHorizontalGroup(inputPanelLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(inputPanelLayout.createParallelGroup()
				    .addComponent(getRaiserPositionLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaiseSizeLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getEffectiveStacksLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaiserRangeLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(inputPanelLayout.createParallelGroup()
				    .addComponent(getSbButton(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaise2Button(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getEStacksValueLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRRangeValueLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(inputPanelLayout.createParallelGroup()
				    .addGroup(inputPanelLayout.createSequentialGroup()
				        .addComponent(getRangeSlider(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(inputPanelLayout.createSequentialGroup()
				        .addComponent(getStackSlider(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, inputPanelLayout.createSequentialGroup()
				        .addGroup(inputPanelLayout.createParallelGroup()
				            .addComponent(getBbButton(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getRaise25Button(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addGap(26)
				        .addComponent(getRaise3Button(), GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 62, Short.MAX_VALUE)))
				.addContainerGap(14, 14));
						inputPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getRaise2Button(), getBbButton(), getSbButton(), getRaise25Button(), getRaise3Button()});
						inputPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getRaiserPositionLabel(), getRaiseSizeLabel(), getEffectiveStacksLabel(), getRaiserRangeLabel()});
						inputPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getEStacksValueLabel(), getRRangeValueLabel()});
						inputPanelLayout.setVerticalGroup(inputPanelLayout.createSequentialGroup()
				.addContainerGap(6, Short.MAX_VALUE)
				.addGroup(inputPanelLayout.createParallelGroup()
				    .addComponent(getRangeSlider(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRRangeValueLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaiserRangeLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(inputPanelLayout.createParallelGroup()
				    .addComponent(getStackSlider(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getEStacksValueLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getEffectiveStacksLabel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getRaise25Button(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaise3Button(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaise2Button(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaiseSizeLabel(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getBbButton(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getSbButton(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRaiserPositionLabel(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
						inputPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getRaise2Button(), getBbButton(), getSbButton(), getRaise25Button(), getRaise3Button(), getRaiserPositionLabel(), getRaiseSizeLabel(), getEffectiveStacksLabel(), getRaiserRangeLabel(), getRRangeValueLabel(), getEStacksValueLabel(), getStackSlider(), getRangeSlider()});
		}
		return inputPanel;
	}
	
	private JLabel getRaiserRangeLabel() {
		if(raiserRangeLabel == null) {
			raiserRangeLabel = new JLabel();
			raiserRangeLabel.setText("Raiser's Range: ");
		}
		return raiserRangeLabel;
	}
	
	private JSlider getRangeSlider() {
		if(rangeSlider == null) {
			rangeSlider = new JSlider();
			rangeSlider.setValue(30);
			rangeSlider.setMinimum(10);
			rangeSlider.setMaximum(99);
			rangeSlider.setSnapToTicks(true);
			rangeSlider.setMajorTickSpacing(5);
			rangeSlider.setMinorTickSpacing(1);
			rangeSlider.addChangeListener(new rangeSliderListener());
		}
		return rangeSlider;
	}
	
	private class rangeSliderListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			raiserRange = getRangeSlider().getValue();
			getRRangeValueLabel().setText(" " + raiserRange + "%");
		}
		
	}
	
	private JLabel getRRangeValueLabel() {
		if(rRangeValueLabel == null) {
			rRangeValueLabel = new JLabel();
			rRangeValueLabel.setText(" 30%");
		}
		return rRangeValueLabel;
	}
	
	private JLabel getEffectiveStacksLabel() {
		if(effectiveStacksLabel == null) {
			effectiveStacksLabel = new JLabel();
			effectiveStacksLabel.setText("Effective Stacks:");
		}
		return effectiveStacksLabel;
	}
	
	private JLabel getEStacksValueLabel() {
		if(eStacksValueLabel == null) {
			eStacksValueLabel = new JLabel();
			eStacksValueLabel.setText(" 20 bb");
		}
		return eStacksValueLabel;
	}
	
	private JSlider getStackSlider() {
		if(stackSlider == null) {
			stackSlider = new JSlider();
			stackSlider.setValue(20);
			stackSlider.setMinimum(10);
			stackSlider.setMaximum(35);
			stackSlider.setSnapToTicks(true);
			stackSlider.setMajorTickSpacing(1);
			stackSlider.setMinorTickSpacing(1);
			stackSlider.addChangeListener(new stackSliderListener());
		}
		return stackSlider;
	}
	
	private class stackSliderListener implements ChangeListener {
		
		@Override
		public void stateChanged (ChangeEvent e) {
			effectiveStack = getStackSlider().getValue();
			getEStacksValueLabel().setText(" " + effectiveStack + " bb");
		}
	}
	
	private JLabel getRaiseSizeLabel() {
		if(raiseSizeLabel == null) {
			raiseSizeLabel = new JLabel();
			raiseSizeLabel.setText("Raise Size:");
		}
		return raiseSizeLabel;
	}
	
	private JLabel getRaiserPositionLabel() {
		if(raiserPositionLabel == null) {
			raiserPositionLabel = new JLabel();
			raiserPositionLabel.setText("Raiser's Position:");
		}
		return raiserPositionLabel;
	}
	
	private JRadioButton getSbButton() {
		if(sbButton == null) {
			sbButton = new JRadioButton();
			sbButton.setText("SB");
			sbButton.setSelected(true);
			sbButton.setAction(getSbAction());
		}
		return sbButton;
	}
	
	private JRadioButton getBbButton() {
		if(buButton == null) {
			buButton = new JRadioButton();
			buButton.setText("BB");
			buButton.setAction(getBuAction());
		}
		return buButton;
	}
	
	private JRadioButton getRaise2Button() {
		if(raise2Button == null) {
			raise2Button = new JRadioButton();
			raise2Button.setText("2 bb");
			raise2Button.setSelected(true);
			raise2Button.setAction(getRaise2Action());
		}
		return raise2Button;
	}
	
	private JRadioButton getRaise25Button() {
		if(raise25Button == null) {
			raise25Button = new JRadioButton();
			raise25Button.setText("2.5 bb");
			raise25Button.setAction(getRaise25Action());
		}
		return raise25Button;
	}
	
	private JRadioButton getRaise3Button() {
		if(raise3Button == null) {
			raise3Button = new JRadioButton();
			raise3Button.setText("3 bb");
			raise3Button.setAction(getRaise3Action());
		}
		return raise3Button;
	}
	
	private JPanel getOutputPanel() {
		if(outputPanel == null) {
			outputPanel = new JPanel();
			GroupLayout outputPanelLayout = new GroupLayout((JComponent)outputPanel);
			outputPanel.setLayout(outputPanelLayout);
			outputPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			outputPanelLayout.setHorizontalGroup(outputPanelLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(outputPanelLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, outputPanelLayout.createSequentialGroup()
				        .addComponent(getShoveRangeLabel(), GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(getSRangeText(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 44, Short.MAX_VALUE)
				        .addComponent(getCallRangeLabel(), GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(getCRangeText(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
				    .addComponent(getOutputTextArea(), GroupLayout.Alignment.LEADING, 0, 406, Short.MAX_VALUE))
				.addContainerGap());
			outputPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getCallRangeLabel(), getShoveRangeLabel()});
			outputPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getCRangeText(), getSRangeText()});
			outputPanelLayout.setVerticalGroup(outputPanelLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(outputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getShoveRangeLabel(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getCallRangeLabel(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getSRangeText(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getCRangeText(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getOutputTextArea(), 0, 75, Short.MAX_VALUE)
				.addContainerGap());
			outputPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getCallRangeLabel(), getShoveRangeLabel()});
			outputPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getCRangeText(), getSRangeText()});
		}
		return outputPanel;
	}
	
	private JLabel getShoveRangeLabel() {
		if(shoveRangeLabel == null) {
			shoveRangeLabel = new JLabel();
			shoveRangeLabel.setText("Shover's Range:");
		}
		return shoveRangeLabel;
	}
	
	private JLabel getCallRangeLabel() {
		if(callRangeLabel == null) {
			callRangeLabel = new JLabel();
			callRangeLabel.setText("Raiser's Call Range:");
		}
		return callRangeLabel;
	}
	
	private JTextField getSRangeText() {
		if(sRangeText == null) {
			sRangeText = new JTextField();
		}
		return sRangeText;
	}
	
	private JTextField getCRangeText() {
		if(cRangeText == null) {
			cRangeText = new JTextField();
		}
		return cRangeText;
	}
	
	private JTextArea getOutputTextArea() {
		if(outputTextArea == null) {
			outputTextArea = new JTextArea();
			outputTextArea.setText("Expected Value Output");
			outputTextArea.setEditable(false);
		}
		return outputTextArea;
	}
	
	private JButton getCalcEqButton() {
		if(calcEqButton == null) {
			calcEqButton = new JButton();
			calcEqButton.setText("Calculate Equilibrium");
			calcEqButton.setAction(getCalculateEqAction());
		}
		return calcEqButton;
	}
	
	private JButton getCalcEvButton() {
		if(calcEvButton == null) {
			calcEvButton = new JButton();
			calcEvButton.setText("Calculate Expected Value");
			calcEvButton.setAction(getCalculateEvAction());
		}
		return calcEvButton;
	}
	
	private AbstractAction getRaise2Action() {
		if(raise2Action == null) {
			raise2Action = new AbstractAction("2 bb", null) {
				public void actionPerformed(ActionEvent evt) {
						raiseSize = 2;
						getRaise2Button().setSelected(true);
						getRaise25Button().setSelected(false);
						getRaise3Button().setSelected(false);
				}
			};
		}
		return raise2Action;
	}
	
	private AbstractAction getRaise25Action() {
		if(raise25Action == null) {
			raise25Action = new AbstractAction("2.5 bb", null) {
				public void actionPerformed(ActionEvent evt) {
						raiseSize = 2.5F;
						getRaise2Button().setSelected(false);
						getRaise25Button().setSelected(true);
						getRaise3Button().setSelected(false);
				}
			};
		}
		return raise25Action;
	}
	
	private AbstractAction getRaise3Action() {
		if(raise3Action == null) {
			raise3Action = new AbstractAction("3 bb", null) {
				public void actionPerformed(ActionEvent evt) {
						raiseSize = 3;
						getRaise2Button().setSelected(false);
						getRaise25Button().setSelected(false);
						getRaise3Button().setSelected(true);
				}
			};
		}
		return raise3Action;
	}
	
	private AbstractAction getSbAction() {
		if(sbAction == null) {
			sbAction = new AbstractAction("SB", null) {
				public void actionPerformed(ActionEvent evt) {
					sb = 0.5;
					getSbButton().setSelected(true);
					getBbButton().setSelected(false);
				}
			};
		}
		return sbAction;
	}
	
	private AbstractAction getBuAction() {
		if(buAction == null) {
			buAction = new AbstractAction("BU", null) {
				public void actionPerformed(ActionEvent evt) {
					sb = 0;
					getSbButton().setSelected(false);
					getBbButton().setSelected(true);
				}
			};
		}
		return buAction;
	}
	
	private AbstractAction getCalculateEqAction() {
		if(calculateEqAction == null) {
			calculateEqAction = new AbstractAction("Calculate Equilibrium", null) {
				public void actionPerformed(ActionEvent evt) {
					if (calculatingEq){
						calculatingEq = false;
						getCalcEqButton().setText("Calculate Equilibrium");
						getCalcEvButton().setEnabled(true);
						enableInputPanel(true);
					} else {
						calculatingEq = true;
						getCalcEqButton().setText("Calculating...");
						getCalcEvButton().setEnabled(false);
						enableInputPanel(false);
						Runnable r = new CalcEquilibrium();
						Thread t = new Thread(r);
						t.start();
						
					}
				}
			};
		}
		return calculateEqAction;
	}
	
	private void enableInputPanel (boolean b) {
		getRaiserRangeLabel().setEnabled(b);
		getEffectiveStacksLabel().setEnabled(b);
		getRRangeValueLabel().setEnabled(b);
		getEStacksValueLabel().setEnabled(b);
		getRangeSlider().setEnabled(b);
		getStackSlider().setEnabled(b);
		getRaiseSizeLabel().setEnabled(b);
		getRaise2Button().setEnabled(b);
		getRaise25Button().setEnabled(b);
		getRaise3Button().setEnabled(b);
		getRaiserPositionLabel().setEnabled(b);
		getSbButton().setEnabled(b);
		getBbButton().setEnabled(b);
		getSRangeText().setEditable(b);
		getCRangeText().setEditable(b);
	}
	
	private AbstractAction getCalculateEvAction() {
		if(calculateEvAction == null) {
			calculateEvAction = new AbstractAction("Calculate Expected Value", null) {
				public void actionPerformed(ActionEvent evt) {
					if (calculatingEq){
						calculatingEq = false;
						getCalcEvButton().setText("Calculate Expected Value");
						getCalcEqButton().setEnabled(true);
						enableInputPanel(true);
					} else {
						calculatingEq = true;
						getCalcEvButton().setText("Calculating...");
						getCalcEqButton().setEnabled(false);
						enableInputPanel(false);
						Runnable r = new CalcEV();
						Thread t = new Thread(r);
						t.start();
						
					}
					
				}
			};
		}
		return calculateEvAction;
	}
	
	private class CalcEV implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Range o = new Range();
			Range s = new Range();
			Range c = new Range();
			o.add("RC" + raiserRange);
			s.add("RP" + (int) Double.parseDouble(getSRangeText().getText()));
			c.add("RC" + (int) Double.parseDouble(getCRangeText().getText()));
			System.out.print( " K ");
			double evOfRaiser = evRaiser(o,c,s,50000);
			int trials = 50000;
			int cc = 0;
			while (calculatingEq && cc < 100) {
				evOfRaiser = (trials/(trials+50000.0))*evOfRaiser + (50000.0/(trials+50000.0))*evRaiser(o,c,s,50000);
				trials += 50000;
				getOutputTextArea().setText("Raiser's EV is: " + evOfRaiser + "\n Shover's EV is: " + (1.5-evOfRaiser));
				cc++;
			}
		}
		
	}

	private class CalcEquilibrium implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("--------------------------------");
			Range openRange = new Range();
			Range shovingRange = new Range();
			Range callingRange = new Range();
				openRange.add("RC" + raiserRange);
				callingRange.add("RC" + raiserRange/2);
				shovingRange = responseShoveRange(openRange,callingRange);
				
			double evOfRaiser = evRaiser(openRange,callingRange,shovingRange,10000);	
			int cc = 0;
			while (calculatingEq && cc < 200) {
				int y = responseCallRange(shovingRange).size();
				int z = responseShoveRange(openRange,callingRange).size();
				if (callingRange.size() > y) {
					callingRange.subtractCombos(2);
				} else {
					callingRange.addCombos(2);
				}
				if (shovingRange.size() > z) {
					shovingRange.subtractCombos(2);
				} else {
					shovingRange.addCombos(2);
				}
				shoveRange = shovingRange.size()/13.26;
				callRange = callingRange.size()/13.26;
				getSRangeText().setText(Double.toString(shoveRange));
				getCRangeText().setText(Double.toString(callRange));
				cc++;
				if (cc%8 == 0) {
					evOfRaiser = evRaiser(openRange,callingRange,shovingRange,120000);	
					}
				getOutputTextArea().setText("Calculating... \n Raiser's EV is: " + evOfRaiser + "\n Shover's EV is: " + (1.5-evOfRaiser));
				
			}
			
			getOutputTextArea().setText("Raiser's EV is: " + evOfRaiser + "\n Shover's EV is: " + (1.5-evOfRaiser));
		}	
		
		private Range responseShoveRange (Range open, Range call) { //works ok
			Range k = new Range();
				k.add("RP" + (int) (open.size()/13.26/4));
			double fe = 1.0 - 1.0*call.size()/open.size();
			double eq = Monte.pfRangeEquity(k.getBottom(50),call,9000,true);
			double reqEq = ( ((1.0-fe)*(effectiveStack-1) - fe*(1.5+raiseSize-sb))/((2*effectiveStack)*(1.0-fe))  );
			while (eq > reqEq) {
				k.addCombos(12);
				eq = Monte.pfRangeEquity(k.getBottom(50),call,9000,true);
			}
			
			return k;
		}
		
		private Range responseCallRange (Range shove) { //works ok
			double callSize = effectiveStack - raiseSize;
			Range k = new Range();
				k.add("RC" + (int) (shove.size()/13.26/2.6));
			double eq = Monte.pfRangeEquity(k.getBottom(50),shove,9000,true);
				
					while (eq > callSize/(2.0*effectiveStack)) {
						k.addCombos(12);
						eq = Monte.pfRangeEquity(k.getBottom(50),shove,9000,true);
					}
					
			return k;		
		}
		
		
	}
	
	private double evRaiser (Range open, Range call, Range shove, int trials) {
		double rPercent = open.size()/1326.0;
		double fe = (1326 - shove.size())/1326.0;
		double fes = 1.0*call.size()/open.size();
		double ev = (rPercent)*((fe)*(1.5) + (1-fe)*( (fes)*((Monte.pfRangeEquity(call,shove,trials,true))*2*effectiveStack-(effectiveStack-sb)) - (1-fes)*(raiseSize-sb) ));
		System.out.print("FE: " + fe + " -- FES: " + fes);
		return ev;
	}

}
