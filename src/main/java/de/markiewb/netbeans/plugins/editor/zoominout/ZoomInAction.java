/* 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2014 Sun Microsystems, Inc.
 * Portions Copyrighted 2014 markiewb
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
        id = "de.markiewb.netbeans.plugins.editor.zoominout.ZoomInAction"
)
@ActionRegistration(
        iconBase = "de/markiewb/netbeans/plugins/editor/zoominout/zoomIn.png",
        displayName = "#CTL_ZoomInAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/View", position = 1150),
    @ActionReference(path = "Editors/Toolbars/Default", position = 50010, separatorBefore = 50009)
})
@Messages("CTL_ZoomInAction=Zoom in text")
public final class ZoomInAction implements ActionListener {

    private final EditorCookie context;

    public ZoomInAction(EditorCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String mimeType = NbEditorUtilities.getMimeType(context.getDocument());
        EditorKit editorKit = CloneableEditorSupport.getEditorKit(mimeType);
        
        Action action = EditorUtilities.getAction(editorKit, EditorActionNames.zoomTextIn);
        action.actionPerformed(null);
    }
}
