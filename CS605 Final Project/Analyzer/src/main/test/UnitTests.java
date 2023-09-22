package query.analyzer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import query.analyzer.DataAccessLayer.QueryDataProp;
import query.analyzer.DataAccessLayer.QueryExecutor;
import query.analyzer.DbProviderConfig.DbConfig;
import query.analyzer.DbProviderConfig.DbProviderTypes;
import query.analyzer.DbProviderConfig.Oracle.OracleConfig;
import query.analyzer.DbProviderConfig.Oracle.OracleConfigFactory;
import query.analyzer.DbProviderConfig.SqlServer.SqlServerConfig;
import query.analyzer.DbProviderConfig.SqlServer.SqlServerConfigFactory;
import query.analyzer.Validators.QueryAnalyzerViewValidator;
import java.util.List;

public class UnitTests {
    private QueryExecutor queryExecutor;
    private QueryService queryService;

    @BeforeEach
    public void setUp() {
        queryExecutor = new QueryExecutor();
        queryService = new QueryService();
    }

    @Test
    public void testOracleConfigFactoryCreate() {
        OracleConfig oracleConfig = OracleConfigFactory.Create("Host", "ServiceName");

        assertNotNull(oracleConfig);
        assertEquals(DbProviderTypes.Oracle, oracleConfig.getProvider());
        assertNotNull(oracleConfig.GetConnectionString());
    }

    @Test
    public void testSqlServerConfigFactoryCreate() {
        SqlServerConfig sqlServerConfig = SqlServerConfigFactory.Create("ServerAddress", "DbName", "Username", "Password");

        assertNotNull(sqlServerConfig);
        assertEquals(DbProviderTypes.SqlServer, sqlServerConfig.getProvider());
        assertNotNull(sqlServerConfig.GetConnectionString());
    }

    @Test
    public void testExecute1() {
        assertNotNull(queryService);

        // Creating database configurations
        DbConfig oracleConfig = OracleConfigFactory.Create("MockHost", "MockServiceName");
        DbConfig sqlServerConfig = SqlServerConfigFactory.Create("MockServerAddress", "MockDbName", "MockUsername", "MockPassword");

        // Executing queries
        List<QueryDataProp> results = queryService.Execute();
        assertNotNull(results);
        assertEquals(2, results.size());

        QueryDataProp oracleResult = results.get(0);
        QueryDataProp sqlServerResult = results.get(1);

        // Verify Oracle result
        assertEquals(DbProviderTypes.Oracle, oracleResult.Provider());
        assertTrue(oracleResult.ExecutionTimeMilliseconds() >= 0 && oracleResult.ExecutionTimeMilliseconds() <= 10955);
        assertTrue(oracleResult.PeakRamUsage() >= 0 && oracleResult.PeakRamUsage() <= 45);
        assertTrue(oracleResult.PeakCpuUsage() >= 0 && oracleResult.PeakCpuUsage() <= 45);

        // Verify SQL Server result
        assertEquals(DbProviderTypes.SqlServer, sqlServerResult.Provider());
        assertTrue(sqlServerResult.ExecutionTimeMilliseconds() >= 0 && sqlServerResult.ExecutionTimeMilliseconds() <= 10955);
        assertTrue(sqlServerResult.PeakRamUsage() >= 0 && sqlServerResult.PeakRamUsage() <= 45);
        assertTrue(sqlServerResult.PeakCpuUsage() >= 0 && sqlServerResult.PeakCpuUsage() <= 45);
    }

    @Test
    public void testValidSqlSyntax() {
        String validSql = "SELECT * FROM TableName WHERE ColumnName = 'Value'";
        QueryAnalyzerViewValidator validator = new QueryAnalyzerViewValidator(validSql);
        assertTrue(validator.validate());
    }

    @Test
    public void testInvalidSqlSyntax() {
        String invalidSql = "SELECT * FROM TableName WHERE ColumnName = 'Value' AND";
        QueryAnalyzerViewValidator validator = new QueryAnalyzerViewValidator(invalidSql);
        assertFalse(validator.validate());
    }


    @Test
    public void testCreateOracleConfig() {
        String host = "TestHost";
        String serviceName = "TestServiceName";

        OracleConfig oracleConfig = OracleConfigFactory.Create(host, serviceName);

        assertNotNull(oracleConfig);
        assertEquals(DbProviderTypes.Oracle, oracleConfig.getProvider());
        assertEquals("Data Source=(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=TestHost)(PORT=1521)))" +
                        "(CONNECT_DATA=(SERVICE_NAME=TestServiceName)));User Id=your_username;Password=your_password;",
                oracleConfig.GetConnectionString());
    }

    @Test
    public void testCreateSqlServerConfig() {
        String serverAddress = "TestServer";
        String dbName = "TestDb";
        String username = "TestUser";
        String password = "TestPassword";

        SqlServerConfig sqlServerConfig = SqlServerConfigFactory.Create(serverAddress, dbName, username, password);

        assertNotNull(sqlServerConfig);
        assertEquals(DbProviderTypes.SqlServer, sqlServerConfig.getProvider());
        assertEquals("Server=TestServer;Database=TestDb;User Id=TestUser;Password=TestPassword;",
                sqlServerConfig.GetConnectionString());
    }


}
