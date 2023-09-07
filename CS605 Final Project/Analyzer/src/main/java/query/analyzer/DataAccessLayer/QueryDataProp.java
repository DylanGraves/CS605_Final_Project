package query.analyzer.DataAccessLayer;

import query.analyzer.DbProviderConfig.DbProviderTypes;

public record QueryDataProp(
        DbProviderTypes Provider,
        long ExecutionTimeMilliseconds,
        double PeakRamUsage,
        double PeakCpuUsage) {

}
