package me.jiangliwu.EARServer.monster;

import static org.junit.Assert.*;
import me.jiangliwu.EARServer.map.Map;
import me.jiangliwu.EARServer.util.DB;

import org.junit.Test;

public class MonsterTest {

	private Monster getMonster(String name, Integer blood , Integer x , Integer y , Map m){
		Monster ret = new Monster();
		ret.setBlood(blood);
		ret.setPosx(x);
		ret.setPosy(y);
		ret.setName(name);
		ret.setMap(m);
		ret.setMoney(50);
		ret.setNow(ret.getBlood());
		return ret;
	}
	@Test
	public void test() {
		Map m = (Map) DB.findByID(Map.class.getName(), 1);
//		{id=1,name="spider",blood=120,now=120,x=11,y=13},
//		{id=2,name="spider",blood=120,now=100,x=12,y=13},
//		{id=3,name="spider",blood=120,now=120,x=13,y=13},
//		{id=4,name="spider",blood=120,now=120,x=14,y=14},
//		{id=5,name="spider",blood=120,now=120,x=15,y=14},
//		{id=6,name="spider",blood=120,now=120,x=16,y=16}
		
		//Monster m1 = 
		
		getMonster("spider",120,11,13,m).save();
		getMonster("spider",120,12,13,m).save();
		getMonster("spider",120,13,13,m).save();
		getMonster("spider",120,14,14,m).save();
		getMonster("spider",120,15,14,m).save();
		getMonster("spider",120,16,16,m).save();
	}

}
