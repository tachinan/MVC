import controllers.CowController;
import models.CowModel;
import models.GoatModel;
import views.CowView;

public class Main {
    public static void main(String[] args) {
        CowModel cowModel = new CowModel();
        GoatModel goatModel = new GoatModel();
        CowView cowView = new CowView();
        new CowController(cowModel, goatModel, cowView);
        cowView.setVisible(true);
    }
}

