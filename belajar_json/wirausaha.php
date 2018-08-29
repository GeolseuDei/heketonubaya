<?php
$mysqli = mysqli_connect('localhost','root','','hackathon_ubaya');
$myArray = array();
if ($result = $mysqli->query("SELECT * FROM wirausaha")) {
    $tempArray = array();
    while($row = $result->fetch_object()) {
        $tempArray = $row;
        array_push($myArray, $tempArray);
    }
    echo json_encode($myArray,JSON_PRETTY_PRINT);
}

$result->close();
$mysqli->close();
?>