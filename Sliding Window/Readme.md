Identification - "Subarray" , "Window Size" , "Largest" , "Smallest"

1. Fixed Window Size : Max/Min Subarray of size k.
2. Varaible Widow Size : Largest/Smallest smallest Subarray of sum k.



```java

windowSize = 0;
while(right side of window does not cross right end)
{
    perform operations

    if( (windowSize) < targetWindowSize)
        increase the Window Size

    else if( (windowSize) == targetWindowSize)
    {
        Store the result of operations
        slide the window one to right (i++, j++)
    }


}

```


