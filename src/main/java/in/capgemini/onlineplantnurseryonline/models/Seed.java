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
public class Seed {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="seed_Id")
	private int seedId;
	
	@NotBlank(message="name can not be empty")
	@Column(name="common_Name",updatable = false,unique=true)
	
	private String commonName;
	
	@Column(name="bloom_Time")
	@Enumerated(EnumType.STRING)
	private BloomTime bloomTime;
	
	@Column(name="watering")
	private String watering;
	@Column(name="difficulty_Level")
	@Enumerated(EnumType.STRING)
	private Difficulty difficultyLevel;

	@Column(name="temperature")
	private String temperature;
	
	@Column(name="typesOfSeeds")
	private String typesOfSeeds;
	@Column(name="seed_Description")
	private String seedsDescription;
	@Column(name="seeds_Stock")
	@PositiveOrZero(message="Stock should be positive or zero")
	private int seedsStock;
	@Column(name="cost")
	@Positive(message="Cost should be Positive")
	private double seedsCost;
	@Column(name="seedsPerPacket")
	@NotNull@Positive(message="Seeds per packet should be positive ")
	private int seedsPerPacket;
	
	public Seed() {
		super();
	}
	public int getSeedId() {
		return seedId;
	}
	public void setSeedId(int seedId) {
		this.seedId = seedId;
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
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
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
		return typesOfSeeds;
	}
	public void setTypesOfSeeds(String typesOfSeeds) {
		this.typesOfSeeds = typesOfSeeds;
	}
	public String getSeedsDescription() {
		return seedsDescription;
	}
	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}
	public int getSeedsStock() {
		return seedsStock;
	}
	public void setSeedsStock(int seedsStock) {
		this.seedsStock = seedsStock;
	}
	public double getSeedsCost() {
		return seedsCost;
	}
	public void setSeedsCost(double seedsCost) {
		this.seedsCost = seedsCost;
	}
	public int getSeedsPerPacket() {
		return seedsPerPacket;
	}
	public void setSeedsPerPacket(int seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}
	
	
}
