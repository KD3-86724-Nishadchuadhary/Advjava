package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Candidate;

public interface CandidateDao extends AutoCloseable {
	List<Candidate> findAll() throws Exception;
	Candidate findByid(int id) throws Exception;
	int Save(Candidate c) throws Exception;
	int update(Candidate c) throws Exception;
	int deleteById(int id) throws Exception;
	int incrVote(int candId) throws Exception;
	
	
}
