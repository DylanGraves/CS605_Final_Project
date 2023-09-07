package query.analyzer.DbProviderConfig.SqlServer;

import query.analyzer.DbProviderConfig.DbProviderTypes;

public class SqlServerConfigFactory
{
    public static SqlServerConfig Create(String ServerAddress, String DbName, String Username, String Password)
    {
        {
            return new SqlServerConfig(
                    DbProviderTypes.SqlServer,
                    ServerAddress,
                    DbName,
                    Username,
                    Password);
        }
    }
}
