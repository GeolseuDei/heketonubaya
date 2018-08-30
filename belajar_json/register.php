<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "hackathon_ubaya";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
} 

$username = mysqli_real_escape_string($conn, $_POST['username']);
$password = mysqli_real_escape_string($conn, $_POST['password']);
$role = mysqli_real_escape_string($conn, $_POST['role']);
$foto = mysqli_real_escape_string($conn, $_POST['foto']);
$status = mysqli_real_escape_string($conn, $_POST['status']);

$sql = "INSERT INTO user (username, password, role, foto, status)
VALUES ('$username', '$password', '$role', '$foto' ,'$status')";

if ($conn->query($sql) === TRUE) {
	echo "New record created successfully";
} else {
	echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>