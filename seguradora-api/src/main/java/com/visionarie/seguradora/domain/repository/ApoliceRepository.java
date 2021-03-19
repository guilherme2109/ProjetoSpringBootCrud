package com.visionarie.seguradora.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visionarie.seguradora.domain.model.Apolice;

@Repository
public interface ApoliceRepository extends JpaRepository<Apolice, Long> {

}
