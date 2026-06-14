Feature: Booking management on Restful-Booker API

  @regression @smoke
  Scenario: Complete flow: create, retrieve and delete a booking
    Given I create the booking
    When I retrieve the booking details
    Then the booking details are correct

    When I delete the booking
    Then the booking is successfully deleted

  @regression
  Scenario: Update a booking with full payload using PUT
    Given I create the booking
    When I updated the booking
    Then the data is updated

  @regression
  Scenario: Partially update a booking using PATCH
    Given I create the booking
    When I updated only the first name and total price
    Then the first name and total price are updated