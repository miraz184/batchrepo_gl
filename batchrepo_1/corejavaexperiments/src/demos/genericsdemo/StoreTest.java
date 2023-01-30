package demos.genericsdemo;

public class StoreTest {
    public static void main(String args[]) {
        Store<Integer> store = new Store();
        int value = 10;
        store.add(value);
        int fetched = store.getValue();
        System.out.println("fetched integer=" + fetched);
    }
}
