package com.sunbeam.Beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class ResultBean {
	private List<Candidate> candList;

			
	public ResultBean() {
		this.candList = new ArrayList<Candidate>();
	}
	public List<Candidate> getCandList() {
		return candList;
	}
	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			this.candList = candDao.findAll();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}
	

}
