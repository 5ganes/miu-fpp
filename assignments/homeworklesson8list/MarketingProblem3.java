package homeworklesson8list;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Marketing {
    private String employeeName;
    private String productName;
    private double salesAmount;

    Marketing(String employeeName, String productName, double salesAmount){
        this.employeeName = employeeName;
        this.productName = productName;
        this.salesAmount = salesAmount;
    }

    public String getEmployeeName(){
        return employeeName;
    }
    public String getProductName(){
        return productName;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    @Override
    public String toString(){
        return "  { EmployeeName : " + employeeName + ", ProductName : " + productName + ", SalesAmount : " + salesAmount + " }\n";
    }

    @Override
    public boolean equals(Object ob){
        if(ob == null) return false;
        if(!(ob instanceof Marketing)) return false;
        Marketing c = (Marketing) ob;
        return employeeName.equals(c.employeeName);
    }
}

class NaturalOrderOfSalesAmount implements Comparator<Marketing> {
    @Override
    public int compare(Marketing m1, Marketing m2) {
        if (Double.compare(m1.getSalesAmount(), m2.getSalesAmount()) != 0) {
            return Double.compare(m1.getSalesAmount(), m2.getSalesAmount());
        }
        return m1.getEmployeeName().compareTo(m2.getEmployeeName());
    }
}

class NameWithSalesAmountMoreThan1000 implements Comparator<Marketing> {
    @Override
    public int compare(Marketing m1, Marketing m2){
        return m1.getEmployeeName().compareTo(m2.getEmployeeName());
    }
}

public class MarketingProblem3 {
    public static List<Marketing> marList = new ArrayList<>();

    public static void main(String[] args) {
        marList.add(new Marketing("A", "Laptop",1300));
        marList.add(new Marketing("B", "Laptop", 920.0));
        marList.add(new Marketing("C", "Laptop", 920.0));
        marList.add(new Marketing("D", "Laptop", 2340.0));
        marList.add(new Marketing("E", "Laptop", 890.0));
        marList.add(new Marketing("F", "Laptop", 1200.0));

        System.out.println("Marketing list without sorting : " + marList);

        Comparator<Marketing> comp = new NaturalOrderOfSalesAmount();
        Collections.sort(marList, comp);
        System.out.println("Marketing list after sorting by natural order of salesAmount : " + marList);

        List<Marketing> listMoreThan1000 = listMoreThan1000(marList);
        Comparator<Marketing> compM = new NameWithSalesAmountMoreThan1000();
        Collections.sort(listMoreThan1000, compM);
        System.out.println("Marketing list after sorting by employeeName with salesAmount > 1000 : " + listMoreThan1000(listMoreThan1000));

    }
    public static List<Marketing> listMoreThan1000(List<Marketing> list){
        ArrayList<Marketing> resList = new ArrayList<Marketing>();
        for(Marketing m : list) {
            if(m.getSalesAmount() > 1000) {
                resList.add(m);
            }
        }
        return resList;
    }

}
