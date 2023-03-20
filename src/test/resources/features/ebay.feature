Feature: Sample Feature

Background:
Given User launches the website

@ebay1
Scenario: Access a Product via category after applying multiple filters
When user clicks on ShopByCategory
And user clicks on "Cell phones & accessories" under "Electronics" section
Then user should redirect to "Cell Phones & Accessories" page
When user clicks on "Cell Phones & Smartphones" under Shop By Category
And user clicks on See All under "Shop by Brand" section
And user selects "5.0 - 5.4 in" under "Screen Size" in the pop up
And user selects "200,300" under "Price" in the pop up
And user selects "US Only" under "Item Location" in the pop up
And user clicks on Apply button
And user clicks on filters selected drop down
Then user verifies "5.0 - 5.4 in" in filters selected
And user verifies "200" in filters selected
And user verifies "300" in filters selected
And user verifies "US Only" in filters selected
And user closes the browser

@ebay
Scenario: Access a Product via Search
When user enters "MacBook" in the search box
And user selects "Computers/Tablets & Networking" under All Categories dropdown
And user clicks on search button
Then user verifies the first item in the result with search item "MacBook"
And user closes the browser
