# Sort Manager
## by Yanaki Kolarov

### This sort manager project is following the MVC structure:
- Model 
  - Sorter Interface
  - AbstractSorter superclass 
  - Abstract and concrete factories
  - Concrete sorters, including bubble, merge, and binary
- View
  - View interface
  - DisplayManager concrete view for the console
- Controller
  - SortManager responsible for using the models to power the view
  
#### Concrete sorters in detail:
- Bubble sort
  - Makes use of a do-while loop which runs at least once, but then only continues if a swap occurred in the previous iteration.
Once no swaps have been made after a full traversal of the array, we can be sure that the items are sorted and as such we can stop iterating for improved efficiency. A swap occurs when an item is greater than the item following it, causing them to switch places with one another.
- Merge sort
  - Splits arrays into subarrays until each subarray is of size 1.
  - Combines the subarrays in a careful manner to ensure the outcome array is sorted.
  - Utilizes recursion for ease of implementation.
- Binary sort
  - Utilizes recursion and the Adaptor design pattern for ease of implementation.