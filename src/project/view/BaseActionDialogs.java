package project.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class BaseActionDialogs extends PlainDocument {

    private int limit;
    public Border compound, oldFieldBorder, oldAreaBorder;
    public JTextArea textAreaDescription;

    BaseActionDialogs(){}

    BaseActionDialogs(int limit) {
        super();
        this.limit = limit;
    }

    BaseActionDialogs(int limit, boolean upper) {
      super();
      this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
          return;

        if ((getLength() + str.length()) <= limit) {
          super.insertString(offset, str, attr);
        }
    }

    public void error(JTextComponent textField) {
        textField.setBackground(new Color(255, 180, 180));
        textField.setBorder(compound);
        textField.setText("At least 4 characters");
    }

    public void errorDescription(int symbolsCount) {
        textAreaDescription.setBackground(new Color(255, 180, 180));
        textAreaDescription.setBorder(compound);
        textAreaDescription.setText(String.format("The description must consist out of %d characters at least", symbolsCount));
    }

    void customSpinner(JSpinner spinner){
        Font boldFont = new Font("Calibri", Font.BOLD, 13);
        spinner.setEditor(new JSpinner.NumberEditor(spinner,"#"));
        JComponent boxSpinner = spinner.getEditor();
        JFormattedTextField textFieldSpinner = ((JSpinner.DefaultEditor)boxSpinner).getTextField();
        textFieldSpinner.setColumns(3);
        textFieldSpinner.setFont(boldFont);
        textFieldSpinner.setHorizontalAlignment(JTextField.CENTER);
    }
}