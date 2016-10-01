<?php
//connect
$conn = mysqli_connect('localhost', 'ユーザ名', 'パスワード', 'データベース名');
// mysql query
$sql = "";
$sql .= "select";
$sql .= " letter";
$sql .= " from テーブル名";
if(isset($_GET['id1'])) {
$id1 = $_GET['id1'];
}
if(isset($_GET['id2'])) {
$id2 = $_GET['id2'];
}
if ($id1 == null){
if ($id2 == null){
System.out.print("NG302");
}else if ($id2 > 1000000 || $id2 < 1){
System.out.print("NG303");
}else {
//connect database. pick letter up!
$sql .= " where id2 = $id2";
$result = mysqli_query($conn, $sql);
while($row = mysqli_fetch_assoc($result)){
$letter = $row["letter"];
}
//出力
System.out.print("OK id2 $id2 $letter");
}
}else if ($id2 != null){
System.out.print("NG301");
}else if ($id1 > 1000000 || $id1 < 1){
System.out.print("NG303");
}else {
//connect database. pick letter up!
$sql .= " where id1 = $id1";
$result = mysqli_query($conn, $sql);
while($row = mysqli_fetch_assoc($result)){
$letter = $row["letter"];
}
//出力
System.out.print("OK id1 $id1 $letter");
}
//結果セットを解放
$result->free();
// データベース切断
mysqli_close($conn);
?>