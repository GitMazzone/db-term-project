/************************************************************************************
 * @file QueryResult.java
 *
 * @author  Michael Mazzone
 */

package com.dbtermproject;

/************************************************************************************
 * This class provides an object to store data queried from the database.
 */
public class QueryResult {
	
	// Advertisement attributes
	private String adTitle;
	private String adMessage;
	private int    adImpressions;

	// Entity attributes
	private String advertiserName;
	private String entities;
	private String paidForBy;
	
	// Meta info attributes
	private String adThumbnail;
	private String createdDate;
	private String updatedDate;
	private String adPage;
	private String adTargets;
	
	// Politicalness attributes
	private int    political;
	private int    notPolitical;
	private double politicalProb;
	
	private double proportionOfImpressions;
	private double avgImpressions;
	private double avgTotalImpressions;
	private double marketCap;
	
	// Constructors *********************************************************************
	// **********************************************************************************
	
	/************************************************************************************
	 * Empty constructor -- everything set to empty string or 0
	 */
	public QueryResult() {
		this.adTitle = "";
		this.adMessage = "";
		this.adImpressions = 0;
		this.advertiserName = "";
		this.entities = "";
		this.paidForBy = "";
		this.adThumbnail = "";
		this.createdDate = "";
		this.updatedDate = "";
		this.adPage = "";
		this.adTargets = "";
		this.political = 0;
		this.notPolitical = 0;
		this.politicalProb = 0.0;
	}

	/************************************************************************************
	 * Full set of attributes
	 */
	public QueryResult(String adTitle, String adMessage, int adImpressions,
			String advertiserName, String entities, String paidForBy,
			String adThumbnail, String createdDate, String updatedDate,
			String adPage, String adTargets, int political, int notPolitical,
			double politicalProb) {
		this.adTitle        = adTitle;
		this.adMessage      = adMessage;
		this.adImpressions  = adImpressions;
		this.advertiserName = advertiserName;
		this.entities       = entities;
		this.paidForBy      = paidForBy;
		this.adThumbnail    = adThumbnail;
		this.createdDate    = createdDate;
		this.updatedDate    = updatedDate;
		this.adPage         = adPage;
		this.adTargets      = adTargets;
		this.political      = political;
		this.notPolitical   = notPolitical;
		this.politicalProb  = politicalProb;
	}

	// End constructors *****************************************************************
	// **********************************************************************************

	public String getAdTitle() {
		return adTitle;
	}
	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}
	public String getAdMessage() {
		return adMessage;
	}
	public void setAdMessage(String adMessage) {
		this.adMessage = adMessage;
	}
	public int getAdImpressions() {
		return adImpressions;
	}
	public void setAdImpressions(int adImpressions) {
		this.adImpressions = adImpressions;
	}
	public String getAdvertiserName() {
		return advertiserName;
	}
	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}
	public String getEntities() {
		return entities;
	}
	public void setEntities(String entities) {
		this.entities = entities;
	}
	public String getPaidForBy() {
		return paidForBy;
	}
	public void setPaidForBy(String paidForBy) {
		this.paidForBy = paidForBy;
	}
	public String getAdThumbnail() {
		return adThumbnail;
	}
	public void setAdThumbnail(String adThumbnail) {
		this.adThumbnail = adThumbnail;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getAdPage() {
		return adPage;
	}
	public void setAdPage(String adPage) {
		this.adPage = adPage;
	}
	public String getAdTargets() {
		return adTargets;
	}
	public void setAdTargets(String adTargets) {
		this.adTargets = adTargets;
	}
	public int getPolitical() {
		return political;
	}
	public void setPolitical(int political) {
		this.political = political;
	}
	public int getNotPolitical() {
		return notPolitical;
	}
	public void setNotPolitical(int notPolitical) {
		this.notPolitical = notPolitical;
	}
	public double getPoliticalProbability() {
		return politicalProb;
	}
	public void setPoliticalProbability(double politicalProbability) {
		this.politicalProb = politicalProbability;
	}

	public double getProportionOfImpressions() {
		return proportionOfImpressions;
	}

	public void setProportionOfImpressions(double proportionOfImpressions) {
		this.proportionOfImpressions = proportionOfImpressions;
	}

	public double getAvgImpressions() {
		return avgImpressions;
	}

	public void setAvgImpressions(double avgImpressions) {
		this.avgImpressions = avgImpressions;
	}

	public double getAvgTotalImpressions() {
		return avgTotalImpressions;
	}

	public void setAvgTotalImpressions(double avgTotalImpressions) {
		this.avgTotalImpressions = avgTotalImpressions;
	}

	public double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}
	
}
