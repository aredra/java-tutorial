package org.example;

public class Car {

    private String name;
    private String carNo;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNo='" + carNo + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
