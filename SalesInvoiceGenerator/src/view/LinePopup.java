package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


        public class LinePopup extends JDialog{
        private JTextField NameField;
        private JTextField CountField;
        private JTextField PriceField;
        private JLabel NameLabel;
        private JLabel CountLabel;
        private JLabel PriceLabel;
        private JButton okButton;
        private JButton cancelButton;


        public LinePopup(SalesInvoiceGeneratorFrame frame) {
            NameField = new JTextField(20);
            NameLabel = new JLabel("Item Name");

            CountField = new JTextField(20);
            CountLabel = new JLabel("Item Count");

            PriceField = new JTextField(20);
            PriceLabel = new JLabel("Item Price");

            okButton = new JButton("OK");
            cancelButton = new JButton("Cancel");

            okButton.setActionCommand("createLineOK");
            cancelButton.setActionCommand("createLineCancel");

            okButton.addActionListener(frame.getController());
            cancelButton.addActionListener(frame.getController());
            setLayout(new GridLayout(4, 2));

            add(NameLabel);
            add(NameField);
            add(CountLabel);
            add(CountField);
            add(PriceLabel);
            add(PriceField);
            add(okButton);
            add(cancelButton);

            pack();
            
            
            
        }

        public JTextField getNameField() {
            return NameField;
        }

        
        public JTextField getCountField() {
            return CountField;
        }

        
        public JTextField getPriceField() {
            return PriceField;
        }

        public JLabel getNameLabel() {
            return NameLabel;
        }

        public JLabel getCountLabel() {
            return CountLabel;
        }

        public JButton getOkButton() {
            return okButton;
        }

        public JButton getCancelButton() {
            return cancelButton;
        }
        
        
    }
