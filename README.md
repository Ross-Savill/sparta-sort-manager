# sparta-sort-manager
My Java application which creates random arrays of varying lengths and allows the user to sort the array using various sorting methods. Provides the length of time taken to sort the array.

--- 

## Using the Sort Manager:

To use my Sort Manager, clone a copy to your machine locally and run the program.

You will be met with a question asking how many integers you would like to fill your array with (you must provide at least two numbers).

You will then be presented with a list of sorting methods including Java's own inbuild sort (you must select a number from the list ranging from 1 to 7).

Following your selection you will be provided with:
  1) The name of the sort
  2) A copy of the array before being sorted
  3) A copy of the array after it has been sorted 
  4) The total time it took to sort the array in nanoseconds (with additional breakdowns in milliseconds and seconds)
  
---
  
## Adding your own sort:
  
In order to add your own sort, you'll need to add your coded sort class to the sorters package, ensure your sort impliments the Sorter interface and that it calls the sort method referenced in the interface to be provided with an array from the inbuilt random array generator.

### The sort method located in the Sorter interface:

```
{
  public interface Sortable {
      int[] sort(int[] arrayToSort);
  }
}
``` 

Make sure to add your sort to the Sort Factory so that it can be called and that you update the text implimented in QuestionTwo located in the questions package to ensure users know about your sort.
