package me.jiangliwu.EARServer.npc;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.junit.Test;

public class NpcServiceTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		NpcService npc = new  NpcService();
		npc.getNpcByMap(null, new JSONArray().put(0));
	}

}
