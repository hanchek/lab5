import java.util.*;

public class task1 {
    public static void GetTimeInitializeElementsInCollection(Collection<Double> ...collections)
    {
        for (Collection<Double>  collection : collections)
        {
            long t1=System.nanoTime();
            for(double i=0; i<1000; i++)
                collection.add(i);
            long t2=System.nanoTime();
            System.out.println(collection.getClass()+" initialization time is "+Math.abs((t2-t1)/1000)+" microseconds");
        }
    }

    public static Double Finder (Double el, Collection<Double> collection)
    {
        Iterator<Double> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Double node = iterator.next();
            if (node.equals(el)) return node;
        }
        return -1.0;
    }

    public static void GetTimeFindElementInCollection(Collection<Double> ...collections)
    {
        for (Collection<Double>  collection : collections)
        {
            Double var;
            long t1=System.nanoTime();
            var = Finder(1.0, collection);
            long t2=System.nanoTime();
            System.out.println("Finding element at the start of "+collection.getClass()+" took "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            var = Finder(1000.0/2, collection);
            t2=System.nanoTime();
            System.out.println("Finding element in the mIDdle of "+collection.getClass()+" took "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            var = Finder(999.0, collection);
            t2=System.nanoTime();
            System.out.println("Finding element in the end of "+collection.getClass()+" took "+Math.abs((t2-t1)/1000)+" microseconds");
            System.out.println("\n");
        }
    }
    public static void GetTimeRemoveElementInCollection (Collection<Double> ...collections)
    {
        for (Collection<Double>  collection : collections)
        {
            long t1=System.nanoTime();
            collection.remove(1.0);
            long t2=System.nanoTime();
            System.out.println(collection.getClass()+" removed element from the start in "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            collection.remove(1000.0/2);
            t2=System.nanoTime();
            System.out.println(collection.getClass()+" removed element from the middle in "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            collection.remove(999.0);
            t2=System.nanoTime();
            System.out.println(collection.getClass()+" removed element from the end in "+Math.abs((t2-t1)/1000)+" microseconds");
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {
        System.out.println("FIRST TASK:\n");
        List<Double> arraylist = new ArrayList<>();
        List<Double> linkedlist = new LinkedList<>();
        Set<Double> treeset = new TreeSet<>();
        Set<Double> hashset = new HashSet<>();

        GetTimeInitializeElementsInCollection(arraylist, linkedlist, treeset, hashset);
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        GetTimeFindElementInCollection(arraylist, linkedlist, treeset, hashset);
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        GetTimeRemoveElementInCollection (arraylist, linkedlist, treeset, hashset);
    }
}
