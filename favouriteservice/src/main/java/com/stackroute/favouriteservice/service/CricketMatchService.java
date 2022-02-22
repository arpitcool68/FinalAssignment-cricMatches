package com.stackroute.favouriteservice.service;

import com.stackroute.favouriteservice.model.Matches;
import com.stackroute.favouriteservice.util.exception.CricketMatchAlreadyExistsException;
import com.stackroute.favouriteservice.util.exception.CricketMatchNotFoundException;

public interface CricketMatchService {

	Matches addCricketMatch(Matches cricketMatch) throws CricketMatchAlreadyExistsException;

	Matches getAllCricketMatches(String matchId) throws CricketMatchNotFoundException;

	boolean deleteCricketMatchByUniqueId(String uniqueId) throws CricketMatchNotFoundException;

	boolean updateCricketMatches(Matches cricketMatchDto) throws CricketMatchNotFoundException;

}
