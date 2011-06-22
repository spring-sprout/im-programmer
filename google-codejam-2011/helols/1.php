<?php
$fp = fopen($argv[1],'r');
$fc = array();
while(!feof($fp)){
  $fc[] = trim(fgets($fp));
}
fclose($fp);
$file = fopen(str_replace('.in', '.out', $argv[1]), "w");
$count = $fc[0];

for($i = 1; $i <= $count;$i++){
  fwrite($file, 'Case #'.$i.': '. logic($fc[$i])."\n");
}
fclose($file);

function logic($fc){
  $result = '';
  $inpus = explode(' ',$fc);
  $O = 1;
  $B = 1;
  $count = array_shift($inpus);
  
  $firstC = $lastC = array_shift($inpus);
  $firstB = array_shift($inpus);
  $$firstC = $firstB;
  $moveHit = 0;
  $mod = 0;
  if($firstB == 1){
    $moveHit = 1;
    $mod = 1;
  }else{
    $moveHit = $firstB;
    $mod = $firstB;
  }
  
  $maxC =  ($count-1)*2 ; 
  for($i = 0 ; $i < $maxC; $i++)
  {
    $color  = $inpus[$i++];
    $button = $inpus[$i];
    
    $needCount = abs($button - $$color);
    
    if($lastC != $color)
    {
      if($mod >=  $needCount){
        $moveHit++;
        $mod = 1;
      }else{
        $moveHit+= abs($needCount - $mod)+1;
        $mod = abs($needCount - $mod)+1;
      } 
    }
    else
    {
      $needCount++;
      $moveHit += $needCount;
      $mod += $needCount;
    }
   
    $$color = $button;
    $lastC = $color;
  }
  return $moveHit ;
}
?>