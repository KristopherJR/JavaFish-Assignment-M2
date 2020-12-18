PROJECT TITLE: COMP2431 Object Oriented Design & Development, Milestone 2 Assignment
PURPOSE OF PROJECT: My assignment 1 Milstone 2 submission for the JavaFish project, utilizes the JavaFish2 framework provided by Dr Marc Price.
VERSION or DATE: 18-12-2020
AUTHORS: Marc Price & Kristopher Randle
VERSION NOTES:

Version: 18-12-2020 saw a great deal of changes. Firstly, Urchins have been added that scuttle across the bottom of the aquarium with a random speed 
between the client range, and scale. To stop them receiving a random location, the setPosition() method in Pet has been overridden for them so they 
can sit at the bottom. Urchin has also received a Test Class. The minimum client brief has now been completely satisfied with the correct number of 
moving tokens. There are SeaHorses, Urchins and JavaFish, with the JavaFish all emitting their own bubbles. Bubbles float past the top of the aquarium 
then reset back to their emitting JavaFish’s mouth. All of the subclasses of Pet also gain random bursts of speed, satisfying one of the client’s optional 
criteria. The previously deleted Boolean ‘direction’ which was not needed in the previous version, was re-added to properly reset the bubbles on the 
JavaFish’s mouths. All Test Classes validateSpeed() method have been updated into two methods, that validateXSpeed() and validateYSpeed(). 

Summary of changes:
1.	Created class ‘Urchin’
2.	Create test class ‘UrchinTest’
3.	Overrode Pets() setPosition() method so that ‘Urchin’ objects are not randomly assigned a position and can sit at the bottom of the aquarium.
4.	Added a total of at least 10 moving tokens, satisfying the clients minimum brief (4 JavaFish, 4 SeaHorse, 3 Urchin)
5.	Created class ‘Bubble’
6.	Re-added Boolean ‘direction’, refactored it into Pets ‘inBounds()’ method
7.	Added ‘resetBubbles()’ in ‘Simulation’ class, which makes use of the re-added Boolean ‘direction’.
8.	Created methods ‘generateRandomXSpeed()’ and ‘generate RandomYSpeed()’ – which are used to create the random bursts of movements in Pet tokens.
9.	Further tidied up commenting and code layout.
