package aut.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * TODO: Description of MyChangeListener.
 *
 * @author ragone.
 * @version 12/12/15
 */
class MyChangeListener implements ChangeListener, EventHandler {

    private final Button saveBtn;

    public MyChangeListener(Button saveBtn) {
        this.saveBtn = saveBtn;
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        saveBtn.setDisable(false);
    }

    @Override
    public void handle(Event event) {
        saveBtn.setDisable(false);
    }

}
