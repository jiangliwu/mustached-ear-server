package me.jiangliwu.EARServer.user;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import me.jiangliwu.EARServer.task.Task;
import me.jiangliwu.EARServer.util.DB;

@Entity
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name", length = 50)
	private String name;

	@Column
	private Integer lvl = 1;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Task> tasks = new LinkedHashSet<Task>();

	@Column
	private String position;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "map_id")
	private me.jiangliwu.EARServer.map.Map map;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public me.jiangliwu.EARServer.map.Map getMap() {
		return map;
	}

	public void setMap(me.jiangliwu.EARServer.map.Map map) {
		this.map = map;
	}

	public void save() {
		DB.save(this);
	}
	
	
	private static User _u;
	public static User getUser(){
		return _u;
	}
	public static void setUser(User u ){
		_u = u;
	}

}
