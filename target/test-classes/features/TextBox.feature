Feature: Testing the ToolsQA website
Scenario: Testing the Elements option

  Given user is already on the website
  When he clicks on TextBox button on the sidebar
  And he enters all required details in the form
  And user clicks on the submit button
  Then he should be able to see the entered details below the form
  
  

