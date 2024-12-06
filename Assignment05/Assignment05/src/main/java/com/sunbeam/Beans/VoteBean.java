package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
	private int candId;
	private int userId;
	private boolean sucess;
	public VoteBean() {
		// TODO Auto-generated constructor stub
	}
	public VoteBean(int candId, int userId, boolean sucess) {
		super();
		this.candId = candId;
		this.userId = userId;
		this.sucess = sucess;
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	
	public void vote() {
		this.sucess = false;
		try(CandidateDao candDao = new CandidateDaoImpl()){
			int count = candDao.incrVote(candId);
			if(count == 1) {
				try(UserDao usrDao = new UserDaoImpl()){
					User user = usrDao.findById(userId);
					if(user!=null) {
						user.setStatus(1);
						count = usrDao.update(user);
						if(count == 1) {
							this.sucess = true;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
