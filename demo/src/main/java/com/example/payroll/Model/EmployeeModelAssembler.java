// package com.example.payroll.Model;
// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

// import org.springframework.boot.web.servlet.error.ErrorController;
// import org.springframework.hateoas.EntityModel;
// import org.springframework.hateoas.server.RepresentationModelAssembler;
// import org.springframework.stereotype.Component;

// @Component
// class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

//   @Override
//   public EntityModel<Employee> toModel(Employee employee) {

//     return EntityModel.of(employee, //
//         linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
//         linkTo(methodOn(ErrorController.class).all()).withRel("employees"));
//   }
// }