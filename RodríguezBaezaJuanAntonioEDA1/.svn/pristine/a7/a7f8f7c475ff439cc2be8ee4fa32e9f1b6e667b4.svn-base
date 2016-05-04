package org.eda1.practica04;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eda1.practica04.RoadNetwork;
import org.junit.Before;
import org.junit.Test;

public class NetworkTestJUnit4 {

	String directorioEntrada;
	String graphFile = "graphSpain.txt";
	
	@Before
	public void setUp() throws Exception {
		directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada 
				+ File.separator + "src"
				+ File.separator + "org" 
				+ File.separator + "eda1"
				+ File.separator + "practica04"
				+ File.separator;		
		graphFile = directorioEntrada + graphFile;
		
	}

	@Test
	public void testReadRoadNetwork() throws FileNotFoundException {
			
		RoadNetwork<String> net = RoadNetwork.readRoadNetwork(graphFile);

		assertTrue(net.numberOfVertices() == 21);
		assertTrue(net.numberOfEdges() == 58);
		
		String cadena = "{Albacete={Madrid=251.0, Murcia=150.0, Valencia=191.0}, " +
						 "Almeria={Granada=173.0, Murcia=224.0}, " +
						 "Badajoz={Caceres=90.0, Huelva=234.0, Madrid=403.0}, " + 
						 "Barcelona={Gerona=100.0, Valencia=349.0, Zaragoza=296.0}, " + 
						 "Bilbao={Madrid=395.0, Oviedo=304.0, Valladolid=280.0, Zaragoza=324.0}, " + 
						 "Caceres={Badajoz=90.0}, " + 
						 "Cadiz={Sevilla=125.0}, " + 
						 "Corunya={Valladolid=455.0, Vigo=171.0}, " +
						 "Gerona={Barcelona=100.0, Lerida=222.0}, " +
						 "Granada={Almeria=173.0, Jaen=99.0, Murcia=278.0, Sevilla=256.0}, " +
						 "Huelva={Badajoz=234.0, Sevilla=92.0}, " +
						 "Jaen={Granada=99.0, Madrid=335.0, Sevilla=242.0}, " +
						 "Lerida={Gerona=222.0}, " +
						 "Madrid={Albacete=251.0, Badajoz=403.0, Bilbao=395.0, Jaen=335.0, Valladolid=193.0, Zaragoza=325.0}, "+
						 "Murcia={Albacete=150.0, Almeria=224.0, Granada=278.0, Valencia=241.0}, " +
						 "Oviedo={Bilbao=304.0}, " +
						 "Sevilla={Cadiz=125.0, Granada=256.0, Huelva=92.0, Jaen=242.0}, " +
						 "Valencia={Albacete=191.0, Barcelona=349.0, Murcia=241.0}, " +
						 "Valladolid={Bilbao=280.0, Corunya=455.0, Madrid=193.0, Vigo=356.0}, " +
						 "Vigo={Corunya=171.0, Valladolid=356.0}, " +
						 "Zaragoza={Barcelona=296.0, Bilbao=324.0, Madrid=325.0}}";
		
		assertEquals(cadena, net.toString());
	}
	
	@Test
	public void testNetworkIteratorBFS_DFS() throws FileNotFoundException {
		RoadNetwork<String> net = RoadNetwork.readRoadNetwork(graphFile);
		String str;
		
		str = "";
		Iterator<String> itr = net.breadthFirstIterator ("Almeria");
		while (itr.hasNext())
  			str += itr.next() + " ";
		assertEquals(str, "Almeria Granada Murcia Jaen Sevilla Albacete Valencia Madrid Cadiz Huelva Barcelona Badajoz Bilbao Valladolid Zaragoza Gerona Caceres Oviedo Corunya Vigo Lerida ");
		
		str = "";
		itr = net.depthFirstIterator ("Almeria");
		while (itr.hasNext())
 			str += itr.next() + " ";
		assertEquals(str, "Almeria Murcia Valencia Barcelona Zaragoza Madrid Valladolid Vigo Corunya Jaen Sevilla Huelva Cadiz Badajoz Caceres Bilbao Oviedo Gerona Lerida Albacete Granada ");
		
		str = "";
		ArrayList<String> aLDFS = net.toArrayDFS("Almeria");
		for (int i = 0; i < aLDFS.size(); i++)
			str += aLDFS.get(i) + " ";
		assertEquals(str, "Almeria Granada Jaen Madrid Albacete Murcia Valencia Barcelona Gerona Lerida Zaragoza Bilbao Oviedo Valladolid Corunya Vigo Badajoz Caceres Huelva Sevilla Cadiz ");
		
		str = "";
		ArrayList<String> aLBFS = net.toArrayBFS("Almeria");
		for (int i = 0; i < aLBFS.size(); i++)
			str += aLBFS.get(i) + " ";
		assertEquals(str, "Almeria Granada Murcia Jaen Sevilla Albacete Valencia Madrid Cadiz Huelva Barcelona Badajoz Bilbao Valladolid Zaragoza Gerona Caceres Oviedo Corunya Vigo Lerida ");
		assertEquals(net.toArrayDFS("Almeria").size(),net.toArrayDFSIterative("Almeria").size());
		assertEquals(net.toArrayDFS("Granada").size(),net.toArrayDFSIterative("Granada").size());
	}
	
	@Test
	public void testDijkstra() throws FileNotFoundException {
		
		RoadNetwork<String> net = RoadNetwork.readRoadNetwork(graphFile);
		double distance = .0;
		ArrayList<Object> shortestPath = null; 
		
		shortestPath = net.Dijkstra("Almeria", "Oviedo");
		
		assertEquals(shortestPath.toString(), "[Almeria, Granada, Jaen, Madrid, Bilbao, Oviedo]");
		distance = net.computeDistanceFromPath(shortestPath);
		assertTrue(distance == 1306.0);

		distance = 0;
		shortestPath = net.Dijkstra("Almeria", "Caceres");
		
		assertEquals(shortestPath.toString(), "[Almeria, Granada, Sevilla, Huelva, Badajoz, Caceres]");
		distance = net.computeDistanceFromPath(shortestPath);
		assertTrue(distance == 845.0);

	}
}
