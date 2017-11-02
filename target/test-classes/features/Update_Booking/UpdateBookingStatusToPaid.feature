Feature: Lookup a definition
  In order to talk better
  As an English student
  I want to look up word definitions

  Scenario: Update Booking status to Paid
    Given the user is on the 'http://phptravels.com/demo/' page
    When user clicks on link provided in 'Admin Section' Section And Login using credentials provided
    And user is on main landing page
    Then user clicks 'Bookings' button to view listing
    And user updates listing status to 'Paid' if not 'Paid' already
    And user ensure all listings have 'Paid' status
    And user logs out