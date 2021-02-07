package com.swcodingschool.Lesson251_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;

@Route
public class VaadinUI extends UI {

    @Autowired
    private CustomerService service;

    private Customer customer;
    private Binder<Customer> binder = new Binder<>(Customer.class);

    private Grid<Customer> grid = new Grid(Customer.class);
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private Button save = new Button("Save", e -> saveCustomer());

    @Override
    protected void init(VaadinRequest request) {
        updateGrid();
        grid.setColumns("firstName", "lastName");
        grid.addSelectionListener(e -> updateForm());

        binder.bindInstanceFields(this);

        VerticalLayout layout = new VerticalLayout(grid, firstName, lastName, save);
    }

    private void updateGrid() {
        List<Customer> customers = service.findAll();
        grid.setItems(customers);
        setFormVisible(false);
    }

    private void updateForm() {
        if (grid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            customer = grid.asSingleSelect().getValue();
            binder.setBean(customer);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        firstName.setVisible(visible);
        lastName.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveCustomer() {
        service.update(customer);
        updateGrid();
    }
}