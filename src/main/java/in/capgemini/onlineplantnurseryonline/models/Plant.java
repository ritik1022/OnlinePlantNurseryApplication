

package in.capgemini.onlineplantnurseryonline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
@Entity
public class Plant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="plant_Id")
	private int plantId;
	
	@NotBlank(message="name can not be empty")
	@Column(name="common_Name",updatable = false,unique=true)
	private String commonName;
	
	@Column(name="bloom_Time")
	@Enumerated(EnumType.STRING)
	private BloomTime bloomTime;
	
	@Column(name="plant_Spread")
	private String plantSpread;
	
	@Column(name="medical_Use")
	private String medicalOrCulinaryUse;
	
	@Column(name="difficulty_Level")
	@Enumerated(EnumType.STRING)
	private Difficulty difficultyLevel;

	@Column(name="temperature")
	private String temperature;
	
	@Column(name="types_Of_Plant")
	private String typesOfPlant;
	
	@Column(name="plant_Description")
	private String plantDescription;
	
	@Column(name="plant_Stock")
	@PositiveOrZero(message="Stock should be positive or zero")
	private int plantStock;
	
	@Column(name="cost")
	@Positive(message="Cost should be Positive")
	private double plantCost;
	
	@Column(name="plant_Height")
	@NotNull@Positive(message="Height per packet should be positive ")
	private int plantHeight;
	
	
	public Plant() {
		super();
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int seedId) {
		this.plantId = seedId;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	
	public BloomTime getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(BloomTime bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getWatering() {
		return plantSpread;
	}
	public void setWatering(String watering) {
		this.plantSpread = watering;
	}
	
	public Difficulty getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(Difficulty difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getTypesOfSeeds() {
		return typesOfPlant;
	}
	public void setTypesOfSeeds(String typesOfSeeds) {
		this.typesOfPlant = typesOfSeeds;
	}
	public String getSeedsDescription() {
		return plantDescription;
	}
	public void setSeedsDescription(String seedsDescription) {
		this.plantDescription = seedsDescription;
	}
	public int getSeedsStock() {
		return plantStock;
	}
	public void setSeedsStock(int seedsStock) {
		this.plantStock = seedsStock;
	}
	public double getSeedsCost() {
		return plantCost;
	}
	public void setSeedsCost(double seedsCost) {
		this.plantCost = seedsCost;
	}
	public int getSeedsPerPacket() {
		return plantHeight;
	}
	public void setSeedsPerPacket(int seedsPerPacket) {
		this.plantHeight = seedsPerPacket;
	}
	public String getMedicalOrCulinaryUse() {
		return medicalOrCulinaryUse;
	}
	public void setMedicalOrCulinaryUse(String medicalOrCulinaryUse) {
		this.medicalOrCulinaryUse = medicalOrCulinaryUse;
	}
	
	
}

