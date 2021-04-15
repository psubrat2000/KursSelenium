package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitExampleTest {

    @Before
    public void setUp(){
        System.out.println("wykonuje się przed każdym testem");
    }

    @After
    public void tearDown(){
        System.out.println("wykonuje się po każdym tescie");
    }

    @Test
    public void shouldShowTestExample(){
        System.out.println("Test uruchomiony!");
    }

    @Test
    public void shouldShowSecondTestExample(){
        System.out.println("Test 2 uruchomiony!");
    }
}
