package application;

import org.junit.jupiter.api.Test;

class ControllerTest {
  CalcController controller;
  
  CalcModel model = new CalcModel();
  ViewInterface view = new AsciiView();
  
  //Test Constructing the CalcController
  @Test
  void setUp() {
    controller = new CalcController(model, view); 
  }

}
