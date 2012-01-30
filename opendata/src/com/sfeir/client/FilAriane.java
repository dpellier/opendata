package com.sfeir.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;

public class FilAriane extends HorizontalPanel {

    private static final String STYLE_FILARIANE = "FilArianne";

    /**
     * Construit un fil d'ariane.
     * <p>
     * Par défaut la racine sera "Gestion des services". Son clic renvoi vers la
     * page d'accueil (vers l'url "Acceuil")
     * </p>
     */
    public FilAriane() {
        super();
        this.init(new Hyperlink("Gestion des Services", "Accueil"));
    }

    /**
     * Construit un fil d'ariane avec la racine du fil d'arianne différent de
     * celle par défaut
     * 
     * @param elemFilArianne
     *            la racine du fil d'ariane
     */
    public FilAriane(final Hyperlink racine) {
        super();
        this.init(racine);
    }

    private void init(final Hyperlink elemFilArianne) {
        this.clear();
        this.addStyleName(FilAriane.STYLE_FILARIANE);
        elemFilArianne.setStyleName("elemFilAriane");
        super.add(elemFilArianne);
    }

    /**
     * Ajoute un Element au fil d'ariane
     * 
     * @param elem
     *            un element de fil d'ariane
     */
    public void add(final Hyperlink elem) {
        Label separator = new Label(" > ");
        separator.setStyleName("elemFilAriane");
        elem.setStyleName("elemFilAriane");
        super.add(separator);
        super.add(elem);
    }

    /**
     * Supprime le dernier element du fil d'ariane
     */
    public void removeLastElement() {
        if (this.getWidgetCount() > 2) {
            // Suprime l'hyperlink et le label " > "
            super.remove(this.getWidgetCount() - 1);
            super.remove(this.getWidgetCount() - 1);
        }
    }

    /**
     * obtient le text du dernier element du fil d'ariane
     * 
     * @return le text du dernier element du fil d'ariane
     */
    public String getLastElementText() {
        return ((Hyperlink) this.getWidget(this.getWidgetCount() - 1))
                .getText();
    }
}