import java.util.ArrayList;

public class Graph
{
     ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public Graph(int v) 
    {
        
        for (int i = 0; i < v; i++) 
        {
            list.add(new ArrayList<>());
        }
    }

    public void push(int u, int v)
     {
        list.get(u).add(v);
       list.get(v).add(u);
    }

    public void disp()
     {
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.print("Vertex " + i+"-->");

            for (int j = 0; j < list.get(i).size(); j++)
             {
                System.out.print(list.get(i).get(j) +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
     {
        Graph graph = new Graph(6);

        graph.push(0, 1);
        graph.push(0, 2);
        graph.push(1, 4);
        graph.push(2, 4);
        graph.push(0,3);
        graph.push(3,5);

        graph.disp();
}
}
