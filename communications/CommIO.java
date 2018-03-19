package communications;

public interface CommIO <iPtype> {
	public void pushToTree();
	iPtype getByID(long ID);
}
