<?php
$mysqli = mysqli_connect('localhost','root','','hackathon_ubaya');
mysqli_set_charset($mysqli, "utf8");
$myArray = array();
if ($result = $mysqli->query("SELECT * FROM sekolah")) {
    $tempArray = array();
    while($row = $result->fetch_object()) {
        $tempArray = $row;
        array_push($myArray, $tempArray);
    }
    echo json_encode($myArray);
    // print_r($myArray);
}

$result->close();
$mysqli->close();
?>