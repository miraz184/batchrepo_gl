package demos.enums;

public class EnumsTest {

    public static void main(String args[]){
        DayBreak lunch=DayBreak.LUNCH;
        DayBreak morningTea=DayBreak.MORNING_TEA;
        String lunchStartTime=lunch.getStartTime();
        String lunchEndTime=lunch.getEndTime();
        String morningTeaStartTime= morningTea.getStartTime();
        String morningTeaEndTime=morningTea.getEndTime();
        DayBreak myVal=DayBreak.LUNCH;
        if(myVal==DayBreak.LUNCH){
            System.out.println("mval contain lunch constant");
        }
        System.out.println("constant="+lunch+" startTime="+lunchStartTime+"endTime="+lunchEndTime);
        System.out.println("constant="+morningTea+" "+morningTeaStartTime+" endtime="+morningTeaEndTime);

        DayBreak breaks[]=DayBreak.values();
        System.out.println("declared constants count="+breaks.length);
        for (DayBreak iteratedBreak:breaks){
            System.out.println(iteratedBreak+" "+iteratedBreak.getStartTime()+"- "+iteratedBreak.getEndTime());
        }
    }

}
