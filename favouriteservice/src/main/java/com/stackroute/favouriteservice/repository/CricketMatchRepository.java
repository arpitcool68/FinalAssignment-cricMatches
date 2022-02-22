package com.stackroute.favouriteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.favouriteservice.model.Matches;

@Repository
public interface CricketMatchRepository extends JpaRepository<Matches, Integer> {

}
