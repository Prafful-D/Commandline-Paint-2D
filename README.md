# CommandPaint
Small utility to draw on 2-D array.

Build
- Clean and build application with maven. 
- mvn clean install

Execute
- Run Application.java

Execute commands,

- Create canvas command 'C' 
  - Syntax : C x y
  - where x is width and y is height of 2-D canvas
  - eg. C 20 4

- Draw line command 'D'
  - Syntax : L x1 y1 x2 y2
  - where x1 & y1 are starting co-ordinates and x2, y2 are ending co-cordinates 
  - eg. L 1 2 6 2

- Draw rectangle command 'R'
  - Syntax : R x1 y1 x2 y2
  - Where x1, y1 are bottom left co-ordinates and x2,y2 are top right co-ordinates of rectangle
  - eg. R 14 1 18 3

- Fill command 'B'
  - B x y c
  - where x and y are point from where filling in canvas start and will stop where ever it finds already paint done. Similar to fill command in Windows paint.
  - c is any character to be filled with
  - eg. B 10 3 o

Create your own commands by extenting Paint.java and registering the same in main class.

Happy Coding.
