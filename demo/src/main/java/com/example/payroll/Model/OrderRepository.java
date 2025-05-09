package com.example.payroll.Model;

import org.springframework.data.jpa.repository.JpaRepository;



//Interact with orders in the database 
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
