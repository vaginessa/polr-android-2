# Programming Kata - Path of Least Resistance

## The Challenge
Energy flows through the path of least resistance. For this challenge, you are provided a grid of integers where each integer represents the amount of resistance encountered at a given point on the grid. Energy enters the grid from the left (at any point) and passes through the grid to the right, moving only one column per round.

Movement is always to an adjacent row, meaning energy can flow horizontally or diagonally. For the sake of this challenge, we assume the first and last row are also adjacent. Effectively, the grid “wraps”.

The total resistance of a path is the sum of the integers in each of the visited cells. The solution needs to handle grids of various sizes with a minimum of 1 row and 5 columns up to 10 rows and 100 columns. If in the next move, the total resistance will exceed 50, the energy cannot continue.

The purpose of this challenge is to find the path of least resistance (that is, the path with the lowest total resistance). The paths of least resistance through two slightly different 5 x 6 grids are shown below. The grid values differ only in the bottom row. The path for the grid on the right takes advantage of the adjacency between the first and last rows.

## Input
The input consists of a sequence of row specifications. Each row is represented by a series of delimited integers on a single line. Note: integers are not restricted to being positive.

## Output
Three lines should be output for each matrix specification. The first line is either “Yes” or “No” to indicate the water made it all the way through the grid. The second line is the total resistance. The third line shows the path taken as a sequence of n delimited integers, each representing the rows traversed in turn. If there is more than one path of least resistance, only one path need be shown in the solution.

# Build and Run

## As a Java class with a main method
The application can be built from the command line using gradle as follows: 
```
./gradlew clean test
```
You can then run it as follows:
```
java -cp ./app/build/intermediates/classes/debug com.jgodha.android.pathofleastresistance.PathOfLeastResistanceMain "3 4 1 2 8 6;6 1 8 2 7 4;5 9 3 9 9 5;8 4 1 3 2 6;3 7 2 8 6 4"
```
It will produce the output as follows:
```
RESULT
Complete: Yes
Cost: 16
Rows visited: 1 2 3 4 4 5
```


## As an Android App
The app has been developed in Android Studio 2.1.2 with Android 6.0 (API 23) SDK and Java 8 (jdk1.8.0_91). It has been tested with Nexus 5S API 23 emulator.
To run the app, open the PathOfLeastResistance project in Android Studio and click Run (green arrow) in the Toolbar for the 'app' configuration.

#Screenshots
![start_app](https://github.com/jgodha/polr-android/blob/master/app/src/main/res/screenshots/start_app.png)
![data_entry](https://github.com/jgodha/polr-android/blob/master/app/src/main/res/screenshots/data_entry.png)
![click_go](https://github.com/jgodha/polr-android/blob/master/app/src/main/res/screenshots/click_go.png)
![output](https://github.com/jgodha/polr-android/blob/master/app/src/main/res/screenshots/output.png)
