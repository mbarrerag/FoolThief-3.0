/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * Está clase esta encargada de escuchar los eventos del raton sobre los botones
 * del menú principal.
 */
public class EventController implements MouseListener {

    private final MainWindow view;

    public EventController(MainWindow view) {
        this.view = view;
        events();
    }

    public final void events() {
        view.btnHome.addMouseListener(this);
        view.btnReports.addMouseListener(this);
        view.btnVehicles.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // No actions required
    }

    /**
     * Dota al botón (JPanel) de un nuevo color al ser clickeado.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Object evt = e.getSource();

        if (evt.equals(view.btnHome)) {
            changeBackground(view.pnlBtnHome, new Color(44, 62, 80));
        } else if (evt.equals(view.btnReports)) {
            changeBackground(view.pnlBtnReports, new Color(44, 62, 80));
        } else if (evt.equals(view.btnVehicles)) {
            changeBackground(view.pnlBtnVehicles, new Color(44, 62, 80));
        }
    }

    /**
     * Cambia el color de los botones (JPanel) cuando se suelta un botón luego
     * de dar click.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        Object evt = e.getSource();

        if (evt.equals(view.btnHome)) {
            changeBackground(view.pnlBtnHome, new Color(44, 62, 80));
        } else if (evt.equals(view.btnReports)) {
            changeBackground(view.pnlBtnReports, new Color(44, 62, 80));
        } else if (evt.equals(view.btnVehicles)) {
            changeBackground(view.pnlBtnVehicles, new Color(44, 62, 80));
        }
    }

    /**
     * Cambia el color de botón (JPanel) al entrar del área del botón.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        Object evt = e.getSource();

        if (evt.equals(view.btnHome)) {
            changeBackground(view.pnlBtnHome, new Color(39, 66, 89));
        } else if (evt.equals(view.btnReports)) {
            changeBackground(view.pnlBtnReports, new Color(39, 66, 89));
        } else if (evt.equals(view.btnVehicles)) {
            changeBackground(view.pnlBtnVehicles, new Color(39, 66, 89));
        }
    }

    /**
     * Cambia el color de botón (JPanel) al salir del área del botón.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        Object evt = e.getSource();

        if (evt.equals(view.btnHome)) {
            changeBackground(view.pnlBtnHome, new Color(51, 51, 51));
        } else if (evt.equals(view.btnReports)) {
            changeBackground(view.pnlBtnReports, new Color(51, 51, 51));
        } else if (evt.equals(view.btnVehicles)) {
            changeBackground(view.pnlBtnVehicles, new Color(51, 51, 51));
        }
    }

    /**
     * Cambia el color del panel dado la referencia al panel y el color.
     *
     * @param panel
     * @param color
     */
    private void changeBackground(JPanel panel, Color color) {
        panel.setBackground(color);
    }
}
