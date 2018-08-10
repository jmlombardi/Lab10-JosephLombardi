package hw;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;

public class Main {

  public static void main(final String[] args) {

    final String IT = CountryCodes.IT;
    final String AT = CountryCodes.AT;
    final String CH = CountryCodes.CH;
    final String FR = CountryCodes.FR;
    final String SI = CountryCodes.SI;
    final String SM = CountryCodes.SM;
    final String VA = CountryCodes.VA;

    final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

    myMap.addVertex(IT);
    myMap.addVertex(AT);
    myMap.addVertex(CH);
    myMap.addVertex(FR);
    myMap.addVertex(SI);
    //myMap.addVertex(SM);
    //myMap.addVertex(VA);

    // Add edges for countries that share a border with Italy.

    myMap.addEdge(IT, AT);
    myMap.addEdge(IT, CH);
    myMap.addEdge(IT, FR);
    myMap.addEdge(IT, SI);
    //myMap.addEdge(IT, SM);
    //myMap.addEdge(IT, VA);

    // Switzerland shares a border with France
    myMap.addEdge(CH, FR);

    // Switzerland shares a border with Austria
    myMap.addEdge(CH, AT);

    // Slovenia shares a border with Austria
    myMap.addEdge(SI, AT);


    final Iterator<String> bfItaly = new BreadthFirstIterator<>(myMap, IT);
    System.out.println("Printing Breadth First starting from Italy.");
    while (bfItaly.hasNext()) {
      final String country = bfItaly.next();
      System.out.println(country);
    }

    System.out.println();
    final Iterator<String> bfSlovenia = new BreadthFirstIterator<>(myMap, SI);
    System.out.println("Printing Breadth First starting from Slovenia.");
    while (bfSlovenia.hasNext()) {
      final String country = bfSlovenia.next();
      System.out.println(country);
    }

    System.out.println();
    final Iterator<String> cfItaly = new ClosestFirstIterator<>(myMap, IT);
    System.out.println("Printing Closest First starting from Italy.");
    while (cfItaly.hasNext()) {
      final String country = cfItaly.next();
      System.out.println(country);
    }

    System.out.println();
    final Iterator<String> cfAustria = new ClosestFirstIterator<>(myMap, AT);
    System.out.println("Printing Closest First starting from Austria.");
    while (cfAustria.hasNext()) {
      final String country = cfAustria.next();
      System.out.println(country);
    }

    System.out.println();
    final Iterator<String> dfItaly = new DepthFirstIterator<>(myMap, IT);
    System.out.println("Printing Depth First starting from Italy.");
    while (dfItaly.hasNext()) {
      final String country = dfItaly.next();
      System.out.println(country);
    }

    System.out.println();
    final Iterator<String> dfSwitzerland = new DepthFirstIterator<>(myMap, CH);
    System.out.println("Printing Depth First starting from Switzerland.");
    while (dfSwitzerland.hasNext()) {
      final String country = dfSwitzerland.next();
      System.out.println(country);
    }

    System.out.println();
    final Iterator<String> rwItaly = new RandomWalkIterator<>(myMap, IT, false, 5);
    System.out.println("Printing Random Walk starting from Italy.");
    while (rwItaly.hasNext()) {
      final String country = rwItaly.next();
      System.out.println(country);
    }

    System.out.println();
    final Iterator<String> rwFrance = new RandomWalkIterator<>(myMap, IT, false, 5);
    System.out.println("Printing Random Walk starting from France.");
    while (rwFrance.hasNext()) {
      final String country = rwFrance.next();
      System.out.println(country);
    }

    GreedyColoring gc = new GreedyColoring(myMap);


    System.out.println("\n"+gc.getColoring());



  } // main

} // class
