package me.jiangliwu.EARServer.npc;

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

import org.json.JSONArray;
import org.json.JSONObject;

import me.jiangliwu.EARServer.task.Task;
import me.jiangliwu.EARServer.util.DB;

@Entity
public class Npc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column()
	private String name;

	@Column
	private Integer posx;

	@Column
	private Integer posy;

	@Column
	private String message;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "map_id")
	private me.jiangliwu.EARServer.map.Map map;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Task.class)
	private Set<Task> tasks = new LinkedHashSet<Task>();

	public Npc() {

	}

	public me.jiangliwu.EARServer.map.Map getMap() {
		return map;
	}

	public void setMap(me.jiangliwu.EARServer.map.Map map) {
		this.map = map;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPosx() {
		return posx;
	}

	public void setPosx(Integer posx) {
		this.posx = posx;
	}

	public Integer getPosy() {
		return posy;
	}

	public void setPosy(Integer posy) {
		this.posy = posy;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void save() {
		DB.save(this);
	}

	public JSONObject toJson() {
		JSONArray  msgArray = new JSONArray();
		String [] msgs = message.split(";");
		for( String s : msgs) 
			msgArray.put(s);
		
		return new JSONObject().put("name", name).put("id", id)
				.put("pos", new JSONArray().put(posx).put(posy))
				.put("message",msgArray);
	}
}
