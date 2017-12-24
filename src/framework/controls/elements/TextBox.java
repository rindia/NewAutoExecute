package framework.controls.elements;

import framework.controls.api.ImplementedBy;
import framework.controls.internals.Control;



@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void EnterText(String text);
    String GetTextValue();

}
