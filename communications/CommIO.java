package communications;

public interface CommIO <iPtype> {
	public void pushToFile();
	iPtype getByID(long ID);
}
