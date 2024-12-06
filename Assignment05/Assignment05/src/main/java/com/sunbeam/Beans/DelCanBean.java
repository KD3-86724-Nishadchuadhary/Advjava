package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DelCanBean {
	private int id;
	private int count;
	public DelCanBean() {
		// TODO Auto-generated constructor stub
	}
	
	public DelCanBean(int id, int count) {
		super();
		this.id = id;
		this.count = count;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void deleteCand() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			this.count = candDao.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
