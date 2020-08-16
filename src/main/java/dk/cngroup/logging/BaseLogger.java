package dk.cngroup.logging;
import ch.qos.logback.classic.util.ContextInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseLogger {

    public static Logger logger;

    static {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, System.getProperty("user.dir") + "/logback.xml");
        logger = LoggerFactory.getLogger(BaseLogger.class);
    }

    public BaseLogger() {
    }
}
