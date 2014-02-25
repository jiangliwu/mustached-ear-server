package me.jiangliwu.EARServer.monster;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import me.jiangliwu.EARServer.util.DB;

import org.json.JSONArray;
import org.json.JSONObject;
@Entity
public class Monster {
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer blood;

	@Column
	private Integer money;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "map_id")
	private me.jiangliwu.EARServer.map.Map map;

	@Column
	private Integer posx;

	@Column
	private Integer posy;
	
	private Integer now;
	
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

	public Integer getBlood() {
		return blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public me.jiangliwu.EARServer.map.Map getMap() {
		return map;
	}

	public void setMap(me.jiangliwu.EARServer.map.Map map) {
		this.map = map;
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
	
	public JSONObject toJson() {

		return new JSONObject().put("name", name).put("id", id)
				.put("blood", blood)
				.put("pos", new JSONArray().put(posx).put(posy));
	}

	public Integer getNow() {
		return now;
	}

	public void setNow(Integer now) {
		this.now = now;
	}
	
	public void save() {
		DB.save(this);
	}
}
