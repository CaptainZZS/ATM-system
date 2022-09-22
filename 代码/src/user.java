public class user {
    private Integer number;
    private String transfer;
    private Double amount;
    private String type;
    private String Collection;
    private String datatime;
    private Integer id;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCollection() {
        return Collection;
    }

    public void setCollection(String collection) {
        Collection = collection;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

    public user(Integer number, String transfer, Double amount,String type, String Collection,String datatime,Integer id) {
        super();
        this.id = id;
        this.transfer = transfer;
        this.amount = amount;
        this.type = type;
        this.Collection = Collection;
        this.datatime = datatime;
        this.id = id;
    }

    @Override
    public String toString() {
        return number + ",  " + transfer + ",  " + amount + ",  " + type + ",  " + Collection + ",  " + datatime + ",  " + id;}
}