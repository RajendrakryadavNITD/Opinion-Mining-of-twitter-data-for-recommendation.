
package topic_clustering;
import java.io.*;

public class Topic_Clustering 
{

    public static void main(String[] args) 
{
BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
try
{
String text=new String(bfr.readLine().trim());
Topic obj=new Topic();
System.out.println(obj.Detect(text));
}catch(Exception e){System.out.println("Error here : " + e.toString());}

}
    
}
