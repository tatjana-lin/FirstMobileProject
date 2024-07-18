package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {

    @Test
    public void addReminderTitlePositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent().contains("Holiday"));
    }

    @Test
    public void addReminderWithDatePositiveTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth("past", "MAY", 2);
        app.getReminder().selectDate(0);
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear("past", "2020");
        app.getReminder().tapOnOk();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("1/5/2020"));
    }

    @Test
    public void addReminderWithTimeTest() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTime("am",539,1195,539,656);
        app.getReminder().tapOnOk();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("6:00"));
    }

    @Test
    public void repeatOffTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnRepeatOff();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderRepeatInfoPresent().contains("Repeat Off"));

    }


    @Test
    public void repetitionIntervalTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().tapOnRepetitionInterval();
        app.getReminder().tapOnEnterNumberField();
        app.getReminder().enterNumber("2");
        app.getReminder().tapOnOkBtn();
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderRepeatInfoPresent().contains("2"));

    }

    @Test
    public void typeOfRepetitionTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
        app.getReminder().swipeToTypeOfRepetitions();
        app.getReminder().tapOnTypeOfRepetitions();
        app.getReminder().selectRepetitiopnInterval("Week");
        app.getReminder().tapOnSaveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderRepeatInfoPresent().contains("Week"));

    }


}

