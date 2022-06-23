package com.example.demo.repository;

import com.example.demo.model.Spid;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpidRepository extends CrudRepository<Spid, Long> {
    List<Spid> findSpidByUserId(User user);
}