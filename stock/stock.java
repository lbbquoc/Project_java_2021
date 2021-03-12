public class stock {
    private int stock_id;
    private String stock_items;
    private String stock_number;
    private String stock_type;
    private String stock_description;
    private ArrayList<Product> listProduct;

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_items() {
        return stock_items;
    }

    public void setStock_items(String stock_items) {
        this.stock_items = stock_items;
    }

    public String getStock_number() {
        return stock_number;
    }

    public void setStock_number(String stock_number) {
        this.stock_number = stock_number;
    }

    public String getStock_type() {
        return stock_type;
    }

    public void setStock_type(String stock_type) {
        this.stock_type = stock_type;
    }

    public String getStock_description() {
        return stock_description;
    }

    public void setStock_description(String stock_description) {
        this.stock_description = stock_description;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }
    public void addStock(){}
    public void editStock(){}
    public void deleteStock(){}
    public void searchStock(){}
}
