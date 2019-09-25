import org.junit.Test;
import org.slf4j.Logger;

public class ExampleTest {
    @Test
    public void loggerSuppressionTest() throws InterruptedException {
        Logger logger = new at.geilehner.logger.Logger.LoggerBuilder()
                .maxMessagesPerDelay(2)
                .suppressDelay(5000)
                .reference(ExampleTest.class).build();

        for(int i = 0; i < 50; i++){
            logger.info("test");
            logger.error("test");
            logger.warn("test");
            Thread.sleep(100);
        }
    }
}
