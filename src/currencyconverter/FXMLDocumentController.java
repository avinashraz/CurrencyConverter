
package currencyconverter;



import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;


public class FXMLDocumentController implements Initializable {
    
   @FXML
   private ComboBox<Currency> box1;
   
   @FXML
   private ComboBox<Currency> box2;
   
   @FXML
   private Label label;
   
   @FXML
   private TextField num;
   
   @FXML
   private Double result;
   
   private double value;
   
    CurrencyConvertor obj = new CurrencyConvertor();
    CurrencyConvertorSoap getCurrency = obj.getCurrencyConvertorSoap();
    
    @FXML
    public void getConversion(ActionEvent event){
        String value1 = box1.getValue().toString().toUpperCase();
        String value2 = box2.getValue().toString().toUpperCase();
        
        result = getCurrency.conversionRate(Currency.valueOf(value1), Currency.valueOf(value2));
        
        if(num.getText().isEmpty()){
        label.setText("1 " + String.valueOf(value1) + " = " + String.valueOf(result) + String.valueOf(value2));
        
    }
        else{
            value =  Double.parseDouble(num.getText());
            double converter = value * result;
            converter = Double.parseDouble(new DecimalFormat(".##").format(converter));
            label.setText(value + " " + String.valueOf(value1) + " = " + String.valueOf(converter) + " "+ String.valueOf(value2));
            
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        box1.setItems(FXCollections.observableArrayList(Currency.values()));
        box2.setItems(FXCollections.observableArrayList(Currency.values()));
    }    
    
}
