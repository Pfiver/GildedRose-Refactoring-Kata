# Gilded Rose Requirements Specification

## Story 1: Stock Item Expiry Estimation
    As a store manager,
    I want to know the expected expiry date of all items on offer,
    so that I can attempt to sell the soon-to-expire items first.

### Scenario 1.1
    Given a stock item is expected to expire in x days,
    When y days have past,
    Then it shall be expected to expire in (x - y) days.

### Scenario 1.2
    Given a stock item is expected to have expired x days ago
    When y days have past,
    Then it shall be expected to have expired (x + y) days ago.

### Scenario 1.3
    Given "Sulfuras", a stock item that does not expire,
    When any amount of time has past,
    Then it still does not expire.

## Story 2: stock item quality estimation
    As a store manager,
    I want to know the estimated quality of all items on offer,
    so that I can adjust their price and position in the shelf accordingly.

### Scenario 2.1
    Given a quality estimation algorithm and a stock item
          that is expected to expire in x days
          and whose current quality estimate is y 
    When z days have past,
    Then its quality estimate shall be determined by the algorithm.

### Quality Estimation Function

	- The Quality of an item is never negative
	- The Quality of an item is never more than 50

    - "Sulfuras" has a fixed Quality of 80 that never changes

	- Every night "Aged Brie" Quality is increased by one
	- Every night "Backstage passes" Quality is increased by one
    - Every night "Backstage passes" Quality increases by 2 when the expiry date is in 10 days or less
    - Every night "Backstage passes" Quality increases by 3 when the expiry date is in 5 days or less
    - Every night "Backstage passes" Quality drops to 0 when the expiry date has passed

	- Every night all normal items whose expiry date has not yet passed Quality is decreased by one
	- Every night all normal items whose expiry date has passed Quality is decreased by two

	- [TODO] "Conjured" items degrade in Quality twice as fast as normal items
