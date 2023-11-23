package com.epam.mjc;


public class StudentManager {

  public class Ilegal extends IllegalArgumentException{
    Ilegal(String massage){
      super(massage);
    }
  }

  private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

  public Student find(long studentID) throws Ilegal {
    if(Student.getValueOf(studentID)==null){
      throw new Ilegal("Could not find student with ID " + studentID);
    }else{
      return Student.getValueOf(studentID);
    }


  }

  public static void main(String[] args) {
    StudentManager manager = new StudentManager();

    for (int i = 0; i < IDs.length; i++) {
        Student student = null;
        try {

            student = manager.find(IDs[i]);
        } catch (Ilegal e) {
            System.err.print(e.getMessage());

        }

        if(student!=null){
          System.out.println("Student name " + student.getName());
        }

    }

  }
}