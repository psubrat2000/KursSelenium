Feature: Qloapps Account Creation

  Scenario: user can open a new account
    Given an open browser with "https://qloapps.coderslab.pl/"
    And click "a.user_login.navigation-link span.hide_xs"
    And an email "afg@abc.com" is entered in input field
    When details are entered
    And register is clicked
    Then the account is created
    And close browser