
public class Person implements Contract {
    String currentitem;
    int x = 0;
    int y = 0;
    int a;
    int b;
    int counter = 5;

    //grabs the mentioned item 
        public void grab(String item)
        {
            currentitem = item;
            System.out.println("You grabbed the" + item);
        }

    //drops the mentioned item    
        public String drop(String item)
        {
            System.out.println("You dropped the" + item);
            currentitem = "nothing";
            return item;

        }

    //Outputs what the item is
        public void examine(String item)
        {
            System.out.println("This is a " + item);
        }

    //Uses the item currently have
        public void use(String item)
        {
            System.out.println("You used the " + item);
        }
    //Walks towards the direction in the x and y axis depending on the input
        public boolean walk(String direction)
        {
            if(counter > 0){
                direction.toLowerCase();
                a = x; //used later for undo
                b = y; //used later for undo
                if(direction == "n"){
                    y = y + 1;
                    System.out.println("(" + x + "," + y + ")");
                    shrink(); //uses energy while walking
                    System.out.println("Energy =" + counter);
                }
                else if(direction == "s"){
                    y = y - 1;
                    System.out.println("(" + x + "," + y + ")");
                    shrink(); //uses energy while walking
                    System.out.println("Energy =" + counter);
                }
                else if(direction == "w"){
                    x = x - 1;
                    System.out.println("(" + x + "," + y + ")");
                    shrink(); //uses energy while walking
                    System.out.println("Energy =" + counter);
                }
                else if (direction == "e"){
                    x = x + 1;
                    System.out.println("(" + x + "," + y + ")");
                    shrink(); //uses energy while walking
                    System.out.println("Energy =" + counter);
                }
                
            }       
            else{
                System.out.println("You need to rest"); //need to rest if the energy level is 0 before walking again
            }
            return false;    
            
        }

        public boolean fly(int x, int y)
        {
            System.out.println("Your character can not fly"); // cannot fly 
            return false;

        }
        public Number shrink()
        {
            counter = counter - 1; // decreases the energy of the character
            return counter;

        }

        public Number grow()
        {
            counter = counter + 1; // increases the energy of the character
            return counter;

        }
        
    //rest to gain 5 energy    
        public void rest()
        {
            counter = 5;
            System.out.println("You have rested. Your energy is restored"); 

        }

    //move back to your previous position without consuming energy   
        public void undo()
        {
            System.out.println("You went to back to your previous postition");
            x = a;
            y = b;
            System.out.println("(" + x + "," + y + ")");
        }
        
    //eat increases energy by 1    
        public void eat(String food){
            System.out.println("You haven eaten" + food);
            grow(); 
            System.out.println("Energy = " + counter);
        }





    public static void main(String[] args){
        Person character = new Person();
        character.walk("n");
        character.walk("n");
        character.walk("s");
        character.examine("camera");
        character.grab("camera");
        character.use("camera");
        character.drop("camera");
        character.walk("e");
        character.walk("e");
        character.walk("w");
        character.walk("w");
        character.walk("w");
        character.rest();
        character.fly(2,3);
        character.walk("w");
        character.undo();
        character.eat("apple");
    }
}

