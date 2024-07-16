public class DayOfTheWeek {




    private static int noOFLeapYears(int startYear, int endYear){
        int totalLeapYears = 0;
        for(int i = startYear ; i < endYear ; i++){
            if(i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)){
                totalLeapYears++;
            }
        }
        return totalLeapYears;


    }
    private static int totalDaysInMonth(int month, int day, boolean isLeap){

        int totalDays = 0;
        for(int i = 1; i < month ;i++){

            if( i <= 7 && i % 2 != 0){
                totalDays += 31;
            }else{

                if(i == 2){
                    if(isLeap){
                        totalDays += 29;
                    }else{
                        totalDays += 28;
                    }
                }else if(i >= 8 && i % 2 == 0){
                    totalDays += 31;
                }else{
                    totalDays += 30;
                }

            }
        }
        return totalDays + day;
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] daysArray = new String[7];
        daysArray[0] = "Monday";
        daysArray[1] = "Tuesday";
        daysArray[2] = "Wednesday"; daysArray[3] = "Thursday"; daysArray[4] = "Friday";
        daysArray[5] = "Saturday";
        daysArray[6] = "Sunday";




        int nofYears = year - 1971;
        boolean isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        int totalDaysInMonth = totalDaysInMonth(month,day,isLeapYear) -1 ;
        int totalLeapYears = noOFLeapYears(1971,year);
        int totalDays = totalDaysInMonth + totalLeapYears * 366 + (nofYears - totalLeapYears)  * 365;



        int dayIndex =(totalDays % 7);

        dayIndex = dayIndex + 4;

        if(dayIndex >= 7 ){
            dayIndex = dayIndex % 7;
        }

        return daysArray[dayIndex];
    }


    public static void main(String[] args){
        System.out.println(dayOfTheWeek(31,8,2019));
        System.out.println(dayOfTheWeek(18,7,1999));
        System.out.println(dayOfTheWeek(15,8,1993));
        System.out.println(dayOfTheWeek(21,12,1980));
    }
}
