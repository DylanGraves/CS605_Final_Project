package query.analyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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
    private TextArea SQLTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    void clear(ActionEvent event) {
        SQLTextField.clear();
    }

    @FXML
    void submit(ActionEvent event) {

    }

}

