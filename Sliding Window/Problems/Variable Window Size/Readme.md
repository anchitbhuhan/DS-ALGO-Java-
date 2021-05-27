Identification : "Array" "String", "Subarray", "Substring", "size" "Max", "Min"


```java

while(j<size)  
{
    calculation

    if(condition < k)
        j++;
    
    else if(condition == k)
    {
        answer <- calculation
       j++;
    }
    
    else if(condition > k)
    {
        while(condition > k)
        {
            remove calculation of i
            i++
        }
        j++
    }
}
return answer
```