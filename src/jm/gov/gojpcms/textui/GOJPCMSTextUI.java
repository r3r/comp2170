/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.textui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import jm.gov.gojpcms.documentcomponent.Document;
import jm.gov.gojpcms.enums.ProjectType;
import jm.gov.gojpcms.projectcomponent.Activity;
import jm.gov.gojpcms.projectcomponent.Consultant;
import jm.gov.gojpcms.projectcomponent.FundingArrangement;
import jm.gov.gojpcms.projectcomponent.ProjectBeneficiaries;
import jm.gov.gojpcms.projectcomponent.ProjectComponent;

/**
 *
 * @author JCARJ
 */
public class GOJPCMSTextUI 
{
   public static void main( String[] args )
   {
      Scanner selection = new Scanner( System.in );
      int choice;
      int attempts = 0;
      
      ProjectComponent projComponent = new ProjectComponent();
      
      
      System.out.println( "******************************************" );
      System.out.println( "******************************************" );
      System.out.println( "**       ****      ****       ****      **" );
      System.out.println( "**      **  **    **  **      ****      **" );
      System.out.println( "**     **    **   **  **       **       **" );
      System.out.println( "**     **    **   **  **       **       **" );
      System.out.println( "**     **         **  **       **       **" );
      System.out.println( "**     **   ****  **  **       **       **" );
      System.out.println( "**     **   ****  **  **  **** **       **" );
      System.out.println( "**      **  **    **  **   **  **       **" );
      System.out.println( "**       ****      ****     ****        **" );
      System.out.println( "**                                      **" );
      System.out.println( "** Welcome to the Government of Jamaica **" );
      System.out.println( "**      Project Management System.      **" );
      System.out.println( "**                                      **" );
      System.out.println( "**          Text User Interface Edition.**" );
      System.out.println( "**                                1.0.0 **" );
      System.out.println( "******************************************" );
      System.out.println( "******************************************" );
      
      System.out.println( "Available actions" );
      System.out.println( "1: Create a New Project" );
      System.out.println( "2: Add a Project Activity" );
      System.out.println( "3: Add a New Consultant" );
      System.out.println( "4: Generate a Status Report" );
      System.out.println( "5: Exit" );
      
      System.out.println( "\nPlease select an action: " );
      
      while ( true )
      {
         try
         {
            choice = Integer.parseInt( selection.nextLine() ); 
            

            if ( choice == 1 )
            {
               choiceOne( projComponent );
               break;
            }

            if ( choice == 2 )
            {
               choiceTwo( projComponent );
               break;
            }

            if ( choice == 3 )
            {
               choiceThree( projComponent );
               break;
            }

            if ( choice == 4 )
            {
               choiceFour( projComponent );
               break;
            }
            
            if ( choice == 5 )
            {
               System.out.println( "Thank you using this application." );
               break;
            }
            
            if ( choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5 )
            {
               throw new InputMismatchException();
            }
         }
         catch( NumberFormatException | InputMismatchException error )
         {
            attempts += 1;
            if ( attempts == 3 )
            {
               System.out.println( "You have exceed the number of attempts." );
               break;
            }
            else
            {
               System.out.println( "Please enter a numeric value in the range shown: " );
            }
         }
      } //End of while loop.
   } //End of main.
   
   public static void choiceOne( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO CREATE A NEW PROJECT-\n" );
      System.out.println( "\n##Project Creation##\n" );

      System.out.println( "Project types" );
      System.out.println( "a: Capital A - Government Funded" );
      System.out.println( "b: Capital B - Foreign Donor" );
      
      System.out.println( "What type of project do you wish to create: " );
      
      try
      {
         String projType = entry.nextLine();
         System.out.println("Which class of project is this? [T]echnical Assitance or [C]apital Project?");
         String projClass = entry.nextLine();
         
         if ( projType.equals( "a" ) )
         {
            System.out.println( "Please enter a name for the project: " );
            String name = entry.nextLine();

            System.out.println( "\nDescribe this project in one sentence: " );
            String description = entry.nextLine();

            System.out.println( "\nEnter the location of the " +name +" Project: " );
            String location = entry.nextLine();

            //RITESH? Here:
            //Problem: ProjectType field
            //Chad? Here:
            //Fixed it
            if(projClass.equals("T")){
                component.addProject( name, description, location, "T", ProjectType.CAPITAL_A, new FundingArrangement(), new ProjectBeneficiaries() );
            }else {
                component.addProject( name, description, location, "C", ProjectType.CAPITAL_A, new FundingArrangement(), new ProjectBeneficiaries() );
            }
            

            secondMenu();
         }

         if ( projType.equals( "b" ) )
         {
            System.out.println( "Please enter a name for the project: " );
            String name = entry.nextLine();

            System.out.println( "\nDescribe this project in one sentence: " );
            String description = entry.nextLine();

            System.out.println( "\nEnter the location of the " +name +" Project: " );
            String location = entry.nextLine();

            //RITESH? Here:
            //Problem: ProjectType field needs to be entered so the project can be made.
            //Chad? Here:
            //Fixed it
            if(projClass.equals("T")){
                component.addProject( name, description, location, "T", ProjectType.CAPITAL_B, new FundingArrangement() , new ProjectBeneficiaries() );
            }else{
                component.addProject( name, description, location, "C", ProjectType.CAPITAL_B, new FundingArrangement() , new ProjectBeneficiaries() );
            }

            secondMenu();
         }
      }
      catch( NullPointerException error )
      {
         System.out.println( "Incorrect parameters were entered when creating the project." );
      }
      
   }
   
   public static void choiceTwo( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO ADD A NEW ACTIVITY-\n" );
      
      System.out.println( "\n##Adding Activity##\n" );
      
      System.out.println( "Please enter a project id: " );
      
      try
      {
         float id = entry.nextFloat(); //Fake project ID for testing
      
         //RITESH? Here:
         //Problem: we need the addProject method to work in choiceOne method for this to work.
         //Chad? Here:
         //Fixed it
         Activity act = new Activity();
         
         System.out.println("Please enter the name of the activity: ");
         act.setName(entry.nextLine());
         
         System.out.println("Please enter the weight of the activity: ");
         act.setWeight(entry.nextFloat());
         
         component.addActivity(id, act ); //random Activity object for testing.

         secondMenu();
      }
      catch( NullPointerException error )
      { 
         System.out.println( "Project was never created successfully" );
      }
   }
   
   public static void choiceThree( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO ADD A NEW CONSULTANT-\n" );
      
      System.out.println( "\n##Adding Consultant##\n" );
      
      System.out.println( "Please enter a project id: " );
      
      try
      {
         float id = entry.nextFloat(); //Fake project ID for testing
      
         //RITESH? Here:
         //Problem: we need the addProject method to work in choiceOne method for this to work.
         //Chad? Here:
         //Fixed it
         Consultant cons = new Consultant();
         System.out.println("Please enter the consultant name: ");
         cons.setName(entry.nextLine());
         
         component.addConsultant( id, cons ); //random consultant object for testing.

         secondMenu();
      }
      catch( NullPointerException error )
      {
         System.out.println( "Project was never created successfully" );
      }
   }
   
   public static void choiceFour( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      System.out.println( "\n-YOU HAVE CHOSEN TO GENERATE A STATUS REPORT-\n" );
      
      System.out.println( "\n##Report Generation##\n" );
      
      System.out.println( "Please enter project id: " );
      
      try
      {
         float id = entry.nextFloat();
         //RITESH? Here:
         //Decision about reports making need to be done.
         //Chad? Here:
         //Fixed it
         System.out.println(component.getProjectStatus(id));

         secondMenu();
      }
      catch( NullPointerException error )
      {
         System.out.println( "Project was never created successfully" );
      }
      
   }
   
   public static void secondMenu()
   {
      Scanner selection = new Scanner( System.in );
      int choice;
      int attempts = 0;
      
      ProjectComponent projComponent = new ProjectComponent();
      //CHAD? HERE
      //I don't think we need option 1 cause it's the same as option 4 in menu 1
      //I don't think we need Option 4 either...too much work...let's leave it
      //So remove 1 and 4
      //If you want u can move 2 and 3 upto menu 1..ur choice
      System.out.println( "Select an action" ); 
      System.out.println( "1: View a Project" );
      System.out.println( "2: Update Activities" );
      System.out.println( "3: Remove Consultants" );
      System.out.println( "4: Update Reports" );
      
      System.out.println( "Action of your choice: " );
      
      while ( true )
      {
         try
         {
            choice = Integer.parseInt( selection.nextLine() ); 
            

            if ( choice == 1 )
            {
               actionOne( projComponent );
               break;
            }

            if ( choice == 2 )
            {
               actionTwo( projComponent );
               break;
            }

            if ( choice == 3 )
            {
               actionThree( projComponent );
               break;
            }

            if ( choice == 4 )
            {
               actionFour( projComponent );
               break;
            }
            
            if ( choice != 1 || choice != 2 || choice != 3 || choice != 4 )
            {
               throw new InputMismatchException();
            }
         }
         catch( NumberFormatException | InputMismatchException error )
         {
            attempts += 1;
            if ( attempts == 3 )
            {
               System.out.println( "You have exceed the number of attempts." );
               break;
            }
            else
            {
               System.out.println( "Please enter a numeric value in the range shown: " );
            }
         }
      } //End of while loop.
   } //End of secondMenu.
   
   public static void actionOne( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO VIEW PROJECTs DETAILS-\n" );
      System.out.println( "Please enter the project id: " );
      
      float id = entry.nextFloat();
      
      component.getProjectDetails( id );
   }
   
   public static void actionTwo( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO UPDATE ACTIVITIES-\n" );
      System.out.println( "Please enter the project id: " );
      float id = entry.nextFloat();
      
      //Chad? HERE:
      //Fixed it
      ArrayList<String> activities = component.viewActivitiesList(id);
      Iterator<String> it = activities.iterator();
      System.out.println("Activities\n");
      System.out.println("ID\tName\tWeight\tPercentage");
      while(it.hasNext()){
          System.out.println(it.next());
      }
      
      System.out.println();
      System.out.println("Choose an Activity from above and enter its id: ");
      float actId = entry.nextFloat();
      
      Activity act = component.getActivity(id, actId);
      
      System.out.println("Please enter the name of the activity( '.' for no change): ");
      String temp = entry.nextLine();
      if (!temp.equals("."))
           act.setName(temp);

      System.out.println("Please enter the weight of the activity ( '-1' for no change): ");
      float tmp = entry.nextFloat();
      if (tmp != -1)
           act.setWeight(tmp);
      
      System.out.println("Please enter percentage completion");
      act.setPercentage(entry.nextFloat());
      
      
      component.updateActivities( id, act);
   }
   
   public static void actionThree( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO REMOVE A CONSULTANT-\n" );
      System.out.println( "Please enter the project id: " );
      float id = entry.nextFloat();
      
      component.removeConsultant( id );
   }
   
   public static void actionFour( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO UPDATE A DOCUMENT-\n" );
      System.out.println( "Please enter the project id: " );
      float id = entry.nextFloat();
      
      component.updateDocument( id, new Document() );
   }
}
