/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.gui;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import org.apache.log4j.Logger;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lukas Lowinger
 */
public class EditWindowGUI extends javax.swing.JDialog {

    /**
     *
     */
    private static final long serialVersionUID = -3509027706405436616L;
    static final Logger logger = Logger.getLogger(EditWindowGUI.class);
    private ArrayList<IEditItemsGuiListener> listeners;
    protected BaseDataModel<?> baseDataModel;

    public void addListeners(IEditItemsGuiListener listener) {
	listeners.add(listener);
    }

    public void removeListeners(IEditItemsGuiListener listener) {
	listeners.remove(listener);
    }

    protected BaseDataModel<?> getBaseDataModel() {
	return baseDataModel;
    }

    protected void setBaseDataModel(BaseDataModel<?> baseDataModel) {
	this.baseDataModel = baseDataModel;
	tableItems.setModel(baseDataModel);
    }

    protected void afterInit() {
    }

    public EditWindowGUI() {
	super();
	listeners = new ArrayList<IEditItemsGuiListener>();
	initComponents();
	horniPanelJP.setLayout(new FlowLayout());
	afterInit();
    }

    /**
     * Creates new form DocumentWizard
     */
    public EditWindowGUI(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
	listeners = new ArrayList<IEditItemsGuiListener>();
	initComponents();
    }

    protected JPanel getTopPanel() {
	return horniPanelJP;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        horniPanelJP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableItems);

        btnSave.setText("Uložit");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Smazat");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("Nový");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout horniPanelJPLayout = new org.jdesktop.layout.GroupLayout(horniPanelJP);
        horniPanelJP.setLayout(horniPanelJPLayout);
        horniPanelJPLayout.setHorizontalGroup(
            horniPanelJPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 454, Short.MAX_VALUE)
        );
        horniPanelJPLayout.setVerticalGroup(
            horniPanelJPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 126, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(btnNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(272, 272, 272)
                        .add(btnDelete)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(horniPanelJP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(horniPanelJP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 53, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnDelete)
                    .add(btnNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void createNew() {
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
	createNew();
    }//GEN-LAST:event_btnNewActionPerformed

    private void cbProduktActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbProduktActionPerformed
	// TODO add your handling code here:
    }// GEN-LAST:event_cbProduktActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
	for (IEditItemsGuiListener ctrl : listeners) {
	    if (!ctrl.validate()) {
		JOptionPane.showMessageDialog(rootPane, "Chyba se zadanim udaju.", "Chyba se zadanim.", JOptionPane.ERROR_MESSAGE);
		return;
	    }
	}
	for (IEditItemsGuiListener ctrl : listeners) {
	    ctrl.save();
	}
    }// GEN-LAST:event_btnSaveActionPerformed

    private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableItemsMouseClicked

	JTable table = (JTable) evt.getComponent();

	if (table.getSelectedRowCount() == 1 && evt.getClickCount() == 1) {
	    int selected = table.getSelectedRow();

	    for (IEditItemsGuiListener ctrl : listeners) {
		ctrl.click(selected);
	    }
	}
    }// GEN-LAST:event_tableItemsMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
	for (IEditItemsGuiListener ctrl : listeners) {
	    ctrl.delete();
	}
    }// GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	// <editor-fold defaultstate="collapsed"
	// desc=" Look and feel setting code (optional) ">
		/*
	 * If Nimbus (introduced in Java SE 6) is not available, stay with the
	 * default look and feel. For details see
	 * http://download.oracle.com/javase
	 * /tutorial/uiswing/lookandfeel/plaf.html
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
		    .getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(EditWindowGUI.class.getName())
		    .log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(EditWindowGUI.class.getName())
		    .log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(EditWindowGUI.class.getName())
		    .log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(EditWindowGUI.class.getName())
		    .log(java.util.logging.Level.SEVERE, null, ex);
	}
	// </editor-fold>

	/* Create and display the dialog */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		EditWindowGUI dialog = new EditWindowGUI(
			new javax.swing.JFrame(), true);
		dialog.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		    }
		});
		dialog.setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel horniPanelJP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableItems;
    // End of variables declaration//GEN-END:variables
}
