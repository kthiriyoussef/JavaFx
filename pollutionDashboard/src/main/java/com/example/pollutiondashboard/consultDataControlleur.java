package com.example.pollutiondashboard;

import com.example.pollutiondashboard.Services.emissionServiceImpl;
import com.example.pollutiondashboard.Services.sourceServiceImpl;
import com.example.pollutiondashboard.entities.Emission;
import com.example.pollutiondashboard.entities.Source;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class consultDataControlleur {
    sourceServiceImpl sourceService=new sourceServiceImpl();
    emissionServiceImpl emissionService=new emissionServiceImpl();
    @FXML
    private Button HOME;
    @FXML
    private Button AddData;
    @FXML
    private Button calculEmission;
    @FXML
    private TableColumn<Source, Integer> idSouCol;
    @FXML
    private TableColumn<Source, String> sourceEmissionCol;

    @FXML
    private TableColumn<Source, String> limiteRegCol;
    @FXML
    private TableColumn<Source, String> ActiviteCol;
    @FXML
    private TableColumn<Source, String> TypeSourceCol;

    @FXML
    private TableColumn<Source, String> SourceCol;
    @FXML
    private TableColumn<Source, String> ETypeSourceCol;
    @FXML
    private TableColumn<Source, Float> EmissionCol;
    ObservableList<Source> dataS ;
    ObservableList<Emission> dataE ;
    @FXML
    private TableView<Source> tableSource;
    @FXML
    private TableView<Emission> tableEmission;

    @FXML
    private void initialize() {

        idSouCol.setCellValueFactory(new PropertyValueFactory<>("idSource"));
        idSouCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        idSouCol.setEditable(false);
        sourceEmissionCol.setCellValueFactory(new PropertyValueFactory<>("sourceEmission"));
        sourceEmissionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        sourceEmissionCol.setEditable(true);
        TypeSourceCol.setCellValueFactory(new PropertyValueFactory<>("TypeSource"));
        TypeSourceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        TypeSourceCol.setEditable(true);
        limiteRegCol.setCellValueFactory(new PropertyValueFactory<>("limiteReglementaire"));
        limiteRegCol.setCellFactory(TextFieldTableCell.forTableColumn());
        limiteRegCol.setEditable(true);
        ActiviteCol.setCellValueFactory(new PropertyValueFactory<>("Activite"));
        ActiviteCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ActiviteCol.setEditable(true);
        tableSource.setEditable(true);
        dataS = FXCollections.observableArrayList(sourceService.findAll());
        tableSource.setItems(dataS);
        SourceCol.setCellValueFactory(new PropertyValueFactory<>("source"));
        SourceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        SourceCol.setEditable(false);
        ETypeSourceCol.setCellValueFactory(new PropertyValueFactory<>("typeSource"));
        ETypeSourceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ETypeSourceCol.setEditable(true);
        EmissionCol.setCellValueFactory(new PropertyValueFactory<>("emission"));
        EmissionCol.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        EmissionCol.setEditable(true);
        dataE = FXCollections.observableArrayList(emissionService.findAll());
        tableEmission.setItems(dataE);


    }
}
