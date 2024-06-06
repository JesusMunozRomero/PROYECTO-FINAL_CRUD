package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.SalidasModel;
import com.api.crud.models.SociosModel;


@Repository
public interface ISalidasRepository extends JpaRepository<SalidasModel, Long>{}
