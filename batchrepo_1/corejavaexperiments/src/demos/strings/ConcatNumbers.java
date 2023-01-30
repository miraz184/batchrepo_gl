package demos.strings;

public class ConcatNumbers {


    public static void main(String args[]){
        ConcatNumbers demo=new ConcatNumbers();
        String result=demo.concatNumbersTill(10);
        System.out.println(result);
    }


    String concatNumbersTill(int number){
        StringBuilder result=new StringBuilder();
        for (int i=0;i<=number;i++){
            result.append(i);
        }
        return result.toString();
    }

}
