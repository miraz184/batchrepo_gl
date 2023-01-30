package demos.interfacejdk8;

@FunctionalInterface
public interface ICheck {

    String test(String msg) throws ClassNotFoundException;

}
