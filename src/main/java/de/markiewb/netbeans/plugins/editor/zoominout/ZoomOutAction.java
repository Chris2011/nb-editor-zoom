/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.markiewb.netbeans.plugins.editor.zoominout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.text.EditorKit;
import org.netbeans.api.editor.EditorActionNames;
import org.netbeans.api.editor.EditorUtilities;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.EditorCookie;
import org.openide.text.CloneableEditorSupport;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "View",
        id = "de.markiewb.netbeans.plugins.editor.zoominout.ZoomOutAction"
)
@ActionRegistration(
        iconBase = "de/markiewb/netbeans/plugins/editor/zoominout/zoomOut.png",
        displayName = "#CTL_ZoomOutAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/View", position = 1151, separatorAfter = 1173),
    @ActionReference(path = "Toolbars/Text Zoom", position = 51)
})
@Messages("CTL_ZoomOutAction=Zoom out text")
public final class ZoomOutAction implements ActionListener {

    private final EditorCookie context;

    public ZoomOutAction(EditorCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String mimeType = NbEditorUtilities.getMimeType(context.getDocument());
        EditorKit editorKit = CloneableEditorSupport.getEditorKit(mimeType);
        
        Action action = EditorUtilities.getAction(editorKit, EditorActionNames.zoomTextOut);
        action.actionPerformed(null);
    }
}
