public class constructor 
{
    String empname;
    int em_id;
    constructor(String empname,int em_id)
    {
        this.empname=empname;
        this.em_id=em_id;
    }
    public static void main(String[] args) {
        constructor c1=new constructor("sumanth jm", 1234);
        // constructor c1=new constructor();//*********** */
        System.out.println("employee name is "+c1.empname+" id is "+c1.em_id);
        constructor c2=new constructor("darshan", 5678);

        System.out.println("employee name is "+c2.empname+" id is "+c2.em_id);


    }
}
