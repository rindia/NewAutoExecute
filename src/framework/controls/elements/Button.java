package framework.controls.elements;

import framework.controls.api.ImplementedBy;
import framework.controls.internals.Control;



@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

    void PerformClick();
    String GetButtonText();
    void PerformSubmit();
}
