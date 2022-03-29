package in.capgemini.onlineplantnurseryonline.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planter {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long planterId;
	private float planterheight;
	private int planterCapacity;
	private int drainageHoles;
	private String planterColor;
	private String planterShape;	
	private int planterStock;
	private int planterCost;
	/*	private Plants plants;
	private Seeds seeds;*/
	
	public Planter() {
		
	}
	
	public Planter(long planterId, float planterheight, int planterCapacity, int drainageHoles, String planterColor, String planterShape, int planterStock, int planterCost) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drainageHoles = drainageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
	}
	public long getPlanterId() {
		return planterId;
	}
	public void setPlanterId(long planterId) {
		this.planterId = planterId;
	}
	public float getPlanterheight() {
		return planterheight;
	}
	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}
	public int getPlanterCapacity() {
		return planterCapacity;
	}
	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}
	public int getDrainageHoles() {
		return drainageHoles;
	}
	public void setDrainageHoles(int drainageHoles) {
		this.drainageHoles = drainageHoles;
	}
	public String getPlanterColor() {
		return planterColor;
	}
	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}
	public String getPlanterShape() {
		return planterShape;
	}
	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}
	public int getPlanterStock() {
		return planterStock;
	}
	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}
	public int getPlanterCost() {
		return planterCost;
	}
	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}
/*	public Plants getPlants() {
		return plants;
	}
	public void setPlants(Plants plants) {
		this.plants = plants;
	}
	public Seeds getSeeds() {
		return seeds;
	}
	public void setSeeds(Seeds seeds) {
		this.seeds = seeds;
	}*/	

}
