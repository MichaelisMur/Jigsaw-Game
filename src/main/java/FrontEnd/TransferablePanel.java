package FrontEnd;

import BackEnd.Figure;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/*
 * TransferablePanel
 * Class describing a drag event logic. Provides dragged figure's data.
 */
class TransferablePanel implements Transferable {
    protected static final DataFlavor newFigurePanelFlavor =
            new DataFlavor(NewFigurePanel.class, "A Figure Object");

    protected static final DataFlavor[] supportedFlavors = {newFigurePanelFlavor};

    private final Figure figure;

    /**
     * Gets figure from the NewFigurePanel object.
     * @param figurePanel NewFigurePanel object to receive.
     */
    public TransferablePanel(NewFigurePanel figurePanel) {
        this.figure = figurePanel.figure;
    }

    /**
     * @return an array of supportedFlavors
     */
    public DataFlavor[] getTransferDataFlavors() {
        return supportedFlavors;
    }

    /**
     * Returns whether the specified data flavor is supported for this object.
     * @param flavor the requested flavor for the data
     */
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(newFigurePanelFlavor);
    }

    /**
     * Receives Figure object from flavor.
     * @param flavor the requested flavor for the data
     * @return Figure object received.
     */
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (flavor.equals(newFigurePanelFlavor)) {
            return figure;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}