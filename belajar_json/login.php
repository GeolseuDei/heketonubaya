<?php
$mysqli = mysqli_connect('localhost','root','','hackathon_ubaya');

$myArray = array();
$username = mysqli_real_escape_string($mysqli, $_POST['username']);
$password = mysqli_real_escape_string($mysqli, $_POST['password']);

if ($result = $mysqli->query("SELECT * FROM user WHERE username = '$username' AND password = '$password'")) {
	$tempArray = array();
	while($row = $result->fetch_object()) {
		$tempArray = $row;
		array_push($myArray, $tempArray);
	}
	echo json_encode($myArray,JSON_PRETTY_PRINT);
} else {
	return false;
}

$result->close();
$mysqli->close();
?>