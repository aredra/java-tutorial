package beginJava;

public class Order {
    private long orderId;
    private String userId;
    private String regDate;
    private String userName;
    private String itemId;
    private String orderAddress;

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void showOrderInfo() {
        System.out.println(this.orderId);
        System.out.println(this.itemId);
        System.out.println(this.userId);
        System.out.println(this.userName);
        System.out.println(this.orderAddress);
        System.out.println(this.regDate);
    }
}
