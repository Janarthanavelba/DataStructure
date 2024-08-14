import java.util.ArrayList;
import java.util.*;
class Dfs
{
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public Dfs(int v)
    {
        for(int i =0;i<v;i++)
        {
            list.add(new ArrayList<Integer>());
        }
    }
    public void push(int u , int v)
    {
        list.get(u).add(v);
        list.get(v).add(u);
    }


    public void dfs(int v)
    {
        int l = list.size();
        boolean [] arr = new boolean[l];
        dfs1(v,arr);
    }


    public void dfs1(int v, boolean [] arr)
    {
        System.out.print(v+" ");
        arr[v] = true;
       
        for(int i=0;i<list.get(v).size();i++)
        {
            int k = list.get(v).get(i);
            if(!arr[k])
            {
                dfs1(k,arr);
            }
        }
    }
    
  
    public void display()
    {
        for(int i =0;i<list.size();i++)
        {
            System.out.print("Vertices:"+ i +" |");
            for(int j = 0;j<list.get(i).size();j++)
            {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println(" ");
        }
    }

    public static void main (String args[])
    {
        Scanner s = new Scanner(System.in);
        Dfs g = new Dfs(6);
        while(true)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            if(a==-1||b==-1)
                break;
            g.push(a,b);
        }
        g.display();
       g.dfs(0);
        
    }
}
