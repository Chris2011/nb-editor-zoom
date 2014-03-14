/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.markiewb.netbeans.plugins.editor.zoominout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.EditorCookie;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "View",
        id = "de.markiewb.netbeans.plugins.editor.zoominout.ZoomResetAction"
)
@ActionRegistration(
        iconBase = "de/markiewb/netbeans/plugins/editor/zoominout/zoomReset.png",
        displayName = "#CTL_ZoomResetAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/View", position = 1153),
    @ActionReference(path = "Editors/Toolbars/Default", position = 50030)
})
@Messages("CTL_ZoomResetAction=Zoom reset")
public final class ZoomResetAction implements ActionListener {

    //Line copied from org.netbeans.modules.editor.actions.ZoomTextAction.TEXT_ZOOM_PROPERTY
    private static final String TEXT_ZOOM_PROPERTY = "text-zoom"; // Defined in DocumentView in editor.lib2

    private final EditorCookie context;

    public ZoomResetAction(EditorCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        JEditorPane[] openedPanes = context.getOpenedPanes();
        
        for (JEditorPane pane : openedPanes) {
            pane.putClientProperty(TEXT_ZOOM_PROPERTY, null);
        }
    }
}
