/*Question 4 Queries:*/

a.)SELECT * FROM Restaurant R,Location L 
WHERE R.RestaurantID = restaurant_var AND R.RestaurantID=L.RestaurantID; /* The restaurant_var is the restaurant user chose*/

b.)SELECT *FROM MenuItem M
WHERE M.RestaurantID = restaurant_var 
ORDER BY Category;

c.)SELECT L.ManagerName,L.FirstOpenDate FROM Location L, MenuItem M
WHERE Category = user_var;

d.)Select RestaurantID FROM Restaurant
WHERE RestaurantName = rest_name;

SELECT M.max(price),L.hourOpen,L.ManagerName,R.Url FROM Location L,Restaurant R,MenuItem M
WHERE R.RestaurantID = rest_var;

e.)
SELECT M.Type,AVG(M.price) FROM MenuItem
GROUP BY M.Type
UNION ALL
SELECT M.Category,AVG(M.price) FROM MenuItem
GROUP BY M.Category

f.) SELECT RATER.NAME, RESTAURANT.NAME, COUNT(RATING.*) AS ratings FROM (RATER INNER JOIN RATING ON RATER.UserID=RATING.UserID) INNER JOIN RESTAURANT ON RATING.RestaurantID=RESTAURANT.RestaurantID
GROUP BY RATER.NAME, RESTAURANT.NAME ORDER BY RATER.NAME

g.)
restId=SELECT R.RestaurantID FROM Restaurant R, Rating T/*Two queries for this question save answer from first query and then use it for query two*/
WHERE T.Date !='/01' 

SELECT R.RestaurantName,R.Url,R.Type FROM Restaurant R,Rating T
WHERE R.RestaurantID = restId;

h.)
SELECT R.NAME, L.FIRST_OPENED FROM RESTAURANT R, LOCATION L WHERE
  R.RestaurantID IN (SELECT RestaurantID FROM RATING WHERE R.RestaurantID=RestaurantID 
					AND STAFF < (SELECT MIN(STAFF) FROM RATING WHERE UserID='100002')
					AND STAFF < (SELECT MIN(FOOD) FROM RATING WHERE UserID='100002')
					AND STAFF < (SELECT MIN(MOOD) FROM RATING WHERE UserID='100002')
					AND STAFF < (SELECT MIN(PRICE) FROM RATING WHERE UserID='100002')) 
  AND R.RestaurantID = L.RestaurantID;

i.)SELECT RESTAURANT.NAME, RATER.NAME FROM (RESTAURANT INNER JOIN RATING ON RESTAURANT.RestaurantID=RATING.RestaurantID) INNER JOIN RATER ON RATING.UserID=RATER.UserID
	WHERE FOOD = (SELECT MAX(FOOD) FROM RATING)
	AND RES_TYPE='Canadian'
	GROUP BY RATER.NAME, RESTAURANT.NAME ORDER BY RATER.NAME
j.)SELECT RES_TYPE FROM RESTAURANT GROUP BY RES_TYPE,RestaurantID ORDER BY (SELECT SUM(FOOD+MOOD+STAFF+PRICE) FROM RATING WHERE RATING.RestaurantID=RESTAURANT.RestaurantID)

k) SELECT Rater.names, Rater.join-date, Rater.reputations, Rating.Food, Rating.Mood, Resteraunt.Name, Rating.Date
   FROM Rater R1, Rating R2, Resteraunt R3
   WHERE R2.Food = 5 AND R2.Mood = 5
l) SELECT Rater.names, Rater.reputations, Rating.Food, Rating.Mood, Resteraunt.Name, Rating.Date
   FROM Rater R1, Rating R2, Resteraunt R3
   WHERE R2.Food = 5 AND R2.Mood = 5
n) SELECT NAME, EMAIL FROM RATER INNER JOIN RATING ON RATING.UserID=RATER.UserID 
WHERE PRICE+MOOD+FOOD+STAFF < (SELECT MIN(PRICE+MOOD+FOOD+STAFF) FROM RATING WHERE UserID IN (SELECT UserID FROM RATER WHERE NAME='John'))
GROUP BY RATER.UserID



