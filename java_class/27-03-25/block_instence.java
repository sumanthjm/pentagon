//**** instance variable using  block */
// public class block_instence 
// {
//     int s_id;
//     {
//         s_id=1234;
//     }
//     public static void main(String[] args) {
//         block_instence b1=new block_instence();
//         System.out.println(b1.s_id);
//         block_instence b2=new block_instence();
//         System.out.println(b2.s_id);

//     }
// }


//**********  block instance in same class with same static main block */

// public class block_instence {

//     {
//         System.out.println("ibb1");
//     }
//     {
//         System.out.println("ibb2");
//     }
//     public static void main(String[] args) {
//         block_instence b1=new block_instence();
//         block_instence b2=new block_instence();
//         {
//             System.out.println("ibb3");
//         }
//     }
// }



//*********  block instance in difference class with different main method */
    class test {

      {
        System.out.println("ibb1");
      }
    {
        System.out.println("ibb2");
    }
    
       }

    public class block_instence
    {
        public static void main(String[] args) {
           test t1=new test();
           test t2=new test();

            
        {
            System.out.println("ibb3");
        }
        }
    }
