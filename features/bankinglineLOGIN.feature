  Feature: Banking line online Home Page Scenarios

@Login
Scenario: Advance Search Link
Given I am on Banking line online Login Page
When I enter my credentials on login page
Then I validate that the login is successfully


  @transfers
  Scenario Outline: Transfers
  Given I am on Banking line online Login Page
  When I enter my credentials on login page
  Then I validate that the login is successfully
  Given I am on transfers funds page
  When I select '<from>' and '<to>' account
  When I enter an amount '<amount>'
  Then I validate that transfer is successfull

  Examples:
    | from                       | to                           | amount  |
    | 45390820393962882          | 800003 Checkingg             | 5278!   |
    | 800003                     | 4539082039396288 Credit Card | 1234    |
    | 4539082039396288           | 800003 Checking              | 5278    |