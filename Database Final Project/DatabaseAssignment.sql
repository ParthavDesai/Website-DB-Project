
CREATE TABLE Rater(
UserID INTEGER,
Email VARCHAR,
Name VARCHAR,
JoinDate DATE,
Type VARCHAR,
Reputation INTEGER,
PRIMARY KEY(UserID),
CHECK (Reputation>=1 AND Reputation<=5),
CHECK(Type = 'blog' OR Type='online' OR Type = 'Food Critic')
);


CREATE TABLE Rating(
UserID INTEGER,
Date DATE,
Price NUMERIC(8,2),
Food INTEGER,
Mood INTEGER,
Comments INTEGER,
Staff INTEGER,
RestaurantID INTEGER,
PRIMARY KEY(Date,UserID),
FOREIGN KEY(UserID)
	REFERENCES Rater,
FOREIGN KEY(RestaurantID)
	REFERENCES Restaurant,
CHECK (Price>=1 AND Price<=5),
CHECK (Mood>=1 AND Mood<=5),
CHECK (Staff>=1 AND Staff<=5),
CHECK (Food>=1 AND Food<=5)
);

CREATE TABLE Restaurant(
RestaurantID INTEGER,
Name VARCHAR,
Type VARCHAR,
Url VARCHAR,
PRIMARY KEY(RestaurantID)
);

CREATE TABLE MenuItem(
ItemID INTEGER,
Name VARCHAR,
Type VARCHAR,
Category VARCHAR,
Description VARCHAR,
Price Numeric(8,2),
RestaurantID INTEGER,
PRIMARY KEY(ItemID),
FOREIGN KEY(RestaurantID)
	REFERENCES Restaurant,
CHECK(Type='Food'OR Type='Beverage'));

CREATE TABLE Location(
LocationID INTEGER,
FirstOpenDate DATE,
ManagerName VARCHAR,
PhoneNumber INTEGER,
StreetAddress VARCHAR,
hourOpen VARCHAR,
hourClosed VARCHAR,
RestaurantID INTEGER,
PRIMARY KEY(LocationID),
FOREIGN KEY(RestaurantID)
	REFERENCES Restaurant
);

CREATE TABLE RatingItem(
UserID INTEGER,
Date DATE,
ItemID VARCHAR,
Rating INTEGER,
Comment VARCHAR,
PRIMARY KEY(UserID, Date, ItemID),
CHECK(Rating>=1 AND Rating<=5)
);
