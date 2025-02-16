# pagina de "https://tutorialsninja.com/demo/" - email "cristian_teste@outlook.com", pass "Cristian70"

Feature: Login with Valid Credentials and Invalid Credentials

  @sanity   @regression
  Scenario: Succesful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "cristian_teste@outlook.com" and password as "Cristian70"
    And the user clicks on the Login button
    When user enters email as "cristianzidarescu@hotmail.com" and password as "Cristian1968"
    And the user clicks on the Login button
    Then the user should be redirected to the My Account Page

#  @regression
#  Scenario: Succesful Login with Valid Credentials and Invalid Credentials
#    Given the user navigates to login page
#    When user enters email as "cristian_teste@outlook.com" and password as "Cristian70"
#    And the user clicks on the Login button
#    Then the user should be redirected to the My Account Page
##    And the user clicks on Continue button


# Daca dorim sa rulam de mai multe ori scenariul trebuie sa generam Scenario Outline - vezi mai jos
  @regression
  Scenario Outline: Login Data Driven
    Given the user navigate to the login page
    When user enters email as "<email>" and password ass "<password>"
    And the user clicks on the Login button
    Then the user should be redirected to the My Account Page.

     Examples:
       | email                           | password     |
       | cristian_teste@outlook.com      | Cristian70   |
       | cristian_zidarescu@yahoo.com    | Cristian1968 |
       | cristianzidarescu@hotmail.com   | Cristian1968 |


#-----------------------------------------------------------------------------------------------------------------------
# Varianta imbunatatita , teoretic, este :
# pagina de "https://tutorialsninja.com/demo/" - email "cristian_teste@outlook.com", pass "Cristian70"
#
#Feature: Login with Valid and Invalid Credentials
#
#  # Test pentru login cu credentiale valide
#  @sanity
#  Scenario: Succesful Login with Valid Credentials
#    Given the user navigates to login page
#    When user enters email as "cristian_teste@outlook.com" and password as "Cristian70"
#    And the user clicks on the Login button
#    Then the user should be redirected to the My Account Page
#
#  # Test pentru login cu credentiale valide pentru regresie
#  @regression
#  Scenario: Succesful Login with Valid Credentials
#    Given the user navigates to login page
#    When user enters email as "cristian_teste@outlook.com" and password as "Cristian70"
#    And the user clicks on the Login button
#    Then the user should be redirected to the My Account Page
#
#  # Test pentru login cu credentiale invalide (nou adăugat)
#  @regression
#  Scenario: Unsuccessful Login with Invalid Credentials
#    Given the user navigates to login page
#    When user enters email as "invalid_email@example.com" and password as "WrongPassword"
#    And the user clicks on the Login button
#    Then the user should see an error message indicating invalid credentials
#
#  # Test de login cu date de test (Data-Driven)
#  @regression
#  Scenario Outline: Login Data Driven
#    Given the user navigates to login page
#    When user enters email as "<email>" and password as "<password>"
#    And the user clicks on the Login button
#    Then the user should be redirected to the My Account Page
#
#    Examples:
#      | email                           | password     |
#      | cristian_teste@outlook.com       | Cristian70   |
#      | cristian_zidarescu@yahoo.com     | Cristian1968 |
#      | cristianzidarescu@hotmail.com    | Cristian1968 |