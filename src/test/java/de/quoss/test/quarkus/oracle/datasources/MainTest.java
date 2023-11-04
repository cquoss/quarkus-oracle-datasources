package de.quoss.test.quarkus.oracle.datasources;

import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class MainTest {

    private static final Logger LOGGER = Logger.getLogger(MainTest.class);

    @Inject
    Main main;

    @Test
    void testMain() {
        LOGGER.infof("[main=%s]%n", main);
        main.printDataSource();
        main.countConfigEntries();
    }

}
