package demos.interfacejdk8;
/*
bifunction demo
takes 2 args
returns 1 result
 */
@FunctionalInterface
public interface IStringConatenator {
    String multiply(String input, int times);
}
