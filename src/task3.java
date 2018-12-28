import java.util.*;
import java.lang.Comparable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class task3 {
    public static abstract class Worker implements Comparable<Worker> {
        private String Name;
        private long ID;
        protected double AverageSalary;

        public String GetName() {
            return Name;
        }

        public long GetID() {
            return ID;
        }

        public void SetName(String Name) {
            this.Name = Name;
        }

        public void SetID(long ID) {
            this.ID = ID;
        }

        public Worker(String Name, long ID) {
            this.Name = Name;
            this.ID = ID;
        }

        public Worker() {
            this.Name = "default";
            this.ID = 1;
        }

        public abstract double GetMonthSalary();

        @Override
        public int compareTo(Worker o) {
            if (this.GetMonthSalary() < o.GetMonthSalary())
                return 1;
            if (this.GetMonthSalary() > o.GetMonthSalary())
                return -1;
            else {
                return String.CASE_INSENSITIVE_ORDER.compare(this.Name, o.Name);
            }
        }
    }

    public static class HourSalaryWorker extends Worker {
        private double HourSalary;

        public double GetHourSalary() {
            return HourSalary;
        }

        public void SetHourSalary(int HourSalary) {
            this.HourSalary = HourSalary;
        }

        @Override
        public double GetMonthSalary() {
            AverageSalary = 20.8 * 8 * HourSalary;
            return 20.8 * 8 * HourSalary;
        }

        public HourSalaryWorker(String Name, long ID, double HourSalary) {
            super(Name, ID);
            this.HourSalary = HourSalary;
            GetMonthSalary();
        }

        public HourSalaryWorker() {
            super();
            this.HourSalary = 0;
            GetMonthSalary();
        }

        @Override
        public String toString() {
            return "Worker:\r\nName: " + super.Name + "\r\nID :" + super.ID +"\r\nType: HourSalary\r\nSalary: " + HourSalary + "\r\n";
        }
    }

    public static class FixedSalaryWorker extends Worker {

        private double FixedSalary;

        public double GetFixedSalary() {
            return FixedSalary;
        }

        public void SetMonthlySalary(double FixedSalary) {
            this.FixedSalary = FixedSalary;
        }

        @Override
        public double GetMonthSalary() {
            AverageSalary = FixedSalary;
            return AverageSalary;
        }

        public FixedSalaryWorker(String Name, long ID, double FixedSalary) {
            super(Name, ID);
            this.FixedSalary = FixedSalary;
            GetMonthSalary();
        }

        public FixedSalaryWorker() {
            super();
            FixedSalary = 0;
            GetMonthSalary();
        }

        @Override
        public String toString() {
            return "Worker:\r\nName: " + super.Name + "\r\nID :" + super.ID +"\r\nType: FixedSalary\r\nSalary: " + FixedSalary + "\r\n";
        }
    }

    public static ArrayList<Worker> RandomInitializeWorkerList(int size) {
        ArrayList<Worker> Workers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean())
                Workers.add(new HourSalaryWorker("Name" + i, random.nextInt(1000), random.nextDouble()));
            else Workers.add(new FixedSalaryWorker("Name" + i, random.nextInt(1000), random.nextDouble()));
        }
        return Workers;
    }

    public static void WriteWorkersToFile(ArrayList<Worker> workers, String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        for (Worker worker : workers) fileWriter.write(worker.toString());
        fileWriter.close();
    }

    public static String GetVariablesFromNextFileLine(String Category, String sep, Scanner scanner) {
        String[] NextLine = scanner.nextLine().split(sep);
        if (!NextLine[0].replaceAll("\\s+", "").equals(Category))
            throw new IllegalArgumentException("Wrong file format");
        return NextLine[1].replaceAll("\\s+", "");
    }

    public static ArrayList<Worker> InitializeWorkersFromFile(String Filename) throws IOException {
        File file = new File(Filename);
        Scanner scanner = new Scanner(file);
        ArrayList<Worker> WorkersList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            if (!scanner.nextLine().equals("Worker:")) throw new IllegalArgumentException("Wrong file format");

            String name = GetVariablesFromNextFileLine("Name", ":", scanner);
            long ID = Long.parseLong(GetVariablesFromNextFileLine("ID", ":", scanner));
            String type = GetVariablesFromNextFileLine("Type", ":", scanner);


            if (type.equals("FixedSalary")) {
                double fixed = Double.parseDouble(GetVariablesFromNextFileLine("Salary", ":", scanner));
                FixedSalaryWorker wrk = new FixedSalaryWorker(name, ID, fixed);
                WorkersList.add(wrk);
            } else if (type.equals("HourSalary")) {
                double hour = Double.parseDouble(GetVariablesFromNextFileLine("Salary", ":", scanner));
                Worker wrk = new HourSalaryWorker(name, ID, hour);
                WorkersList.add(wrk);
            } else throw new IllegalArgumentException("Wrong file format");
        }
        return WorkersList;
    }

    public static void main(String args[]) {
        ArrayList<Worker> RandomWorkers = RandomInitializeWorkerList(20);
        try {
            WriteWorkersToFile(RandomWorkers, "Workers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Worker> Workers = new ArrayList<Worker>();
        try {
            Workers = InitializeWorkersFromFile("Workers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(Workers);

        System.out.println("Workers: \n");
        for (int i = 0; i < Workers.size(); i++) System.out.println(Workers.get(i).toString());

        //write sorted list to file
        try {
            WriteWorkersToFile(Workers, "SortedWorkers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("First five names of workers");
        for (int i = 0; i < 5; i++) System.out.println("Name: " + Workers.get(i).GetName());

        System.out.println("\n" + "Last three id-s of workers");
        for (int i = Workers.size() - 3; i < Workers.size(); i++)
            System.out.println("id: " + Long.toString(Workers.get(i).GetID()));
    }
}