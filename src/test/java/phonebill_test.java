import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class phonebill_test {
    private phonebill phonebill;

    @BeforeEach
    public void setUp() {
        phonebill = new phonebill();
    }

    // 测试等价类1：0分钟<=通话时长<1分钟
//    @Test
//    public void testCalculateBillLessThanOneMinute() {
//        int min = 1/6;
//        double expectedBill = 0.05;
//        assertEquals(expectedBill, phonebill.Money(min));
//    }
//
//    // 测试等价类2：1分钟<=通话时长<=20分钟
//    @Test
//    public void testCalculateBillMoreThanOneMinute() {
//        int min = 10;
//        double expectedBill = 0.5;
//        assertEquals(expectedBill, phonebill.Money(min));
//    }
//
//    // 测试等价类3：通话时长>=20分钟
//    @Test
//    public void testCalculateBillMoreThanTwentyMinute() {
//        int min = 60;
//        double expectedBill = 5;
//        assertEquals(expectedBill, phonebill.Money(min));
//    }

    //将测试1，2，3合起来，采用决策表形式测试
    @DisplayName(value = "testPhonebill")
    @ParameterizedTest
    @CsvFileSource(resources = "/测试用例2.csv",numLinesToSkip = 1, encoding = "UTF-8")
    public void testPhonebill(int id,double min, double expectedBill) throws ParseException{
        assertEquals(expectedBill, phonebill.Money(min));
    }

    //测试等价类4：测试时制转换
    @DisplayName(value = "testTimelessconversion")
    @ParameterizedTest
    @CsvFileSource(resources = "/测试用例1.csv",numLinesToSkip = 1, encoding = "UTF-8")
    public void testTimelessconversion(int id,int month, int day, double expectedmin) throws ParseException{
        double min =60;
        min=Judge.Trans1(month,day, min);
        min=Judge.Trans2(month,day, min);
        assertEquals(expectedmin, min);
    }
}
