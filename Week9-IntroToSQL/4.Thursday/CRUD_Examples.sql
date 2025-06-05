CREATE TABLE Trainers (
	TrainerID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Region VARCHAR(50)
);

INSERT INTO Trainers (Name, Region)
VALUES ('Ash Ketchum', 'Kanto');

INSERT INTO Trainers (Name, Region)
VALUES ('Misty', 'Cerulean');

CREATE TABLE Pokemon(
	PokemonID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(50),
    Level INT,
    TrainerID INT,
    FOREIGN KEY (TrainerID) REFERENCES Trainers(TrainerID)
);

-- lets add some pokemon to the table

INSERT INTO Pokemon (Name, Type, Level, TrainerID)
VALUES ('Pikachu', 'Electric', 25, 1),
       ('Bulbasaur', 'Grass', 15, 1),
       ('Psyduck', 'Water', 18, 2);
       
DELETE FROM Pokemon
WHERE PokemonID = 3;

UPDATE Pokemon
SET Level = Level + 1
WHERE PokemonID = 1;