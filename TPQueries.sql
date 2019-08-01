
-- Query 1:
SELECT advertiser, SUM(impressions) AS impressions
FROM advertisement, entity
WHERE ad_id = entity_id
GROUP BY advertiser
ORDER BY impressions DESC;

-- Query 2:
SELECT DISTINCT title, paid_for_by
FROM advertisement, entity
WHERE ad_id = entity_id
	AND title <> paid_for_by
ORDER BY paid_for_by ASC;

-- Query 3: 
SELECT DISTINCT title, paid_for_by, SUM(impressions) AS impressions
FROM advertisement, entity 
WHERE ad_id = entity_id
	AND title <> paid_for_by
GROUP BY title, paid_for_by
ORDER BY paid_for_by ASC;

-- Query 4: 
SELECT DISTINCT advertiser, targets
FROM entity, meta_info
WHERE entity_id = meta_id 
	AND targets <> "";

-- Query 5: 
SELECT advertiser, (COUNT(entities)/9802)*100 AS proportion
FROM advertisement, entity
WHERE ad_id = entity_id
GROUP BY advertiser
ORDER BY proportion DESC;

-- Query 6:
SELECT advertiser, AVG(political)/AVG(not_political) AS politicalProbability
FROM politicalness, entity
WHERE political_id = entity_id
	AND political <> 0 AND not_political <> 0
GROUP BY advertiser
ORDER BY politicalProbability DESC;
					
-- Query 7: 
SELECT title, created, impressions
FROM meta_info,advertisement
WHERE meta_id = ad_id
	AND LOCATE('2018-10-06',created);

-- Query 8:
CREATE TABLE IF NOT EXISTS temp1 AS 
SELECT AVG(impressions) AS totalAverageImpressions 
FROM advertisement); 

CREATE TABLE IF NOT EXISTS temp2 AS 
SELECT DISTINCT advertiser, AVG(impressions) AS avgImpressions  
FROM entity, advertisement, temp1 
WHERE entity_id = ad_id 
GROUP BY advertiser 
ORDER BY AVG(impressions) DESC);

SELECT * 
FROM temp2, temp1;

-- Query 9: 
CREATE TABLE IF NOT EXISTS temp1table AS 
SELECT AVG(impressions) AS totalAverageImpressions 
FROM advertisement;

CREATE TABLE IF NOT EXISTS temp22table AS 
SELECT advertiser, market_cap, AVG(impressions) AS avgImpressions 
FROM entity, advertisement, temp1table, publicly_traded_entity  
WHERE entity_id = ad_id 
	AND publicly_traded_name = advertiser 
GROUP BY advertiser, market_cap 
ORDER BY market_cap DESC;
					
SELECT * 
FROM temp22table, temp1table;
					
					
					