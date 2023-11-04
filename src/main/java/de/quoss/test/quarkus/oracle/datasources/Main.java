package de.quoss.test.quarkus.oracle.datasources;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.runtime.Startup;
import io.smallrye.common.constraint.Assert;
// import oracle.jdbc.xa.client.OracleXADataSource;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.sql.XADataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@ApplicationScoped
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

   // private DataSource dataSource;

    @Default
    AgroalDataSource dataSource;

    // public Main(final AgroalDataSource dataSource) {
    //     Assert.assertNotNull(dataSource);
    //     this.dataSource = dataSource;
    //     System.err.format("[dataSource=%s]%n", dataSource);
    // }

    void printDataSource() {
        LOGGER.infof("[dataSource=%s]", dataSource);
    }

    void countConfigEntries() {
        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute("select count(*) from os_deploy_config");
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                LOGGER.infof("[count=%s]", rs.getObject(1));
            }
        } catch (SQLException e) {
            LOGGER.errorf(e, "%s", e.getMessage());
        }
    }

}
