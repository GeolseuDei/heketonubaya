<?php
$mysqli = mysqli_connect('localhost','root','','hackathon_ubaya');

$myArray = array();
$pesan = mysqli_real_escape_string($mysqli, $_POST['username']);
$tanggal = date('d-m-y');
$iduser = mysqli_real_escape_string($mysqli, $_POST['iduser']);

if ($result = $mysqli->query("INSERT INTO report (pesan, tgl_report, iduser)
	VALUES ($pesan, $tanggal, $iduser)")) {
	return true;
} else {
	return false;
}

$result->close();
$mysqli->close();
?>