package query.analyzer.Validators;

import net.sf.jsqlparser.util.validation.Validation;
import net.sf.jsqlparser.util.validation.ValidationError;
import net.sf.jsqlparser.util.validation.feature.DatabaseType;

import java.util.Arrays;
import java.util.List;

public class QueryAnalyzerViewValidator
{
    //This will validate the input of the GUI, to verify that its correctly syntaxed SQL

    private String sql;

    public QueryAnalyzerViewValidator(String sql) {
        this.sql = sql;
    }

    public boolean validate() {
        // validate statement if it's valid for all given databases.
        Validation validation = new Validation(Arrays.asList(DatabaseType.SQLSERVER, DatabaseType.ORACLE), sql);
        List<ValidationError> errors = validation.validate();

        if (errors.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}