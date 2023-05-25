package com.example.pollutiondashboard;

import com.example.pollutiondashboard.Services.emissionServiceImpl;
import com.example.pollutiondashboard.Services.sourceServiceImpl;
import com.example.pollutiondashboard.entities.Emission;
import com.example.pollutiondashboard.entities.Source;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
public class dashControlleur {
    sourceServiceImpl emissionService=new sourceServiceImpl();
    private Button HOME;
    @FXML
    private Button ajouterdata;
    @FXML
    private Button calculEmission;

    @FXML
    private Button consulterData;

    @FXML
    private TableView<Source> table;
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    @FXML
    private TableColumn<Source, Integer> idSouCol;
    @FXML
    private TableColumn<Source, String> sourceEmissionCol;
    ObservableList<Emission> dataE ;
    @FXML
    private TableView<Source> tableSource;
    @FXML
    private TableColumn<Source, String> limiteRegCol;
    @FXML
    private TableColumn<Source, String> ActiviteCol;
    @FXML
    private TableColumn<Source, String> TypeSourceCol;

    public void initialize() {
        // Initialize the chart with data and configure its appearance
       /* XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Category 1", 10));
        series.getData().add(new XYChart.Data<>("Category 2", 20));
        series.getData().add(new XYChart.Data<>("Category 3", 30));

        barChart.getData().add(series);*/

        // Set axis labels
        xAxis.setLabel("Sources");
        yAxis.setLabel("emission");
        ObservableList<XYChart.Data<String, Number>> chartData = emissionService.chart();
        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName("Emission Data");
        serie.setData(chartData);
        barChart.getData().add(serie);
    }

}
