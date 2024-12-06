package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class FindCandBean {
	private int candId;
	private Candidate cand;
	
	public FindCandBean() {
		// TODO Auto-generated constructor stub
	}

	public FindCandBean(int candId, Candidate cand) {
		super();
		this.candId = candId;
		this.cand = cand;
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public Candidate getCand() {
		return cand;
	}

	public void setCand(Candidate cand) {
		this.cand = cand;
	}
	
	public void findCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			this.cand = candDao.findByid(candId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
