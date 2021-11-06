package util;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DateUtilLeapYearShould {

    /*All years divisible by 400 ARE bisiestos (1600, 2000, 2400)
    All years divisible by 100 but not by 400 NO son bisiestos (1700, 1800, 1900)
    All years divisible by 4 but not by 100 Are leap years (1996, 2004, 2012)
    All years not divisible by 4 are Not leap years bisiestos (2017, 2018, 2019)*/

    @Test
    public void returnTrueWhenYearIsDivisibleBy400() {

        assertThat(DateUtil.isLeapYear(1600), is(true));
        assertThat(DateUtil.isLeapYear(2000), is(true));
        assertThat(DateUtil.isLeapYear(2400), is(true));
    }

    @Test
    public void returnFalseWhenYearIsDivisibleBy100ButNotBy400() {
        assertThat(DateUtil.isLeapYear(1700), is(false));
        assertThat(DateUtil.isLeapYear(1800), is(false));
        assertThat(DateUtil.isLeapYear(1900), is(false));
    }

    @Test
    public void returnTrueWhenYearIsDivisibleBy4ButNotBy100() {
        assertThat(DateUtil.isLeapYear(1996), is(true));
        assertThat(DateUtil.isLeapYear(2004), is(true));
        assertThat(DateUtil.isLeapYear(2008), is(true));
    }

    @Test
    public void returnFalseWhenYearIsNotDivisibleBy4() {
        assertThat(DateUtil.isLeapYear(2017), is(false));
        assertThat(DateUtil.isLeapYear(2019), is(false));
        assertThat(DateUtil.isLeapYear(2018), is(false));
    }


}