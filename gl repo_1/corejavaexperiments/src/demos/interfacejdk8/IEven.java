package demos.interfacejdk8;

/**
 * predicate demo
 *
 * argument type anything
 *  return type is always boolean
 */
@FunctionalInterface
public interface IEven {
    boolean isEven(int num);
}
