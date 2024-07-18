package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper {
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterReminderTitle(String title) {
        type(By.id("reminder_title"), title);

    }

    public void tapOnSaveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int number) {
        pause(500);

        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < number; i++) {
                if (period.equals("future")) {
                    swipe(0.8, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5, 0.9);
                }
            }
        }
    }

    private String getSelectedMonth() {
        return isTextPresent(By.id("date_picker_month"));
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period, String year) {
        pause(500);

        if (!getSelectedYear().equals(year)) {
            if (period.equals("future")) {
                swipeUntilNeededYear(year, 0.6, 0.5);
            } else if (period.equals("past")) {
                swipeUntilNeededYear(year, 0.5, 0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private void swipeUntilNeededYear(String year, double startPoint, double stopPoint) {
        while (!getYear().equals(year)) {
            swipeInElement(By.className("android.widget.ListView"), startPoint, stopPoint);
            getYear();
        }
    }

    public String getYear() {
        return isTextPresent(By.id("month_text_view"));
    }

    private String getSelectedYear() {
        return isTextPresent(By.id("date_picker_year"));
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void tapOnTimeField() {
        tap(By.id("time"));
    }

    public void selectTime(String timeOfDay, int xHour, int yHour, int xMin, int yMin) {
        pause(500);

        if (timeOfDay.equals("am")) {
            tapWithCoordinates(277, 1332);
        } else if (timeOfDay.equals("pm")) {
            tapWithCoordinates(789, 1332);
        }

        tapWithCoordinates(xHour, yHour);
        tapWithCoordinates(xMin, yMin);
    }

    public void tapOnRepeatOff() {
        tap(By.id("repeat_switch"));
    }

    public void tapOnRepetitionInterval() {
        tap(By.id("repeat_no_text"));
    }

    public void tapOnEnterNumberField() {
        tap(By.xpath("//android.widget.EditText"));
    }

    public void enterNumber(String number) {
        type((By.xpath("//android.widget.EditText")), number);
    }

    public void tapOnOkBtn() {
        tap(By.id("android:id/button1"));
    }

    public void swipeToTypeOfRepetitions() {
        pause(500);
        swipe(0.9, 0.7);
    }

    public void tapOnTypeOfRepetitions() {
        tap(By.id("repeat_type_text"));
    }

    public void selectRepetitiopnInterval(String interval) {
        tap(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=" + "\"" +interval+"\""+"]"));
    }
}
