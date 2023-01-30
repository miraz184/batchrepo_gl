package demos.interfacejdk8;

@FunctionalInterface
public interface ILengthChecker {
    boolean check(String input, int expected);
}
