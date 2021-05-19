package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Client;
import ru.sapteh.models.Orders;
import ru.sapteh.service.OrdersDAOImpl;

public class TableController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Orders, Integer> dao = new OrdersDAOImpl(factory);
    ObservableList<Orders> observableList = FXCollections.observableArrayList();

    @FXML
    private TableView<Orders> tableView;

    @FXML
    private TableColumn<Orders, Integer> idColumn;

    @FXML
    private TableColumn<Orders, String> productColumn;

    @FXML
    private TableColumn<Orders, String> costColumn;

    @FXML
    private TableColumn<Orders, String> clientColumn;

    @FXML
    void initialize(){
        observableList.addAll(dao.findByAll());
        tableView.setItems(observableList);
        idColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getId()));
        costColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getCost()));
        productColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getProduct().getName()));
        clientColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getClient().getName()));
    }

}
