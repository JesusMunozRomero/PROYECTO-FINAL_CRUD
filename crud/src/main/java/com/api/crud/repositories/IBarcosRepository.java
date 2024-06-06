package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.BarcosModel;
import com.api.crud.models.SociosModel;


@Repository
public interface IBarcosRepository extends JpaRepository<BarcosModel, Long>{}
