package demos.exceptiondemos;

public class StringWork {

    public static void main(String args[]) {
        StringWork demo = new StringWork();
        System.out.println("inside main before lowercase called");
        try {
            String result = demo.toLowerCase("good", 70);
            System.out.println("result=" + result);
        } catch (InvalidArgumentException e) {
            System.out.println("invalid argument," + e.getMessage());
        }
        catch (InvalidAgeException e){
            System.out.println("age you rpovided is not accepted,"+e.getMessage());
        }

    }

    String toLowerCase(String input, int age) throws InvalidArgumentException,InvalidAgeException {
        if (input == null || input.isEmpty()) {
            InvalidArgumentException e = new InvalidArgumentException("input is null or empty");
            throw e;
        }
        if(age>60 || age<18){
            throw new InvalidAgeException("age can't be greater thna 60");
        }
        String lowercased = input.toLowerCase();
        System.out.println("after lowercase");
        return lowercased;

    }

}
