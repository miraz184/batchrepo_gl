package demos.strings;

public class StringOperations {
    public static void main(String args[]){
        String s="mumbai";
        char ch=s.charAt(1);
        int length=s.length();
        boolean isEmpty=s.isEmpty();//""  , "   "
        String s2=" hello ";
        System.out.println("before trim length="+s2.length()+" string="+s2);
        String trimmed=s2.trim();
        System.out.println("trimmed length="+trimmed.length()+" string="+s2);
        boolean isBlank=s.isBlank();
        System.out.println("check is string has only whitespaces="+isBlank);
        char array[]=s.toCharArray();
        String uppercased=s.toUpperCase();
        String substr1= s.substring(1,4);
        String substr2=s.substring(1);
        System.out.println("substr1="+substr1 + ",substr2="+substr2);
    }
}
