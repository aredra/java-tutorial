package array;

import java.util.ArrayList;

public class Student {
    private int studentID;
    private String studentName;
    private ArrayList<Subject> subjectList;
    private ArrayList<Book> bookList;

    public Student(int id, String studentName) {
        this.studentID = id;
        this.studentName = studentName;
        subjectList = new ArrayList<Subject>();
        bookList = new ArrayList<Book>();
    }

    public void addSubject(String name, int score) {
        Subject newSubject = new Subject(name, score);
        subjectList.add(newSubject);
        System.out.println("Add Subject");
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        bookList.add(newBook);
        System.out.println("Add Book");
    }
    public void showStudentInfo(){
        int total = 0;
        for (Subject el : subjectList) {
            total += el.getScore();
            System.out.println(studentName+"'s "+el.getName()+" score is "+el.getScore());
        }
        System.out.println(studentName+"'s total score is "+total);
        System.out.println(studentName+"'s avg score is "+total/subjectList.size());
    }
    public void showBookList() {
        int total = 0;
        StringBuilder bookListName = new StringBuilder();
        for (Book book : bookList) {
            total++;
            bookListName.append(book.getTitle()).append(" ");
        }
        System.out.println(studentName+" is read "+bookListName+": "+total);
    }
}
