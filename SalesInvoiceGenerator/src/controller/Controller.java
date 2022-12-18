package controller;

import model.Invoice;
import model.InvoicesTableModel;
import model.Lines;
import model.LinesTableModel;
import view.InvoicePopup;
import view.SalesInvoiceGeneratorFrame;
import view.LinePopup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener {

    private SalesInvoiceGeneratorFrame frame;
    private InvoicePopup invoicePopup;
    private LinePopup linePopup;

    public Controller(SalesInvoiceGeneratorFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand(); //to get action name when I click on button
        System.out.println("Action: " + actionCommand);
        
        switch (actionCommand) {                     //diffrentiation between actionCommand
            case "Load File":
                loadFile();
                break;
            case "Save File":
                saveFile();
                break;
            case "Create New Invoice":
                createNewInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Create New Item":
                createNewItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "createInvoiceCancel":
                createInvoiceCancel();
                break;
            case "createInvoiceOK":
                createInvoiceOK();
                break;
            case "createLineOK":
                createLineOK();
                break;
            case "createLineCancel":
                createLineCancel();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = frame.getInvoiceTable().getSelectedRow();
        if (selectedIndex != -1) {
            System.out.println("You have selected row: " + selectedIndex);
            Invoice currentInvoice = frame.getInvoices().get(selectedIndex);
            frame.getInvoiceNumLabel().setText("" + currentInvoice.getNumber());
            frame.getInvoiceDateLabel().setText(currentInvoice.getDate());
            frame.getCustomerNameLabel().setText(currentInvoice.getCustomerName());
            frame.getInvoiceTotalLabel().setText("" + currentInvoice.getInvoiceTotal());
            LinesTableModel linesTableModel = new LinesTableModel(currentInvoice.getLines());
            frame.getLineTable().setModel(linesTableModel);
            linesTableModel.fireTableDataChanged();
        }
    }

    
    private void loadFile() {
        JFileChooser fc = new JFileChooser();
        try {
            int Clicked = fc.showOpenDialog(frame);
            if (Clicked == JFileChooser.APPROVE_OPTION) {
                File loadFile = fc.getSelectedFile();
                Path headerPath = Paths.get(loadFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                ArrayList<Invoice> invoicesArray = new ArrayList<>();
                
                for (String headerL : headerLines) {
                    try {
                        String[] headerColumns = headerL.split(",");
                        int number = Integer.parseInt(headerColumns[0]);
                        String date = headerColumns[1];
                        String name = headerColumns[2];

                        Invoice invoice = new Invoice(number, date, name);
                        invoicesArray.add(invoice);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Invoice format error.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                Clicked = fc.showOpenDialog(frame);
                if (Clicked == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(linePath);
                    
                    for (String lineLine : lineLines) {
                        try {
                            String[] lineP = lineLine.split(",");
                            int invoiceNumber = Integer.parseInt(lineP[0]);
                            String itemName = lineP[1];
                            double itemPrice = Double.parseDouble(lineP[2]);
                            int count = Integer.parseInt(lineP[3]);
                            Invoice inv = null;
                            for (Invoice invoice : invoicesArray) {
                                if (invoice.getNumber() == invoiceNumber) {
                                    inv = invoice;
                                    break;
                                }
                            }

                            Lines line = new Lines(itemName, itemPrice, count, inv);
                            inv.getLines().add(line);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(frame, "Error in line format", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                }
                frame.setInvoices(invoicesArray);
                InvoicesTableModel invoicesTableModel = new InvoicesTableModel(invoicesArray);
                frame.setInvoicesTableModel(invoicesTableModel);
                frame.getInvoiceTable().setModel(invoicesTableModel);
                frame.getInvoicesTableModel().fireTableDataChanged();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "File not applicable to be read", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    private void saveFile() {
        ArrayList<Invoice> invoices = frame.getInvoices();
        
        String headers = "";
        String lines = "";
        
        for (Invoice invoice : invoices) {
            String invoiceCSV = invoice.getAsCSV();
            headers += invoiceCSV;
            headers += "\n";

            for (Lines line : invoice.getLines()) {
                String lineCSV = line.getAsCSV();
                lines += lineCSV;
                lines += "\n";
            }
        }
        
        try {
            JFileChooser s = new JFileChooser();
            int result = s.showSaveDialog(frame);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = s.getSelectedFile();
                FileWriter H = new FileWriter(headerFile);
                H.write(headers);
                H.flush();
                H.close();
                result = s.showSaveDialog(frame);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = s.getSelectedFile();
                    FileWriter L = new FileWriter(lineFile);
                    L.write(lines);
                    L.flush();
                    L.close();
                }
            }
            
        } catch (Exception ex) {

        }
    }

    
    private void createNewInvoice() {
        invoicePopup = new InvoicePopup(frame);
        invoicePopup.setVisible(true);
    }

    
    
    private void deleteInvoice() {
        int selectedRow = frame.getInvoiceTable().getSelectedRow();
        if (selectedRow != -1) {
            frame.getInvoices().remove(selectedRow);
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    
    
    private void createNewItem() {
        linePopup = new LinePopup(frame);
        linePopup.setVisible(true);
    }

    
    
    
    private void deleteItem() {
        int selectedRow = frame.getLineTable().getSelectedRow();

        if (selectedRow != -1) {
            LinesTableModel linesTableModel = (LinesTableModel) frame.getLineTable().getModel();
            linesTableModel.getLines().remove(selectedRow);
            linesTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    
    
    private void createInvoiceCancel() {
        invoicePopup.setVisible(false);
        invoicePopup.dispose();
        invoicePopup = null;
    }

    
    
    
    
    private void createInvoiceOK() {
        String date = invoicePopup.getInvoiceDateField().getText();
        String customer = invoicePopup.getCustomerNameField().getText();
        int num = frame.getNewInvoiceNumber();
        try {
            String[] datePieces = date.split("-");
            
            if (datePieces.length < 3) {
                JOptionPane.showMessageDialog(frame, "Wrong format", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                
                int day = Integer.parseInt(datePieces[0]);
                int month = Integer.parseInt(datePieces[1]);
                int year = Integer.parseInt(datePieces[2]);
                
                if (day > 31 || month > 12) {
                    JOptionPane.showMessageDialog(frame, "Wrong format", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Invoice invoice = new Invoice(num, date, customer);
                    frame.getInvoices().add(invoice);
                    frame.getInvoicesTableModel().fireTableDataChanged();
                    invoicePopup.setVisible(false);
                    invoicePopup.dispose();
                    invoicePopup = null;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Wrong format", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    
    
       
    private void createLineOK() {
        String item = linePopup.getNameField().getText();
        String countStr = linePopup.getCountField().getText();
        String priceStr = linePopup.getPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getInvoiceTable().getSelectedRow();
        if (selectedInvoice != -1) {
            Invoice invoice = frame.getInvoices().get(selectedInvoice);
            Lines line = new Lines(item, price, count, invoice);
            invoice.getLines().add(line);
            LinesTableModel linesTableModel = (LinesTableModel) frame.getLineTable().getModel();
            linesTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
        linePopup.setVisible(false);
        linePopup.dispose();
        linePopup = null;
    }

    
    
        
    private void createLineCancel() {
        linePopup.setVisible(false);
        linePopup.dispose();
        linePopup = null;
    }

}
