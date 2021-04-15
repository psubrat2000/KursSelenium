Feature: My Store Login

  Scenario Outline: user can open a new account
    Given an open browser with "https://prod-kurs.coderslab.pl/index.php"
    And click Signin
    And an email "afg@abc.com" is entered in input field
    When details are entered
    And register is clicked
    Then the account is created
    And close browser
    Examples: