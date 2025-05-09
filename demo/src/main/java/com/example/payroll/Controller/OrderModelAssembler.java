package com.example.payroll.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.swing.text.html.parser.Entity;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

// import jakarta.persistence.criteria.Order;
// import jakarta.transaction.Status;


import com.example.payroll.Model.Order;
import com.example.payroll.Enum.Status;



@Component
class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {

        // Links to single-item resource and aggregate root

        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        // Links based on state of the order

        if (order.getStatus() == Status.IN_PROGRESS) {

            orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId()))
                    .withRel("cancel"));

            orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId()))
                    .withRel("complete"));
        }

        return orderModel;
    }

}
