package query.analyzer.DbProviderConfig.Oracle;

import query.analyzer.DbProviderConfig.DbConfig;
import query.analyzer.DbProviderConfig.DbProviderTypes;

public class OracleConfig extends DbConfig
{
    public OracleConfig(DbProviderTypes dbProvider, String host, String serviceName)
    {
        ProviderDbType = dbProvider;
        ConnectionString = String.format(
                "Data Source=(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST={%s})(PORT=1521)))" +
                        "(CONNECT_DATA=(SERVICE_NAME={%s})));User Id=your_username;Password=your_password;",
                host,serviceName);
    }
}
