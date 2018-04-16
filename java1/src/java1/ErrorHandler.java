package java1;

public class ErrorHandler {
	
	public void errorHasOccured(Exception e, String eMess) {
		System.out.println(eMess);
		System.out.println(e.getMessage());
	}

}
