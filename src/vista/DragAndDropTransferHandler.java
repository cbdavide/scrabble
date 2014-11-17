/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceMotionListener;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import vista.letras.GraficLetter;

/**
 *
 * @author david
 */
public class DragAndDropTransferHandler extends TransferHandler implements DragSourceMotionListener {

    public DragAndDropTransferHandler() {
        super();
    }

    @Override
    public Transferable createTransferable(JComponent c) {

        if (c instanceof GraficLetter) {
            Transferable tip = (GraficLetter) c;
            return tip;
        }
        return null;
    }

    @Override
    public int getSourceActions(JComponent c) {

        if (c instanceof GraficLetter) {
            return TransferHandler.COPY;
        }

        return TransferHandler.NONE;
    }

    @Override
    public void dragMouseMoved(DragSourceDragEvent dsde) {

    }

}
