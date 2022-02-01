package de.quoss.test.quarkus.oracle.datasources;

import io.quarkus.runtime.Startup;
import io.smallrye.common.constraint.Assert;
import oracle.jdbc.xa.client.OracleXADataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import javax.sql.XADataSource;

@ApplicationScoped
public class Main {

   // private DataSource dataSource;

   private DataSource dataSource;

    public Main(final DataSource dataSource) {
        Assert.assertNotNull(dataSource);
        this.dataSource = dataSource;
        System.err.format("[dataSource=%s]%n", dataSource);
    }

}
