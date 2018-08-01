package com.ittest.hashMap;

public class TestThread {
	
	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					bussiness.subMethod();
				}
			}
		}).start();
		
		for (int i = 0; i < 3; i++) {
			bussiness.mainMethod();
		}
		
	}
	
}
