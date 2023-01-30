package demos.genericsdemo;

public class Store<T> {
   private T  value;

   void add(T value){
       this.value=value;
   }

    public T getValue() {
        return value;
    }
}
