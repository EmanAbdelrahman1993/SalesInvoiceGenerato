package view;

import controller.Controller;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.Invoice;
import model.InvoicesTableModel;
import model.LinesTableModel;

/**
 *
 * @author Ali
 */
public class SalesInvoiceGeneratorFrame extends javax.swing.JFrame {

    public ActionListener Controller;

    /**
     * Creates new form SalesInvoiceGeneratorFrame
     */
    
    public SalesInvoiceGeneratorFrame() {
        initComponents();
    }

//    public SalesInvoiceGeneratorFrame(ArrayList<Invoice> arr) {
//        initComponents();
//        invoices = new ArrayList<>(arr);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(controller);
        invoiceNumber = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        invoiceTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        createNewInvoice = new javax.swing.JButton();
        createNewInvoice.addActionListener(controller);
        deleteInvoice = new javax.swing.JButton();
        deleteInvoice.addActionListener(controller);
        createNewItem = new javax.swing.JButton();
        createNewItem.addActionListener(controller);
        deleteItem = new javax.swing.JButton();
        deleteItem.addActionListener(controller);
        invoiceNumberLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoicetotalLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        loadFileMenuItem.addActionListener(controller);
        saveFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem.addActionListener(controller);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoiceTable);

        invoiceNumber.setText("Invoice Number");

        invoiceDate.setText("Invoice Date");

        customerName.setText("Customer Name");

        invoiceTotal.setText("Invoice Total");

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ));
        jScrollPane2.setViewportView(lineTable);

        createNewInvoice.setText("Create New Invoice");
        createNewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceActionPerformed(evt);
            }
        });

        deleteInvoice.setText("Delete Invoice");

        createNewItem.setText("Create New Item");
        createNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewItemActionPerformed(evt);
            }
        });

        deleteItem.setText("Delete Item");

        invoiceNumberLabel.setText(".");

        invoiceDateLabel.setText(".");

        customerNameLabel.setText(".");

        invoicetotalLabel.setText(".");

        file.setText("File");

        loadFileMenuItem.setText("Load File");
        loadFileMenuItem.setToolTipText("");
        file.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save File");
        file.add(saveFileMenuItem);

        jMenuBar1.add(file);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceDate)
                        .addGap(18, 18, 18)
                        .addComponent(invoiceDateLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerName)
                        .addGap(18, 18, 18)
                        .addComponent(customerNameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceTotal)
                        .addGap(18, 18, 18)
                        .addComponent(invoicetotalLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceNumber)
                        .addGap(18, 18, 18)
                        .addComponent(invoiceNumberLabel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(createNewInvoice)
                .addGap(59, 59, 59)
                .addComponent(deleteInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createNewItem)
                .addGap(107, 107, 107)
                .addComponent(deleteItem)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceNumber)
                            .addComponent(invoiceNumberLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceDate)
                            .addComponent(invoiceDateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerName)
                            .addComponent(customerNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceTotal)
                            .addComponent(invoicetotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteItem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteInvoice)
                        .addComponent(createNewInvoice))
                    .addComponent(createNewItem))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        createNewItem.getAccessibleContext().setAccessibleName("Create New Item");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewInvoiceActionPerformed

    private void createNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewItemActionPerformed

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
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesInvoiceGeneratorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewInvoice;
    private javax.swing.JButton createNewItem;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton deleteInvoice;
    private javax.swing.JButton deleteItem;
    private javax.swing.JMenu file;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceNumber;
    private javax.swing.JLabel invoiceNumberLabel;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel invoiceTotal;
    private javax.swing.JLabel invoicetotalLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lineTable;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JMenuItem saveFileMenuItem;
    // End of variables declaration//GEN-END:variables
private ArrayList<Invoice> invoices;
    
    
    private Controller controller = new Controller(this);
   
    private InvoicesTableModel invoicesTableModel;
    private LinesTableModel lineTableModel; 
    
    
    public ArrayList<Invoice> getInvoices() {
        if (invoices == null) invoices = new ArrayList<>();
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public InvoicesTableModel getInvoicesTableModel() {
        if (invoicesTableModel == null) {
            invoicesTableModel = new InvoicesTableModel(getInvoices());
        }
        return invoicesTableModel;
    }

    public void setInvoicesTableModel(InvoicesTableModel invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public JLabel getCustomerNameLabel() {
        return customerNameLabel;
    }

    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }

    public JLabel getInvoiceNumLabel() {
        return invoiceNumberLabel;
    }

    public JTable getInvoiceTable() {
        return invoiceTable;
    }

    public JLabel getInvoiceTotalLabel() {
        return invoicetotalLabel;
    }

    public JTable getLineTable() {
        return lineTable;
    }

    public Controller getController() {
        return controller;
    }
    
    public int getNewInvoiceNumber() {
        int number = 0;
        
        for (Invoice invoice : getInvoices()) {
            if (invoice.getNumber() > number) 
                number = invoice.getNumber();
        }
        
        return ++number;
    }
    
    
    
}