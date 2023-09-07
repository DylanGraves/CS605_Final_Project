package query.analyzer.DbProviderConfig;

public abstract class DbConfig
{
    protected String ConnectionString;
    protected DbProviderTypes ProviderDbType;

    public String GetConnectionString() {
        return ConnectionString;
    }

    protected void SetConnectionString(String conn)
    {
        ConnectionString = conn;
    }

    public DbProviderTypes getProvider() {
        return ProviderDbType;
    }

    protected void setProvider(DbProviderTypes provider) {
        ProviderDbType = provider;
    }
}
