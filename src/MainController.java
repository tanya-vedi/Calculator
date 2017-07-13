
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tanya
 */
public class MainController {

    @FXML
    private Label result;
    private long number1 = 0;
    private String operator= "";
    private boolean start= true;
    private Modal model= new Modal();
    
    @FXML  
    public void processNumbers(ActionEvent event){
        if(start)
        {
            result.setText("");
            start=false;
        }
        String value = ((Button)event.getSource()).getText();//gets the text of the button clicked
        result.setText(result.getText()+value);
    }
    public void processOperators(ActionEvent event){
      String value = ((Button)event.getSource()).getText();//gets the text of the button clicked
      if(!value.equals("="))
      {
          if(!operator.isEmpty())
              return;
          operator=value;
          number1= Long.parseLong(result.getText());
          result.setText("");
      }else
      {
          if(operator.isEmpty())
              return;
          long number2= Long.parseLong(result.getText());
          float output= model.calculate(number1, number2, operator);
          result.setText(String.valueOf(output));
          operator="";
          start= true;
      }
      
    }
}
