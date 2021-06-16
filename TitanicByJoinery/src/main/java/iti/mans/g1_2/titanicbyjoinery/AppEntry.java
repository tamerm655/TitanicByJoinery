package iti.mans.g1_2.titanicbyjoinery;

import act.Act;
import act.inject.DefaultValue;
import act.util.Output;
import java.io.IOException;
import joinery.DataFrame;
import org.osgl.logging.LogManager;
import org.osgl.logging.Logger;
import org.osgl.mvc.annotation.GetAction;
import osgl.version.Version;
import osgl.version.Versioned;

public class AppEntry {
    public static void main(String[] args) throws Exception {
        //Reading Titanic Data
        System.out.println("Reading Titanic Data");
        DataFrame<Object> df1 = new DataFrame<>();
        try{
            df1 = DataFrame.readCsv("D:\\Java_course\\day_4\\Titanic.csv")
            .describe();
            //df.iterrows ().forEachRemaining (System.out::println);
            System.out.println(df1.toString());
        }catch (IOException e) {
            e.printStackTrace ();
        }
        System.out.println("///////////////////////////////////////////////////////////");
        //Reading vgsales Data
        System.out.println("Reading vgsales Data");
        DataFrame<Object> df2 = new DataFrame<>();
        try{
            df2 = DataFrame.readCsv("D:\\Java_course\\day_4\\vgsales.csv")
            .describe();
            //df.iterrows ().forEachRemaining (System.out::println);
            System.out.println(df2.toString());
        }catch (IOException e) {
            e.printStackTrace ();
        }
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("joining passengerCol with rankCol");
        
        //joining two columns from both tables
        DataFrame<Object> passengerCol = new DataFrame<>();
        try{
            passengerCol = df1.retain("PassengerId"); 
        }catch (IOException e) {
            e.printStackTrace ();
        }
        DataFrame<Object> rankCol = new DataFrame<>();
        try{
            rankCol = df2.retain("Rank").join(passengerCol);
            System.out.println(rankCol.toString());
        }catch (IOException e) {
            e.printStackTrace ();
        }
        
        //Adding column to table
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("adding passengerCol to vgsales table");
        
        try{
            DataFrame<Object> rankCol2 = df2.add(df1.col("PassengerId"));
            System.out.println(rankCol2.toString());
        }catch (IOException e) {
            e.printStackTrace ();
        }
        
        //Merging two columns
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("merging passengerCol with rankCol");
        
        try{
            DataFrame<Object> rankCol3 = DataFrame.readCsv("D:\\Java_course\\day_4\\vgsales.csv")
            .retain("Rank")
            .merge(passengerCol);
            System.out.println(rankCol3.toString());
        }catch (IOException e) {
            e.printStackTrace ();
        }
        
    }

}
