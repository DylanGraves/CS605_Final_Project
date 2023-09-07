package query.analyzer.DbProviderConfig.SqlServer;

import query.analyzer.DbProviderConfig.DbConfig;
import query.analyzer.DbProviderConfig.DbProviderTypes;

public class SqlServerConfig extends DbConfig
{
    public SqlServerConfig(DbProviderTypes dbType, String ServerAddress, String DbName, String UserName, String Password)
    {
        ProviderDbType = dbType;
        ConnectionString = String.format(
                "Server=%s;Database=%s;User Id=%s;Password=%s;",
                ServerAddress,DbName,UserName, Password);
    }
}
