package com.example.spring.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.demo.model.RazorPay;

/**
 * Created by Ritesh on 13/01/2021
 */

@Repository
public interface OrderRepository extends JpaRepository<RazorPay, Integer> {

}
