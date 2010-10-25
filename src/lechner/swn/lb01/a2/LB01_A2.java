package lechner.swn.lb01.a2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import lechner.swn.lb01.a2.logfile.LogReader;
import lechner.swn.lb01.a2.selectors.*;
import lechner.swn.lb01.a2.visitors.*;

public class LB01_A2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length > 0) {
			LogReader logReader = new LogReader(args[0]);
			
			IVisitor visitor = null;
			ISelector selector = null; 
			
			Scanner in = new Scanner(System.in);
			String visitorName = "";
			while(visitor == null){
				try {
				System.out.print("Filter logfile by: (available filters are IP, Page, DateInterval): ");
				visitorName = in.nextLine();
				visitor = (IVisitor) createInstance(visitorName, "lechner.swn.lb01.a2.visitors", "Visitor");
				}
				catch (ClassNotFoundException ce) {
					System.out.println("ERROR: The visitor '"+visitorName+"' was not found.");
				} catch (Exception e) {
					System.out.println("ERROR: "+e.getLocalizedMessage());
				}
			}
			visitor.apply(logReader.getLogEntries());
			
			String selectorName = "";
			while(selector == null){
				try {
					System.out.print("What should be printed (available options are Browsers, AverageHitsPerVisitor, LogEntry, TotalHits): ");
					selectorName = in.nextLine();
					selector = (ISelector) createInstance(selectorName, "lechner.swn.lb01.a2.selectors", "Selector");
				}
				catch (ClassNotFoundException ce) {
					System.out.println("ERROR: The selector '"+selectorName+"' was not found.");
				} catch (Exception e) {
					System.out.println("ERROR: "+e.getLocalizedMessage());
				}
			}
			selector.select(logReader.getLogEntries());
		}
		else {
			System.out.println("ERROR: The first program argument must be the logfile's path");
		}
	}
	
	private static Object createInstance(String className, String packageName, String suffix) throws ClassNotFoundException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		Class newclass = Class.forName(packageName+"."+className+suffix); // erzeugt die Klasse
		Constructor constructor = newclass.getConstructors()[0];
		Object[] constructorArgs = new Object[constructor.getParameterTypes().length];
		
		if(constructorArgs.length == 0){
			return constructor.newInstance();
		}
		
		System.out.println("Enter the parameters for "+suffix+" '"+className+"'");
		Scanner in = new Scanner(System.in);
		for(int j=0; j<constructor.getParameterAnnotations().length; j++){
			Annotation[] a = constructor.getParameterAnnotations()[j];

			for(int i=0; i<a.length; i++){
				NamedParam paramName = (NamedParam)a[i];
				System.out.print("\t"+paramName.value()+": ");
				constructorArgs[j]=in.nextLine(); 
			}
		}
		return constructor.newInstance(constructorArgs); //erzeugt Objekt
	}
}
