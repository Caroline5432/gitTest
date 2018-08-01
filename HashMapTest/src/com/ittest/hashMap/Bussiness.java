package com.ittest.hashMap;

public class Bussiness {

	private boolean flag = true;

	public synchronized void mainMethod() {

		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + "main thread running loop count --" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		flag = true;
		notify();

	}

	public synchronized void subMethod() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + "sub thread running loop count --" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		flag = false;
		notify();
	}

}
