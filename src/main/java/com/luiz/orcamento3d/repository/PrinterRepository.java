package com.luiz.orcamento3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.orcamento3d.model.Printer;

@Repository
public interface PrinterRepository extends JpaRepository<Printer, Integer> {

}
