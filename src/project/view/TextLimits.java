package project.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class TextLimit extends PlainDocument {
  private int limit;
  TextLimit(int limit) {
    super();
    this.limit = limit;
  }

  TextLimit(int limit, boolean upper) {
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
}