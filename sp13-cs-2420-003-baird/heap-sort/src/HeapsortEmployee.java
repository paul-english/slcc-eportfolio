import java.util.List;

public class HeapsortEmployee
{
    List<Employee> coll;

    public HeapsortEmployee()
    {
        coll = Util.getEmployees();
    }

    public void runSort()
    {
        printList("Employees sorted by Name", HeapSort.heapSort(coll, new EmpSortByName()));
        printList("Employees sorted by Age", HeapSort.heapSort(coll, new EmpSortByAge()));
        printList("Employees sorted by Salary", HeapSort.heapSort(coll, new EmpSortBySalary()));
    }

    private void printList(String header, List<Employee> list)
    {
        System.out.printf("%s\n%s\n", header, "EmpId\tName\tAge\tSalary");
        for (Employee e : list)
            System.out.println(e);
        System.out.println();
    }

}
