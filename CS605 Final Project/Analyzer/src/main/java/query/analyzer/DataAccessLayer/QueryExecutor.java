package query.analyzer.DataAccessLayer;

import query.analyzer.DbProviderConfig.DbConfig;

import java.util.Random;

public class QueryExecutor
{
    private Random _random;
    public QueryExecutor()
    {
        _random = new Random();
    }

    public QueryDataProp Execute(DbConfig config)
    {
        return new QueryDataProp(
                        config.getProvider(),
                        _random.nextLong(0,10955),
                        _random.nextDouble(0,45),
                        _random.nextDouble(0,45));
    }
}
