/*Zachary Branson
 * CSC241 001
 * Lab 6
 * 
 * 
 * Files- lab6.dat
 * 
 * 
 * Example Input:
 * 
 * c d root
c d usr
c d dev
c d tmp
c d bin
c d sbin
c d uucp
c f smith usr
c f jones usr
c f williams usr
c f ttyp0 dev
c f ttyp1 dev
c f sd2 dev
c f sd0 dev
c f sd1 dev
c f find bin
c f ls bin
c f crt set
s dev
s bin
s var
s usr
t


 * 
 * Example Output:
 * 
 * 
Welcome to DrJava.  Working directory is /Users/zacharybranson/Dropbox/School/Fall 2015/CSC-241/lab6
> run lab6
Directory root created!
Directory usr created!
Directory dev created!
Directory tmp created!
Directory bin created!
Directory sbin created!
Directory uucp created!
File smith created under the directory usr
File jones created under the directory usr
File williams created under the directory usr
File ttyp0 created under the directory dev
File ttyp1 created under the directory dev
File sd2 created under the directory dev
File sd0 created under the directory dev
File sd1 created under the directory dev
File find created under the directory bin
File ls created under the directory bin
File crt created under the directory set
No directory found for: set!
Directory dev contains the files: 
sd1
ttyp0
ttyp1
Directory bin contains the files: 
find
ls
Directory var contains the files: 
No directory found for: var!
Directory usr contains the files: 
jones
smith
williams
Printing All Files: 
bin, find, ls, dev, sd1, ttyp0, ttyp1, root, sbin, tmp, usr, jones, smith, williams, uucp, > 
> 
 * 
 * 
 * Time Started: 11/6/2015 6:00pm
 * Time Ended:11/10/2015 3:00am
 * 
 * 
 * 
 * 
 * */



import java.util.*;
import java.io.*;



public class lab6 {
  
  public static void main(String[] args) throws IOException {
    BinarySearchTree<String> tree = new BinarySearchTree<String>();
    
    File file = new File("lab6.dat");
    Scanner input = new Scanner(file);
   
    while(input.hasNextLine()) {
      char command = input.next().charAt(0);
      if(command == 'c') {
        char type = input.next().charAt(0);
        String name = input.next();
        if(type == 'd'){
          System.out.println("Directory " + name + " created!");
          tree.add(name);    
        }else if(type == 'f'){
          String directory = input.next();
          System.out.println("File " + name + " created under the directory " + directory);
          tree.addFile(name, directory);
        }// end if d or f
      } else if(command == 's') {
        String directory = input.next(); 
        System.out.println("Directory " + directory + " contains the files: ");
        tree.printFileTree(directory);
      } else if(command == 't'){
 
        System.out.println("Printing All Files: ");
        tree.printInOrder();
        break;
        
      } // end if command
    }// end while
  } // end main
}// end lab6 class