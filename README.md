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
  - A swap occurs when an item is greater than the item following it, causing them to switch places with one another.
  - If no swaps occurred during a full traversal, the items must be sorted and we can stop iterating for improved efficiency.
- Merge sort
  - Splits arrays recursively into sub-arrays until each subarray is of size 1.
  - Merges the sub-arrays recursively in a careful manner to ensure the outcome joint array is sorted.
  - Recursion ends when each sub-array has been merged successfully back into a sorted array.
- Binary sort
  - Converts an unsorted array into a binary tree, sorting the data in the process.
  - Utilizes the Adaptor design pattern to provide an intermediary or an adaptor which extracts data from the binary tree and returns it as a sorted int array.
  - Utilizes recursion for ease of work with the binary tree due to its nature.