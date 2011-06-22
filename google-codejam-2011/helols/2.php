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
  $r = logic($fc[($i*2)-1],$fc[$i*2]) ;
  if(!empty($r)){
    fwrite($file, 'Case #'.$i.': '. $r."\n");
  }
}
fclose($file);

function logic($fc,$fc1){
  $cs = explode(' ', $fc1);
  $result = 0;
  $r = 0;
  $min = pow(10, 6)+1;
  foreach($cs as $k =>$v){
    $r ^= $v;
    $min = min($min,$v);
  }
  foreach($cs as $k =>$v){
    if($r != 0){
      return 'NO';
    }else{
      $result += $v;
    }
  }
  return $result-$min;
}
?>
