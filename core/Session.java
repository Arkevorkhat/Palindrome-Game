package core;

import java.time.*;
import java.time.temporal.Temporal;
import java.util.Random;

public class Session {
	public Session(String UN, long LT) {
		Random r = new Random();
		SessionID =r.nextLong();
		username = UN;
		dura = Duration.ofMinutes(LT);
		createTime = LocalTime.now();
		
	}
	private final long SessionID;
	private final String username;
	private final Duration dura;
	private final LocalTime createTime;
	public long getSessID() {
		return this.SessionID;
	}
	public String getUN() {
		return this.username;
	}
	public LocalTime getCreateTime() {
		return this.createTime;
	}
	public Duration getLifeTime() {
		return this.dura;
	}
	public Temporal getTimeRemaining() {
		return dura.subtractFrom(createTime);
	}
}