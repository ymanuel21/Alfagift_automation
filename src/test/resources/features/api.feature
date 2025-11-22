Feature: Faker API Persons

Scenario: Verify male persons from 1990-2000
  When I call "persons" endpoint
  When I call "persons" endpoint with _quantity=10, _gender=male, _birthday_start=1990-01-01, _birthday_end=2000-12-31
  Then I should get 10 persons
  And each person should be "male"
  And each person's birthday should be between "1990-01-01" and "2000-12-31"

