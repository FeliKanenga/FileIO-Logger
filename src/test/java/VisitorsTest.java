import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisitorsTest {


   @Test
    public void load() {

        Assert.assertEquals(Visitors.load("feli"),
                "Success");

    }
}