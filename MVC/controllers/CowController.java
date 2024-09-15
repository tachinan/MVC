package controllers;

import models.Cow;
import models.CowModel;
import models.GoatModel;
import views.CowView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class CowController {
    private CowModel cowModel;
    private GoatModel goatModel;
    private CowView cowView;

    public CowController(CowModel cowModel, GoatModel goatModel, CowView cowView) {
        this.cowModel = cowModel;
        this.goatModel = goatModel;
        this.cowView = cowView;
        this.cowView.addMilkButtonListener(new MilkButtonListener());
        this.cowView.addRemoveGoatButtonListener(new RemoveGoatButtonListener());
    }

    private class MilkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = cowView.getIdInput();
            if (!id.matches("[1-9][0-9]{7}")) {
                cowView.setMessage("Invalid ID format");
                return;
            }

            Optional<Cow> cowOptional = cowModel.getCowById(id);
            if (cowOptional.isEmpty()) {
                cowView.setMessage("ID not found");
                return;
            }

            Cow cow = cowOptional.get();
            if (cowModel.isCompleteCow(cow)) {
                String message = "";
                if (cow.getTeats() == 4) {
                    message = "Cow can be milked.";
                    if (Math.random() < 0.05) {
                        cow.setTeats(3);
                        message += " However, it lost one teat.";
                    }
                } else if (cow.getTeats() == 3) {
                    if (Math.random() < 0.20) {
                        cow.setTeats(4);
                        message = "Cow is now complete with 4 teats.";
                    } else {
                        message = "Cow cannot be milked.";
                    }
                }

                int milkQuantity = cow.getAgeYears() + cow.getAgeMonths();
                cowView.setMessage(message);
                cowView.setMilkQuantity(milkQuantity);
            } else {
                cowView.setMessage("This ID belongs to a goat.");
            }
        }
    }

    private class RemoveGoatButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = cowView.getIdInput();
            if (goatModel.isGoat(id, cowModel)) {
                cowModel.removeGoatById(id);
                cowView.setMessage("Goat removed from milking machine.");
            } else {
                cowView.setMessage("Invalid ID or not a goat.");
            }
        }
    }
}
