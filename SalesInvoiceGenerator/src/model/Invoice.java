package model;

import java.util.ArrayList;

/**
 *
 * @author Ali
 */
    public class Invoice {
    private int number;
    private String date;
    private String customerName;
    private ArrayList<Lines> lines;
    
    
    public Invoice() {}
    
    

    public Invoice(int number, String date, String customerName) {
        this.number = number;
        this.date = date;
        this.customerName = customerName;
    }

    
    
    public double getInvoiceTotal() {
        double total = 0.0;
        
        for(Lines line : getLines())
        {
            total += line.getLineTotal();
        }
        return total;
    }
    
    public ArrayList<Lines> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "num=" + number + ", date=" + date + ", customer=" + customerName + '}';
    }
    
    public String getAsCSV() {
        return number + "," + date + "," + customerName;
    }
    
}
