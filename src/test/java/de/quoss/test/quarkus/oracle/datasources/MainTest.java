package de.quoss.test.quarkus.oracle.datasources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class MainTest {

    @Inject
    Main main;

    @Test
    void testMain() {
        System.err.format("[main=%s]%n", main);
    }

}
