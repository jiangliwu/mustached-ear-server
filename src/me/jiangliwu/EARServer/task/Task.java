package me.jiangliwu.EARServer.task;

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

import org.json.JSONObject;

import me.jiangliwu.EARServer.npc.Npc;
import me.jiangliwu.EARServer.util.DB;

@Entity
public class Task implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String title;

	@Column
	private String content;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "npc_id")
	private Npc npc;

	@Column
	private Integer taskExp = 100;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "father")
	private Task father;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Task.class)
	private Set<Task> children = new LinkedHashSet<Task>();

	/**
	 * 0 talk with some npc 1 kill monster (args is monster number) 2 others
	 */
	@Column
	private Integer taskType = 0;

	@Column
	private Integer taskArgs = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Npc getNpc() {
		return npc;
	}

	public void setNpc(Npc npc) {
		this.npc = npc;
	}

	public Integer getTaskExp() {
		return taskExp;
	}

	public void setTaskExp(Integer taskExp) {
		this.taskExp = taskExp;
	}

	public Task getFather() {
		return father;
	}

	public void setFather(Task father) {
		this.father = father;
	}

	public Set<Task> getChildren() {
		return children;
	}

	public void setChildren(Set<Task> children) {
		this.children = children;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Integer getTaskArgs() {
		return taskArgs;
	}

	public void setTaskArgs(Integer taskArgs) {
		this.taskArgs = taskArgs;
	}

	public void save() {
		DB.save(this);
	}

	public JSONObject toJson() {
		JSONObject ret = new JSONObject().put("id", getId())
				.put("title", getTitle()).put("content", content)
				.put("taskExp", taskExp).put("taskType", taskType);
		return ret;
	}
}
