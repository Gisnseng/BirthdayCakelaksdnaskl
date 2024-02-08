package cs301.birthdaycake;

public class CakeController {
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView view) {
        this.cakeView = view;
        this.cakeModel = cakeView.getCakeModel();
    }
}