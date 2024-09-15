package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CowView extends JFrame {
    private JTextField idInputField;
    private JTextArea messageArea;
    private JButton milkButton;
    private JButton removeGoatButton;
    private JLabel milkQuantityLabel;

    public CowView() {
        this.setTitle("Cow and Goat Milking System");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Enter ID:"));
        idInputField = new JTextField();
        panel.add(idInputField);

        milkButton = new JButton("Milk Cow");
        panel.add(milkButton);

        removeGoatButton = new JButton("Remove Goat");
        panel.add(removeGoatButton);

        panel.add(new JLabel("Milk Quantity:"));
        milkQuantityLabel = new JLabel("0");
        panel.add(milkQuantityLabel);

        messageArea = new JTextArea();
        messageArea.setEditable(false);

        this.add(panel, BorderLayout.CENTER);
        this.add(new JScrollPane(messageArea), BorderLayout.SOUTH);
    }

    public String getIdInput() {
        return idInputField.getText();
    }

    public void setMessage(String message) {
        messageArea.setText(message);
    }

    public void setMilkQuantity(int quantity) {
        milkQuantityLabel.setText(quantity + " liters");
    }

    public void addMilkButtonListener(ActionListener listener) {
        milkButton.addActionListener(listener);
    }

    public void addRemoveGoatButtonListener(ActionListener listener) {
        removeGoatButton.addActionListener(listener);
    }
}
