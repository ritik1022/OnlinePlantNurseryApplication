package in.capgemini.onlineplantnurseryonline.exception;

public class PlanterIdExceptionResponse {
	
	 private String planterId;

	  public PlanterIdExceptionResponse(String planterId) {
	    super();
	    this.planterId = planterId;
	  }

	  public String getplanterId() {
	    return planterId;
	  }

	  public void setplanterId(String planterId) {
	    this.planterId = planterId;
	  }

}
