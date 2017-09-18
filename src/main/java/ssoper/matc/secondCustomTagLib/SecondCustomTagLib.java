package ssoper.matc.secondCustomTagLib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class SecondCustomTagLib extends SimpleTagSupport{

    String timeContextualGreeting;

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        getTimeMessage();
        out.println(timeContextualGreeting);
    }

    public void getTimeMessage() {

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        int currentHour = currentTime.getHour();
        int currentMinute = currentTime.getMinute();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();

        System.out.println(currentDate + "\n");

        if(currentHour >= 6 && (currentHour <= 7 && currentMinute <= 30)) {
            timeContextualGreeting = "Wake up call.";
        }

        if (currentHour >= 11) {
            timeContextualGreeting = "Wrap up work and get ready to bike to school.";
        }

        if (currentHour >= 12 && (currentHour <= 12 && currentMinute <= 29)) {
            timeContextualGreeting = "Class starts soon, finish your homework and get to class.";
        }

        if (currentHour >= 16 && currentHour <= 17) {
            timeContextualGreeting = "Time for dinner, wrap up your lab time and go eat!";
        }

        if (currentYear == 2017 && currentMonth == 10 && currentDay == 31) {
            timeContextualGreeting = "\n" +
                    "Happy Halloween!";
        }
    }
}
