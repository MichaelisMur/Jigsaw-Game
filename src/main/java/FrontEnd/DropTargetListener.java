package FrontEnd;

import BackEnd.Field;
import BackEnd.Figure;

import javax.swing.*;
import java.awt.dnd.*;

/*
 * DropTargetListener
 * Class describing a drop event logic.
 */
class DropTargetListener extends DropTargetAdapter {

    public DropTargetListener(JPanel panel) {
        new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
    }

    /**
     * @param event event of dropping after dragging an object.
     */
    public void drop(DropTargetDropEvent event) {
        try {
            var tr = event.getTransferable();
            var figure = (Figure) tr.getTransferData(TransferablePanel.newFigurePanelFlavor);
            if (event.isDataFlavorSupported(TransferablePanel.newFigurePanelFlavor)) {
                event.acceptDrop(DnDConstants.ACTION_COPY);
                event.dropComplete(true);

                // Coordinates to place generated figure.
                var location = event.getLocation();
                if (Field.checkFigure(location.x / 50, location.y / 50, figure)) {
                    Field.addFigure(location.x / 50, location.y / 50, figure);
                    GameMenu.fieldPanel.shadow = null;
                    GameMenu.fieldPanel.repaint();
                    GameMenu.newFigurePanel.updateFigure();
                    GameMenu.newFigurePanel.repaint();
                    ++GameMenu.turns;
                }
                return;
            }
            event.rejectDrop();
        } catch (Exception e) {
            e.printStackTrace();
            event.rejectDrop();
        }
    }

    /**
     * @param dragOverEvent event of ongoing dragging over the fieldPanel.
     */
    public void dragOver(DropTargetDragEvent dragOverEvent) {
        GameMenu.location = dragOverEvent.getLocation();

        // Check if figure can be added to the coordinates.
        if (Field.checkFigure(
                dragOverEvent.getLocation().x / 50,
                dragOverEvent.getLocation().y / 50,
                GameMenu.newFigurePanel.figure))
        {
            GameMenu.fieldPanel.shadow = GameMenu.newFigurePanel.figure;
        } else {
            GameMenu.fieldPanel.shadow = null;
        }
        GameMenu.fieldPanel.repaint();
    }

    /**
     * @param dte event of a dragging cursor leaving from the fieldPanel.
     */
    public void dragExit(DropTargetEvent dte) {
        GameMenu.fieldPanel.shadow = null;
        GameMenu.fieldPanel.repaint();
    }
}