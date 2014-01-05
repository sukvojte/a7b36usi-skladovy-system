/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.gui.documentitems;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.gui.ComboBoxProductItem;
import cz.a7b36usi.sklad.gui.documentitems.ifaces.IDocumentItemsGUI;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGuiListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

/**
 * 
 * @author Lukas Lowinger
 */
@Component
public class DocumentItemsGUI extends javax.swing.JDialog implements
		IDocumentItemsGUI {

	static final Logger logger = Logger.getLogger(DocumentItemsGUI.class);

	private ArrayList<IOrderItemsGuiListener> listeners;

	private MovementDTO editedItem;
	private List<ProductDTO> products;
	private BaseDataModel<?> baseDataModel;

	public void addListeners(IOrderItemsGuiListener listener) {
		listeners.add(listener);
	}

	public void removeListeners(IOrderItemsGuiListener listener) {
		listeners.remove(listener);
	}

	public void editMovementItem(MovementDTO movementItem) {
		editedItem = movementItem;

		cbProdukt.setSelectedIndex(-1);
		if (editedItem != null) {
			try {
				tbCount.setText(String.valueOf(editedItem.getQuantity()));
			} catch (RuntimeException ex) {
				tbCount.setText("0");
			}

			int i = 0;
			if (products != null) {
				for (ProductDTO product : products) {
					if (product.getId().equals(editedItem.getProdukt().getId())) {
						cbProdukt.setSelectedIndex(i);
						break;
					}
					i++;
				}
			}
		} else {
			tbCount.setText("");
		}

	}

	public MovementDTO getEditedMovementItem() {

		if (editedItem == null) {
			editedItem = new MovementDTO();
		}
		ComboBoxProductItem product = (ComboBoxProductItem) cbProdukt
				.getSelectedItem();
		if (product != null) {
			editedItem.setProdukt(product.getProduct());
		} else {
			editedItem.setProdukt(null);
		}
		editedItem.setQuantity(Integer.parseInt(tbCount.getText()));

		return editedItem;
	}

	public void setTableModel(BaseDataModel<?> model, List<ProductDTO> products, List<ProductVersionDTO> productVersions, List<WrappingTypeDTO> wrappings) {
		this.baseDataModel = model;
		this.products = products;
		this.tableItems.setModel(model);

		cbProdukt.removeAllItems();
		if (products != null) {
			for (ProductDTO product : products) {
				cbProdukt.addItem(new ComboBoxProductItem(product));
			}
		}
		
		sarzeCB.removeAllItems();
		if(productVersions != null){
		    for (ProductVersionDTO pv : productVersions) {
			sarzeCB.addItem(pv);
		    }
		}
		druhBaleni.removeAllItems();
		if(druhBaleni!= null){
		    for (WrappingTypeDTO wt : wrappings) {
			druhBaleni.addItem(wt);
		    }
		}

	}

	public DocumentItemsGUI() {
		super();
		listeners = new ArrayList<IOrderItemsGuiListener>();
		initComponents();
	}

	/**
	 * Creates new form DocumentWizard
	 */
	public DocumentItemsGUI(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		listeners = new ArrayList<IOrderItemsGuiListener>();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        cbProdukt = new javax.swing.JComboBox<ComboBoxProductItem>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbCount = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        novyZaznamJB = new javax.swing.JButton();
        sarzeCB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        druhBaleni = new javax.swing.JComboBox();

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

        cbProdukt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProdukt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProduktActionPerformed(evt);
            }
        });

        jLabel1.setText("Produkt :");

        jLabel2.setText("Počet :");
        jLabel2.setToolTipText("");

        tbCount.setText("0");
        tbCount.setToolTipText("");

        btnDelete.setText("Smazat");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        novyZaznamJB.setText("Novy");
        novyZaznamJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novyZaznamJBActionPerformed(evt);
            }
        });

        sarzeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Sarze :");

        jLabel4.setText("Druh baleni :");

        druhBaleni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(38, 38, 38)
                                .add(jLabel4))
                            .add(layout.createSequentialGroup()
                                .add(42, 42, 42)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel1)
                                    .add(jLabel2)
                                    .add(jLabel3))))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, 140, Short.MAX_VALUE)
                                .add(novyZaznamJB)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnDelete)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(39, 39, 39)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(druhBaleni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(cbProdukt, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(tbCount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, sarzeCB, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .add(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbProdukt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(tbCount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(sarzeCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(druhBaleni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 54, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnDelete)
                    .add(novyZaznamJB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novyZaznamJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novyZaznamJBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novyZaznamJBActionPerformed

	private void cbProduktActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbProduktActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cbProduktActionPerformed

	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
		for (IOrderItemsGuiListener ctrl : listeners) {
			ctrl.save();
		}
	}// GEN-LAST:event_btnSaveActionPerformed

	private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableItemsMouseClicked

		JTable table = (JTable) evt.getComponent();

		if (table.getSelectedRowCount() == 1) {
			int selected = table.getSelectedRow();

			for (IOrderItemsGuiListener ctrl : listeners) {
				ctrl.click(selected);
			}
		}
	}// GEN-LAST:event_tableItemsMouseClicked

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
		for (IOrderItemsGuiListener ctrl : listeners) {
			ctrl.delete();
		}
	}// GEN-LAST:event_btnDeleteActionPerformed

	/**
	 * @param args
	 *            the command line arguments
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
			java.util.logging.Logger
					.getLogger(DocumentItemsGUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger
					.getLogger(DocumentItemsGUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger
					.getLogger(DocumentItemsGUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger
					.getLogger(DocumentItemsGUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DocumentItemsGUI dialog = new DocumentItemsGUI(
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
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<ComboBoxProductItem> cbProdukt;
    private javax.swing.JComboBox druhBaleni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton novyZaznamJB;
    private javax.swing.JComboBox sarzeCB;
    private javax.swing.JTable tableItems;
    private javax.swing.JTextField tbCount;
    // End of variables declaration//GEN-END:variables

}
