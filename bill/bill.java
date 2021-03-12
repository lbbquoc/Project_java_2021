public class bill {
    private int bill_id;
    private String bill_type;
    private String bill_number;
    private int bill_customer_id;
    private String bill_description;
    private String bill_date;
    private ArrayList<Product> listProduct;
    private float totalBill;

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

    public String getBill_number() {
        return bill_number;
    }

    public void setBill_number(String bill_number) {
        this.bill_number = bill_number;
    }

    public int getBill_customer_id() {
        return bill_customer_id;
    }

    public void setBill_customer_id(int bill_customer_id) {
        this.bill_customer_id = bill_customer_id;
    }

    public String getBill_description() {
        return bill_description;
    }

    public void setBill_description(String bill_description) {
        this.bill_description = bill_description;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public float getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(float totalBill) {
        this.totalBill = totalBill;
    }
    public void addBill() {

    }
    public void editBill() {

    }
    public void deleteBill() {
    }
    public void searchBill() {

    }
}
