package Pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Control {
    @FXML
    public ComboBox<String> PizzaT;
    @FXML
    public RadioButton NYKnow;
    @FXML
    public RadioButton CHKnow;
    @FXML
    public ComboBox<String> SizeIn;
    @FXML
    public TextArea subTotalLabel;
    @FXML
    public Button setupID;
    @FXML
    public TextArea outputPage1; //just incase there have error output, for testing use.
    //page2:
    @FXML
    public Button ShowList;
    @FXML
    public ListView<Pizza> DeleteOrderList;
    @FXML
    public Button DeleteCurrent;
    @FXML
    public Button DeleteAll;
    @FXML
    public TextArea subTotalLabelDelete;
    private OrderList orderList = new OrderList();
    private Order CurrentOrder=new Order();
    public void initialize() {
        //initialize the P1
        ToggleGroup toggleGroup = new ToggleGroup();
        NYKnow.setToggleGroup(toggleGroup);
        CHKnow.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == NYKnow) {
               CHKnow.setSelected(false);
            }
            else if(newValue == CHKnow) { NYKnow.setSelected(false);}
        });
    }
    public void CreateKnow(ActionEvent actionEvent) {
        String type=PizzaT.getSelectionModel().getSelectedItem();
        String size=SizeIn.getSelectionModel().getSelectedItem();
        Size CurrentSize;
        Pizza CurrentPizza;
        switch (size){
            case "Small":
                CurrentSize=Size.Small;
                break;
            case "Medium":
                CurrentSize=Size.Medium;
                break;
            case "Large":
                CurrentSize=Size.Large;
                break;
            default:
                throw new IllegalArgumentException("Ivalid Size" + size);
        }
        if(NYKnow.isSelected()) {
            NYPizza NY=new NYPizza();
            if(type.equals("Deluxe")) {CurrentPizza=NY.createDeluxe(CurrentSize);subTotalLabel.setText(STR."\{CurrentSize.getDeluxe()}");}
            else if (type.equals("BBQChicken")) {CurrentPizza=NY.createBBQChicken(CurrentSize);subTotalLabel.setText(STR."\{CurrentSize.getChicken()}");}
            else if(type.equals("Meatzza")) {CurrentPizza=NY.createMeatzza(CurrentSize);subTotalLabel.setText(STR."\{CurrentSize.getMeatzza()}");}
            else{throw new IllegalArgumentException("Ivalid Pizza Type" + type);}
        }
        else if(CHKnow.isSelected()) {
            CHPizza CH=new CHPizza();
            if(type.equals("Deluxe")) {CurrentPizza=CH.createDeluxe(CurrentSize);subTotalLabel.setText(STR."\{CurrentSize.getDeluxe()}");}
            else if (type.equals("BBQChicken")) {CurrentPizza=CH.createBBQChicken(CurrentSize);subTotalLabel.setText(STR."\{CurrentSize.getChicken()}");}
            else if(type.equals("Meatzza")) {CurrentPizza=CH.createMeatzza(CurrentSize);subTotalLabel.setText(STR."\{CurrentSize.getMeatzza()}");}
            else{throw new IllegalArgumentException("Ivalid Pizza Type" + type);}
        }
        else{
            throw new IllegalArgumentException("Ivalid Curst");
        }
        CurrentOrder=new Order();
        CurrentOrder.add(CurrentPizza);
        String output1=CurrentOrder.toString();
        outputPage1.appendText(STR."\{output1}"); //for test use
    }

    /*
        show the current list of pizza in current order.
     */
    public void showDelete(ActionEvent actionEvent) {
        ObservableList<Pizza> OPizzas = FXCollections.observableArrayList();
        for(int i=0;i<CurrentOrder.getPizzas().size();i++) {
            OPizzas.add(CurrentOrder.getPizza(i));
        }
        DeleteOrderList.setItems(OPizzas);
    }
    public void NYPizza(ActionEvent actionEvent) {
    }

    public void CHPizza(ActionEvent actionEvent) {
    }

    public void HandleDIY(ActionEvent actionEvent) {
        
    }

}

