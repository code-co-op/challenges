<?php

$handle = fopen ("php://stdin", "r");
function birthdayCakeCandles($n, $ar) {
    $count = 0;
    $highest = -1;
    foreach($ar as $h)
    {
        if ($h > $highest)
        {
            $count=1;
            $highest=$h;
        }
        elseif ($h == $highest)
            $count++;
    }
    return $count;
}

fscanf($handle, "%i",$n);
$ar_temp = fgets($handle);
$ar = explode(" ",$ar_temp);
$ar = array_map('intval', $ar);
$result = birthdayCakeCandles($n, $ar);
echo $result . "\n";
