/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.PlayBuffer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.border.LineBorder;
import vista.board.LetterContainer;
import vista.hand.GraficHand;
import vista.letras.GraficLetter;
import vista.window.ClientWindow;

/**
 *
 * @author david
 */
public class LetterContainerTargetListener implements DropTargetListener, Serializable {

    private PlayBuffer playBuffer;

    private final LetterContainer letterContainer;
    private GraficHand graficHand;

    public LetterContainerTargetListener(LetterContainer lc) {
        this.letterContainer = lc;
    }

    public void setPlayBuffer(PlayBuffer pb) {
        this.playBuffer = pb;
        this.graficHand = playBuffer.getGraficHand();
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        letterContainer.setBorder(new LineBorder(Color.YELLOW) {
            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                return new Insets(-5, 10, 10, 10);
            }
        });
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        letterContainer.setBorder(new LineBorder(new Color(102, 153, 153)) {
            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                return new Insets(-5, 10, 10, 10);
            }
        });
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        Object transferableObject = null;

        DataFlavor dataFlavor = ClientWindow.getDataFlavor();

        Transferable transferable = dtde.getTransferable();

        DropTargetContext c = dtde.getDropTargetContext();

        if (transferable.isDataFlavorSupported(dataFlavor)) {

            try {
                transferableObject = dtde.getTransferable().getTransferData(dataFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                Consola.consola("Problema al recibir");
            }
        }

        if (transferableObject == null) {
            return;
        }

        GraficLetter letraObtenida = (GraficLetter) transferableObject;
        letraObtenida.decreaseLetterSize();
        letraObtenida.removeDraggableMouseListener();

        letterContainer.setGraficLetter(letraObtenida);
        letterContainer.addLabel();

        playBuffer.addLetter(letraObtenida);

        //Bordes a la normaidad
        letterContainer.setBorder(new LineBorder(new Color(102, 153, 153)) {
            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                return new Insets(-5, 10, 10, 10);
            }
        });

    }

}
