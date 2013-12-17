/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.gui.main;

import cz.a7b36usi.sklad.BO.DocumentType;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.Service.IPrintService;
import cz.a7b36usi.sklad.gui.main.ifaces.IGuiData;
import cz.a7b36usi.sklad.gui.main.ifaces.IGuiTextFields;
import cz.a7b36usi.sklad.gui.main.ifaces.ISkladMainGUI;
import cz.a7b36usi.sklad.gui.main.listeners.IMainGuiListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.validators.AbstractValidator;
import cz.a7b36usi.sklad.validators.NumberValidator;
import cz.a7b36usi.sklad.validators.PasswordValidator;
import cz.a7b36usi.sklad.validators.UserNameValidator;
import cz.a7b36usi.sklad.validators.ValueValidator;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lukas Lowinger
 */
@Component
public class SkladMainGUI extends javax.swing.JFrame implements ISkladMainGUI {

    private PartnerDTO lastZakaznik = null;
    private UserDTO lastUser = null;
    private OrderDTO lastOrder = null;
    private BaseDataModel baseDataModel;
    public JButton filtrJB;
    /* Listenery - START */
    private ArrayList<IMainGuiListener> listeners;
    @Autowired
    IPrintService printService;

    public void addListeners(IMainGuiListener listener) {
	listeners.add(listener);
    }

    public void removeListeners(IMainGuiListener listener) {
	listeners.remove(listener);
    }
    /* Listenery - END */

    public boolean switchTab(Tabs tab) {

	// TODO: switch tab

	// Fire event
	for (IMainGuiListener ctrl : listeners) {
	    ctrl.tabChanged(tab);
	}

	return true;
    }

    public IGuiData getData() {
	return new IGuiData() {
	    public UserDTO getUserData() {
		//TODO: co s ID ?
		long id = 0;
		if (lastUser != null) {
		    id = lastUser.getId();
		}
		return new UserDTO((id != 0 ? id : null), uzivatelskeJmenoJT.getText(), (UserRole) roleJC.getSelectedItem(), new String(hesloUzivatelPF.getPassword()));
	    }

	    public PartnerDTO getPartnerData() {
		//TODO: zatim se neresi dodavatel, odberatel
		long id = 0;
		if (lastZakaznik != null) {
		    id = lastZakaznik.getId();
		}
		return new PartnerDTO((id != 0 ? id : null), true, false, uliceTF.getText(), mestoTF.getText(), spolecnostTF.getText(), Integer.parseInt(pscTF.getText()), Integer.parseInt(cisloPopTF.getText()));
	    }

	    public OrderDTO getOrderData() {
		long id = 0;
		if (lastOrder != null) {
		    id = lastOrder.getId();
		}
		return new OrderDTO((id != 0 ? id : null), dateChooserCombo1.getSelectedDate().getTime(), cisloObjednavkaTF.getText(), null, ((PartnerDTO) partnersCB.getSelectedItem()).getId());//TODO: id partnera ? list orderItemu ?
	    }

	    public DocumentDTO getDocumentData() {
		throw new UnsupportedOperationException("Not supported yet.");
	    }
	};
    }

    public void setTableModel(BaseDataModel model) {
	baseDataModel = model;
	jTable1.setModel(model);
	createFilterPanel();
    }

    public void editCustomer(PartnerDTO customer) {
	ulozJB.setText("Ulož");
	lastZakaznik = customer;
	nullValidators();
	if (lastZakaznik != null) {
	    uliceTF.setText(lastZakaznik.getUlice());
	    mestoTF.setText(lastZakaznik.getMesto());
	    spolecnostTF.setText(lastZakaznik.getSpolecnost());
	    pscTF.setText(String.valueOf(lastZakaznik.getPsc()));
	    cisloPopTF.setText(String.valueOf(lastZakaznik.getCisloPopisne()));
	} else {
	    uliceTF.setText("");
	    mestoTF.setText("");
	    spolecnostTF.setText("");
	    pscTF.setText("");
	    cisloPopTF.setText("");
	}
    }

    public void editUser(UserDTO user) {
	ulozJB.setText("Ulož");
	lastUser = user;
	nullValidators();
	if (lastUser != null) {
	    uzivatelskeJmenoJT.setEditable(false);
	    uzivatelskeJmenoJT.setText(user.getUsername());
	    hesloUzivatelPF.setText(user.getPassword());
	    roleJC.setSelectedItem(user.getAcl());
	} else {
	    uzivatelskeJmenoJT.setEditable(true);
	    uzivatelskeJmenoJT.setText("");
	    hesloUzivatelPF.setText("heslo");
	    roleJC.setSelectedItem(UserRole.SKLADNIK);
	}
    }

    public void editOrder(OrderDTO order) {
	ulozJB.setText("Ulož");
	lastOrder = order;
	nullValidators();
	if (lastOrder != null) {
	    Calendar c = Calendar.getInstance();
	    c.setTime(order.getDate());
	    dateChooserCombo1.setCurrent(c);
	    cisloObjednavkaTF.setText(order.getNumber());
	} else {
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date());
	    dateChooserCombo1.setCurrent(c);
	    cisloObjednavkaTF.setText(null);
	}

    }

    private void nullForms() {
	editCustomer(null);
	editUser(null);
	editOrder(null);
	ulozJB.setText("Vytvoř");
    }

    private void nullValidators() {
	((AbstractValidator) pscTF.getInputVerifier()).correct(pscTF);
	((AbstractValidator) cisloPopTF.getInputVerifier()).correct(cisloPopTF);
	((AbstractValidator) spolecnostTF.getInputVerifier()).correct(spolecnostTF);
	((AbstractValidator) uzivatelskeJmenoJT.getInputVerifier()).correct(uzivatelskeJmenoJT);
	((AbstractValidator) hesloUzivatelPF.getInputVerifier()).correct(hesloUzivatelPF);
    }

    /**
     * Creates new form SkladMainGUI
     */
    public SkladMainGUI() {
	listeners = new ArrayList<IMainGuiListener>();
	filtrJB = new JButton("FILTRR");
	initComponents();

	addListeners();
	addItemsToComboLists();
	addInputVerifiers();
    }

    private void addListeners() {
	jTabbedPane1.addChangeListener(new ChangeListener() {
	    public void stateChanged(ChangeEvent e) {
		JTabbedPane source = (JTabbedPane) e.getSource();
		if (!(source.getSelectedComponent() instanceof TabsJPanel)) {
		    throw new RuntimeException("Panel " + source.getSelectedIndex() + " isn't instance of TabsJPanel");
		}

		/*
		 * TODO: remove this comment
		 * Aby tady nemusel byt enum, tak lze v NetBeans vyuzit Custom Creation Code na karte Code, kde si zavolas vlastni konstruktor. 
		 * Ja vyuzivam tridy TabsJPanel ktera dedi z JPanel, ale je tam navic informace o aktivnim panelu. Takze tenhle kod nemusis editovat, 
		 * kdyz budes editovat zalozky
		 */

		TabsJPanel panel = (TabsJPanel) source.getSelectedComponent();
		Tabs selectedTab = panel.getTab();

		// TODO: akce pri zmene panelu
		nullForms();

		// Fire event tabChanged
		for (IMainGuiListener ctrl : listeners) {
		    ctrl.tabChanged(selectedTab);
		}


	    }
	});

	hidePasswordCheckbox.addItemListener(new ItemListener() {
	    public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
		    hesloUzivatelPF.setEchoChar((char) 0);
		} else {
		    hesloUzivatelPF.setEchoChar('*');
		}
	    }
	});
    }

    private void addInputVerifiers() {
	pscTF.setInputVerifier(new NumberValidator(errorPscJL, "Zadajte PSC jako cislo."));
	cisloPopTF.setInputVerifier(new NumberValidator(errorCisloPopJL, "Zadajte Cislo popisne jako cislo."));
	spolecnostTF.setInputVerifier(new ValueValidator(errorSpolecnostJL, "", "Zadejte nejakou hodnotu."));
	uzivatelskeJmenoJT.setInputVerifier(new UserNameValidator(errorUzivJmenoJL, "Zadejte nejakou hodnotu nebo se jmeno uz vyskytuje"));
	hesloUzivatelPF.setInputVerifier(new PasswordValidator(errorHesloJL, "Heslo musi obsahovat alespon 1 znak"));
    }

    private void addItemsToComboLists() {
	roleJC.removeAllItems();
	roleJC.addItem(UserRole.PRODUCT_MANAGER);
	roleJC.addItem(UserRole.SKLADNIK);
	roleJC.addItem(UserRole.VEDOUCI);

	typDokladuJC.removeAllItems();
	typDokladuJC.addItem(DocumentType.PRIJEMKA);
	typDokladuJC.addItem(DocumentType.VYDEJKA);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelAddress = new TabsJPanel(Tabs.ADDRESS_BOOK);
        jLabel1 = new javax.swing.JLabel();
        spolecnostTF = new javax.swing.JTextField();
        uliceTF = new javax.swing.JTextField();
        mestoTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pscTF = new javax.swing.JTextField();
        cisloPopTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        errorPscJL = new javax.swing.JLabel();
        errorCisloPopJL = new javax.swing.JLabel();
        errorSpolecnostJL = new javax.swing.JLabel();
        panelOrders = new TabsJPanel(Tabs.ORDERS);
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cisloObjednavkaTF = new javax.swing.JTextField();
        tiskObjednavkyJB = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        partnersCB = new javax.swing.JComboBox();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        panelMovements = new TabsJPanel(Tabs.MOVEMENTS);
        panelDocuments =  new TabsJPanel(Tabs.DOCUMENTS);
        cisloDokladTF = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        typDokladuJC = new javax.swing.JComboBox();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        panelWarehouse = new TabsJPanel(Tabs.WAREHOUSE);
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        panelUsers = new TabsJPanel(Tabs.USERS);
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uzivatelskeJmenoJT = new javax.swing.JTextField();
        roleJC = new javax.swing.JComboBox();
        errorUzivJmenoJL = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        hesloUzivatelPF = new javax.swing.JPasswordField();
        errorHesloJL = new javax.swing.JLabel();
        hidePasswordCheckbox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        filtrJP = new javax.swing.JPanel();
        smazJB = new javax.swing.JButton();
        ulozJB = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAddress.setToolTipText("");

        jLabel1.setText("Společnost :");

        jLabel2.setText("Ulice :");

        jLabel3.setText("Město :");

        jLabel4.setText("PSČ :");

        jLabel5.setText("Číso pop. :");

        errorPscJL.setText("error psc");

        errorCisloPopJL.setText("error cisloPop");

        errorSpolecnostJL.setText("error spolecnost");

        org.jdesktop.layout.GroupLayout panelAddressLayout = new org.jdesktop.layout.GroupLayout(panelAddress);
        panelAddress.setLayout(panelAddressLayout);
        panelAddressLayout.setHorizontalGroup(
            panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelAddressLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(panelAddressLayout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(mestoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panelAddressLayout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(uliceTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panelAddressLayout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(spolecnostTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(panelAddressLayout.createSequentialGroup()
                        .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4)
                            .add(jLabel5))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(cisloPopTF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .add(pscTF))))
                .add(38, 38, 38)
                .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(errorPscJL)
                    .add(errorCisloPopJL)
                    .add(errorSpolecnostJL))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        panelAddressLayout.setVerticalGroup(
            panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelAddressLayout.createSequentialGroup()
                .add(13, 13, 13)
                .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(spolecnostTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(errorSpolecnostJL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(uliceTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel3)
                    .add(mestoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(pscTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(errorPscJL))
                .add(12, 12, 12)
                .add(panelAddressLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cisloPopTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(errorCisloPopJL))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adresář", panelAddress);

        jLabel9.setText("Datum :");

        jLabel10.setText("Číslo objednávky :");

        tiskObjednavkyJB.setText("Tisk objednavky");
        tiskObjednavkyJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiskObjednavkyJBActionPerformed(evt);
            }
        });

        jLabel18.setText("Partner :");

        partnersCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout panelOrdersLayout = new org.jdesktop.layout.GroupLayout(panelOrders);
        panelOrders.setLayout(panelOrdersLayout);
        panelOrdersLayout.setHorizontalGroup(
            panelOrdersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelOrdersLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(tiskObjednavkyJB)
                .addContainerGap())
            .add(panelOrdersLayout.createSequentialGroup()
                .add(33, 33, 33)
                .add(panelOrdersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel10)
                    .add(jLabel9)
                    .add(jLabel18))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelOrdersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cisloObjednavkaTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(partnersCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dateChooserCombo1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(311, Short.MAX_VALUE))
        );
        panelOrdersLayout.setVerticalGroup(
            panelOrdersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelOrdersLayout.createSequentialGroup()
                .add(panelOrdersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelOrdersLayout.createSequentialGroup()
                        .add(36, 36, 36)
                        .add(jLabel9)
                        .add(18, 18, 18))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelOrdersLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(dateChooserCombo1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                .add(panelOrdersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(cisloObjednavkaTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelOrdersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel18)
                    .add(partnersCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 90, Short.MAX_VALUE)
                .add(tiskObjednavkyJB)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Objednávky", panelOrders);

        org.jdesktop.layout.GroupLayout panelMovementsLayout = new org.jdesktop.layout.GroupLayout(panelMovements);
        panelMovements.setLayout(panelMovementsLayout);
        panelMovementsLayout.setHorizontalGroup(
            panelMovementsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 621, Short.MAX_VALUE)
        );
        panelMovementsLayout.setVerticalGroup(
            panelMovementsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 256, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pohyby", panelMovements);

        jLabel14.setText("Typ dokladu :");

        jLabel15.setText("Číslo dokladu :");

        jLabel16.setText("Datum :");

        typDokladuJC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout panelDocumentsLayout = new org.jdesktop.layout.GroupLayout(panelDocuments);
        panelDocuments.setLayout(panelDocumentsLayout);
        panelDocumentsLayout.setHorizontalGroup(
            panelDocumentsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelDocumentsLayout.createSequentialGroup()
                .add(18, 18, 18)
                .add(panelDocumentsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel15)
                    .add(jLabel14)
                    .add(jLabel16))
                .add(30, 30, 30)
                .add(panelDocumentsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(typDokladuJC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cisloDokladTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dateChooserCombo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        panelDocumentsLayout.setVerticalGroup(
            panelDocumentsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelDocumentsLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(panelDocumentsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel14)
                    .add(typDokladuJC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelDocumentsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel15)
                    .add(cisloDokladTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelDocumentsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel16)
                    .add(dateChooserCombo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Doklady", panelDocuments);

        jLabel11.setText("Jméno :");

        jLabel12.setText("Kód :");

        jLabel13.setText("Množství :");

        org.jdesktop.layout.GroupLayout panelWarehouseLayout = new org.jdesktop.layout.GroupLayout(panelWarehouse);
        panelWarehouse.setLayout(panelWarehouseLayout);
        panelWarehouseLayout.setHorizontalGroup(
            panelWarehouseLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelWarehouseLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelWarehouseLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel12)
                    .add(jLabel11)
                    .add(jLabel13))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelWarehouseLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jTextField1)
                    .add(jTextField2)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        panelWarehouseLayout.setVerticalGroup(
            panelWarehouseLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelWarehouseLayout.createSequentialGroup()
                .add(15, 15, 15)
                .add(panelWarehouseLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelWarehouseLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelWarehouseLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Skladové zásoby", panelWarehouse);

        jLabel6.setText("Uživatelské jméno :");

        jLabel7.setText("Role :");

        uzivatelskeJmenoJT.setName("uzivatelskeJmeno"); // NOI18N

        roleJC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        errorUzivJmenoJL.setText("error uz jmeno");

        jLabel8.setText("Heslo :");

        hesloUzivatelPF.setText("jPasswordField1");
        hesloUzivatelPF.setEchoChar('*');

        errorHesloJL.setText("error heslo");

        hidePasswordCheckbox.setText("Zobrazit");

        org.jdesktop.layout.GroupLayout panelUsersLayout = new org.jdesktop.layout.GroupLayout(panelUsers);
        panelUsers.setLayout(panelUsersLayout);
        panelUsersLayout.setHorizontalGroup(
            panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelUsersLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jLabel8))
                .add(18, 18, 18)
                .add(panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(roleJC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(panelUsersLayout.createSequentialGroup()
                        .add(panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(uzivatelskeJmenoJT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .add(hesloUzivatelPF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .add(25, 25, 25)
                        .add(panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(panelUsersLayout.createSequentialGroup()
                                .add(hidePasswordCheckbox)
                                .add(18, 18, 18)
                                .add(errorHesloJL))
                            .add(errorUzivJmenoJL))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        panelUsersLayout.setVerticalGroup(
            panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelUsersLayout.createSequentialGroup()
                .add(33, 33, 33)
                .add(panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(uzivatelskeJmenoJT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(errorUzivJmenoJL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(hesloUzivatelPF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8)
                    .add(errorHesloJL)
                    .add(hidePasswordCheckbox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelUsersLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(roleJC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Uživatelé", panelUsers);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.layout.GroupLayout filtrJPLayout = new org.jdesktop.layout.GroupLayout(filtrJP);
        filtrJP.setLayout(filtrJPLayout);
        filtrJPLayout.setHorizontalGroup(
            filtrJPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 630, Short.MAX_VALUE)
        );
        filtrJPLayout.setVerticalGroup(
            filtrJPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 35, Short.MAX_VALUE)
        );

        smazJB.setText("Smaž");
        smazJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smazJBActionPerformed(evt);
            }
        });

        ulozJB.setText("Ulož");
        ulozJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozJBActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(smazJB)
                        .add(18, 18, 18)
                        .add(ulozJB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(filtrJP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(smazJB)
                    .add(ulozJB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(filtrJP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 317, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
	// TODO add your handling code here:
	this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
	JTable table = (JTable) evt.getComponent();

	if (table.getSelectedRowCount() == 1) {
	    int selected = table.getSelectedRow();

	    // Fire event
	    for (IMainGuiListener ctrl : listeners) {
		ctrl.tableSelectedIndex(selected);
	    }

	}

	if (table.getSelectedRowCount() == 2) {
	    int selected = table.getSelectedRow();

	    // Fire event
	    for (IMainGuiListener ctrl : listeners) {
		ctrl.tableDoubleClickOnIndex(selected);
	    }

	}

    }//GEN-LAST:event_jTable1MouseClicked

    private void ulozJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozJBActionPerformed
	if (!ulozJB.getText().equals("Ulož")) {
	    ((UserNameValidator) uzivatelskeJmenoJT.getInputVerifier()).setValue(uzivatelskeJmenoJT.getText());
	} else {
	    ((UserNameValidator) uzivatelskeJmenoJT.getInputVerifier()).setValue("");
	}

	for (IMainGuiListener ctrl : listeners) {
	    if (!ctrl.validate()) {
		JOptionPane.showMessageDialog(panelMovements, "CHYBA se zadanim udaju.");
		return;
	    }
	}

	// Fire event
	for (IMainGuiListener ctrl : listeners) {
	    ctrl.editFormSave();
	}
	uzivatelskeJmenoJT.setEditable(false);
	//ulozJB.setText("Edituj");
    }//GEN-LAST:event_ulozJBActionPerformed

    private void smazJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smazJBActionPerformed
	// 
	for (IMainGuiListener ctrl : listeners) {
	    ctrl.deleteItem();
	}
	nullForms();
    }//GEN-LAST:event_smazJBActionPerformed

    private void tiskObjednavkyJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiskObjednavkyJBActionPerformed
	// TODO add your handling code here:
	printService.printOrder(50L);
    }//GEN-LAST:event_tiskObjednavkyJBActionPerformed
    /**
     * Creates filters fields in JPanel from DataModel
     */
    private void createFilterPanel() {
	int count = this.baseDataModel.getColumnCount();
	filtrJP.setLayout(new FlowLayout());

	filtrJP.removeAll();
	filtrJP.updateUI();
	for (int i = 0; i < count; i++) {
	    filtrJP.add(getPair(new JTextField(), new JLabel(this.baseDataModel.getColumnName(i), JLabel.CENTER)));
	}
	JButton filtr = new JButton("Filtruj");
	filtrJB = filtr;
	filtrJP.add(getPair(filtr, new JLabel("")));
    }

    /**
     * Gets JPanel pair of two JComponent components
     *
     * @param field
     * @param comp
     * @return JPanel pair
     */
    private JPanel getPair(JComponent field, JComponent comp) {
	JPanel pair = new JPanel(new GridLayout(2, 1));
	field.setPreferredSize(new Dimension(120, 20));
	pair.add(comp);
	pair.add(field, 1);
	return pair;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(SkladMainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(SkladMainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(SkladMainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(SkladMainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new SkladMainGUI().setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cisloDokladTF;
    private javax.swing.JTextField cisloObjednavkaTF;
    private javax.swing.JTextField cisloPopTF;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JLabel errorCisloPopJL;
    private javax.swing.JLabel errorHesloJL;
    private javax.swing.JLabel errorPscJL;
    private javax.swing.JLabel errorSpolecnostJL;
    private javax.swing.JLabel errorUzivJmenoJL;
    private javax.swing.JPanel filtrJP;
    private javax.swing.JPasswordField hesloUzivatelPF;
    private javax.swing.JCheckBox hidePasswordCheckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField mestoTF;
    private javax.swing.JPanel panelAddress;
    private javax.swing.JPanel panelDocuments;
    private javax.swing.JPanel panelMovements;
    private javax.swing.JPanel panelOrders;
    private javax.swing.JPanel panelUsers;
    private javax.swing.JPanel panelWarehouse;
    private javax.swing.JComboBox partnersCB;
    private javax.swing.JTextField pscTF;
    private javax.swing.JComboBox roleJC;
    private javax.swing.JButton smazJB;
    private javax.swing.JTextField spolecnostTF;
    private javax.swing.JButton tiskObjednavkyJB;
    private javax.swing.JComboBox typDokladuJC;
    private javax.swing.JTextField uliceTF;
    private javax.swing.JButton ulozJB;
    private javax.swing.JTextField uzivatelskeJmenoJT;
    // End of variables declaration//GEN-END:variables

    public IGuiTextFields getTextFields() {
	return new IGuiTextFields() {
	    public List<JTextField> getAddressBookTextFields() {
		ArrayList<JTextField> list = new ArrayList<JTextField>();
		list.add(spolecnostTF);
		list.add(uliceTF);
		list.add(mestoTF);
		list.add(pscTF);
		list.add(cisloPopTF);
		return list;
	    }

	    public List<JTextField> getUsersTextFields() {
		ArrayList<JTextField> list = new ArrayList<JTextField>();
		list.add(uzivatelskeJmenoJT);
		list.add(hesloUzivatelPF);
		return list;
	    }

	    public List<JTextField> getOrderTextFields() {
		ArrayList<JTextField> list = new ArrayList<JTextField>();
//		list.add(datumObjednavkaTF);
		list.add(cisloObjednavkaTF);
		return list;
	    }
	};
    }

    public void setPartnerList(List<PartnerDTO> list) {
	partnersCB.removeAllItems();
	if (list != null) {
	    for (PartnerDTO partnerDTO : list) {
		partnersCB.addItem(partnerDTO);
	    }
	}
    }

    public void editMovement(MovementDTO movement) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editDocument(DocumentDTO movement) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
}
