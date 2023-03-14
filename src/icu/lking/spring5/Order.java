package icu.lking.spring5;

public class Order {
    private String orderNumber;
    private String createUserName;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    /**
     * 重写toString方法，用于显示信息
     * @return
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", createUserName='" + createUserName + '\'' +
                '}';
    }
}
