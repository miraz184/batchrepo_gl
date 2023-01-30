package demos.interfacejdk8;

/*
Consumer demo , takes 1 arg, doesn't return anything
 */
@FunctionalInterface
public  interface IPrint {

    void print(String msg);

}
