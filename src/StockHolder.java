public class StockHolder {

    int id;
    String name;
    int budget;
    private Stock stock;

    public StockHolder(){}

    public StockHolder(int id, String name, int budget, Stock stock) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "StockHolder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", stock=" + stock +
                '}';
    }
}
