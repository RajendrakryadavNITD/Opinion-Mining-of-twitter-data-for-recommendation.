
package topic_clustering;
import java.util.*;
import java.io.*;

public class Topic 
{
HashSet<String>data[];
String data_path[];
HashMap<Integer,String>index;
FileInputStream file;
Scanner scan;
String st;
int n,i;
public Topic()
{
n=3;
data=new HashSet[n];
data_path=new String[n];
data_path[0]=new String("e:\\bollywood.txt");
data_path[1]=new String("e:\\sports.txt");
data_path[2]=new String("e:\\political.txt");
index=new HashMap();
index.put(0,"Bollywood");
index.put(1,"Sport");
index.put(2,"Politics");
i=0;
while(i<n)
{
data[i]=new HashSet<String>();
try
{
file=new FileInputStream(new File(data_path[i]));
scan=new Scanner(file);
while(scan.hasNextLine())
{
StringTokenizer stk=new StringTokenizer(scan.nextLine().trim()," ");
while(stk.hasMoreTokens())
data[i].add(stk.nextToken().toLowerCase());
}
}catch(Exception e){System.out.println("Error load Data : " + e.toString());}    
i++;
}

}

public String Detect(String str)
{
StringBuffer  topic=new StringBuffer();
int count=0,i=0,j,k,l=0;
String st[]=new String(str.toLowerCase().trim()).split(" ");
int len=st.length;

while(count==0 && i<len)
{
k=i;
l=0;    
while(count==0 && l<data.length)
{

while(k<len && count==0 && data[l].contains(st[k]))    
{
    count++;
    k++;
}
l++;
}
i++;
}


if(count>0)
return(index.get(l-1));    
else
return("Other");
}







}
