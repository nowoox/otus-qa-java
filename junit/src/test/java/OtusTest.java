import org.junit.Test;

public class OtusTest extends YaTest {

    @Test
    public void yatest() throws InterruptedException {

        String[] mark = {"Samsung", "Xiaomi"};

        GoToMarket();

        GoToPhones();

        SelectMark(mark);

        Sort();

        AddToCompare(mark);

        GoToCompare();

        CheckNumberOfCompareItems(mark);

        Thread.sleep(5000);
    }

}
