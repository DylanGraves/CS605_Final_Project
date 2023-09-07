package query.analyzer;

import query.analyzer.DataAccessLayer.QueryDataProp;
import query.analyzer.DataAccessLayer.QueryExecutor;
import query.analyzer.DbProviderConfig.DbConfig;
import query.analyzer.DbProviderConfig.DbProviderTypes;
import query.analyzer.DbProviderConfig.Oracle.OracleConfig;
import query.analyzer.DbProviderConfig.Oracle.OracleConfigFactory;
import query.analyzer.DbProviderConfig.SqlServer.SqlServerConfig;
import query.analyzer.DbProviderConfig.SqlServer.SqlServerConfigFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryService //Query service is created by the controller.
{
    //Query Service creates query configurations via abstract factory.
    //Query Service spins up the DAL and executes the query executor.

    private List<DbConfig> _configList;
    private QueryExecutor _executor;


    public QueryService() {
        _executor = new QueryExecutor();
        _configList = new ArrayList<>();
        CreateConfigs();
    }

    private void CreateConfigs()
    {
        _configList.add(OracleConfigFactory.Create(
                "HostFetchedFromExternalSettings",
                "ServiceNameFetchedFromExternalSettings"));

        _configList.add(SqlServerConfigFactory.Create(
                "ServerAddressedFromExternalSettings",
                "DbNameFetchedFromExternalSettings",
                "Username",
                "Password"));
    }

    public List<QueryDataProp> Execute()
    {
        List<QueryDataProp> QueryDataPropsList = new ArrayList<>();
        _configList.forEach((d) -> QueryDataPropsList.add(_executor.Execute(d)));
        return QueryDataPropsList;
    }
}
