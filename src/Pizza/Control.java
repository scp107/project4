package Pizza;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Control {
    public RadioButton CHDIY ;
    public RadioButton NYDIY ;
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
    @FXML
    public ListView<Topping> ToppingList;
    @FXML
    public TextArea OutPuts3;
    @FXML
    public Button startDIY;
    @FXML
    public ComboBox<String> SizeDIY;
    //page 4 elements
    @FXML
    public TableView<PizzaAndPrice> Output4Detail;
    @FXML
    public TextArea Output4Price;
    @FXML
    public Button checkOrder;
    @FXML
    public TextArea Output4;
    @FXML
    private TableColumn<PizzaAndPrice, Size> sizeColumn;
    @FXML
    private TableColumn<PizzaAndPrice, ArrayList<Topping>> toppingColumn;
    @FXML
    private TableColumn<PizzaAndPrice, Curst> curseColumn;
    @FXML
    private TableColumn<PizzaAndPrice, Double> priceColumn;
    /*
        the value that using inside the program.
     */
    private OrderList orderList = new OrderList();
    private Order CurrentOrder=new Order();
    private double price=0.0;
    private ArrayList<Double> priceList=new ArrayList<>();

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
        //initialize the P2:
        subTotalLabelDelete.setText(price+"");
        //initialize the P3:
        ObservableList<Topping> TempTopping = FXCollections.observableArrayList(Topping.values());
        ToppingList.setItems(TempTopping);
        ToppingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ToggleGroup toggleGroupP4 = new ToggleGroup();
        NYDIY.setToggleGroup(toggleGroupP4);
        CHDIY.setToggleGroup(toggleGroupP4);
        toggleGroupP4.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == NYDIY) {
                CHDIY.setSelected(false);
            }
            else if(newValue == CHDIY) {NYDIY.setSelected(false);}
        });
        OutPuts3.appendText(price+"");
        //initialize the P4:
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        toppingColumn.setCellValueFactory(new PropertyValueFactory<>("toppingsString"));
        curseColumn.setCellValueFactory(new PropertyValueFactory<>("crustString"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
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
            if(type.equals("Deluxe")) {CurrentPizza=NY.createDeluxe(CurrentSize);
                price=price+CurrentSize.getDeluxe();
                priceList.add(CurrentSize.getDeluxe());
                priceUpdate();}
            else if (type.equals("BBQChicken")) {CurrentPizza=NY.createBBQChicken(CurrentSize);
                price=price+CurrentSize.getChicken();priceList.add(CurrentSize.getChicken());
                priceUpdate();}
            else if(type.equals("Meatzza")) {CurrentPizza=NY.createMeatzza(CurrentSize);
                price=price+CurrentSize.getMeatzza();priceList.add(CurrentSize.getMeatzza());
                priceUpdate();}
            else{throw new IllegalArgumentException("Ivalid Pizza Type" + type);}
        }
        else if(CHKnow.isSelected()) {
            CHPizza CH=new CHPizza();
            if(type.equals("Deluxe")) {CurrentPizza=CH.createDeluxe(CurrentSize);
                price=price+CurrentSize.getDeluxe();priceList.add(CurrentSize.getDeluxe());
                priceUpdate();}
            else if (type.equals("BBQChicken")) {CurrentPizza=CH.createBBQChicken(CurrentSize);
                price=price+CurrentSize.getChicken();priceList.add(CurrentSize.getChicken());
                priceUpdate();}
            else if(type.equals("Meatzza")) {CurrentPizza=CH.createMeatzza(CurrentSize);
                price=price+CurrentSize.getMeatzza();priceList.add(CurrentSize.getMeatzza());
                priceUpdate();}
            else{throw new IllegalArgumentException("Ivalid Pizza Type" + type);}
        }
        else{
            throw new IllegalArgumentException("Ivalid Curst");
        }
        CurrentOrder.add(CurrentPizza);
        String output1=CurrentOrder.toString();
        outputPage1.appendText(STR."\{output1}"); //for test use
    }

    /*
     Update all the price window in every page.
     */
    public void priceUpdate(){
        price=Math.round(price * 100.0) / 100.0;
        subTotalLabelDelete.setText(price+"");
        subTotalLabel.setText(price+"");
        OutPuts3.setText(price+"");
        Output4Price.setText(price+"");
    }
    /*
        show the current list of pizza in current order.(used in page2, to initialize the checking table)
     */
    public void showDelete(ActionEvent actionEvent) {
        ObservableList<Pizza> OPizzas = FXCollections.observableArrayList();
        for (Pizza pizza : CurrentOrder.getPizzas()) {
            OPizzas.add(pizza);
        }
        DeleteOrderList.setItems(OPizzas);
        priceUpdate();
    }
    /*
        Deleted the current pizza that being selected in listView
     */
    public void DeleteTarget(ActionEvent actionEvent) {
        int targetNum=DeleteOrderList.getSelectionModel().getSelectedIndex();
        double deletePrice=priceList.get(targetNum);
        price=price-deletePrice;
        CurrentOrder.deletePizza(targetNum);
        showDelete(actionEvent);
        priceUpdate();
    }
    /*
        Deleted everything in current order.
     */
    public void DeleteAll(ActionEvent actionEvent) {
        CurrentOrder=new Order();
        priceList.clear();
        price=0.0;
        priceUpdate();
        showDelete(actionEvent);
    }
    /*
        create a DIY order
     */
    public void HandleDIY(ActionEvent actionEvent) {
        try{
            ArrayList<Topping>ChoosedTopping=new ArrayList<>(ToppingList.getSelectionModel().getSelectedItems());
            String currentSize=SizeDIY.getSelectionModel().getSelectedItem();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred: " + e.getMessage());
        }
        ArrayList<Topping>ChoosedTopping=new ArrayList<>(ToppingList.getSelectionModel().getSelectedItems());
        String size=SizeDIY.getSelectionModel().getSelectedItem();
        Size CurrentSize;
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
        if(ChoosedTopping.size()<=7) {
            if (NYDIY.isSelected()) {
                NYPizza NY = new NYPizza();
                Pizza CurrentPizza = NY.createBuildYourOwn(CurrentSize, ChoosedTopping);
                double newPrice = NY.createBuildYourOwn(CurrentSize, ChoosedTopping).price();
                priceList.add(newPrice);
                price = price + newPrice;
                CurrentOrder.add(CurrentPizza);
                priceUpdate();
            } else if (CHDIY.isSelected()) {
                CHPizza CH = new CHPizza();
                Pizza CurrentPizza = CH.createBuildYourOwn(CurrentSize, ChoosedTopping);
                double newPrice = CH.createBuildYourOwn(CurrentSize, ChoosedTopping).price();
                priceList.add(newPrice);
                price = price + newPrice;
                price = price + newPrice;
                CurrentOrder.add(CurrentPizza);
                priceUpdate();
            }
        }
        else{
            OutPuts3.appendText("Too many toppings!");
        }
    }
    /*
        print out the page 4's pizza list.
     */
    public void InitializePage4(ActionEvent actionEvent) {
        ObservableList<PizzaAndPrice> pizzaList = FXCollections.observableArrayList();
        for(int i=0;i<CurrentOrder.getPizzas().size();i++){
            Pizza TempPizza=CurrentOrder.getPizzas().get(i);
            pizzaList.add(new PizzaAndPrice(TempPizza, priceList.get(i)));
        }
        Output4Detail.setItems(pizzaList);
        price+=price*0.06625;
        priceUpdate();
    }

    public void placingOrder(ActionEvent actionEvent) {
        CurrentOrder.getANumber();
        CurrentOrder.addPrices(price);
        if(CurrentOrder.getNumber()!=0 && CurrentOrder.getPrice()!=0){
            orderList.addOrder(CurrentOrder);
        }
        Output4.appendText(orderList.toString());
        //clear everything for next upcoming order.
        CurrentOrder=new Order();
        priceList.clear();
        price=0.0;
        priceUpdate();
    }
}

