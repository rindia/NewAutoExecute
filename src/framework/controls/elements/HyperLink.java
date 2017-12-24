package framework.controls.elements;

import framework.controls.api.ImplementedBy;
import framework.controls.internals.Control;



@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control{


    void ClickLink();
    String GetUrlText();
    boolean CheckUrlTextContains(String containsText);
}
