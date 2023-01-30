package demos.abstractclassdemo;

public class Car extends MotorVehicle{

    public Car(String vehicleNum){
        super(vehicleNum);
    }

    @Override
    void move() {
        String vehicleNumber=getVehicleNumber();
        System.out.println( vehicleNumber+" moves like a car");
    }
}
