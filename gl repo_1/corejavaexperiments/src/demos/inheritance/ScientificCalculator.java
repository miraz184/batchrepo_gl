package demos.inheritance;


public class ScientificCalculator extends SimpleCalculator {
    private String stringMemory;

   public  String addStrings(String str1, String str2){
       String result= str1+str2;
       this.stringMemory=result;
       return result;
   }

   @Override
   public String getLastOperationDetails(){
       return ""+stringMemory;
    }



}
