package com.jsware.voteAdmin.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jsware.voteAdmin.entities.Voter;

public interface VoterRepo extends CrudRepository<Voter, Long> {

}
