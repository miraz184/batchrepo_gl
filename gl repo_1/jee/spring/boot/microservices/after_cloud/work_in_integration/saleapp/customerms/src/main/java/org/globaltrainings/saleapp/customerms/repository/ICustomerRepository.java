package org.globaltrainings.saleapp.customerms.repository;

import org.globaltrainings.saleapp.customerms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
