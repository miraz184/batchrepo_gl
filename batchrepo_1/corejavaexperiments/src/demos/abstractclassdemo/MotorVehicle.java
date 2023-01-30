package demos.abstractclassdemo;

public abstract class MotorVehicle {

    private String vehicleNumber;

    public MotorVehicle(String vehicleNum) {
        this.vehicleNumber = vehicleNum;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    abstract void move();

}
