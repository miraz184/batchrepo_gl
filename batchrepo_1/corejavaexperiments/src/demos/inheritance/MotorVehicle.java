package demos.inheritance;

public class MotorVehicle {

    private String vehicleNumber;

    public MotorVehicle(String vehicleNum) {
        this.vehicleNumber = vehicleNum;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    protected void move(){
        System.out.println(vehicleNumber+" vehicle moves");
    }

}
