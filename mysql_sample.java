<?php
//random letter
$str = array_merge(range('a', 'z'));
//connect mysql
$conn = mysqli_connect('localhost', 'ユーザ名', 'パスワード');
//select database
mysqli_select_db($conn, 'データベース名');
for($i = 1; $i < 1000001; $i++ ){
$r_str = $str[rand(0, count($str) - 1)];
$sql = "";
$sql .= "insert";
$sql .= " into テーブル名";
$sql .= "(id1, id2, letter)";
$sql .= " values";
$sql .= "($i, $i, '$r_str')";
mysqli_query($conn, $sql);
print($sql);
}
?>
