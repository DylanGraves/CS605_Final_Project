package query.analyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import query.analyzer.DataAccessLayer.QueryDataProp;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class QueryAnalyzerController {

    @FXML
    private Button ClearButton;

    @FXML
    private Label MicrosoftExecutionTimeLabel;

    @FXML
    private Label MicrosoftPeakRAMLabel;

    @FXML
    private Label MircosoftPeakCPULabel;

    @FXML
    private Label OracleExecutionTimeLabel;

    @FXML
    private Label OraclePeakCPULabel;

    @FXML
    private Label OraclePeakRAMLabel;

    @FXML
    private Label WarningLabel;

    @FXML
    private TextArea SQLTextField;

    @FXML
    private Button SubmitButton;

    QueryService queryService = new QueryService();


    @FXML
    void clear(ActionEvent event) {
        SQLTextField.clear();

        MicrosoftExecutionTimeLabel.setText("... milliseconds");
        MicrosoftPeakRAMLabel.setText("... %");
        MircosoftPeakCPULabel.setText("... %");

        OracleExecutionTimeLabel.setText("... milliseconds");
        OraclePeakRAMLabel.setText("... %");
        OraclePeakCPULabel.setText("... %");
    }

    @FXML
    void submit(ActionEvent event) {
        List<QueryDataProp> queryDataPropList = queryService.Execute();

        MicrosoftExecutionTimeLabel.setText(Long.toString(queryDataPropList.get(1).ExecutionTimeMilliseconds()) + " milliseconds");
        MicrosoftPeakRAMLabel.setText(String.format("%.2f", queryDataPropList.get(1).PeakRamUsage()) + "%");
        MircosoftPeakCPULabel.setText(String.format("%.2f", queryDataPropList.get(1).PeakCpuUsage()) + "%");

        OracleExecutionTimeLabel.setText(Long.toString(queryDataPropList.get(0).ExecutionTimeMilliseconds()) + " milliseconds");
        OraclePeakRAMLabel.setText(String.format("%.2f", queryDataPropList.get(0).PeakRamUsage()) + "%");
        OraclePeakCPULabel.setText(String.format("%.2f", queryDataPropList.get(0).PeakCpuUsage()) + "%");

        // TODO add text to warning label if SQL Validator returns false.
    }

}

