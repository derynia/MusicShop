package learn.android.musicshop;

import java.io.Serializable;

public class Order implements Serializable {
    private String userName;
    private String goodName;
    private int quantity;
    private double orderPrice;

    public Order(String userName, String goodName, int quantity, double orderPrice) {
        this.userName = userName;
        this.goodName = goodName;
        this.quantity = quantity;
        this.orderPrice = orderPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order {" +
                "user name = '" + userName + '\'' +
                ", good name = '" + goodName + '\'' +
                ", quantity = " + quantity +
                ", order price = " + orderPrice +
                '}';
    }

    public String toStringForTextView() {
        return "Customer name: " + userName + "\nGoods name: " + goodName + "\nQuantity: " + quantity
                + "\nPrice: " +  orderPrice + "\nOrder price: "  + (quantity * orderPrice);
    }

}
