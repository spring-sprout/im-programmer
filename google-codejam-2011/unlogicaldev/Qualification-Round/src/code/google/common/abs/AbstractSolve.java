package code.google.common.abs;

public abstract class AbstractSolve implements Runnable {
	
	protected String input;
	protected int seq;
	
	public AbstractSolve(){
	}
	
	public AbstractSolve(String input, int seq){
		this.input = input;
		this.seq = seq;
	}
	

	/**
	 * 문제풀기 A
	 * @param p
	 */
	abstract public void solve();
	
	
	@Override
	public void run() {
		solve();
	}

}
