package store;
import employee.*;
import product.*;
import java.util.ArrayList;
public class Store {
    private int store_id = 0;
    private String store_name;
    private String store_address;
    private String store_Phone;

    private ArrayList<Employee> listEmployee;
    private ArrayList<Product> listProduct;

    public Store(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }
    public Store()
    {
        store_id ++;
    }

    public Store(String store_name, String store_address, String store_Phone) {
        store_id ++;
        this.store_name = store_name;
        this.store_address = store_address;
        this.store_Phone = store_Phone;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setstore_Phone(String store_Phone) {
        this.store_Phone = store_Phone;
    }

    public String getstore_Phone() {
        return store_Phone;
    }

    public void setListEmployee(ArrayList<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
        
    }
    public ArrayList<Product> getListProduct() {
        return listProduct;
    }


    public void addStore(){}
    public void editStore(){}
    public void deleteStore(){}
    public void searchStore(){}
    public void analysisStore(){}
    public float calRevenue()
    {
        return 0;
    }
}
