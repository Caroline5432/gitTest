package com.ittest.hashMap;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		HashMap<Integer,User> users = new HashMap<>();
		users.put(1, new User("张三",25));
		users.put(2, new User("李四",22));
		users.put(3, new User("王五",28));
		
		System.out.println(users);
		
		HashMap<Integer, User> users2 = sortHashMap(users);
		
		System.out.println(users2);
		
		System.out.println("git测试2");
		
	}
	
	public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
		
		//获得键值对集合
		Set<Entry<Integer,User>> entrySet = map.entrySet();
		//将set集合转成list集合
		ArrayList<Entry<Integer,User>> list = new ArrayList<Entry<Integer, User>>(entrySet);
		Collections.sort(list, new Comparator<Entry<Integer,User>>() {

			@Override
			public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2) {
				
				System.out.println(o2.getValue().getAge()-o1.getValue().getAge());
				
				return o1.getValue().getAge()-o2.getValue().getAge();
			}
		});
		
		LinkedHashMap<Integer,User> linkedHashMap = new LinkedHashMap<>();
		for (Entry<Integer, User> entry : list) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		
		return linkedHashMap;
	}

}
