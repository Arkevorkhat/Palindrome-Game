package backEnd;

import java.time.*;
import java.time.temporal.Temporal;
import java.util.Random;

public class Session {
	public Session(String UN, long LT) {
		/*
		 * UN needs to be present and correct, if passed an invalid username, the user
		 * currently logged in will be booted back out to the login screen, LT can
		 * either be long minutes, or 0, if 0, the default session lifetime is 3 hours.
		 */
		Random r 	 = new Random();
		SessionID    = r.nextLong();
		username     = UN;
		dura         = Duration.ofMinutes(LT == 0 ? 160l : LT);
		creationTime = LocalTime.now();

	}

	private final long SessionID;
	private final String username;
	private final Duration dura;
	private final LocalTime creationTime;

	public long getSessID() {
		return this.SessionID;
	}

	public String getUN() {
		return this.username;
	}

	public LocalTime getCreateTime() {
		return this.creationTime;
	}

	public Duration getLifeTime() {
		return this.dura;
	}

	public Temporal getTimeRemaining() {
		return dura.subtractFrom(creationTime);
	}
}