# Custom Java Titled Bar
A customizable title bar API compatible with the native functions for Java Swing applications

![Demo of the project][Demo]

[Demo]: https://github.com/FredPerr/CustomJavaTitledBar/blob/master/src/main/resources/customtitlebar.png "Demo"

## Installation
####Local Integration
To implement the files of this project into your own project, you can simply clone this repository and add the package `titlebar` into your source files.
This project is not accessible via Maven yet...

## Usage
To create the JFrame, we use the class `TBJFrame`:
```java
        TBJFrame frame = new TBJFrame("Demo", WindowFrameType.NORMAL, new DarkTBTheme());
```
We now add the base attributes of our frame as a `JFrame` would require:
```java
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);
```
It is possible to add an icon on the title bar with the following code:
```java
	// Load the image
        InputStream fis = getClass().getResourceAsStream("/test.png");
	// Set the icon
        frame.iconPanel.setIcon(ImageIO.read(fis));
```

As usual, we pack and display the frame with the following lines:
```java
	frame.pack();
	frame.setVisible(true);
```

## Layout
The components and the layout can be edited directly in the code of this repository, but by default the following layout is used:
![Layout of the title bar][DemoLayout]

[DemoLayout]: https://github.com/FredPerr/CustomJavaTitledBar/blob/master/src/main/resources/customtitlebar-layout.png "layout"

## Theme
This project supports theme creation for the any newly created `TBJFrame`.
A default dark theme is built-in the project, but anyone can build his own theme by extending the `TBTheme` interface and use it when creating the `TBJFrame`. Editing the project to its core always remains an option for more control over the user interface. 
