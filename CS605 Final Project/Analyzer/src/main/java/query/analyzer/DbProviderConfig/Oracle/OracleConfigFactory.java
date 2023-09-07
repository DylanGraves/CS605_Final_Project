package query.analyzer.DbProviderConfig.Oracle;

import query.analyzer.DbProviderConfig.DbProviderTypes;
import query.analyzer.DbProviderConfig.SqlServer.SqlServerConfig;

public class OracleConfigFactory
{
    public static OracleConfig Create(String Host, String ServiceName)
    {
        {
            return new OracleConfig(
                    DbProviderTypes.Oracle,
                    Host,
                    ServiceName);
        }
    }
}
