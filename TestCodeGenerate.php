<?php

$Alphabet = "abcdefghijklmnopqrstuvwxyz";

$link = mysqli_connect('localhost', 'mysql_user', 'testuser');

mysqli_select_db($link,"database1");

for($i=1;$i<1000001;$i++){
	$letter = $Alphabet[rand(0,25)];
	$command = "insert into database1(id1, id2, letter) values($i, $i, $letter)";
	mysqli_query($conn, $command);
	print($command);

}
?>
