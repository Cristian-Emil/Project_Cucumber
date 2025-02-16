Feature: Login Data Driven with Excel

  Scenario Outline: Login Data Driven Excel
    Given the user navigates to login page
    Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |

#   Deci se iau valorile din EXCEL FILE care o sa fie preluate de pasul - Then , cel definit mai sus.
#   "Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>""
#   Pentru aceasta o sa modificam in pachetul stepDefinition, clasa LoginSteps ca sa implementam pasul THEN cel mai sus discutat
#   Acestea se fac in liniile de comanda care au titlul: *******   Data Driven test ************** din LoginSteps