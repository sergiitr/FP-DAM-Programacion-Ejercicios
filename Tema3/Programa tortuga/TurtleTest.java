
/* 
 * Compilar: javac -cp turtleClasses.jar TurtleTest.java
 * Ejecutar: java -cp turtleClasses.jar:. TurtleTest
 * @author Sergio Trillo Rodriguez
 */
import java.awt.*;
import java.util.*;

public class TurtleTest {
    public static void main(String[] args) {
        World habitat = new World(600, 600);

        /**
         * Creamos la fila central de ciruclos
         * Fila de 4 circulos
         */
        Turtle yertle = new Turtle(habitat);
        Turtle yertle2 = new Turtle(habitat);
        Turtle yertle3 = new Turtle(habitat);
        Turtle yertle4 = new Turtle(habitat);

        /**
         * Creamos la fila de 3 ciruclos abajo de la central
         * Fila de 3 circulos
         */
        Turtle yertle5 = new Turtle(habitat);
        Turtle yertle6 = new Turtle(habitat);
        Turtle yertle7 = new Turtle(habitat);

        /**
         * Creamos creamos los vertices (tanto de arriba como de abajo)
         * Fila de 1 circulos
         */
        Turtle yertle8 = new Turtle(habitat);
        Turtle yertle9 = new Turtle(habitat);

        /**
         * Creamos la fila de 3 ciruclos arriba de la central
         * Fila de 3 circulos
         */
        Turtle yertle10 = new Turtle(habitat);
        Turtle yertle11 = new Turtle(habitat);
        Turtle yertle12 = new Turtle(habitat);



        for (int i=0; i<100; i++) {
            yertle.forward(i);
            yertle.turn(i);
        }
        yertle2.penUp();
        for (int i=0; i<75; i++)
            for(int j=0; j<300; j++)
                yertle2.moveTo(i,j);
            
        
        yertle2.penDown();
        for (int i=0; i<100; i++) {
            yertle2.forward(i);
            yertle2.turn(i);
        }

        yertle3.penUp();
        for (int i=0; i<325; i++)
            for(int j=0; j<300; j++)
                yertle3.moveTo(i,j);
        
        yertle3.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle3.backward(i);
            yertle3.turn(i);
        }


        yertle4.penUp();
        for (int i=0; i<250; i++)
            for(int j=0; j<300; j++)
                yertle4.moveTo(i,j);
        
        yertle4.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle4.backward(i);
            yertle4.turn(i);
        }
        
        // --------------
        yertle5.penUp();
        for (int i=0; i<212; i++)
            for(int j=0; j<375; j++)
            yertle5.moveTo(i,j);
        
        yertle5.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle5.backward(i);
            yertle5.turn(i);
        }

        yertle6.penUp();
        for (int i=0; i<272; i++)
            for(int j=0; j<375; j++)
            yertle6.moveTo(i,j);
        
        yertle6.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle6.backward(i);
            yertle6.turn(i);
        }


        yertle7.penUp();
        for (int i=0; i<(272+60); i++)
            for(int j=0; j<375; j++)
            yertle7.moveTo(i,j);
        
        yertle7.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle7.backward(i);
            yertle7.turn(i);
        }


        //-------
        yertle8.penUp();
        for (int i=0; i<(275); i++)
            for(int j=0; j<450; j++)
            yertle8.moveTo(i,j);
        
        yertle8.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle8.backward(i);
            yertle8.turn(i);
        }
        
        //----
        yertle9.penUp();
        for (int i=0; i<(275); i++)
            for(int j=0; j<150; j++)
                yertle9.moveTo(i,j);
        
        yertle9.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle9.backward(-i);
            yertle9.turn(-i);
        }

        //--- Fila de 3 arriba
        yertle10.penUp();
        for (int i=0; i<212; i++)
            for(int j=0; j<225; j++)
                yertle10.moveTo(i,j);
        
        yertle10.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle10.backward(i);
            yertle10.turn(i);
        }

        yertle11.penUp();
        for (int i=0; i<272; i++)
            for(int j=0; j<225; j++)
                yertle11.moveTo(i,j);
        
        yertle11.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle11.backward(i);
            yertle11.turn(i);
        }


        yertle12.penUp();
        for (int i=0; i<(275+60); i++)
            for(int j=0; j<225; j++)
            yertle12.moveTo(i,j);
        
        yertle12.penDown();
        for (int i=0; i<yertle2.getHeight()*3; i++){
            yertle12.backward(i);
            yertle12.turn(i);
        }

        // The show method is deprecated, use setVisible(true) instead
        // habitat.show(true);
        habitat.setVisible(true);
    }
}