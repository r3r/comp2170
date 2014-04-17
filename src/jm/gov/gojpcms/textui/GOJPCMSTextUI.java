1/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.textui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
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
      /*
      ALERT:
         WE NEED TO REMOVE UNNECCESSARY COMMENTS FOR THE FINAL THING FOR SUBMISSION!
      */
      
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
      
      firstMenu();
   } //End of main.
   
   public static void firstMenu()
   {
      Scanner selection = new Scanner( System.in );
      int choice;
      int attempts = 0;
      
      ProjectComponent projComponent = new ProjectComponent();
      
    
      
      while ( true )
      {
            System.out.println( "\n\nAvailable actions" );
            System.out.println( "1: Create a New Project" );
            System.out.println( "2: More options[if projects already exist]" );
            System.out.println( "3: Exit" );

            System.out.print( "\nPlease select an action: " );
         try
         {
            choice = Integer.parseInt( selection.nextLine() ); 
            

            if ( choice == 1 )
            {
               choiceOne( projComponent );
               
            }
            
            if ( choice == 2 )
            {
               secondMenu(projComponent);
               
            }
            
            if ( choice == 3 )
            {
               System.out.println( "Thank you using this application." );
               System.exit( 0 );
            }
            
            if ( choice != 1 | choice != 2 | choice != 3 )
            {
               throw new InputMismatchException();
            }
         }
         catch( NumberFormatException | InputMismatchException error )
         {
            attempts += 1;
            if ( attempts == -1 )
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
   } //End of firstMenu.
   
   public static void secondMenu(ProjectComponent projComponent)
   {
      Scanner selection = new Scanner( System.in );
      int choice;
      int attempts = 0;
      
     
      
    
      
      while ( true )
      {
            System.out.println( "\n\nAvailable actions" );
            System.out.println( "1: Create a New Project" );
            System.out.println( "2: View Projects List");
            System.out.println( "3: Add a Project Activity" );
            System.out.println( "4: Add a New Consultant" );
            System.out.println( "5: Generate a Status Report" );
            System.out.println( "6: More Options" );
            System.out.println( "7: Exit" );

            System.out.print( "\nPlease select an action: " );
         try
         {
            choice = Integer.parseInt( selection.nextLine() ); 
            

            if ( choice == 1 )
            {
               choiceOne( projComponent );
               
            }
            if ( choice == 2 )
            {
               choiceTwo( projComponent );
              
            }
            if ( choice == 3 )
            {
               choiceThree( projComponent );
               
            }

            if ( choice == 4 )
            {
               chocieFour( projComponent );
               
            }

            if ( choice == 5 )
            {
               choiceFive( projComponent );
               
            }
            
            if ( choice == 6 )
            {
               thirdMenu(projComponent);
               
            }
            
            if ( choice == 7 )
            {
               System.out.println( "Thank you using this application." );
               System.exit( 0 );
            }
            
            if ( choice != 1 | choice != 2 | choice != 3 | choice != 4 | choice != 5 | choice != 6 | choice != 7)
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
   
   public static void thirdMenu(ProjectComponent projComponent)
   {
      Scanner selection = new Scanner( System.in );
      int choice;
      int attempts = 0;
      
      
      //CHAD? HERE
      //I don't think we need option 1 cause it's the same as option 4 in menu 1
      //I don't think we need Option 4 either...too much work...let's leave it
      //So remove 1 and 4
      //If you want u can move 2 and 3 upto menu 1..ur choice
      //Changes made:
      //removed 1 and 4
      //Renamed actionTwo amd actionThree to one and two respectively.
     
      
      while ( true )
      {
        System.out.println( "\n\nSelect an action" ); 
        System.out.println( "1: Update Activities" );
        System.out.println( "2: Remove Consultants" );
        System.out.println( "3: Return to previous menu" );
        System.out.println( "4: Exit" );

        System.out.print( "Action of your choice: " );
         try
         {
            choice = Integer.parseInt( selection.nextLine() ); 
            

            if ( choice == 1 )
            {
               actionOne( projComponent );
               
            }

            if ( choice == 2 )
            {
               actionTwo( projComponent );
              
            }
            
            if ( choice == 3 )
            {
               return;
            }
            
            if ( choice == 4 )
            {
               System.out.println( "Thank you using this application." );
               System.exit( 0 );
            }
            
            if ( choice != 1 | choice != 2 | choice != 3)
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
   } //End of thirdMenu.
   
   public static void choiceOne( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO CREATE A NEW PROJECT-\n" );
      System.out.println( "\n##Project Creation##\n" );

      System.out.println( "Project types" );
      System.out.println( "a: Capital A - Government Funded" );
      System.out.println( "b: Capital B - Foreign Donor" );
      
      try
      {
         System.out.print( "What type of project do you wish to create: " );
         String projType = entry.nextLine();
         
         if ( projType.equals( "a" ) | projType.equals( "A" ) )
         {
            System.out.print("Which class of project is this? [T]echnical Assitance or [C]apital Project? ");
            String projClass = entry.nextLine();
            
            if ( !( projClass.equals( "T" ) ) )
            {
               if ( !( projClass.equals( "C" ) ) )
               {
                  throw new InputMismatchException();
               }
            }
            
            System.out.print( "\nPlease enter a name for the project: " );
            String name = entry.nextLine();

            System.out.print( "\nDescribe this project in one sentence: " );
            String description = entry.nextLine();
            
            System.out.print( "\nEnter the location of the " +name +" Project: " );
            String location = entry.nextLine();

            //RITESH? Here:
            //Problem: ProjectType field
            //Chad? Here:
            //Fixed it
            if (projClass.equals("T"))
            {
                System.out.println(component.addProject( name, description, location, "T", ProjectType.CAPITAL_A, new FundingArrangement(), new ProjectBeneficiaries() ));
            }
            
            if (projClass.equals("C"))
            {
                System.out.println(component.addProject( name, description, location, "C", ProjectType.CAPITAL_A, new FundingArrangement(), new ProjectBeneficiaries() ));
            }
            
            secondMenu( component);
         }

         if ( projType.equals( "b" ) | projType.equals( "B" ))
         {
            System.out.print("Which class of project is this? [T]echnical Assitance or [C]apital Project? ");
            String projClass = entry.nextLine();
            
            if ( !( projClass.equals( "T" ) ) )
            {
               if ( !( projClass.equals( "C" ) ) )
               {
                  throw new InputMismatchException();
               }
            }
            
            System.out.print( "\nPlease enter a name for the project: " );
            String name = entry.nextLine();

            System.out.print( "\nDescribe this project in one sentence: " );
            String description = entry.nextLine();

            System.out.print( "\nEnter the location of the " +name +" Project: " );
            String location = entry.nextLine();

            //RITESH? Here:
            //Problem: ProjectType field needs to be entered so the project can be made.
            //Chad? Here:
            //Fixed it
            if(projClass.equals("T"))
            {
                System.out.println(component.addProject( name, description, location, "T", ProjectType.CAPITAL_B, new FundingArrangement() , new ProjectBeneficiaries() ));
            }
            if (projClass.equals("C"))
            {
                System.out.println(component.addProject( name, description, location, "C", ProjectType.CAPITAL_B, new FundingArrangement() , new ProjectBeneficiaries() ));
            }

            secondMenu(component);
         }
         
         if ( !( projType.equals( "a" ) ) | !( projType.equals( "b" ) ) | !( projType.equals( "A" ) ) | !( projType.equals( "B" ) ) )
            {
               throw new InputMismatchException();
            }
      }
      catch( NullPointerException | InputMismatchException error )
      {
         System.out.println( "\n-NO VALID ENTRY WAS GIVEN.-\n" );
         //firstMenu();
      }
      
   }
   
   public static void choiceTwo( ProjectComponent component ){
        System.out.println( "\n-YOU HAVE CHOSEN TO View Projects-\n" );
        ArrayList<String> list = component.viewProjectsList();
        System.out.println("ID\tType\t\tClass\t\t\tName\t\tConsultant");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
        
   }
   
   public static void choiceThree( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      Scanner entry1 = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO ADD A NEW ACTIVITY-\n" );
      
      System.out.println( "\n##Adding Activity##\n" );
      
      try
      {
         System.out.print( "\nPlease enter a project id: " );
         float id = entry.nextFloat(); //Fake project ID for testing
      
         //RITESH? Here:
         //Problem: we need the addProject method to work in choiceOne method for this to work.
         //Chad? Here:
         //Fixed it
         Activity act = new Activity();
         
         System.out.print("\nPlease enter the name of the activity: ");
         act.setName( entry1.nextLine() );
         
         System.out.print("\nPlease enter the weight of the activity: ");
         act.setWeight( entry1.nextFloat() );
         
         component.addActivity(id, act ); 

         //secondMenu();
      }
      catch( NullPointerException error )
      { 
         error.printStackTrace();
         System.out.println( "\n-PROJECT WAS NEVER CREATED SUCCESSFULLY-\n" );
        // firstMenu();
      }
   }
   
   public static void chocieFour( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      Scanner entry1 = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO ADD A NEW CONSULTANT-\n" );
      
      System.out.println( "\n##Adding Consultant##\n" );
      
      System.out.print( "Please enter a project id: " );
      
      try
      {
         float id = entry.nextFloat(); //Fake project ID for testing
      
         //RITESH? Here:
         //Problem: we need the addProject method to work in choiceOne method for this to work.
         //Chad? Here:
         //Fixed it
         Consultant cons = new Consultant();
         System.out.print("Please enter the consultant name: ");
         cons.setName(entry1.nextLine());
         
         System.out.println(component.addConsultant( id, cons ));

         //secondMenu();
      }
      catch( NullPointerException error )
      {
         System.out.println( "\n-PROJECT WAS NEVER CREATED SUCCESSFULLY-\n" );
         //firstMenu();
      }
   }
   
   public static void choiceFive( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      System.out.println( "\n-YOU HAVE CHOSEN TO GENERATE A STATUS REPORT-\n" );
      
      System.out.println( "\n##Report Generation##\n" );
      
      System.out.print( "Please enter project id: " );
      
      try
      {
         float id = entry.nextFloat();
         //RITESH? Here:
         //Decision about reports making need to be done.
         //Chad? Here:
         //Fixed it
         System.out.println(component.getProjectStatus(id));

         //secondMenu();
      }
      catch( NullPointerException error )
      {
         System.out.println( "\n-PROJECT WAS NEVER CREATED SUCCESSFULLY-\n" );
         //1firstMenu();
      }
      
   }
   
   public static void actionOne( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      Scanner entry1 = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO UPDATE ACTIVITIES-\n" );
      System.out.print( "Please enter the project id: " );
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
      System.out.print("Choose an Activity from above and enter its id: ");
      float actId = entry.nextFloat();
      
      Activity act = component.getActivity(id, actId);
      
      System.out.print("Please enter the name of the activity( '.' for no change): ");
      String temp = entry1.nextLine();
      if (!temp.equals("."))
           act.setName(temp);

      System.out.print("Please enter the weight of the activity ( '-1' for no change): ");
      float tmp = entry1.nextFloat();
      if (tmp != -1)
           act.setWeight(tmp);
      
      System.out.print("Please enter percentage completion: ");
      act.setPercentage(entry.nextFloat());
      
      
      component.updateActivities( id, act);
      
      //secondMenu();
   }
   
   public static void actionTwo( ProjectComponent component )
   {
      Scanner entry = new Scanner( System.in );
      
      System.out.println( "\n-YOU HAVE CHOSEN TO REMOVE A CONSULTANT-\n" );
      System.out.print( "Please enter the project id: " );
      float id = entry.nextFloat();
      
      component.removeConsultant( id );
      
      //secondMenu();
   }
}
