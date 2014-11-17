/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 *
 * @author david
 */
public class DraggableMouseListener extends MouseAdapter implements Serializable {

    @Override
    public void mousePressed(MouseEvent e) {
        JComponent c = (JComponent) e.getSource();
        c.setBorder(BorderFactory.createLineBorder(Color.yellow));

        TransferHandler handler = c.getTransferHandler();

        handler.exportAsDrag(c, e, TransferHandler.MOVE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        JComponent c = (JComponent) e.getSource();
        c.setBorder(BorderFactory.createRaisedBevelBorder());

    }

}
