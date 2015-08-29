package datamanagement;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheckGradeUserInterface extends javax.swing.JFrame implements InterfaceUnitLister, InterfaceStudentLister {
	private CheckGradeControl control_;
	private javax.swing.DefaultComboBoxModel unitModel_;
	private javax.swing.DefaultComboBoxModel recordModel_;
	float assignment1;
	float assignment2;
	float exam;
	int selectedId;

	
	
	public CheckGradeUserInterface(CheckGradeControl control) {
		this.control_ = control;
		unitModel_ = new javax.swing.DefaultComboBoxModel(new String[0]);
		recordModel_ = new javax.swing.DefaultComboBoxModel(new String[0]);
		initComponents();
		jComboBox1_.setModel(unitModel_);
		jComboBox2_.setModel(recordModel_);
		jlabel6_.setText("");
	}

	
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		jLabel1_ = new javax.swing.JLabel();
		jPanel1_ = new javax.swing.JPanel();
		jComboBox1_ = new javax.swing.JComboBox();
		jPanel2_ = new javax.swing.JPanel();
		jComboBox2_ = new javax.swing.JComboBox();
		jPanel3_ = new javax.swing.JPanel();
		jLabel2_ = new javax.swing.JLabel();
		jLabel3_ = new javax.swing.JLabel();
		jLabel4_ = new javax.swing.JLabel();
		jTextField1_ = new javax.swing.JTextField();
		jTextField2_ = new javax.swing.JTextField();
		jTextField3_ = new javax.swing.JTextField();
		jButton1_ = new javax.swing.JButton();
		jPanel4_ = new javax.swing.JPanel();
		jLabel5_ = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1_.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabel1_.setText("Check Grade UI");

		jPanel1_.setBorder(javax.swing.BorderFactory.createTitledBorder("Unit"));

		jComboBox1_.setModel(unitModel_);
		jComboBox1_.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent event) {
				jComboBox1ItemStateChanged(event);
			}
		});

		
		
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1_);
		jPanel1_.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jComboBox1_, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jComboBox1_, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel2_.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));

		jComboBox2_.setModel(recordModel_);
		jComboBox2_.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent event) {
				jComboBox2ItemStateChanged(event);
			}
		});

		
		
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2_);
		jPanel2_.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jComboBox2_, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jComboBox2_, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel3_.setBorder(javax.swing.BorderFactory.createTitledBorder("Marks"));

		jLabel2_.setText("Assignment 1:");

		jLabel3_.setText("Assignment 2:");

		jLabel4_.setText("Exam:");

		jTextField1_.setEditable(false);
		jTextField1_.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent event) {
				jTextFieldKeyTyped(event);
			}
		});

		
		
		jTextField2_.setEditable(false);
		jTextField2_.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent event) {
				jTextFieldKeyTyped(event);
			}
		});

		
		
		jTextField3_.setEditable(false);
		jTextField3_.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent event) {
				jTextFieldKeyTyped(event);
			}
		});

		
		
		jButton1_.setText("Change");
		jButton1_.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				jButton1ActionPerformed(event);
			}
		});

		
		
		jButton2_ = new javax.swing.JButton();

		jButton2_.setText("Check Grade");
		jButton2_.setActionCommand("checkGrade");
		jButton2_.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				jButton3ActionPerformed(event);
			}
		});

		
		
		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3_);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2_)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jTextField1_, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(jLabel3_))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(85).addComponent(jButton1_,
								GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(
						jPanel3Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(jTextField2_, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(jLabel4_))
								.addComponent(jButton2_))
						.addGap(18)
						.addComponent(jTextField3_, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGap(15)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2_)
								.addComponent(jTextField1_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3_)
						.addComponent(jTextField2_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addComponent(jLabel4_).addComponent(jTextField3_,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel3Layout
								.createParallelGroup(Alignment.BASELINE).addComponent(jButton1_).addComponent(jButton2_))
				.addContainerGap()));
		jPanel3_.setLayout(jPanel3Layout);

		jPanel4_.setBorder(javax.swing.BorderFactory.createTitledBorder("Grade"));

		jLabel5_.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel5_.setForeground(new java.awt.Color(255, 0, 0));
		jLabel5_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5_.setText("grade");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4_);
		jPanel4_.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel5_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						153, Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(jLabel5_)
						.addContainerGap(43, Short.MAX_VALUE)));

		jlabel6_ = new JLabel();
		jlabel6_.setText("Error message");
		jlabel6_.setForeground(Color.RED);
		jlabel6_.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jButton3_ = new javax.swing.JButton();

		jButton3_.setText("Save");
		jButton3_.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				jButton2ActionPerformed(event);
			}
		});

		
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(
														jlabel6_, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jPanel3_, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(jPanel1_, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jPanel2_, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18).addComponent(jPanel4_, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup().addGap(157).addComponent(jLabel1_))
						.addGroup(layout.createSequentialGroup().addGap(165).addComponent(jButton3_,
								GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap().addComponent(jLabel1_).addGap(13)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel1_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(jPanel2_,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(jPanel4_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jPanel3_, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(jButton3_).addGap(11)
				.addComponent(jlabel6_, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	
	
	private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent event) {// GEN-FIRST:event_jComboBox1ItemStateChanged
		String currentUnit = (String) jComboBox1_.getSelectedItem();
		Refresh3();
		clearStudents();
		if (event.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			if (currentUnit.equals((String) jComboBox1_.getItemAt(0))) {
				currentUnit = "NONE";
			}
			control_.unitSelected(currentUnit);
		}
	}// GEN-LAST:event_jComboBox1ItemStateChanged

	
	
	private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent event) {// GEN-FIRST:event_jComboBox2ItemStateChanged
		Refresh3();
		String currentStudent = (String) jComboBox2_.getSelectedItem();
		if (event.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
			if (currentStudent.equals((String) jComboBox2_.getItemAt(0))) {
				selectedId = new Integer(0);
				control_.studentSelected(selectedId);
			} else {
				selectedId = new Integer(currentStudent.split("\\s")[0]);
			}
			control_.studentSelected(selectedId);
		}
	}// GEN-LAST:event_jComboBox2ItemStateChanged

	
	
	private void jButton3ActionPerformed(java.awt.event.ActionEvent event) {// GEN-FIRST:event_jButton3ActionPerformed
		assignment1 = new Float(jTextField1_.getText()).floatValue();
		assignment2 = new Float(jTextField2_.getText()).floatValue();
		exam = new Float(jTextField3_.getText()).floatValue();
		// lblErrMsg.setText("");
		try {
			String string = control_.checkGrade(assignment1, assignment2, exam);
			jLabel5_.setText(string);
		} catch (RuntimeException runtimeException) {
			jlabel6_.setText(runtimeException.getMessage());
		}
	}// GEN-LAST:event_jButton3ActionPerformed

	
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent event) {// GEN-FIRST:event_jButton1ActionPerformed
		control_.enableChangeMarks();
		jLabel5_.setText("");
		// lblErrMsg.setText("");
	}// GEN-LAST:event_jButton1ActionPerformed

	
	
	private void jTextFieldKeyTyped(java.awt.event.KeyEvent event) {// GEN-FIRST:event_jTextField1KeyTyped
		jLabel5_.setText("");
		jlabel6_.setText("");
	}// GEN-LAST:event_jTextField1KeyTyped

	
	
	private void jButton2ActionPerformed(java.awt.event.ActionEvent event) {// GEN-FIRST:event_jButton2ActionPerformed
		float aassignment1 = new Float(jTextField1_.getText()).floatValue();
		float assignment2 = new Float(jTextField2_.getText()).floatValue();
		float exam = new Float(jTextField3_.getText()).floatValue();
		jlabel6_.setText("");
		try {
			control_.saveGrade(aassignment1, assignment2, exam);
			// jButton3ActionPerformed(null);
		} catch (RuntimeException runtimeException) {
			jlabel6_.setText(runtimeException.getMessage());
		}
	}// GEN-LAST:event_jButton2ActionPerformed

	
	
	public void clearUnits() {
		unitModel_.removeAllElements();
		unitModel_.addElement("<none selected>");
		clearStudents();
	}

	
	
	public void addUnit(InterfaceUnit unit) {
		unitModel_.addElement(unit.getUnitCode());
	}

	
	
	public void setState1(boolean isEnabled) {
		jComboBox1_.setEnabled(isEnabled);
		jlabel6_.setText("");
	}

	
	
	public void clearStudents() {
		recordModel_.removeAllElements();
		recordModel_.addElement("<none selected>");
	}

	
	
	public void addStudent(InterfaceStudent student) {
		recordModel_
				.addElement(student.getID().toString() + " : " + student.getFirstName() + " " + student.getLastName());
	}

	
	
	public void setState2(boolean isEnabled) {
		jComboBox2_.setEnabled(isEnabled);
		jlabel6_.setText("");
	}

	
	
	public void setRecord(InterfaceStudentUnitRecord record) {
		jTextField1_.setText(new Float(record.getAssignment1Mark()).toString());
		jTextField2_.setText(new Float(record.getAssignment2Mark()).toString());
		jTextField3_.setText(new Float(record.getExamMark()).toString());
		jLabel5_.setText("");
	}

	
	
	public void Refresh3() {
		jTextField1_.setText("");
		jTextField2_.setText("");
		jTextField3_.setText("");
		jLabel5_.setText("");
		jlabel6_.setText("");
		jTextField1_.setEditable(false);
		jTextField2_.setEditable(false);
		jTextField3_.setEditable(false);
	}

	
	
	public void setState3(boolean isEnabled) {
		jButton2_.setEnabled(isEnabled);
	}

	
	
	public void setState4(boolean isEnabled) {
		jButton1_.setEnabled(isEnabled);
		// gradeLB.setText("");
	}

	
	
	public void setState5(boolean isEnabled) {
		jTextField1_.setEditable(isEnabled);
		jTextField2_.setEditable(isEnabled);
		jTextField3_.setEditable(isEnabled);
	}

	
	
	public void setState6(boolean isEnabled) {
		jButton3_.setEnabled(isEnabled);
	}

	
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1_;
	private javax.swing.JButton jButton2_;
	private javax.swing.JButton jButton3_;
	private javax.swing.JComboBox jComboBox1_;
	private javax.swing.JComboBox jComboBox2_;
	private javax.swing.JLabel jLabel1_;
	private javax.swing.JLabel jLabel2_;
	private javax.swing.JLabel jLabel3_;
	private javax.swing.JLabel jLabel4_;
	private javax.swing.JLabel jLabel5_;
	private javax.swing.JLabel jlabel6_;
	private javax.swing.JPanel jPanel1_;
	private javax.swing.JPanel jPanel2_;
	private javax.swing.JPanel jPanel3_;
	private javax.swing.JPanel jPanel4_;
	private javax.swing.JTextField jTextField1_;
	private javax.swing.JTextField jTextField2_;
	private javax.swing.JTextField jTextField3_;
}
