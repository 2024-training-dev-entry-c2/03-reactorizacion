
public class PriceDetail {
    private Double basePrice;
    private String adjustmentType;
    private Double adjustmentValue;
    private Double finalPrice;

    public PriceDetail() {}

    public void calculatePrice(Double totalBasePrice, Integer start, Integer end){
        Double discountOrIncrease = 0.0;
        String adjustmentType = "N/A";

        if (start >= 5 && end <= 10) {
            discountOrIncrease = -0.08 * totalBasePrice;
            adjustmentType = "8% de descuento";
        } else if (start >= 10 && end <= 15) {
            discountOrIncrease = 0.10 * totalBasePrice;
            adjustmentType = "10% de incremento";
        } else if (end > 25) {
            discountOrIncrease = 0.15 * totalBasePrice;
            adjustmentType = "15% de incremento";
        }
        double finalPrice = totalBasePrice + discountOrIncrease;

        this.basePrice = totalBasePrice;
        this.adjustmentType = adjustmentType;
        this.adjustmentValue = discountOrIncrease;
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString(){
        return "Precio base: " + this.basePrice + '\n' +
                "Tipo de ajuste: " + this.adjustmentType + '\n' +
                "Valor del ajuste: " + this.adjustmentValue + '\n' +
                "Precio final: " + this.finalPrice + '\n' ;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }
}
