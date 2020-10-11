class Clock {

    int hours = 12;
    int minutes = 0;

    void next(){
        // implement me
        addMinute();
        //String time = String.format("time is %d:%02d", hours, minutes);
        //System.out.println(time);
    }
    void addHour(){
        this.hours++;
        if(this.hours > 12){
            this.hours = 1;
        }
    }
    void addMinute(){
        this.minutes++;
        if(this.minutes > 59){
            addHour();
            this.minutes = 0;
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.next();
    }
}