package com.luiz.orcamento3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.orcamento3d.model.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {

}
