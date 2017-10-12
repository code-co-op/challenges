#!/bin/bash
read n
read ar
count=0
highest=-1
for height in $ar
do
  if [[ "$height" -gt "$highest" ]]
  then
    count=1
    highest=$height
  elif [[ "$height" -eq "$highest" ]]
  then
    let "count=count+1"
  fi
done
echo $count
