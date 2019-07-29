/************************************************************************************
 * @file QueryResultDAO.java
 *
 * @author  Michael Mazzone
 */

package com.dbtermproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/************************************************************************************
 * This class provides access to the database using JDBC.
 * ArrayLists are used in JSP files to display relevant data.
 */
public class QueryResultDAO {
	
	static final String url = "jdbc:mysql://localhost/facebookaddata?"
			+ "useUnicode=true&"
			+ "useJDBCCompliantTimezoneShift=true&"
			+ "useLegacyDatetimeCode=false&"
			+ "serverTimezone=EST";
	private String user = "root";
	private String pass = "pass";
	private Connection connection;
	
	/********************************************************************************
     * Query 1: List entity and total impressions
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listAllEntitiesAndImpressions() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT advertiser, SUM(impressions) AS impressions\n" + 
					"FROM advertisement, entity\n" + 
					"WHERE ad_id = entity_id\n" + 
					"GROUP BY advertiser\n" + 
					"ORDER BY impressions DESC;");
			while(resultSet.next()) {
				String advertiser = resultSet.getString("advertiser");
				int impressions   = resultSet.getInt("impressions");
				QueryResult tuple = new QueryResult();
				tuple.setAdvertiserName(advertiser);
				tuple.setAdImpressions(impressions);
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return tuples;
	}
	
	/********************************************************************************
     * Query 2: List entity and the ads they pay for
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listAllEntitiesAndTheirAds() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT DISTINCT title, paid_for_by\n" + 
					"FROM advertisement, entity\n" + 
					"WHERE ad_id = entity_id\n" + 
					"	AND title <> paid_for_by\n" + 
					"ORDER BY paid_for_by ASC;");
			while(resultSet.next()) {
				String paidForBy = resultSet.getString("paid_for_by");
				String title   = resultSet.getString("title");
				QueryResult tuple = new QueryResult();
				tuple.setAdTitle(title);
				tuple.setPaidForBy(paidForBy);
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		disconnect();

		return tuples;
	}
	
	/********************************************************************************
     * Query 3: List ads by entity and the number of impressions per ad
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listAllAdsAndImpressions() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT DISTINCT title, paid_for_by, SUM(impressions) AS impressions\n" + 
					"FROM advertisement, entity\n" + 
					"WHERE ad_id = entity_id\n" + 
					"	AND title <> paid_for_by\n" + 
					"GROUP BY title, paid_for_by\n" + 
					"ORDER BY paid_for_by ASC;");
			while(resultSet.next()) {
				String title   = resultSet.getString("title");
				String paidForBy = resultSet.getString("paid_for_by");
				int impressions = resultSet.getInt("impressions");
				QueryResult tuple = new QueryResult();
				tuple.setAdTitle(title);
				tuple.setPaidForBy(paidForBy);
				tuple.setAdImpressions(impressions);
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		disconnect();

		return tuples;
	}

	/********************************************************************************
     * Query 4: List companies and their target audience
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listTargetAudiences() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT DISTINCT advertiser, targets\n" + 
					"FROM entity, meta_info\n" + 
					"WHERE entity_id = meta_id\n" + 
					"	AND targets <> \"\";");
			while(resultSet.next()) {
				String advertiser = resultSet.getString("advertiser");
				String targets   = resultSet.getString("targets");
				QueryResult tuple = new QueryResult();
				tuple.setAdvertiserName(advertiser);
				tuple.setAdTargets(targets);
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		disconnect();

		return tuples;
	}

	/********************************************************************************
     * Query 5: Show proportion of all ads an entity is responsible for
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listEntityAdProportions() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT advertiser, (COUNT(entities)/9802)*100 AS proportion\n" + 
					"FROM advertisement, entity\n" + 
					"WHERE ad_id = entity_id\n" + 
					"GROUP BY advertiser\n" + 
					"ORDER BY proportion DESC;");
			while(resultSet.next()) {
				String advertiser = resultSet.getString("advertiser");
				double proportion   = resultSet.getDouble("proportion");
				QueryResult tuple = new QueryResult();
				tuple.setAdvertiserName(advertiser);
				tuple.setProportionOfImpressions(proportion);
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		disconnect();

		return tuples;
	}
	
	/********************************************************************************
     * Query 6: Rank entities by average proportion of political/not_political
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listEntitiesRankedByPoliticalness() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT advertiser, AVG(political)/AVG(not_political) AS politicalProbability\n" + 
					"FROM politicalness, entity\n" + 
					"WHERE political_id = entity_id\n" + 
					"	AND political <> 0 AND not_political <> 0\n" + 
					"GROUP BY advertiser\n" + 
					"ORDER BY politicalProbability DESC;");
			while(resultSet.next()) {
				String advertiser = resultSet.getString("advertiser");
				double politicalProbability   = resultSet.getDouble("politicalProbability");
				QueryResult tuple = new QueryResult();
				tuple.setAdvertiserName(advertiser);
				tuple.setPoliticalProbability(politicalProbability);
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		disconnect();

		return tuples;
	}
	
	// TODO: make this take an input
	/********************************************************************************
     * Query 7: List all ads within a date range
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listAdsWithinDateRange() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT title, created, impressions\n" + 
					"FROM meta_info,advertisement\n" + 
					"WHERE meta_id = ad_id\n" + 
					"AND LOCATE('2018-10-06',created);");
			while(resultSet.next()) {
				String title = resultSet.getString("title");
				String created = resultSet.getString("created");
				int impressions = resultSet.getInt("impressions");
				QueryResult tuple = new QueryResult();
				tuple.setAdTitle(title);
				tuple.setCreatedDate(created);
				tuple.setAdImpressions(impressions);
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		disconnect();

		return tuples;
	}

	/********************************************************************************
     * Query 8: List well-known entities and compare their total impressions to 
     *          average of all entities
     * @return  the set of tuples matching the query
     */
	public ArrayList<QueryResult> listWellKnownImpressions() {
		connect();
		ArrayList<QueryResult> tuples = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			statement.execute("" +
					"CREATE TABLE IF NOT EXISTS temp1 AS (\n" + 
					"SELECT AVG(impressions) AS totalAverageImpressions\n" + 
					"FROM advertisement);\n" + 
					"\n" + 
					"CREATE TABLE IF NOT EXISTS temp2 AS (\n" + 
					"SELECT DISTINCT advertiser, AVG(impressions) AS avgImpressions\n" + 
					"FROM entity, advertisement, temp1\n" + 
					"WHERE entity_id = ad_id\n" + 
					"GROUP BY advertiser\n" + 
					"ORDER BY AVG(impressions) DESC);");
			ResultSet resultSet = statement.executeQuery("" +
					"SELECT *\n" + 
					"FROM temp2, temp1;");
			while(resultSet.next()) {
				String advertiser = resultSet.getString("advertiser");
				double avgImpressions   = resultSet.getDouble("avgImpressions");
				double avgTotalImpressions = resultSet.getDouble("totalAverageImpressions");
				QueryResult tuple = new QueryResult();
				tuple.setAdvertiserName(advertiser);
				tuple.setAvgImpressions(avgImpressions);
				tuple.setAvgTotalImpressions(avgTotalImpressions);
				
				tuples.add(tuple);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		disconnect();

		return tuples;
	}
	
	/********************************************************************************
     * Connect to the database using JDBC.
     */
	public void connect() {
		try {
			System.out.println("Connecting...");
			if(connection == null || connection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, pass);
				System.out.println("MySQL connection established!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/********************************************************************************
     * Disconnect from the database.
     */
	public void disconnect() {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
