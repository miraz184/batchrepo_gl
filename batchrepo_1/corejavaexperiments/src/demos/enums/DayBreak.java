package demos.enums;

public enum DayBreak {
    MORNING_TEA("11:15am","11:30am"),
    LUNCH("1:00pm","2:00pm"),
    EVENING_TEA("4:15pm", "4:30pm");

    private String startTime,endTime;

    DayBreak(String start,String endTime) {
        this.startTime = start;
        this.endTime=endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }

}
