package core;

import java.util.Random;

public class Session {
	public Session(String UN, long LT) {
		Random r = new Random();
		SessionID =r.nextLong();
		username = UN;
		timeStart = System.currentTimeMillis();
		lifeTime = LT;
	}
	private final long SessionID;
	private final String username;
	private final long timeStart;
	private final long lifeTime;
	public long getSessID() {
		return this.SessionID;
	}
	public String getUN() {
		return this.username;
	}
	public long getLoginTime() {
		return this.timeStart;
	}
	public long getLifeTime() {
		return this.lifeTime;
	}
	public long getTimeRemainingMillis() {
		return getLoginTime()-getLifeTime();
	}
}
