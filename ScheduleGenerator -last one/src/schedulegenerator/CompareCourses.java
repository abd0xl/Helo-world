package schedulegenerator;

import java.util.ArrayList;
import java.util.List;

public class CompareCourses {

    public void confliction(List<Course> a, List<Course> b) {
        int perA[] = new int[2], perB[] = new int[2];
        String periodsA = "";
        String periodsB = "";
        String[] splittedA, splittedB;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).sections.size(); j++) {
                for (int k = a.size() - 1; k > 0; k--) {
                    for (int l = 0; l < a.get(k).sections.size(); l++) {
                        if (a.get(i).sections.get(j).sectionDays == a.get(k).sections.get(l).sectionDays) {
                            for (int m = 0; m < 5; m++) {
                                if (a.get(i).sections.get(j).periods[m] != "") {
                                    periodsA += a.get(i).sections.get(j).periods[m];
                                }
                                if (a.get(k).sections.get(l).periods[m] != "") {
                                    periodsB += a.get(i).sections.get(j).periods[m];
                                }
                            }
                            System.out.println(periodsA + ", " + periodsB);
                            splittedA = periodsA.split("~");
                            splittedB = periodsB.split("~");

                            perA[0] = Integer.parseInt(splittedA[0]);
                            perA[1] = Integer.parseInt(splittedA[1]);

                            perB[0] = Integer.parseInt(splittedA[0]);
                            perB[1] = Integer.parseInt(splittedA[1]);
                        }
                    }
                }
            }
        }
    }
    public ArrayList<Course> isNotConflict( Course a, Course b, ArrayList<Course> c ) {
        int perA[] = new int[2], perB[] = new int [2];
        String[] periodsA = new String[3];
        String[] periodsB = new String[3];
        List <Course> courses = new ArrayList();
        c = new ArrayList<Course>(courses.size());
        
        for (int i = 0; i < a.sections.size(); i++) {
            for (int j = 0; j < a.sections.get(i).sectionDays.length; j++) {
                if (a.sections.get(i).sectionDays[j] == b.sections.get(i).sectionDays[j]) {
                    
                    periodsA = a.sections.get(i).periods[j].split("~");

                    perA[0] = Integer.parseInt(periodsA[0]);
                    perA[1] = Integer.parseInt(periodsA[1]);
                    
                    periodsB = b.sections.get(i).periods[j].split("~");

                    perB[0] = Integer.parseInt(periodsB[0]);
                    perB[1] = Integer.parseInt(periodsB[1]);

                    if(perA[0] > perB[1]){
                        c.add(a);
                        c.add(b);
                    }else if (perA[1] < perB[0]){
                        c.add(a);
                        c.add(b);
                    }else {
                        j++;
                        continue;
                    }
                }
            }
            
            c.add(a);
            c.add(b);
            
//            System.out.println("\t\t\tSunday\t   Monday\t  Tuesday\tWednesday\t\tThursday");
//
//        for (int x = 0; x < (c.size()); x++) {
//
//            for (int z = 0; z < c.get(x).sections.size(); z++) {
//                System.out.print(c.get(x).getName() + " section: " + c.get(x).sections.get(z).getName() + "\t");
//                c.get(x).sections.get(z).printSectionDays();
//                System.out.println("");
//            }

      
        }
        return c;
        }
        
         

//        System.out.println("\t\t\tSunday\t   Monday\t  Tuesday\tWednesday\t\tThursday");
//
//        for (int i = 0; i < (c.size()); i++) {
//
//            for (int j = 0; j < c.get(i).sections.size(); j++) {
//                System.out.print(c.get(i).getName() + " section: " + c.get(i).sections.get(j).getName() + "\t");
//                c.get(i).sections.get(j).printSectionDays();
//                System.out.println("");
//            }
//        }
    
        
        
        
    }



