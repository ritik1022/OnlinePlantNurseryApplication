package in.capgemini.onlineplantnurseryonline.models;

import java.io.Serializable;

public enum BloomTime implements Serializable {
	  WINTER, SUMMER, AUTUMN, MONSOON;
	
		public String getStatus() {
			return this.name();
		}
}