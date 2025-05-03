// //
// chetak is running
// horse@4f023edb is running
// kudure is running
// horse@3a71f4dd is running

//



// public class horse 
// {
//     String name;
//     int height;
//     void run()
//      {
//         System.out.println(this.name+" is running");
//         System.out.println(this+" is running");
//      }   
//      public static void main(String[] args) {
//         horse h1=new horse();
//         h1.height=8;
//         h1.name="chetak";
//         h1.run();
//         horse h2=new horse();
//         h2.height=9;
//         h2.name="kudure";
//         h2.run();
//      }
// }



//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++





//// ** VARIABLE (CLASHING/SHADOWING)  ***/////////////////////////////
/// out
/// 
/// 

// public class horse 
// {
//     String name="rajkumar";
//     int height;
//     void run()
//      {
//         String name="dr_rajkumar";
//         System.out.println(this.name+" is actor");
//         System.out.println(name+" is actor");
//      }   
//      public static void main(String[] args) {
//         horse h1=new horse();
//         h1.run();
       
//      }
// }



/////+++++++++ STATIC VARIABLES ++++//////////////////////////////

public class horse
{
    String name="dr_raj";
    static int height=9;
    public static void main(String[] args) 
    {
        horse h1=new horse();
        h1.name="rajkumar";
        height=10;
        System.out.println(h1.name+" height is ="+height);
        
        horse h2=new horse();
        System.out.println(h2.name+"hight ="+height);
}


}