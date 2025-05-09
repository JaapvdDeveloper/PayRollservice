package com.example.payroll.Model;

import java.util.Objects;

import com.example.payroll.Enum.Status; // ✅ Correct import

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order {

    private @Id @GeneratedValue Long id;
    private String description;
    private Status status;

    Order() {}

    public Order(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id) &&
               Objects.equals(description, order.description) &&
               status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status);
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", description='" + description + '\'' +
               ", status=" + status +
               '}';
    }
}
