import java.util.*;
import java.time.LocalDate;
import java.math.BigDecimal;

class Portfolio { 
    String owner; 
    LocalDate inceptionDate; 
    BigDecimal value; 

    public Portfolio(String owner, LocalDate inceptionDate, BigDecimal value){
        this.owner = owner;
        this.inceptionDate = inceptionDate;
        this.value = value;

    }
    public String getOwner() {
        return owner;
    }

    public LocalDate getInceptionDate() {
        return inceptionDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "( " + owner + "," + inceptionDate + "," + value + " )";
    }


} 





// And a List of Portfolios, 
//sort the list based on inceptionDate in ascending order, 
//if inceptionDate is same,  sort by value, if stillsame, sort by owner. 