package com.sunbeam.Beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class UsrBean {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	private int status;
	private String role;
	private int count = 0;
	private User user;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UsrBean() {
	}

	public UsrBean(int id, String firstName, String lastName, String email, String password, String birth, int status,
			String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.status = status;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void register() throws Exception {
		String fname = this.firstName;
		String lname = this.lastName;
		String email = this.email;
		String passwd = this.password;
		String birth = this.birth;
		Date d = Date.valueOf(birth);
		int status = 0;
		String role = "voter";
		
		
		try(UserDao usrDao = new UserDaoImpl()){
			User u = new User(0, fname, lname, email, passwd, d, status, role);
			this.count = usrDao.save(u);
		}
		
	}
	
	public void login() {
		try(UserDao usrDao = new UserDaoImpl()){
			User dbUser = usrDao.findByEmail(this.email);
			if(dbUser != null && dbUser.getPassword().equals(this.password)) {
				this.user = dbUser;
			}
			else
				this.user = null;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
