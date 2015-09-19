import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import poker.*;
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
public class CallingPractice extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar jMenuBar1;
	private AbstractAction abstractAction1;
	private JButton jButton1;
	private JLabel jLabel2;
	private JPanel holeCard2;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JButton jButton2;
	private JPanel holeCard1;
	private JPanel questionPanel;
	private JLabel jLabel1;
	private JLabel scoreLabel;
	private AbstractAction abstractAction2;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	private Hand holecards = new Hand("Ah Kh");
	private Range callRange = new Range();
	private Range pushRange = new Range();
	private String hc1 = "/cards/" + Card.getImage(holecards.getCard(0)) +".gif";
	private String hc2 = "/cards/" + Card.getImage(holecards.getCard(1)) +".gif";
	private static int qNumber = 1;
	private static int correct = 0;
	private static int total = 0;
	private AbstractAction mixedModeAction;
	private AbstractAction pushModeAction;
	private AbstractAction callModeAction;
	private JCheckBoxMenuItem mixedModeRadio;
	private JCheckBoxMenuItem pushModeRadio;
	private JCheckBoxMenuItem callModeRadio;
	private JMenu modeMenu;
	private AbstractAction onlyMarginalAction;
	private JCheckBoxMenuItem onlyMarginalMenu;
	private JMenu optionsMenu;
	private AbstractAction abstractAction5;
	private JLabel jLabel5;
	private JButton jButton3;
	private JDialog answerDialog;
	private AbstractAction abstractAction4;
	private AbstractAction abstractAction3;
	private int vsRange = 60;
	private int vsRange2;
	private int pot = 100;
	private int call = 100;
	private int ev = 0;
	private double reqEq;
	private double hadEq;
	private Range r1 = new Range();
	private Range r2 = new Range();
	private String answer;
	private boolean onlyMarginal = false;
	private String mode = "CALL";
	private boolean callmode = true;
	private int shoveStack;
	private int callStack;
	private int foldEquity;
	private boolean b; //used to generate only marginal loop

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CallingPractice inst = new CallingPractice();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public CallingPractice() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			callRange.add("RC40");
			pushRange.add("RP60");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getJButton1(), GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 44, Short.MAX_VALUE)
				        .addComponent(getJButton2(), GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
				        .addGap(6))
				    .addComponent(getScoreLabel(), GroupLayout.Alignment.LEADING, 0, 290, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(getQuestionPanel(), 0, 284, Short.MAX_VALUE)
				        .addGap(6))));
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getScoreLabel(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getQuestionPanel(), GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJButton1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButton2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJButton2(), getJButton1()});
			this.setTitle("SS Practice");
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenuBar1.add(getOptionsMenu());
					jMenu1.setText("File");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("jMenuItem1");
						jMenuItem1.setAction(getAbstractAction1());
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("jMenuItem2");
						jMenuItem2.setAction(getAbstractAction2());
					}
				}
			}
			pack();
			this.setSize(321, 301);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAbstractAction1() { //new menu action
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("New", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					correct = 0;
					total = 0;
					qNumber = 1;
					nextQuestion();
				}
			};
		}
		return abstractAction1;
	}
	
	private AbstractAction getAbstractAction2() { //exit menu action
		if(abstractAction2 == null) {
			abstractAction2 = new AbstractAction("Exit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return abstractAction2;
	}
	
	private JLabel getScoreLabel() {
		if(scoreLabel == null) {
			scoreLabel = new JLabel();
			scoreLabel.setText("Score: " + correct + "/" + total);
			scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return scoreLabel;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Question " + qNumber);
			jLabel1.setFont(new java.awt.Font("Arial",0,14));
		}
		return jLabel1;
	}
	
	private JPanel getQuestionPanel() {
		if(questionPanel == null) {
			questionPanel = new JPanel();
			GroupLayout questionPanelLayout = new GroupLayout((JComponent)questionPanel);
			questionPanel.setLayout(questionPanelLayout);
			questionPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			questionPanelLayout.setHorizontalGroup(questionPanelLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(questionPanelLayout.createParallelGroup()
				    .addComponent(getJLabel2(), GroupLayout.Alignment.LEADING, 0, 111, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, questionPanelLayout.createSequentialGroup()
				        .addPreferredGap(getJLabel2(), getJLabel1(), LayoutStyle.ComponentPlacement.INDENT)
				        .addComponent(getJLabel1(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(36)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getHoleCard1(), GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getJPanel1(), GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			questionPanelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getHoleCard1(), getJPanel1()});
			questionPanelLayout.setVerticalGroup(questionPanelLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getJLabel1(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(20)
				.addGroup(questionPanelLayout.createParallelGroup()
				    .addGroup(questionPanelLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(getJPanel1(), GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
				    .addComponent(getJLabel2(), GroupLayout.Alignment.LEADING, 0, 108, Short.MAX_VALUE)
				    .addGroup(questionPanelLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(getHoleCard1(), GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap());
			questionPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getHoleCard1(), getJPanel1()});
		}
		return questionPanel;
	}
	
	private JPanel getHoleCard1() {
		if(holeCard1 == null) {
			holeCard1 = new JPanel();
			BorderLayout holeCard1Layout = new BorderLayout();
			holeCard1.setLayout(holeCard1Layout);
			holeCard1.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
			holeCard1.setSize(80, 100);
			holeCard1.add(getJLabel3(), BorderLayout.CENTER);
		}
		return holeCard1;
	}
	
	private JPanel getJPanel1() {
		if(holeCard2 == null) {
			holeCard2 = new JPanel();
			BorderLayout holeCard2Layout = new BorderLayout();
			holeCard2.setLayout(holeCard2Layout);
			holeCard2.setSize(78, 97);
			holeCard2.setLocale(new java.util.Locale("en", "GB"));
			holeCard2.add(getJLabel4(), BorderLayout.CENTER);
		}
		return holeCard2;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("<html><center><p><b>V.S. Range</b></p><p>" + vsRange + "%</p><br /><p><b>Pot</b></p><p>$" + pot + "</p></center></html>");
			jLabel2.setVerticalAlignment(SwingConstants.TOP);
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel2;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("CALL $" + call);
			jButton1.setAction(getAbstractAction3());
		}
		return jButton1;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("FOLD");
			jButton2.setAction(getAbstractAction4());
		}
		return jButton2;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setIcon((Icon) new ImageIcon(getClass().getResource(hc1)));
			jLabel3.setPreferredSize(new java.awt.Dimension(75, 99));
		}
		return jLabel3;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setIcon((Icon) new ImageIcon(getClass().getResource(hc2)));
			jLabel4.setPreferredSize(new java.awt.Dimension(75, 99));
		}
		return jLabel4;
	}
	
	private void nextQuestion(){
		
		scoreLabel.setText("Score: " + correct + "/" + total);
		qNumber +=1;
		
		if (mode == "CALL") {
			callmode = true;
		} else if (mode == "PUSH") {
			callmode = false;
		} else if (Math.random() > 0.5) {
			callmode = true;
		} else {
			callmode = false;
		}
		
		if (callmode) {
			
			b = true;
			while (b) {
			vsRange = 1 + (int) (Math.random()*60);
			pot = (int) (Math.random()*200 + 40);
			call = (int) (Math.random()*pot/2 + pot/2);
			
			
			holecards = callRange.remove((int) (Math.random()*callRange.size()));
			hc1 = "/cards/" + Card.getImage(holecards.getCard(0)) +".gif";
			hc2 = "/cards/" + Card.getImage(holecards.getCard(1)) +".gif";
			callRange.add(holecards);
			if (!onlyMarginal) {
					b = false;
			} else {
					r1.clear();
					r2.clear();
					r1.add(holecards);
					try {
						if (vsRange>9){
							r2.add("RP" + vsRange);
						} else {
							r2.add("RP0" + vsRange);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int[] val = Monte.pfRangeEquity(r1,r2,1000);
					
					reqEq = 1.0 * call/(pot+call);
					hadEq = ((val[0]+(0.5*val[2]))/(val[0]+val[1]+val[2]));
					
					if (Math.abs(reqEq-hadEq) < .065) b = false;
				}
			}
			jLabel2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			jLabel2.setText("<html><center><p><b>V.S. Range</b></p><p>" + vsRange + "%</p><br /><p><b>Pot</b></p><p>$" + pot + "</p></center></html>");
			jButton1.setText("CALL $" +call);
		} else {
			b = true;
			while (b) {
				vsRange = 10 + (int) (Math.random()*90);
				pot = (int) (Math.random()*47 + 3);
				shoveStack = (int) (Math.random()*8*pot + 2*pot);
				callStack = (int) (shoveStack - (0.6*pot*Math.random()+0.2*pot));
				foldEquity = ((int) (Math.random()*8.5))*5 + 20;
				
				holecards = pushRange.remove((int) (Math.random()*pushRange.size()));
				hc1 = "/cards/" + Card.getImage(holecards.getCard(0)) +".gif";
				hc2 = "/cards/" + Card.getImage(holecards.getCard(1)) +".gif";
				pushRange.add(holecards);
				
				if (!onlyMarginal) {
						b = false;
				} else {
						r1.clear();
						r2.clear();
						r1.add(holecards);
						vsRange2 = vsRange * foldEquity / 100;
						try {
							if (vsRange2>9){
								r2.add("RC" + vsRange2);
							} else {
								r2.add("RC0" + vsRange2);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						int[] val = Monte.pfRangeEquity(r1,r2,1000);
						
						reqEq = ( ((1.0-(foldEquity/100.0))*shoveStack - (foldEquity/100.0)*pot)/((pot+shoveStack+callStack)*(1.0-(foldEquity/100.0)))  );
						hadEq = ((val[0]+(0.5*val[2]))/(val[0]+val[1]+val[2]));
						
						if (Math.abs(reqEq-hadEq) < .065) b = false;
					}
			}
			jLabel2.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
			jLabel2.setText("<html><div style=\"text-align:right\"><br /><p><b>V.S. Range:&nbsp;</b> " + vsRange + "%</p><p><b>Pot:</b> &nbsp;&nbsp;$" + pot + "</p><p><b>Villain has:</b> &nbsp;&nbsp;$" + callStack + "</p><p><b>Fold Equity:</b> &nbsp;" + foldEquity + "%</p></div></html>");
			jButton1.setText("PUSH $" + shoveStack);
		}
		
		jLabel1.setText("Question " + qNumber);
		jLabel3.setIcon((Icon) new ImageIcon(getClass().getResource(hc1)));
		jLabel4.setIcon((Icon) new ImageIcon(getClass().getResource(hc2)));
	}
	
	private void checkQuestion(boolean called) {
		r1.clear();
		r2.clear();
		r1.add(holecards);
		if (callmode) {
			try {
				if (vsRange>9){
					r2.add("RP" + vsRange);
				} else {
					r2.add("RP0" + vsRange);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int[] val = Monte.pfRangeEquity(r1,r2,10000);
			
			reqEq = 1.0 * call/(pot+call);
			hadEq = ((val[0]+(0.5*val[2]))/(val[0]+val[1]+val[2]));
			ev = (int) ((hadEq-reqEq)*(pot+call)*100);
			
			if (called && ev > 0) {
				answer = "CORRECT";
				correct += 1;
			} else if (!called && ev < 0) {
				answer = "CORRECT";
				correct += 1;
			} else {
				answer = "INCORRECT";
			}
			total += 1;
			
			showAnswer();
		} else {
			vsRange = vsRange * foldEquity / 100;
			try {
				if (vsRange>9){
					r2.add("RC" + vsRange);
				} else {
					r2.add("RC0" + vsRange);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int[] val = Monte.pfRangeEquity(r1,r2,10000);
			
			reqEq = ( ((1.0-(foldEquity/100.0))*shoveStack - (foldEquity/100.0)*pot)/((pot+shoveStack+callStack)*(1.0-(foldEquity/100.0)))  );
			hadEq = ((val[0]+(0.5*val[2]))/(val[0]+val[1]+val[2]));
			ev = (int) ( ((foldEquity/100.0)*pot + (1.0-(foldEquity/100.0))*((pot+shoveStack+callStack)*hadEq - shoveStack))*100    );
			
			if (called && ev > 0) {
				answer = "CORRECT";
				correct += 1;
			} else if (!called && ev < 0) {
				answer = "CORRECT";
				correct += 1;
			} else {
				answer = "INCORRECT";
			}
			total += 1;
			
			showAnswer();
		}
		
	}
	
	private void showAnswer() {
		getAnswerDialog().pack();
		jLabel5.setText("<html><center><p><b>" + answer + "</b></p><br><p>Required equity:<br>" + (int) (100*reqEq) + "%<br>You had equity:<br>" + (int) (100*hadEq) +"%<br>Your EV was:<br>$" + M.toS(ev) + "</p></center></html>");
		getAnswerDialog().setLocationRelativeTo(null);
		getAnswerDialog().setVisible(true);
		
	}
	
	private AbstractAction getAbstractAction3() {
		if(abstractAction3 == null) {
			abstractAction3 = new AbstractAction("CALL $" + call, null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					checkQuestion(true);
				}
			};
		}
		return abstractAction3;
	}
	
	private AbstractAction getAbstractAction4() {
		if(abstractAction4 == null) {
			abstractAction4 = new AbstractAction("FOLD", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					checkQuestion(false);
				}
			};
		}
		return abstractAction4;
	}
	
	private JDialog getAnswerDialog() {
		if(answerDialog == null) {
			answerDialog = new JDialog(this);
			GroupLayout answerDialogLayout = new GroupLayout((JComponent)answerDialog.getContentPane());
			answerDialog.getContentPane().setLayout(answerDialogLayout);
			answerDialog.setFont(new java.awt.Font("Arial",0,14));
			answerDialog.setPreferredSize(new java.awt.Dimension(248, 247));
			answerDialog.setSize(248, 247);
			answerDialogLayout.setHorizontalGroup(answerDialogLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(answerDialogLayout.createParallelGroup()
				    .addComponent(getJButton3(), GroupLayout.Alignment.LEADING, 0, 228, Short.MAX_VALUE)
				    .addComponent(getJLabel5(), GroupLayout.Alignment.LEADING, 0, 228, Short.MAX_VALUE))
				.addContainerGap());
			answerDialogLayout.setVerticalGroup(answerDialogLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getJLabel5(), 0, 111, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getJButton3(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
		}
		return answerDialog;
	}
	
	private JButton getJButton3() {
		if(jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Next Question");
			jButton3.setAction(getAbstractAction5());
		}
		return jButton3;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("???");
			jLabel5.setFont(new java.awt.Font("Arial",0,14));
			jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel5;
	}
	
	private AbstractAction getAbstractAction5() {
		if(abstractAction5 == null) {
			abstractAction5 = new AbstractAction("Next Question", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					getAnswerDialog().dispose();
					nextQuestion();
				}
			};
		}
		return abstractAction5;
	}
	
	private JMenu getOptionsMenu() {
		if(optionsMenu == null) {
			optionsMenu = new JMenu();
			optionsMenu.setText("Options");
			optionsMenu.add(getOnlyMarginalMenu());
			optionsMenu.add(getModeMenu());
		}
		return optionsMenu;
	}
	
	private JCheckBoxMenuItem getOnlyMarginalMenu() {
		if(onlyMarginalMenu == null) {
			onlyMarginalMenu = new JCheckBoxMenuItem();
			onlyMarginalMenu.setText("Only Marginal Spots");
			onlyMarginalMenu.setSelected(false);
			onlyMarginalMenu.setAction(getOnlyMarginalAction());
		}
		return onlyMarginalMenu;
	}
	
	private AbstractAction getOnlyMarginalAction() {
		if(onlyMarginalAction == null) {
			onlyMarginalAction = new AbstractAction("Only Marginal Spots", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					if (onlyMarginal == true) {
						onlyMarginal = false;
					} else {
						onlyMarginal = true;
					}
				}
			};
		}
		return onlyMarginalAction;
	}
	
	private JMenu getModeMenu() {
		if(modeMenu == null) {
			modeMenu = new JMenu();
			modeMenu.setText("Mode");
			modeMenu.add(getCallModeRadio());
			modeMenu.add(getPushModeRadio());
			modeMenu.add(getMixedModeRadio());
		}
		return modeMenu;
	}
	
	private JCheckBoxMenuItem getCallModeRadio() {
		if(callModeRadio == null) {
			callModeRadio = new JCheckBoxMenuItem();
			callModeRadio.setText("Call");
			callModeRadio.setSelected(true);
			callModeRadio.setAction(getCallModeAction());
		}
		return callModeRadio;
	}
	
	private JCheckBoxMenuItem getPushModeRadio() {
		if(pushModeRadio == null) {
			pushModeRadio = new JCheckBoxMenuItem();
			pushModeRadio.setText("Push");
			pushModeRadio.setAction(getPushModeAction());
		}
		return pushModeRadio;
	}
	
	private JCheckBoxMenuItem getMixedModeRadio() {
		if(mixedModeRadio == null) {
			mixedModeRadio = new JCheckBoxMenuItem();
			mixedModeRadio.setText("Mixed");
			mixedModeRadio.setAction(getMixedModeAction());
		}
		return mixedModeRadio;
	}
	
	private AbstractAction getCallModeAction() {
		if(callModeAction == null) {
			callModeAction = new AbstractAction("Call", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					callModeRadio.setSelected(true);
					pushModeRadio.setSelected(false);
					mixedModeRadio.setSelected(false);
					mode = "CALL";
				}
			};
		}
		return callModeAction;
	}
	
	private AbstractAction getPushModeAction() {
		if(pushModeAction == null) {
			pushModeAction = new AbstractAction("Push", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					callModeRadio.setSelected(false);
					pushModeRadio.setSelected(true);
					mixedModeRadio.setSelected(false);
					mode = "PUSH";
				}
			};
		}
		return pushModeAction;
	}
	
	private AbstractAction getMixedModeAction() {
		if(mixedModeAction == null) {
			mixedModeAction = new AbstractAction("Mixed", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					callModeRadio.setSelected(false);
					pushModeRadio.setSelected(false);
					mixedModeRadio.setSelected(true);
					mode = "MIXED";
				}
			};
		}
		return mixedModeAction;
	}

}
