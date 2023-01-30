package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private int memory;
    private String lastOperation;
    private List<Integer> lastOperationParameters;

    private void save(String methodName, int result, List<Integer>params){
        this.lastOperation=methodName;
        this.memory=result;
        this.lastOperationParameters=params;
    }

    private int internalAdd(int num1, int num2){
        int result= num1+num2;
        List<Integer>list=new ArrayList<>();
        list.add(num1);
        list.add(num2);
        save("add",result, list);
        return result;

    }

    public int add(int num1, int num2){
        int result= internalAdd(num1, num2);
        return result;
    }

    public int sub(int num1, int num2){
        int result= num1-num2;
        List<Integer>list=new ArrayList<>();
        list.add(num1);
        list.add(num2);
        save("save",result, list);
         return result;
    }

    public String getLastOperationDetails(){
        String desired="operation="+lastOperation+"-paramaerters="+lastOperationParameters+"-result="+memory;
        return desired;
    }


}
