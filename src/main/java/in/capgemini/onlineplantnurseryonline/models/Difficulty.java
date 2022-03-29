package in.capgemini.onlineplantnurseryonline.models;

import java.io.Serializable;

public enum Difficulty implements Serializable{
    EASY, MEDIUM, HARD;	
	public String getStatus() {
		return this.name();
	}
}